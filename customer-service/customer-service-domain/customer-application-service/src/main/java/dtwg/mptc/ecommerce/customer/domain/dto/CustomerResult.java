package dtwg.mptc.ecommerce.customer.domain.dto;

import dtwg.mptc.ecommerce.business.domain.valueobject.CustomerStatus;
import dtwg.mptc.ecommerce.business.domain.valueobject.LoyaltyTier;

import java.util.UUID;

public record CustomerResult(
        UUID customerId,
        String username,
        String familyName,
        String givenName,
        String email,
        String phoneNumber,
        LoyaltyTier loyaltyTier,
        CustomerStatus status
) {
}
