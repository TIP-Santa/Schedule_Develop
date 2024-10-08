package com.sparta.schedule_develop.service;

import com.sparta.schedule_develop.dto.ScheduleRequestDto;
import com.sparta.schedule_develop.dto.ScheduleResponseDto;
import com.sparta.schedule_develop.entity.Schedule;
import com.sparta.schedule_develop.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // POST
    public ScheduleResponseDto createSchedule(ScheduleRequestDto createScheduleRequestDto) {
        // RequestDto > Entity
        Schedule schedule = new Schedule();
        // DB 저장
        Schedule saveSchedule = scheduleRepository.save(schedule);
        // Entity > ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }

    // GET
    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    // PUT
    public Long getUpdateSchedule(Long scheduleKey, ScheduleRequestDto updateScheduleRequestDto) {
        // 해당 일정이 DB에 존재하는지 확인
        Schedule schedule = scheduleRepository.findByKey(scheduleKey);
        if(schedule == null){
            // 일정 내용 수정
            scheduleRepository.update(scheduleKey, updateScheduleRequestDto);
            return scheduleKey;
        } else {
            throw new IllegalArgumentException("선택한 일정이 존재하지 않습니다.");
        }
    }


    public Long getDeleteSchedule(Long scheduleKey) {
        // 해당 일정이 DB에 존재하는지 확인
        Schedule schedule = scheduleRepository.findByKey(scheduleKey);
        if(schedule == null){
            // 해당 일정 삭제
            scheduleRepository.delete(scheduleKey);
            return scheduleKey;
        } else {
            throw new IllegalArgumentException("선택한 일정이 존재하지 않습니다.");
        }
    }
}
