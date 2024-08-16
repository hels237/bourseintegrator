package com._coder.bourse.repository;

import com._coder.bourse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);
}
