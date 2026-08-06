package org.webmarketapp.webmarket.domain.repository;

import org.webmarketapp.webmarket.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByRole(String role);
    Optional<User> findByEmail(String email);
}
