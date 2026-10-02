package dtwg.mptc.ecommerce.payment.persistence.mapper;

import dtwg.mptc.ecommerce.domain.valueobject.CreditHistoryId;
import dtwg.mptc.ecommerce.domain.valueobject.CustomerId;
import dtwg.mptc.ecommerce.domain.valueobject.Money;
import dtwg.mptc.ecommerce.payment.domain.entity.CreditHistory;
import dtwg.mptc.ecommerce.payment.persistence.entity.CreditHistoryEntity;
import org.springframework.stereotype.Component;

// Written by hand: CreditHistory has a private constructor + custom Builder and wraps fields in value objects
@Component
public class CreditHistoryPersistenceMapper {

  public CreditHistoryEntity creditHistoryToCreditHistoryEntity(CreditHistory creditHistory) {
    CreditHistoryEntity creditHistoryEntity = new CreditHistoryEntity();
    creditHistoryEntity.setId(creditHistory.getId().value());
    creditHistoryEntity.setCustomerId(creditHistory.getCustomerId().value());
    creditHistoryEntity.setAmount(creditHistory.getAmount().getAmount());
    creditHistoryEntity.setTransactionType(creditHistory.getTransactionType());
    return creditHistoryEntity;
  }

  public CreditHistory creditHistoryEntityToCreditHistory(CreditHistoryEntity creditHistoryEntity) {
    return CreditHistory.builder()
        .id(new CreditHistoryId(creditHistoryEntity.getId()))
        .customerId(new CustomerId(creditHistoryEntity.getCustomerId()))
        .amount(new Money(creditHistoryEntity.getAmount()))
        .transactionType(creditHistoryEntity.getTransactionType())
        .build();
  }
}
