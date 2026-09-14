package dtwg.mptc.ecommerce.order.persistence.adaptor;

import dtwg.mptc.ecommerce.domain.entity.Order;
import dtwg.mptc.ecommerce.domain.port.output.OrderRepository;
import dtwg.mptc.ecommerce.order.persistence.repository.OrderJpaRepository;

public class OrderRepositoryAdaptor implements OrderRepository {

    private  final OrderJpaRepository orderJpaRepository;

    public OrderRepositoryAdaptor(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public void save(Order order) {

    }
}
