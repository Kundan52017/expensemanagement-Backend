package com.eems.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eems.model.Approval;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {

}