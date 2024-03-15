package com.eazybytes.page.service;

import com.eazybytes.page.dto.ComentDTO;
import com.eazybytes.page.dto.LikesDTO;
import com.eazybytes.page.dto.PostsDTO;
import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.LikesEntity;
import com.eazybytes.page.entity.PostsEntity;
import com.eazybytes.page.exception.NotFoundException;
import com.eazybytes.page.mapper.ComentMapper;
import com.eazybytes.page.mapper.LikesMapper;
import com.eazybytes.page.repository.ComentRepository;
import com.eazybytes.page.repository.LikesRepository;
import com.eazybytes.page.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final ComentRepository comentRepository;
    private final PostsRepository postsRepository;
    private final LikesRepository likesRepository;
    private final ComentMapper comentMapper;
    private final LikesMapper likesMapper;

   @Transactional
    public void createComent(Long postsId, ComentDTO comentDTO) {
        PostsEntity post = postsRepository.findById(postsId)
                .orElseThrow(()-> new NotFoundException("не найдено id"));
        ComentEntity coment = comentMapper.toEntity(comentDTO);
        ComentEntity comentEntitySave =comentRepository.save(coment);
        post.getComentList().add(comentEntitySave);
        PostsEntity postEntitySave = postsRepository.save(post);
    }
    @Transactional
    public void createLikes(Long postsId, LikesDTO likesDTO) {
       PostsEntity post = postsRepository.findById(postsId)
               .orElseThrow(()->new NotFoundException("не найдено по айди"));
        LikesEntity like = likesMapper.toEntity(likesDTO);
        LikesEntity likesEntitySave = likesRepository.save(like);
        post.getLikesList().add(likesEntitySave);
        PostsEntity postsEntitySave = postsRepository.save(post);
    }
}
