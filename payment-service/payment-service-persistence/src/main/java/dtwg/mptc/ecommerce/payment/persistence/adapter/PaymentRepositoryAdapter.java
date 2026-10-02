package dtwg.mptc.ecommerce.payment.persistence.adapter;

import dtwg.mptc.ecommerce.payment.domain.entity.Payment;
import dtwg.mptc.ecommerce.payment.domain.output.PaymentRepository;
import dtwg.mptc.ecommerce.payment.persistence.entity.PaymentEntity;
import dtwg.mptc.ecommerce.payment.persistence.mapper.PaymentPersistenceMapper;
import dtwg.mptc.ecommerce.payment.persistence.repository.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {
  private final PaymentJpaRepository paymentJpaRepository;
  private final PaymentPersistenceMapper paymentPersistenceMapper;

  @Override
  public Payment savePayment(Payment payment) {
    PaymentEntity paymentEntity = paymentPersistenceMapper.paymentToPaymentEntity(payment);
    PaymentEntity savedPaymentEntity = paymentJpaRepository.save(paymentEntity);
    return paymentPersistenceMapper.paymentEntityToPayment(savedPaymentEntity);
  }
}
