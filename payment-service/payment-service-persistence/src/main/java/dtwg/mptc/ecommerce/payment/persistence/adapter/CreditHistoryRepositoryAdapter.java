package dtwg.mptc.ecommerce.payment.persistence.adapter;

import dtwg.mptc.ecommerce.payment.domain.entity.CreditHistory;
import dtwg.mptc.ecommerce.payment.domain.output.CreditHistoryRepository;
import dtwg.mptc.ecommerce.payment.persistence.entity.CreditHistoryEntity;
import dtwg.mptc.ecommerce.payment.persistence.mapper.CreditHistoryPersistenceMapper;
import dtwg.mptc.ecommerce.payment.persistence.repository.CreditHistoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreditHistoryRepositoryAdapter implements CreditHistoryRepository {
  private final CreditHistoryJpaRepository creditHistoryJpaRepository;
  private final CreditHistoryPersistenceMapper creditHistoryPersistenceMapper;

  @Override
  public CreditHistory save(CreditHistory creditHistory) {
    CreditHistoryEntity creditHistoryEntity =
        creditHistoryPersistenceMapper.creditHistoryToCreditHistoryEntity(creditHistory);
    CreditHistoryEntity savedCreditHistoryEntity = creditHistoryJpaRepository.save(creditHistoryEntity);
    return creditHistoryPersistenceMapper.creditHistoryEntityToCreditHistory(savedCreditHistoryEntity);
  }
}
