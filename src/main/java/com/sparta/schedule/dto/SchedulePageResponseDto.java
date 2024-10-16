package com.sparta.schedule.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class SchedulePageResponseDto {

    private List<ScheduleResponseDto> schedules;
    public SchedulePageResponseDto(List<ScheduleResponseDto> schedules) {
        this.schedules = schedules;
    }
}
