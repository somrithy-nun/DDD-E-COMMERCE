package dtwg.mptc.ecommerce.user.mapper;

import dtwg.mptc.ecommerce.user.dto.UserCreateRequest;
import dtwg.mptc.ecommerce.user.dto.UserResponse;
import dtwg.mptc.ecommerce.user.UserEntity;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface UserMapper {

    UserEntity toEntity(UserCreateRequest userCreateRequest);

    UserResponse toResponse(UserEntity userEntity);

    @Mapping(source = "familyName", target = "firstName")
    @Mapping(source = "givenName", target = "lastName")
    UserRepresentation toRepresentation(UserCreateRequest userCreateRequest);

}
