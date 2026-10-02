package dtwg.mptc.ecommerce.payment;

import dtwg.mptc.ecommerce.payment.domain.service.PaymentDomainService;
import dtwg.mptc.ecommerce.payment.domain.service.PaymentDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
  @Bean
  public PaymentDomainService paymentDomainService() {
    return new PaymentDomainServiceImpl();
  }
}
