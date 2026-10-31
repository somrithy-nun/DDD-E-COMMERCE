package dtwg.mptc.ecommerce.user.service;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface KeycloakUserService {
    void createKeycloakUser(UserRepresentation userRepresentation);

    UserRepresentation getKeycloakUserByUsername(String userUpdateRequest);

    void updateKeycloakUser(String id, UserRepresentation userRepresentation);

    UserRepresentation getKeycloakUserById(String id);

    void deleteKeycloakUserById(String id);

    Slice<UserRepresentation> getKeycloakUsers(Pageable pageable);

    Slice<UserRepresentation> getKeycloakUsersByRoleName(String roleName, Pageable pageable);
}
