package dtwg.mptc.ecommerce.order.persistence.adapter;

import dtwg.mptc.ecommerce.order.domain.entity.Order;
import dtwg.mptc.ecommerce.order.domain.port.output.OrderRepository;
import dtwg.mptc.ecommerce.order.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private  final OrderJpaRepository orderJpaRepository;

    @Override
    public void saveOrder(Order order) {

    }
}
