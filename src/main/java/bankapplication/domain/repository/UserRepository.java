package bankapplication.domain.repository;

import bankapplication.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);

    boolean existsByCardNumber(String number);
}
