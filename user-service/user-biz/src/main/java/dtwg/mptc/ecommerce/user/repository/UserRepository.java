package dtwg.mptc.ecommerce.user.repository;

import dtwg.mptc.ecommerce.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity,String> {

    boolean existsByUsername(String username);

}
