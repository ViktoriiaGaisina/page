package com.eazybytes.page.service;

import com.eazybytes.page.dto.ComentDTO;
import com.eazybytes.page.dto.PostsDTO;
import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.mapper.ComentMapper;
import com.eazybytes.page.mapper.LikesMapper;
import com.eazybytes.page.mapper.PostsMapper;
import com.eazybytes.page.repository.ComentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentService {
    private final ComentRepository comentRepository;
    private final ComentMapper comentMapper;
    private final LikesMapper likesMapper;
    private final PostsMapper postsMapper;

    public ComentDTO createComent(Long id, ComentDTO comentDTO, PostsDTO postsDTO) {
        ComentEntity coments = comentMapper.toEntity(comentDTO);
        coments.setPosts(postsMapper.toEntity(postsDTO));
        ComentEntity entitysave = comentRepository.save(coments);
        postsDTO.getComentList().add(comentMapper.comentDTO(entitysave));
        return comentMapper.comentDTO(entitysave);
    }
}
