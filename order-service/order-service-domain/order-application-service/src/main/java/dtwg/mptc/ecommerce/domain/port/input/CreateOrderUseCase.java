package dtwg.mptc.ecommerce.domain.port.input;

import dtwg.mptc.ecommerce.domain.port.dto.CreateOrderRequest;

public interface CreateOrderUseCase {

    void execute(CreateOrderRequest createOrderRequest);

}
