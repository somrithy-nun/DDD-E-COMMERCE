package dtwg.mptc.ecommerce.payment.persistence.mapper;

import dtwg.mptc.ecommerce.domain.valueobject.CreditEntryId;
import dtwg.mptc.ecommerce.domain.valueobject.CustomerId;
import dtwg.mptc.ecommerce.domain.valueobject.Money;
import dtwg.mptc.ecommerce.payment.domain.entity.CreditEntry;
import dtwg.mptc.ecommerce.payment.persistence.entity.CreditEntryEntity;
import org.springframework.stereotype.Component;

// Written by hand: CreditEntry has a private constructor + custom Builder and wraps fields in value objects
@Component
public class CreditEntryPersistenceMapper {

  public CreditEntryEntity creditEntryToCreditEntryEntity(CreditEntry creditEntry) {
    CreditEntryEntity creditEntryEntity = new CreditEntryEntity();
    creditEntryEntity.setId(creditEntry.getId().value());
    creditEntryEntity.setCustomerId(creditEntry.getCustomerId().value());
    creditEntryEntity.setTotalCreditAmount(creditEntry.getTotalCreditAmount().getAmount());
    return creditEntryEntity;
  }

  public CreditEntry creditEntryEntityToCreditEntry(CreditEntryEntity creditEntryEntity) {
    return CreditEntry.builder()
        .id(new CreditEntryId(creditEntryEntity.getId()))
        .customerId(new CustomerId(creditEntryEntity.getCustomerId()))
        .totalCreditAmount(new Money(creditEntryEntity.getTotalCreditAmount()))
        .build();
  }
}
