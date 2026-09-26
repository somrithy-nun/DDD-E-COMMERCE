package dtwg.mptc.ecommerce.common.domain.port.input;

import dtwg.mptc.ecommerce.common.domain.dto.CreateOrderCommand;

public interface ExplicitPort {

    void execute(CreateOrderCommand createOrderCommand);

}
