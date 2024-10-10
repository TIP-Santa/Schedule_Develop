package com.sparta.schedule_develop.controller;

import com.sparta.schedule_develop.dto.ScheduleRequestDto;
import com.sparta.schedule_develop.dto.ScheduleResponseDto;
import com.sparta.schedule_develop.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 일정 작성
    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto createScheduleRequestDto){
        return scheduleService.createSchedule(createScheduleRequestDto);
    }

    // 일정 조회
    @GetMapping("/search")
    public List<ScheduleResponseDto> getSchedule(@RequestParam(value = "scheduleKey", required = false) Long scheduleKey,
                                           @RequestParam(value = "userName", required = false) String userName,
                                           @RequestParam(value = "scheduleDate", required = false) LocalDate scheduleDate){
        return scheduleService.getSchedule(scheduleKey, userName, scheduleDate);
    }

    // 일정 수정
    @PutMapping
    public Long updateSchedule(@RequestParam Long scheduleKey, @RequestBody ScheduleRequestDto updateScheduleRequestDto){
        return scheduleService.updateSchedule(scheduleKey, updateScheduleRequestDto);
    }

    // 일정 삭제
    @DeleteMapping
    public Long deleteSchedule(@RequestParam Long scheduleKey){
        return scheduleService.deleteSchedule(scheduleKey);
    }
}
