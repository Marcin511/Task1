package Task.Venture_labs_Task1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String name); // create methods for find user by name

    Optional<User> findByUserNameAndPassword(String name, String password); // create method to login
}
