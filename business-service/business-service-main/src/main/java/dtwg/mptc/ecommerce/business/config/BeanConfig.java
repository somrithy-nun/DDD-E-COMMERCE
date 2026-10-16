package dtwg.mptc.ecommerce.business.config;

import dtwg.mptc.ecommerce.business.domain.service.BusinessDomainService;
import dtwg.mptc.ecommerce.business.domain.service.BusinessDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public BusinessDomainService businessDomainService() {
        return new BusinessDomainServiceImpl();
    }
}
