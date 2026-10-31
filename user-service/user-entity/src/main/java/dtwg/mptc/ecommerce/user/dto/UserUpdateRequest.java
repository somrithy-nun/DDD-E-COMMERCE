package dtwg.mptc.ecommerce.user.dto;


import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record UserUpdateRequest(


        String familyName,
        String givenName,
        String gender,
        String address,
        String mobilePhone, // use , as delimiter
        Date birthday

) {


}
