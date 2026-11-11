package dtwg.mptc.ecommerce.customer.domain.usecase;

import dtwg.mptc.ecommerce.customer.client.dto.UserResponse;
import dtwg.mptc.ecommerce.customer.client.exception.UserServiceUnavailableException;
import dtwg.mptc.ecommerce.customer.client.feign.UserFeignClient;
import dtwg.mptc.ecommerce.customer.domain.dto.CreateCustomerCommand;
import dtwg.mptc.ecommerce.customer.domain.dto.CreateCustomerResult;
import dtwg.mptc.ecommerce.customer.domain.exception.CustomerAlreadyExistsException;
import dtwg.mptc.ecommerce.customer.domain.mapper.CustomerDataMapper;
import dtwg.mptc.ecommerce.customer.domain.port.output.CustomerRepository;
import dtwg.mptc.ecommerce.entity.Customer;
import dtwg.mptc.ecommerce.event.CustomerCreatedEvent;
import dtwg.mptc.ecommerce.exception.CustomerDomainException;
import dtwg.mptc.ecommerce.service.CustomerDomainService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// Use case: register a new customer.
// Called by the REST API controller (POST /api/v1/customers).
// Flow: check duplicates -> build domain Customer -> domain validates & initiates -> save -> return new id
@Component
@Slf4j
@RequiredArgsConstructor
public class CreateCustomerUseCase {

    private final CustomerDomainService customerDomainService; // business rules (from customer-domain-core)
    private final CustomerRepository customerRepository;
    private final CustomerDataMapper customerDataMapper;
    private final UserFeignClient userFeignClient;

    @Transactional // everything below runs in one DB transaction: if anything fails, nothing is saved
    public CreateCustomerResult execute(CreateCustomerCommand createCustomerCommand) {
        log.info("Execute CreateCustomerUseCase : {}", createCustomerCommand);

        try {
            UserResponse userResponse = userFeignClient.getById(createCustomerCommand.userId());
            log.info("User found: {} ", userResponse);
        }catch (FeignException.FeignClientException.NotFound e) {
            throw new CustomerDomainException("User not found");
        }catch (UserServiceUnavailableException e ){
            throw  new CustomerDomainException(e.getMessage());
        }

        if (customerRepository.existsByUsername(createCustomerCommand.username())) {
            throw new CustomerAlreadyExistsException("Username already exists");
        }
        if (customerRepository.existsByEmail(createCustomerCommand.email())) {
            throw new CustomerAlreadyExistsException("Email already exists");
        }

        Customer customer = customerDataMapper.createCustomerCommandToCustomer(createCustomerCommand);

        CustomerCreatedEvent customerCreatedEvent = customerDomainService.validateAndInitiateCustomer(customer);

        Customer savedCustomer = customerRepository.save(customer);

        log.info("Customer created with id: {} at {}",
                savedCustomer.getId().value(), customerCreatedEvent.getCreatedAt());

        return new CreateCustomerResult(savedCustomer.getId().value());
    }
}
