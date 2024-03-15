package com.eazybytes.page.dto;

import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.LikesEntity;
import com.eazybytes.page.entity.UsersEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsDTO {
    private Long id;
    private String name;
    private List<ComentDTO> comentList;
    private List<LikesDTO> likesList;
    private Integer totaLikeToPosts;
}
