package com.sparta.schedule_develop.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleRequestDto {
    private String userName;
    private String scheduleTitle;
    private String scheduleDescription;
    private LocalDate scheduleDate;
    private String schedulePassword;
    private String userId;
}
