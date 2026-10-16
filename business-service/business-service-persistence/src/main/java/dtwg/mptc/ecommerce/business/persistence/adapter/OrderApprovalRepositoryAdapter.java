package dtwg.mptc.ecommerce.business.persistence.adapter;

import dtwg.mptc.ecommerce.business.persistence.entity.OrderApprovalEntity;
import dtwg.mptc.ecommerce.business.domain.entity.OrderApproval;
import dtwg.mptc.ecommerce.business.domain.port.OrderApprovalRepository;
import dtwg.mptc.ecommerce.business.persistence.mapper.OrderApprovalPersistenceMapper;
import dtwg.mptc.ecommerce.business.persistence.repository.OrderApprovalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderApprovalRepositoryAdapter implements OrderApprovalRepository {

    private final OrderApprovalJpaRepository orderApprovalJpaRepository;
    private final OrderApprovalPersistenceMapper orderApprovalPersistenceMapper;

    @Override
    public OrderApproval save(OrderApproval orderApproval) {
        OrderApprovalEntity orderApprovalEntity = orderApprovalPersistenceMapper.orderApprovalToOrderApprovalEntity(orderApproval);

        return orderApprovalPersistenceMapper.orderApprovalEntityToOrderApproval(orderApprovalJpaRepository.save(orderApprovalEntity));
    }
}
