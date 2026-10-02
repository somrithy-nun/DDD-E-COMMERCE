package dtwg.mptc.ecommerce.payment.domain.output;


import dtwg.mptc.ecommerce.payment.domain.entity.Payment;

public interface PaymentRepository {
  Payment savePayment(Payment payment);
}
