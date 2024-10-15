package com.sparta.schedule.entitiy;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private Long scheduleKey;
    private String writerName;
    private LocalDate scheduleDate;
    private String scheduleTitle;
    private String scheduleDescription;
    private String schedulePassword;
}
