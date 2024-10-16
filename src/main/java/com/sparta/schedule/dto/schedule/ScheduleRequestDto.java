package com.sparta.schedule.dto.schedule;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleRequestDto {
    private String writerName;
    private LocalDate scheduleDate;
    private String scheduleTitle;
    private String scheduleDescription;
}

