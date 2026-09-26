package dtwg.mptc.ecommerce.common.domain.dto;

public record CommandOrderAddress(

        String street,
        String postalCode,
        String city
) {

}
