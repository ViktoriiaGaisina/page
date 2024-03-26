package com.eazybytes.page.repository;

import com.eazybytes.page.entity.ComentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ComentRepository extends JpaRepository<ComentEntity, Long> {
}
