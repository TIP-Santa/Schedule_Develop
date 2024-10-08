package com.sparta.schedule_develop.dto;

import com.sparta.schedule_develop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long scheduleKey;
    private String userName;
    private String scheduleTitle;
    private String scheduleDescription;
    private LocalDate scheduleDate;
//    private String schedulePassword;
    private String userId;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleKey = schedule.getScheduleKey();
        this.userName = schedule.getUserName();
        this.scheduleTitle = schedule.getScheduleTitle();
        this.scheduleDescription = schedule.getScheduleDescription();
        this.scheduleDate = schedule.getScheduleDate();
        this.userId = schedule.getUserId();
        this.createDateTime = schedule.getCreateDateTime();
        this.updateDateTime = schedule.getUpdateDateTime();
    }
}
