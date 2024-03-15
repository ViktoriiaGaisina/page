package com.eazybytes.page.controller;

import com.eazybytes.page.dto.UsersDTO;
import com.eazybytes.page.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Api( "Профиль пользователя")
public class UsersController {
    private final UsersService usersService;
    @Operation(description= "Найти всех пользователей по id")
    @GetMapping("/{id}")
    public UsersDTO getUsersById(@PathVariable Long id) {
        return usersService.getByUsersById(id);
    }
}
