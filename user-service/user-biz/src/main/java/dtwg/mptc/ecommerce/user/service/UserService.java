package dtwg.mptc.ecommerce.user.service;

import dtwg.mptc.ecommerce.restapi.dto.PageResponse;
import dtwg.mptc.ecommerce.user.dto.UserCreateRequest;
import dtwg.mptc.ecommerce.user.dto.UserResponse;
import dtwg.mptc.ecommerce.user.dto.UserUpdateRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponse create(UserCreateRequest userCreateRequest);

    UserResponse update(String id, UserUpdateRequest userUpdateRequest);

    UserResponse getById(String id);

    void deleteById(String id);

    UserResponse getByUsername(String username);

    PageResponse<UserResponse> getUsersByRoleName(String roleName, Pageable pageable);

    PageResponse<UserResponse> getUsers(PageRequest of);
}
