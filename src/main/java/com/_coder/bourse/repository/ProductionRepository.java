package com._coder.bourse.repository;

import com._coder.bourse.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductionRepository extends JpaRepository<Production,Integer> {

}
