package com.sparta.schedule.service;

import com.sparta.schedule.dto.SchedulePageResponseDto;
import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // POST
    public ScheduleResponseDto createSchedule(ScheduleRequestDto createScheduleRequestDto) {
        Schedule schedule = new Schedule(createScheduleRequestDto);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        ScheduleResponseDto responseDto = new ScheduleResponseDto(savedSchedule);
        return responseDto;
    }

    // GET
    // findAll
    public SchedulePageResponseDto getAllSchedules(int page, int size) {
        Page<Schedule> schedulePage = scheduleRepository.findAllByOrderByModifiedDateTimeDesc(PageRequest.of(page, size));

        List<ScheduleResponseDto> scheduleDtos = schedulePage.stream()
                .map(ScheduleResponseDto::new)
                .collect(Collectors.toList());

        return new SchedulePageResponseDto(scheduleDtos);
    }

    // PUT
    @Transactional
    public ScheduleResponseDto updateSchedule(Long scheduleKey, ScheduleRequestDto updateScheduleRequestDto) {
        Schedule schedule = findSchedule(scheduleKey);
        schedule.update(updateScheduleRequestDto);
        ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
        return responseDto;
    }

    // DELETE
    public Long deleteSchedule(Long scheduleKey, ScheduleRequestDto deleteScheduleRequestDto) {
        Schedule schedule = findSchedule(scheduleKey);
        scheduleRepository.delete(schedule);
        return scheduleKey;
    }


    // find
    private Schedule findSchedule(Long scheduleKey) {
        return scheduleRepository.findById(scheduleKey).orElseThrow(() ->
                new IllegalArgumentException("선택한 일정이 존재하지 않습니다.")
        );
    }
}
