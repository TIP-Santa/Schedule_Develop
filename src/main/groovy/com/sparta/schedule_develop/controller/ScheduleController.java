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

    private ScheduleService scheduleService;
    public ScheduleController(JdbcTemplate jdbcTemplate) {
        this.scheduleService = new ScheduleService(jdbcTemplate);
    }

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto createScheduleRequestDto){
        return scheduleService.createSchedule(createScheduleRequestDto);
    }

    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }

    @PutMapping("/{scheduleKey}")
    public Long updateSchedule(@PathVariable Long scheduleKey, @RequestBody ScheduleRequestDto updateScheduleRequestDto){
        return scheduleService.getUpdateSchedule(scheduleKey, updateScheduleRequestDto);
    }

    @DeleteMapping("/{scheduleKey}")
    public Long deleteSchedule(@PathVariable Long scheduleKey){
        return scheduleService.getDeleteSchedule(scheduleKey);
    }


}
