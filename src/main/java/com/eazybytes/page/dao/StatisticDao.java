package com.eazybytes.page.dao;

import com.eazybytes.page.dto.StatisticDto;
import com.eazybytes.page.mapper.StatisticMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StatisticDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<StatisticDto> findStatisticByDate(LocalDate from, LocalDate to) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("fromDate", from);
        params.addValue("toDate", to);
        return namedParameterJdbcTemplate.query(getQuery(), params, new StatisticMapper.StatisticInfoMapper());
    }

    private String getQuery() {
        return "SELECT " +
                "  (SELECT COUNT(*) FROM users WHERE create_date >= :fromDate AND create_date < :toDate) AS countUsersRegister, " +
                "  (SELECT COUNT(*) FROM posts WHERE create_date >= :fromDate AND create_date < :toDate) AS countPost, " +
                "  (SELECT COUNT(*) FROM likes WHERE create_date >= :fromDate AND create_date < :toDate) AS countLikes " +
                "  (SELECT COUNT(*) FROM likes WHERE create_date >= :fromDate AND create_date < :toDate) AS countComment" +
                "FROM dual";

    }

}

