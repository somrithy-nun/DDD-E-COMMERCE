package dtwg.mptc.ecommerce.payment.persistence.mapper;

import dtwg.mptc.ecommerce.domain.valueobject.CustomerId;
import dtwg.mptc.ecommerce.domain.valueobject.Money;
import dtwg.mptc.ecommerce.domain.valueobject.OrderId;
import dtwg.mptc.ecommerce.domain.valueobject.PaymentId;
import dtwg.mptc.ecommerce.payment.domain.entity.Payment;
import dtwg.mptc.ecommerce.payment.persistence.entity.PaymentEntity;
import org.springframework.stereotype.Component;

// Written by hand: Payment has a private constructor + custom Builder and wraps fields in value objects
@Component
public class PaymentPersistenceMapper {

  public PaymentEntity paymentToPaymentEntity(Payment payment) {
    PaymentEntity paymentEntity = new PaymentEntity();
    paymentEntity.setId(payment.getId().value());
    paymentEntity.setCustomerId(payment.getCustomerId().value());
    paymentEntity.setOrderId(payment.getOrderId().value());
    paymentEntity.setPrice(payment.getPrice().getAmount());
    paymentEntity.setPaymentStatus(payment.getPaymentStatus());
    paymentEntity.setCreatedAt(payment.getCreatedAt());
    return paymentEntity;
  }

  public Payment paymentEntityToPayment(PaymentEntity paymentEntity) {
    return Payment.builder()
        .id(new PaymentId(paymentEntity.getId()))
        .customerId(new CustomerId(paymentEntity.getCustomerId()))
        .orderId(new OrderId(paymentEntity.getOrderId()))
        .price(new Money(paymentEntity.getPrice()))
        .paymentStatus(paymentEntity.getPaymentStatus())
        .createdAt(paymentEntity.getCreatedAt())
        .build();
  }
}
