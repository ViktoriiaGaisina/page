package com.eazybytes.page.dto;

import com.eazybytes.page.entity.PostsEntity;
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
public class UsersDTO {
    private Long id;
    private String name;
    private List<PostsDTO> postsList;
    private Integer totalPosts;
}
