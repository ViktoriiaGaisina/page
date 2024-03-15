package com.eazybytes.page.controller;

import com.eazybytes.page.dto.ComentDTO;
import com.eazybytes.page.dto.LikesDTO;
import com.eazybytes.page.dto.PostsDTO;
import com.eazybytes.page.service.ComentService;
import com.eazybytes.page.service.PostsService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api("Добавление к постам ")
@RequestMapping("/api/v1/coment")
public class ComentController {
    private final ComentService comentService;
    private final PostsService postsService;
    @Operation(description= "Создать комментарий к посту")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{postsId}/comments")
    public PostsDTO createComent (@PathVariable Long postsId, @RequestBody ComentDTO comentDTO) {
        return comentService.createComent(postsId, comentDTO );
    }
    @Operation(description= "Создать лайк под постом")
    @PostMapping("{postsId}/likes")
    public void createLikes(@PathVariable Long postsId, @RequestBody LikesDTO likesDTO) {
        postsService.createLikes(postsId, likesDTO);
    }
}
