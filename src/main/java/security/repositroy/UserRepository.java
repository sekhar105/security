package security.repositroy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import security.entites.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmailAdress(String emailAdress);
}
