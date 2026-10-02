package dtwg.mptc.ecommerce.payment.domain.exception;


import dtwg.mptc.ecommerce.domain.exception.DomainException;

public class PaymentDomainException extends DomainException {
  public PaymentDomainException(String message) {
    super(message);
  }

  public PaymentDomainException(String message, Throwable cause) {
    super(message, cause);
  }
}
