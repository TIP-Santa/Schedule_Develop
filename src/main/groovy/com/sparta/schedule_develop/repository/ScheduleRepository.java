package com.sparta.schedule_develop.repository;

import com.sparta.schedule_develop.dto.ScheduleRequestDto;
import com.sparta.schedule_develop.dto.ScheduleResponseDto;
import com.sparta.schedule_develop.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;
    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // POST
    public Schedule save(Schedule schedule) {
        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체
        String sql = "insert into schedule(" +
                "username, " +
                "schedule_date, " +
                "schedule_title, " +
                "schedule_description, " +
                "schedule_password, " +
                "user_id" +
                ") values(?,?,?,?,?,?)";
        jdbcTemplate.update( con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, schedule.getUserName());
            ps.setDate(2, Date.valueOf(schedule.getScheduleDate()));
            ps.setString(3, schedule.getScheduleTitle());
            ps.setString(4, schedule.getScheduleDescription());
            ps.setString(5, schedule.getSchedulePassword());
            ps.setString(6, schedule.getUserId());
            return ps;
        }, keyHolder);
        // DB Insert 후 받아온 기본 키 확인
        Long key = keyHolder.getKey().longValue();
        schedule.setScheduleKey(key);
        return schedule;
    }

    // GET
    public List<ScheduleResponseDto> findAll() {
        // DB 조회
        String sql = "select * from schedule";
        return jdbcTemplate.query(sql, new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL의 결과로 받아온 schedule 데이터들을 ScheduleResponseDto 타입으로 변환
                Long scheduleKey = rs.getLong("schedule_key");
                String userName = rs.getString("username");
                LocalDate scheduleDate = rs.getDate("schedule_date").toLocalDate();
                String scheduleTitle = rs.getString("schedule_title");
                String scheduleDescription = rs.getString("schedule_description");
                String userId = rs.getString("user_id");
                return new ScheduleResponseDto(scheduleKey, userName, scheduleDate, scheduleTitle, scheduleDescription, userId);
            }
        });
    }

    // PUT
    public void update(Long scheduleKey, ScheduleRequestDto updateScheduleRequestDto) {
        // 일정 내용 수정
        String sql = "update schedule set username = ?, schedule_date = ?, schedule_title = ?, schedule_description= ? where schedule_key= ?";
        jdbcTemplate.update(sql,
                updateScheduleRequestDto.getUserName(),
                updateScheduleRequestDto.getScheduleDate(),
                updateScheduleRequestDto.getScheduleTitle(),
                updateScheduleRequestDto.getScheduleDescription(),
                scheduleKey
        );
    }

    // DELETE
    public void delete(Long scheduleKey) {
        String sql = "delete from schedule where schedule_key= ?";
        jdbcTemplate.update(sql, scheduleKey);
    }

    public Schedule findByKey(Long scheduleKey) {
        // DB 조회
        String sql = "select * from schedule where schedule_key= ?";
        return jdbcTemplate.query(sql, resultSet -> {
            if(resultSet.next()){
                Schedule schedule = new Schedule();
                schedule.setUserName(resultSet.getString("username"));
                schedule.setScheduleDate(resultSet.getDate("schedule_date").toLocalDate());
                schedule.setScheduleTitle(resultSet.getString("schedule_title"));
                schedule.setScheduleDescription(resultSet.getString("schedule_description"));
                schedule.setUserId(resultSet.getString("user_id"));
                return schedule;
            } else {
                return null;
            }
        }, scheduleKey);
    }
}
