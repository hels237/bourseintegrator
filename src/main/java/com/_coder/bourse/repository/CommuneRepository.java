package com._coder.bourse.repository;

import com._coder.bourse.model.Council;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommuneRepository extends JpaRepository<Council,Integer> {
}
