package com._coder.bourse.repository;

import com._coder.bourse.model.Council;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouncilRepository extends JpaRepository<Council, Integer> {
    @Query(value = "select * from Council c " +
            "join c.productions p " +
            "join p.products pr " +
            "where pr.designation like %?1%", nativeQuery = true)
    Page<Council> findCouncilsByProductionAttributes(String productName, Pageable pageable);
}