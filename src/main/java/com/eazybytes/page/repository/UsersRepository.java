package com.eazybytes.page.repository;

import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
}
