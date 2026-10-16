package dtwg.mptc.ecommerce.business.domain.port;


import dtwg.mptc.ecommerce.business.domain.entity.OrderApproval;

public interface OrderApprovalRepository {

    OrderApproval save(OrderApproval orderApproval);

}
