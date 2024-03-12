package com.eazybytes.page.controller;

import com.eazybytes.page.dto.ComentDTO;
import com.eazybytes.page.dto.PostsDTO;
import com.eazybytes.page.service.ComentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@Tag(name = "Коментарии")
@RequestMapping("/api/v1/coment")
public class ComentController {
    private final ComentService comentService;

    @Operation(summary ="возможность добавлять комментарии к постам")
    @PostMapping("/{postId}/comments")
    public ResponseEntity<ComentDTO> addCommentToPost
            (@PathVariable Long postId,
             @RequestBody ComentDTO comentDTO) {
        PostsDTO postDTO = new PostsDTO();
        postDTO.setId(postId);
        ComentDTO createdComment = comentService.createComent(postId, comentDTO, postDTO);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }
}
