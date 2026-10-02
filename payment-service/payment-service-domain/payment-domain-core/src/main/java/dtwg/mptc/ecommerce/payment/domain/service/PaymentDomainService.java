package dtwg.mptc.ecommerce.payment.domain.service;


import dtwg.mptc.ecommerce.domain.valueobject.PaymentStatus;
import dtwg.mptc.ecommerce.payment.domain.entity.CreditEntry;
import dtwg.mptc.ecommerce.payment.domain.entity.CreditHistory;
import dtwg.mptc.ecommerce.payment.domain.entity.Payment;

public interface PaymentDomainService {
  CreditHistory validateAndInitiatePayment(Payment payment, CreditEntry creditEntry);

  void updatePaymentStatus(Payment payment, PaymentStatus newPaymentStatus);
}
