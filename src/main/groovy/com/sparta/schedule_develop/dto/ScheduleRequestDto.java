package com.sparta.schedule_develop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleRequestDto {
    private String userName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate scheduleDate;
    private String scheduleTitle;
    private String scheduleDescription;
//    private String schedulePassword;
    private String userId;
}
