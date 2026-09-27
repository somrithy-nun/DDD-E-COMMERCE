package dtwg.mptc.ecommerce.order.domain.exception;

import dtwg.mptc.ecommerce.domain.exception.DomainException;


public class OrderDomainException  extends  DomainException{


    public OrderDomainException(String message) {
        super(message);
    }

    public OrderDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
