package dtwg.mptc.ecommerce.common.domain.service;

import dtwg.mptc.ecommerce.common.domain.entity.Business;
import dtwg.mptc.ecommerce.common.domain.entity.Order;
import dtwg.mptc.ecommerce.common.domain.event.OrderCancelledEvent;
import dtwg.mptc.ecommerce.common.domain.event.OrderCreatedEvent;
import dtwg.mptc.ecommerce.common.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Business business);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);

}
