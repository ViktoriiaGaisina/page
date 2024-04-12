package com.eazybytes.page.service;

import com.eazybytes.page.dto.ComentDTO;
import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.LikesEntity;
import com.eazybytes.page.entity.PostsEntity;
import com.eazybytes.page.entity.UsersEntity;
import com.eazybytes.page.exception.NotFoundException;
import com.eazybytes.page.mapper.ComentMapper;
import com.eazybytes.page.mapper.LikesMapper;
import com.eazybytes.page.repository.ComentRepository;
import com.eazybytes.page.repository.LikesRepository;
import com.eazybytes.page.repository.PostsRepository;
import com.eazybytes.page.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final ComentRepository comentRepository;
    private final PostsRepository postsRepository;
    private final LikesRepository likesRepository;
    private final UsersRepository usersRepository;
    private final ComentMapper comentMapper;
    private final LikesMapper likesMapper;

    @Transactional
    public void createComent(Long postsId, ComentDTO comentDTO) {
        PostsEntity post = postsRepository.findById(postsId)
                .orElseThrow(() -> new NotFoundException("не найдено id"));
        ComentEntity coment = comentMapper.toEntity(comentDTO);
        ComentEntity comentEntitySave = comentRepository.save(coment);
        post.getComentList().add(comentEntitySave);
        PostsEntity postEntitySave = postsRepository.save(post);
    }

    /*доработать метод - проставления лайков над постом
    можем как поставить так и убрать лайк
     1 юзер может поставить 1 лайк под 1 постом
     И доделать вызов в кейсе когда лайк убираем

Что нужно сделать
Открепить в таблице пост лайк
Дальше открепить от юзера лайк
И после удаляем саму запись о лайке

1 нужно понять под какой фоткой ставим лайк и кто его ставит
2 посмотреть у того кто хочет поставить лайк под фото есть ли уже проставленный лайк под этим фото
для этого ты бежим по всем айкуам юзера и смотрим какую фотку он пролайкал
для этого нам нужен вернутся и  сравнить с айди аргумента*/
    @Transactional
    public void createAndUpdateLikes(Long postsId, Long userId) {
        PostsEntity post = postsRepository.findById(postsId)
                .orElseThrow(() -> new NotFoundException("не найдено по айди"));
        UsersEntity user = usersRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("не найден"));
        Long likeId = getLike(user.getLikesEntities(), postsId);
        if (likeId != null) {
            deleteLikesById(likeId, post, user);
        } else {
            LikesEntity like = new LikesEntity();
            like.setPost(post);
            LikesEntity likesEntitySave = likesRepository.save(like);
            user.getLikesEntities().add(likesEntitySave);
            usersRepository.save(user);
            post.getLikesList().add(likesEntitySave);
            postsRepository.save(post);

        }
    }

    private void deleteLikesById(long likeId, PostsEntity post, UsersEntity user) {
        user.getLikesEntities().removeIf(like -> like.getLikeId().equals(likeId));
        usersRepository.save(user);
        post.getLikesList().removeIf(lik -> lik.getLikeId().equals(likeId));
        postsRepository.save(post);
        likesRepository.deleteById(likeId);
    }

    private Long getLike(List<LikesEntity> likes, Long postsId) {
        return likes.stream()
                .filter(tmp -> tmp.getPost().getPostsId().equals(postsId))
                .map(LikesEntity::getLikeId)
                .findFirst().orElse(null);
    }
}
