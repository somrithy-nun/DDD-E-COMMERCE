package dtwg.mptc.ecommerce.order.persistence.adapter;

import dtwg.mptc.ecommerce.order.domain.entity.Order;
import dtwg.mptc.ecommerce.order.domain.port.output.OrderRepository;
import dtwg.mptc.ecommerce.order.persistence.entity.OrderEntity;
import dtwg.mptc.ecommerce.order.persistence.mapper.OrderPersistenceMapper;
import dtwg.mptc.ecommerce.order.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private  final OrderJpaRepository orderJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;


    @Override
    public Order saveOrder(Order order) {
        OrderEntity orderEntity = orderPersistenceMapper.orderToOrderEntity(order);

        // Map OrderEntity to Order
        return orderPersistenceMapper.orderEntityToOrder(orderJpaRepository.save(orderEntity));


    }
}
