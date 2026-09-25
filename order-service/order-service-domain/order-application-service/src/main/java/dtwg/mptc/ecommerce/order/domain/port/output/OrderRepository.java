package dtwg.mptc.ecommerce.order.domain.port.output;

import dtwg.mptc.ecommerce.order.domain.entity.Order;

public interface OrderRepository {

    Order saveOrder(Order order);
}
