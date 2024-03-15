package com.eazybytes.page.mapper;

import com.eazybytes.page.dto.ComentDTO;
import com.eazybytes.page.entity.ComentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ComentMapper {
    private final LikesMapper likesMapper;

    public ComentDTO comentDTO(ComentEntity comentEntity) {
        return ComentDTO.builder()
                .id(comentEntity.getComentId())
                .name(comentEntity.getName())
                .likesList(comentEntity.getLikesList().stream()
                        .map(likesMapper::toDto)
                        .collect(Collectors.toList()))
                .totalLikeToComents(comentEntity.getLikesList().size())
                .build();
    }
    public ComentEntity toEntity(ComentDTO comentDTO) {
        return ComentEntity.builder()
                .comentId(comentDTO.getId())
                .name(comentDTO.getName())
                .likesList(comentDTO.getLikesList().stream()
                        .map(likesMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
