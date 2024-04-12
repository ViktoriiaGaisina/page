package com.eazybytes.page.mapper;

import com.eazybytes.page.dto.StatisticDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticMapper {

    public static class StatisticInfoMapper implements RowMapper<StatisticDto> {
        @Override
        public StatisticDto mapRow(ResultSet rs, int i) throws SQLException {
            return StatisticDto.builder()
                    .countUsersRegister(rs.getLong("count_users_register"))
                    .countPost(rs.getLong("count_post"))
                    .countisNotComment(rs.getLong("countis_not_comment"))
                    .countIsNotLiked(rs.getLong("count_is_not_liked"))
                    .build();
        }
    }
}
