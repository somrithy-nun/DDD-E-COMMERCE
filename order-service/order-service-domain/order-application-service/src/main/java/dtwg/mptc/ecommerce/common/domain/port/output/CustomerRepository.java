package dtwg.mptc.ecommerce.common.domain.port.output;

import dtwg.mptc.ecommerce.common.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findCustomer(UUID customerId);
}
