package com.eazybytes.page.repository;

import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface LikesRepository extends JpaRepository<LikesEntity, Long> {
}
