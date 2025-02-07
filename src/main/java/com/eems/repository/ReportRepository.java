package com.eems.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eems.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    // Custom query methods if needed
	@Override
	Report save(Report report);

}
