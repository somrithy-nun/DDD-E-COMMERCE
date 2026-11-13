package dtwg.mptc.ecommerce.customer.restapi.controller;

import dtwg.mptc.ecommerce.core.PageResponse;
import dtwg.mptc.ecommerce.customer.client.dto.UserResponse;
import dtwg.mptc.ecommerce.customer.client.feign.UserFeignClient;
import dtwg.mptc.ecommerce.customer.domain.dto.CustomerResult;
import dtwg.mptc.ecommerce.customer.domain.dto.GetCustomersQuery;
import dtwg.mptc.ecommerce.customer.domain.usecase.GetAllCustomersUseCase;
import dtwg.mptc.ecommerce.customer.restapi.dto.CustomerResponse;
import dtwg.mptc.ecommerce.customer.restapi.mapper.CustomerWebMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerQueryController {

    private  final UserFeignClient userFeignClient;
    private final GetAllCustomersUseCase getAllCustomersUseCase;
    private final CustomerWebMapper customerWebMapper;


    @GetMapping
    public PageResponse<CustomerResponse> getAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "25") int size
    ) {
        PageResponse<CustomerResult> result = getAllCustomersUseCase.execute(new GetCustomersQuery(page, size));
        return customerWebMapper.toCustomerResponse(result);
    }

    @GetMapping("/check-user/{userId}")
    public UserResponse checkUser(@PathVariable String userId){
        return userFeignClient.getById(userId);
    }
}
