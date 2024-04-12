package com.eazybytes.page.mapper;

import com.eazybytes.page.dto.PostsDTO;
import com.eazybytes.page.entity.PostsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostsMapper {
    private final ComentMapper comentMapper;
    private final LikesMapper likesMapper;
    public PostsDTO toDto(PostsEntity postsEntity) {
        return PostsDTO.builder()
                .id(postsEntity.getPostsId())
                .name(postsEntity.getName())
                .comentList(postsEntity.getComentList().stream()
                        .map(comentMapper::comentDTO)
                        .toList())
                .likesList(postsEntity.getLikesList()!=null?postsEntity.getLikesList().stream()
                        .map(likesMapper::toDto)
                        .toList():null)
                .totaLikeToPosts(postsEntity.getLikesList()!=null?postsEntity.getLikesList().size():null)
                .build();
    }
    public PostsEntity toEntity(PostsDTO postsDTO) {
        return PostsEntity.builder()
                .postsId(postsDTO.getId())
                .name(postsDTO.getName())
                .comentList(postsDTO.getComentList().stream()
                        .map(comentMapper::toEntity)
                        .collect(Collectors.toList()))
                .likesList(postsDTO.getLikesList().stream()
                        .map(likesMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
