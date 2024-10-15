package com.sparta.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String writerName;
    private String scheduleTitle;
    private String scheduleDescription;
    private String schedulePassword;
}

