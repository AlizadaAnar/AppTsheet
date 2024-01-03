package com.company.MeTimesheet.repository;

import com.company.MeTimesheet.entity.ProductRaport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRaportRepository extends JpaRepository<ProductRaport, Long> {
}
