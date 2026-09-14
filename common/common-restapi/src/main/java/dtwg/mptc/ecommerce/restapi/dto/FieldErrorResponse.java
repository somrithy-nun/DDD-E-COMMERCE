package dtwg.mptc.ecommerce.restapi.dto;

import lombok.Builder;

@Builder
public record FieldErrorResponse(
        String field,
        String code,
        String reason
) {

}
