package com._coder.bourse.repository;

import com._coder.bourse.model.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Integer> {
    Confirmation findByToken(String token);
}
