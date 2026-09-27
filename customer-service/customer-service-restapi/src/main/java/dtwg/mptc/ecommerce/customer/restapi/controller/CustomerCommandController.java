package dtwg.mptc.ecommerce.customer.restapi.controller;


import dtwg.mptc.ecommerce.customer.domain.dto.CreateCustomerResult;
import dtwg.mptc.ecommerce.customer.domain.dto.DeactivateCustomerCommand;
import dtwg.mptc.ecommerce.customer.domain.dto.UpdateCustomerResult;
import dtwg.mptc.ecommerce.customer.domain.usecase.CreateCustomerUseCase;
import dtwg.mptc.ecommerce.customer.domain.usecase.DeactivateCustomerUseCase;
import dtwg.mptc.ecommerce.customer.domain.usecase.UpdateCustomerUseCase;
import dtwg.mptc.ecommerce.customer.restapi.dto.CustomerCreateRequest;
import dtwg.mptc.ecommerce.customer.restapi.dto.CustomerCreateResponse;
import dtwg.mptc.ecommerce.customer.restapi.dto.CustomerUpdateRequest;
import dtwg.mptc.ecommerce.customer.restapi.dto.CustomerUpdateResponse;
import dtwg.mptc.ecommerce.customer.restapi.mapper.CustomerWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerCommandController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeactivateCustomerUseCase deactivateCustomerUseCase;
    private final CustomerWebMapper customerWebMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerCreateResponse createCustomer(@Valid @RequestBody CustomerCreateRequest customerCreateRequest){
        CreateCustomerResult createCustomerResult = createCustomerUseCase.execute(
                customerWebMapper.customerCreateRequestToCreateCustomerCommand(customerCreateRequest));

        return customerWebMapper.createCustomerResultToCustomerCreateResponse(createCustomerResult);
    }

    @PutMapping("/{customerId}")
    public CustomerUpdateResponse updateCustomer(@PathVariable UUID customerId,
                                                 @Valid @RequestBody CustomerUpdateRequest customerUpdateRequest){
        UpdateCustomerResult updateCustomerResult = updateCustomerUseCase.execute(
                customerWebMapper.customerUpdateRequestToUpdateCustomerCommand(customerId, customerUpdateRequest));

        return customerWebMapper.updateCustomerResultToCustomerUpdateResponse(updateCustomerResult);
    }

    @PatchMapping("/{customerId}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateCustomer(@PathVariable UUID customerId){
        deactivateCustomerUseCase.execute(new DeactivateCustomerCommand(customerId));
    }

}
