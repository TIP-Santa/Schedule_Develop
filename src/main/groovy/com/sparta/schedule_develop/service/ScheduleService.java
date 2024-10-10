package com.sparta.schedule_develop.service;

import com.sparta.schedule_develop.dto.ScheduleRequestDto;
import com.sparta.schedule_develop.dto.ScheduleResponseDto;
import com.sparta.schedule_develop.entity.Schedule;
import com.sparta.schedule_develop.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).toList();
    }

    // PUT
    @Transactional
    public Long updateSchedule(Long scheduleKey, ScheduleRequestDto updateScheduleRequestDto) {
        // 해당 일정이 DB에 존재하는지 확인
        Schedule schedule = findScheduleByKey(scheduleKey);
        // 일정 내용 수정
        schedule.update(updateScheduleRequestDto);
        return scheduleKey;
    }

    // DELETE
    public Long deleteSchedule(Long scheduleKey) {
        // 해당 일정이 DB에 존재하는지 확인
        Schedule schedule = findScheduleByKey(scheduleKey);

        // 해당 일정 삭제
        scheduleRepository.delete(schedule);
        return scheduleKey;
    }

    private Schedule findScheduleByKey(Long scheduleKey) {
        return scheduleRepository.findById(scheduleKey).orElseThrow(() ->
                new IllegalArgumentException("선택한 일정이 존재하지 않습니다.")
        );
    }
}
