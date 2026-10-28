package dtwg.mptc.ecommerce.user.controller;

import dtwg.mptc.ecommerce.user.dto.UserCreateRequest;
import dtwg.mptc.ecommerce.user.dto.UserResponse;
import dtwg.mptc.ecommerce.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse create(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        return userService.create(userCreateRequest);
    }
}

