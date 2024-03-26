package com.eazybytes.page.repository;

import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public  interface LikesRepository extends JpaRepository<LikesEntity, Long> {
}
