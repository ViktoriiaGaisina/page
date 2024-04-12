package com.eazybytes.page.controller;

import com.eazybytes.page.dto.StatisticDto;
import com.eazybytes.page.service.StaticService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api("Добавление к постам ")
@RequestMapping("/api/v1/coment")
public class StatisticController {
    private final StaticService staticService;
    @Operation(description = "получить информацию по статистике сайта")
    @GetMapping("/statistic-info")
    public List<StatisticDto> getStatisticByDate(@RequestParam LocalDate from,@RequestParam LocalDate to) {
        return staticService.getStatisticByDate(from, to);
    }
}