package dtwg.mptc.ecommerce.customer.domain.port.output;


import dtwg.mptc.ecommerce.business.domain.valueobject.CustomerId;
import dtwg.mptc.ecommerce.core.PageResponse;
import dtwg.mptc.ecommerce.customer.domain.dto.CustomerResult;
import dtwg.mptc.ecommerce.entity.Customer;

import java.util.Optional;

public interface CustomerRepository {
    PageResponse<CustomerResult> findAll(int page, int size);
    Customer save(Customer customer);
    Optional<Customer> findById(CustomerId customerId);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
