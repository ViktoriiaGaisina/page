package com.eazybytes.page.repository;

import com.eazybytes.page.entity.ComentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentRepository extends JpaRepository<ComentEntity, Long> {
}
