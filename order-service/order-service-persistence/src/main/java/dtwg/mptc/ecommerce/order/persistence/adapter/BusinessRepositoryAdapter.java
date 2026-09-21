package dtwg.mptc.ecommerce.order.persistence.adapter;

import dtwg.mptc.ecommerce.domain.entity.Business;
import dtwg.mptc.ecommerce.order.domain.port.output.BusinessRepository;
import dtwg.mptc.ecommerce.order.persistence.mapper.OrderPersistenceMapper;
import dtwg.mptc.ecommerce.order.persistence.repository.BusinessJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class BusinessRepositoryAdapter implements BusinessRepository {

    private  final BusinessJpaRepository businessJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Optional<Business> findBusiness(UUID businessId) {
        return businessJpaRepository.findById(businessId)
                .map(orderPersistenceMapper::businessEntityToBusiness);
    }
}

