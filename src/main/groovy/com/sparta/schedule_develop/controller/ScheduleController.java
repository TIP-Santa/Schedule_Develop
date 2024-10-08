package com.sparta.schedule_develop.controller;

import com.sparta.schedule_develop.dto.ScheduleRequestDto;
import com.sparta.schedule_develop.dto.ScheduleResponseDto;
import com.sparta.schedule_develop.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto createScheduleRequestDto){
        // RequestDto > Entity
        Schedule schedule = new Schedule();
        // Schedule Max Key Check
        Long maxKey = scheduleList.size() > 0 ? Collections.max(scheduleList.keySet()) +1 : 1;
        schedule.setScheduleKey(maxKey);
        // DB 저장
        scheduleList.put(schedule.getScheduleKey(), schedule);
        // Entity > ResponseDto
        ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
        return responseDto;
    }

    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules(){
        //Map To List
        List<ScheduleResponseDto> getAllScheduleResponseList = scheduleList.values().stream()
                .map(ScheduleResponseDto::new).toList();
        return getAllScheduleResponseList;
    }

    @PutMapping("/{scheduleKey}")
    public Long updateSchedule(@PathVariable Long scheduleKey, @RequestBody ScheduleRequestDto updateScheduleRequestDto){
        // 해당 일정이 DB에 존재하는지 확인
        if(scheduleList.containsKey(scheduleKey)){
            //해당 일정 가져오기
            Schedule schedule = scheduleList.get(scheduleKey);
            // 일정 수정
            schedule.update(updateScheduleRequestDto);
            return schedule.getScheduleKey();
        } else {
            throw new IllegalArgumentException("선택한 일정이 존재하지 않습니다.");
        }
    }

    @DeleteMapping("/{scheduleKey}")
    public Long deleteSchedule(@PathVariable Long scheduleKey){
        // 해당 일정이 DB에 존재하는지 확인
        if(scheduleList.containsKey(scheduleKey)){
            // 해당 일정 삭제
            scheduleList.remove(scheduleKey);
            return scheduleKey;
        } else {
         throw new IllegalArgumentException("선택한 일정이 존재하지 않습니다.");
        }
    }


}
