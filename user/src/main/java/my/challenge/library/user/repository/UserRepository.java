package my.challenge.library.user.repository;

import my.challenge.library.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find user by email
     * @param email {@link String}
     * @return {@link User}
     */
    User getByEmail(String email);
}
