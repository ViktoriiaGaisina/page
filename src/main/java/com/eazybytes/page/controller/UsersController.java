package com.eazybytes.page.controller;

import com.eazybytes.page.dto.UsersDTO;
import com.eazybytes.page.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Профиль пользователя")
public class UsersController {
    private final UsersService usersService;

    @Operation(summary = "При доступе к профилю пользователя показывает список постов с названиями и кол-во лайков и комментариев")
    @GetMapping("/{id}")
    public UsersDTO getUsersById(@PathVariable Long id) {
        return usersService.getByUsersById(id);
    }
}
