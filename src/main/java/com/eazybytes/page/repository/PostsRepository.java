package com.eazybytes.page.repository;

import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<PostsEntity, Long> {
}
