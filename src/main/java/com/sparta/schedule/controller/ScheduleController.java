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

    // 일정 작성
    // RequestBody : writerName, ScheduleTitle, ScheduleDescription, SchedulePassword, user_Key
    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto createScheduleRequestDto){
        return scheduleService.createSchedule(createScheduleRequestDto);
    }

    // 전체 일정 조회 (페이징)
    // URL : /api/schedule?page=0&size=10
    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return scheduleService.getAllSchedules(page, size);
    }

    // 특정 일정 수정
    // URL : /api/schedule/{scheduleKey}
    // RequestBody : scheduleTitle, schedule_Description, schedule_password
    @PutMapping("/{scheduleKey}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long scheduleKey, @RequestBody ScheduleRequestDto updateScheduleRequestDto){
        return scheduleService.updateSchedule(scheduleKey, updateScheduleRequestDto);
    }

    // 특정 일정 삭제
    // URL : /api/schedule/{scheduleKey}
    // RequestBody : schedulePassword
    @DeleteMapping("/{scheduleKey}")
    public Long deleteSchedule(@PathVariable Long scheduleKey, @RequestBody ScheduleRequestDto deleteScheduleRequestDto){
        return scheduleService.deleteSchedule(scheduleKey, deleteScheduleRequestDto);
    }
}
