package security.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import security.entites.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer>{

	
}
