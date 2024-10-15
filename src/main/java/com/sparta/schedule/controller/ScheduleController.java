package com.sparta.schedule.controller;

import com.sparta.schedule.dto.ScheduleRequestDte;
import com.sparta.schedule.dto.ScheduleResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDte createScheduleRequestDte){
        return null;
    }

    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules(){
        return null;
    }

    @PutMapping("/{scheduleKey}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long scheduleKey, @RequestBody ScheduleRequestDte updateScheduleRequestDte){
        return null;
    }

    @DeleteMapping("/{scheduleKey}")
    public void deleteSchedule(@PathVariable Long scheduleKey){

    }
}
