package com.eazybytes.page.mapper;

import com.eazybytes.page.dto.UsersDTO;
import com.eazybytes.page.entity.UsersEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersMapper {
    private final PostsMapper postsMapper;
    public UsersDTO toDto(UsersEntity usersEntity) {
        return UsersDTO.builder()
                .id(usersEntity.getId())
                .name(usersEntity.getName())
                .postsList(usersEntity.getPostsList().stream()
                        .map(postsMapper::toDto)
                        .toList())
                .totalPosts(usersEntity.getPostsList().size())
                .build();
    }
}
