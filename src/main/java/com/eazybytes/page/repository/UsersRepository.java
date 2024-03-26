package com.eazybytes.page.repository;

import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    long countByCreateDateAfter(LocalDateTime date);
}