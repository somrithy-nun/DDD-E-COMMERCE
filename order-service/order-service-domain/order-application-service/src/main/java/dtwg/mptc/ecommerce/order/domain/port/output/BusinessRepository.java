package dtwg.mptc.ecommerce.order.domain.port.output;


import dtwg.mptc.ecommerce.domain.entity.Business;

import java.util.Optional;
import java.util.UUID;

public interface BusinessRepository {
    Optional<Business> findBusiness(UUID businessId);
}
