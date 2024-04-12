package com.eazybytes.page.service;

import com.eazybytes.page.dao.StatisticDao;
import com.eazybytes.page.dto.StatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StaticService {

    private final StatisticDao statisticDao;

    public List<StatisticDto> getStatisticByDate(LocalDate from, LocalDate to) {
        return statisticDao.findStatisticByDate(from, to);
    }

    }

