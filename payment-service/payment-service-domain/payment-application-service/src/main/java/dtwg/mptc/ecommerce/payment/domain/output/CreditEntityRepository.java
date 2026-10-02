package dtwg.mptc.ecommerce.payment.domain.output;


import dtwg.mptc.ecommerce.domain.valueobject.CustomerId;
import dtwg.mptc.ecommerce.payment.domain.entity.CreditEntry;

public interface CreditEntityRepository  {
    CreditEntry findByCustomerId(CustomerId customerId);

    CreditEntry save(CreditEntry creditEntry);
}
