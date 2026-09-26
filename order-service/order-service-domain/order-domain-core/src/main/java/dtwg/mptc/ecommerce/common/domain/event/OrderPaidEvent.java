package dtwg.mptc.ecommerce.common.domain.event;

import dtwg.mptc.ecommerce.common.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent{
    public OrderPaidEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
