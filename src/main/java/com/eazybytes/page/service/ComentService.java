package com.eazybytes.page.service;

import com.eazybytes.page.commentmat.CommentCensor;
import com.eazybytes.page.dto.CommentPostDTO;
import com.eazybytes.page.dto.PostsDTO;
import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.PostsEntity;
import com.eazybytes.page.exception.NotFoundException;
import com.eazybytes.page.mapper.ComentMapper;
import com.eazybytes.page.mapper.PostsMapper;
import com.eazybytes.page.repository.ComentRepository;
import com.eazybytes.page.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ComentService {
    private final ComentRepository comentRepository;
    private final PostsRepository postsRepository;
    private final ComentMapper comentMapper;
    private final PostsMapper postsMapper;

    @Transactional
    public PostsDTO createComent(Long postsId, CommentPostDTO comentDTO) {
        PostsEntity post = postsRepository.findById(postsId)
                .orElseThrow(() -> new NotFoundException("не нашлось"));
        ComentEntity coment = new ComentEntity();
        coment.setName(comentDTO.getName());
       
        String commentText = coment.getName();
        commentText = CommentCensor.censorComment(commentText);
        coment.setName(commentText);

        ComentEntity comentEntity = comentRepository.save(coment);
        post.getComentList().add(comentEntity);
        PostsEntity postEntity = postsRepository.save(post);
        return postsMapper.toDto(postEntity);
    }
}
