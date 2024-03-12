package com.eazybytes.page.service;

import com.eazybytes.page.dto.ComentDTO;
import com.eazybytes.page.dto.PostsDTO;
import com.eazybytes.page.dto.UsersDTO;
import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.PostsEntity;
import com.eazybytes.page.entity.UsersEntity;
import com.eazybytes.page.exception.NotFoundException;
import com.eazybytes.page.mapper.ComentMapper;
import com.eazybytes.page.mapper.LikesMapper;
import com.eazybytes.page.mapper.PostsMapper;
import com.eazybytes.page.mapper.UsersMapper;
import com.eazybytes.page.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;
    private final LikesMapper likesMapper;
    private final PostsMapper postsMapper;
    private final ComentMapper comentMapper;

    public UsersDTO getByUsersById(long id) {
        UsersEntity user = usersRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("не найден по айди"));
        List<PostsDTO> postsDtoList = user.getPostsList().stream()
                .map(postsMapper::toDto)
                .toList();
        int totalPosts = user.getPostsList().size();
        int totaLikePosts = 0;
        int totalLikeComents = 0;
        for(PostsDTO postsDto: postsDtoList) {
            totaLikePosts+=postsDto.getLikesList().size();
            for(ComentDTO comentDto : postsDto.getComentList()) {
                totalLikeComents+=comentDto.getLikesList().size();
            }
        }
        return usersMapper.toDto(user);
    }
}
