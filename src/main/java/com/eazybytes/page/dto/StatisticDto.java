package com.eazybytes.page.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticDto {
    private long countUsersRegister;
    private Long countPost;
    private Long countisNotComment;
    private Long countIsNotLiked;
}
