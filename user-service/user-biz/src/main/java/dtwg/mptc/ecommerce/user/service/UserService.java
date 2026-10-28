package dtwg.mptc.ecommerce.user.service;

import dtwg.mptc.ecommerce.user.dto.UserCreateRequest;
import dtwg.mptc.ecommerce.user.dto.UserResponse;

public interface UserService {
    UserResponse create(UserCreateRequest userCreateRequest);

}
