package com.sparta.schedule_develop.dto;

import com.sparta.schedule_develop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleResponseDto {
    private Long scheduleKey;
    private String userName;
    private LocalDate scheduleDate;
    private String scheduleTitle;
    private String scheduleDescription;
//    private String schedulePassword;
    private String userId;

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleKey = schedule.getScheduleKey();
        this.userName = schedule.getUserName();
        this.scheduleTitle = schedule.getScheduleTitle();
        this.scheduleDescription = schedule.getScheduleDescription();
        this.scheduleDate = schedule.getScheduleDate();
        this.userId = schedule.getUserId();
    }

    public ScheduleResponseDto(Long scheduleKey, String userName, LocalDate scheduleDate, String scheduleTitle, String scheduleDescription, String userId) {
        this.scheduleKey = scheduleKey;
        this.userName = userName;
        this.scheduleDate = scheduleDate;
        this.scheduleTitle = scheduleTitle;
        this.scheduleDescription = scheduleDescription;
        this.userId = userId;

    }
}
