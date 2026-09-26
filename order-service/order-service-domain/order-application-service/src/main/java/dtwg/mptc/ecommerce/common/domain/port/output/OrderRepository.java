package dtwg.mptc.ecommerce.common.domain.port.output;

import dtwg.mptc.ecommerce.common.domain.entity.Order;

public interface OrderRepository {

    Order saveOrder(Order order);
}
