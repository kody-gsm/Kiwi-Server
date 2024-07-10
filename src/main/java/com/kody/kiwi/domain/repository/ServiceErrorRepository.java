package com.kody.kiwi.domain.repository;

import com.kody.kiwi.domain.entity.Absent;
import com.kody.kiwi.domain.entity.ServiceError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceErrorRepository extends JpaRepository<ServiceError, Long> {
    List<ServiceError> findAllByOrderByCreatedAtDesc();
}

