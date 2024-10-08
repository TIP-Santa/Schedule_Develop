package com.sparta.schedule_develop.controller;

import com.sparta.schedule_develop.dto.ScheduleRequestDto;
import com.sparta.schedule_develop.dto.ScheduleResponseDto;
import com.sparta.schedule_develop.service.ScheduleService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final JdbcTemplate jdbcTemplate;
    public ScheduleController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto createScheduleRequestDto){
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.createSchedule(createScheduleRequestDto);
    }

    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules(){
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.getAllSchedules();
    }

    @PutMapping("/{scheduleKey}")
    public Long updateSchedule(@PathVariable Long scheduleKey, @RequestBody ScheduleRequestDto updateScheduleRequestDto){
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.getUpdateSchedule(scheduleKey, updateScheduleRequestDto);
    }

    @DeleteMapping("/{scheduleKey}")
    public Long deleteSchedule(@PathVariable Long scheduleKey){
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.getDeleteSchedule(scheduleKey);
    }


}
