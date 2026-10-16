package dtwg.mptc.ecommerce.business.domain.port;


import dtwg.mptc.ecommerce.business.domain.entity.Business;

import java.util.Optional;

public interface BusinessRepository {

    Optional<Business> findBusinessInformation(Business business);

}
