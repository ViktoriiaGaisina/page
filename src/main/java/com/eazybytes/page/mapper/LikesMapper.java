package com.eazybytes.page.mapper;

import com.eazybytes.page.dto.LikesDTO;
import com.eazybytes.page.entity.LikesEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LikesMapper {
    public LikesDTO toDto(LikesEntity likesEntity) {
        return LikesDTO.builder()
                .id(likesEntity.getLikeId())
                .build();
    }
    public LikesEntity toEntity(LikesDTO likesDTO) {
        return LikesEntity.builder()
                .likeId(likesDTO.getId())
                .build();
    }
    public List<LikesEntity> toEntityList(List<LikesDTO> likesDTOs) {
        if (likesDTOs == null) {
            return null;
        }
        return likesDTOs.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
