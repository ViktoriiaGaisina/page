package com.eazybytes.page.dto;

import com.eazybytes.page.entity.ComentEntity;
import com.eazybytes.page.entity.PostsEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikesDTO {
    private Long id;
    private String name;
}
