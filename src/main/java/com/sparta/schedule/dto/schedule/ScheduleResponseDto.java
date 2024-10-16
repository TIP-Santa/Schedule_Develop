package com.sparta.schedule.dto.schedule;

import com.sparta.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long scheduleKey;
    private String writerName;
    private LocalDate scheduleDate;
    private String scheduleTitle;
    private String scheduleDescription;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;


    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleKey = schedule.getScheduleKey();
        this.writerName = schedule.getWriterName();
        this.scheduleDate = schedule.getScheduleDate();
        this.scheduleTitle = schedule.getScheduleTitle();
        this.scheduleDescription = schedule.getScheduleDescription();
        this.createdDateTime = schedule.getCreatedDateTime();
        this.modifiedDateTime = schedule.getModifiedDateTime();
    }
}
