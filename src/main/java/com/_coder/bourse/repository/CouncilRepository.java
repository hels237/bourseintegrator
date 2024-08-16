package com._coder.bourse.repository;

import com._coder.bourse.model.Council;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CouncilRepository extends JpaRepository<Council, Integer> {
//    @Query("SELECT DISTINCT c FROM Council c " +
//            "JOIN c.productions p " +
//            "JOIN p.products pr " +
//            "WHERE pr.designation LIKE %:MproductDescription%")
//    Page<Council> findCouncilsByProductionAttributes(
//            @Param("productName") String productName,
//            @Param("productDescription") String productDescription,
//            Pageable pageable);
}