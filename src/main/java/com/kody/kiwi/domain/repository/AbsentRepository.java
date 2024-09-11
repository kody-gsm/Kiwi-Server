package com.kody.kiwi.domain.repository;

import com.kody.kiwi.domain.entity.Absent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AbsentRepository extends JpaRepository<Absent, Long> {
    List<Absent> findAllByOrderByCreatedAtDesc();
}

