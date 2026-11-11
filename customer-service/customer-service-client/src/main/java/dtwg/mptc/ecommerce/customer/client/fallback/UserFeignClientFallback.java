package dtwg.mptc.ecommerce.customer.client.fallback;

import dtwg.mptc.ecommerce.customer.client.dto.UserResponse;
import dtwg.mptc.ecommerce.customer.client.exception.UserServiceUnavailableException;
import dtwg.mptc.ecommerce.customer.client.feign.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public UserResponse getById(String id) {

        log.info("UserFeignClientFallBack: getById: {}" , id );

        throw  new UserServiceUnavailableException("User service is unavailable now");

    }
}
