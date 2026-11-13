package dtwg.mptc.ecommerce.customer.domain.mapper;

import dtwg.mptc.ecommerce.customer.domain.dto.CreateCustomerCommand;
import dtwg.mptc.ecommerce.customer.domain.dto.CustomerResult;
import dtwg.mptc.ecommerce.business.domain.valueobject.Email;
import dtwg.mptc.ecommerce.business.domain.valueobject.PhoneNumber;
import dtwg.mptc.ecommerce.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CustomerDataMapper {

    // id and status are not set here: the domain sets them in initiateCustomer()
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "loyaltyTier", ignore = true)
    Customer createCustomerCommandToCustomer(CreateCustomerCommand createCustomerCommand);

    // Domain -> read model: unwrap value objects (CustomerId, Email, PhoneNumber) to plain types
    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "email.value", target = "email")
    @Mapping(source = "phoneNumber.value", target = "phoneNumber")
    CustomerResult customerToCustomerResult(Customer customer);

    default Email toEmail(String email) {
        return email == null ? null : new Email(email);
    }

    default PhoneNumber toPhoneNumber(String phoneNumber) {
        return phoneNumber == null ? null : new PhoneNumber(phoneNumber);
    }

}
