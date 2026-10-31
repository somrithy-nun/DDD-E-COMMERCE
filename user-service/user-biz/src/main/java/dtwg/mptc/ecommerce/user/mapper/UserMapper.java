package dtwg.mptc.ecommerce.user.mapper;

import dtwg.mptc.ecommerce.user.dto.UserCreateRequest;
import dtwg.mptc.ecommerce.user.dto.UserResponse;
import dtwg.mptc.ecommerce.user.UserEntity;
import dtwg.mptc.ecommerce.user.dto.UserUpdateRequest;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.*;

@Mapper(componentModel = "spring")

public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toEntity(UserUpdateRequest request, @MappingTarget UserEntity entity);


    default UserResponse toResponse(UserEntity userEntity, UserRepresentation userRepresentation){
        return UserResponse.builder()
                .id(userEntity.getId())
                .familyName(userRepresentation.getFirstName())
                .givenName(userRepresentation.getLastName())
                .birthday(userEntity.getBirthday())
                .address(userEntity.getAddress())
                .mobilePhone(userEntity.getMobilePhone())
                .gender(userEntity.getGender())
                .build();
    }

    UserEntity toEntity(UserCreateRequest userCreateRequest);

    UserResponse toResponse(UserEntity userEntity);

    @Mapping(source = "familyName", target = "firstName")
    @Mapping(source = "givenName", target = "lastName")
    UserRepresentation toRepresentation(UserCreateRequest userCreateRequest);

}
