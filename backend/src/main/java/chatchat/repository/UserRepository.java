package chatchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chatchat.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
