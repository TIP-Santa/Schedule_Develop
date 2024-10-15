package com.sparta.schedule.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ScheduleResponseDto {
    private Long scheduleKey;
    private String writerName;
    private LocalDate scheduleDate;
    private String scheduleTitle;
    private String scheduleDescription;
    private LocalDateTime modifiedDateTime;
}
