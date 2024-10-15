package com.sparta.schedule.controller;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
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
    public ScheduleResponseDto updateSchedule(@PathVariable Long scheduleKey, @RequestBody ScheduleRequestDto updateScheduleRequestDto){
        return scheduleService.updateSchedule(scheduleKey, updateScheduleRequestDto);
    }


    @DeleteMapping("/{scheduleKey}")
    public Long deleteSchedule(@PathVariable Long scheduleKey){
        return scheduleService.deleteSchedule(scheduleKey);
    }
}
