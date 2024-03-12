package com.eazybytes.page.mapper;

import com.eazybytes.page.dto.LikesDTO;
import com.eazybytes.page.entity.LikesEntity;
import org.springframework.stereotype.Component;

@Component
public class LikesMapper {
    public LikesDTO toDto(LikesEntity likesEntity) {
        return LikesDTO.builder()
                .id(likesEntity.getLikeid())
                .name(likesEntity.getName())
                .build();
    }
    public LikesEntity toEntity(LikesDTO likesDTO) {
        return LikesEntity.builder()
                .likeid(likesDTO.getId())
                .name(likesDTO.getName())
                .build();
    }
}
