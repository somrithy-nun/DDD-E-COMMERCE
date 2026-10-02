package dtwg.mptc.ecommerce.payment.domain.output;


import dtwg.mptc.ecommerce.payment.domain.entity.CreditHistory;

public interface CreditHistoryRepository {
    CreditHistory save(CreditHistory creditHistory);
}
