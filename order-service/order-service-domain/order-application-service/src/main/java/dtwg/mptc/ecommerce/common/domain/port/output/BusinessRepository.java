package dtwg.mptc.ecommerce.common.domain.port.output;


import dtwg.mptc.ecommerce.common.domain.entity.Business;

import java.util.Optional;

public interface BusinessRepository {
    Optional<Business> findBusiness(Business business);
}
