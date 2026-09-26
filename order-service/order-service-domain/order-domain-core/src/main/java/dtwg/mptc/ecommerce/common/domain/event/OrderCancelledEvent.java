package dtwg.mptc.ecommerce.common.domain.event;

import dtwg.mptc.ecommerce.common.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent{
    public OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
