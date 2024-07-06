package com.kody.kiwi.domain.repository;

import com.kody.kiwi.domain.entity.Attend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AttendRepository extends JpaRepository<Attend, Long> {
}
