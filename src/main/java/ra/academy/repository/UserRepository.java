package ra.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.academy.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsername(String username);
}
