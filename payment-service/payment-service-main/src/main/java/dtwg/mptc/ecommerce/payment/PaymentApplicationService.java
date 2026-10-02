package dtwg.mptc.ecommerce.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"dtwg.mptc.ecommerce.payment.persistence"})
@EnableJpaRepositories(basePackages = "dtwg.mptc.ecommerce.payment.persistence")
@SpringBootApplication
public class PaymentApplicationService {
  public static void main(String[] args) {
    SpringApplication.run(PaymentApplicationService.class, args);
  }
}
