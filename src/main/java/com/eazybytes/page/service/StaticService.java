package com.eazybytes.page.service;

import com.eazybytes.page.repository.PostsRepository;
import com.eazybytes.page.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StaticService {

    private final UsersRepository usersRepository;

    private final PostsRepository postsRepository;

    }

