package dtwg.mptc.ecommerce.payment.domain.dto;


import dtwg.mptc.ecommerce.domain.valueobject.PaymentStatus;

import java.util.UUID;

public record CreatePaymentResult(
    UUID paymentId,
    PaymentStatus paymentStatus
) {
}
