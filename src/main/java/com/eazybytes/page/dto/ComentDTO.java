package com.eazybytes.page.dto;

import com.eazybytes.page.entity.LikesEntity;
import com.eazybytes.page.entity.PostsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComentDTO {
    private Long id;
    private String name;
    private List<LikesDTO> likesList;
    private Integer totalLikeToComents;
}
