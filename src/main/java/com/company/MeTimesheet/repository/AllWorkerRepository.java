package com.company.MeTimesheet.repository;

import com.company.MeTimesheet.entity.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllWorkerRepository extends JpaRepository<Workers, Long> {
}
