package dtwg.mptc.ecommerce.business.domain.service;


import dtwg.mptc.ecommerce.business.domain.entity.Business;
import dtwg.mptc.ecommerce.business.domain.event.OrderApprovalEvent;

import java.util.List;

public interface BusinessDomainService {
    OrderApprovalEvent validateOrder(Business business, List<String> failureMessages);
}
