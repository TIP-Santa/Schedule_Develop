package com.sparta.schedule_develop.entity;

import com.sparta.schedule_develop.dto.ScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private Long scheduleKey;
    private String userName;
    private LocalDate scheduleDate;
    private String scheduleTitle;
    private String scheduleDescription;
    private String schedulePassword;
    private String userId;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public void update(ScheduleRequestDto updateScheduleRequestDto) {
        this.userName = updateScheduleRequestDto.getUserName();
        this.scheduleDate = updateScheduleRequestDto.getScheduleDate();
        this.scheduleTitle = updateScheduleRequestDto.getScheduleTitle();
        this.scheduleDescription = updateScheduleRequestDto.getScheduleDescription();
    }
}
