package com.sparta.schedule_develop.entity;

import com.sparta.schedule_develop.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleKey;

    @Column(name = "username", nullable = false)
    private String userName;
    @Column(name = "scheduleDate", nullable = false)
    private LocalDate scheduleDate;
    @Column(name = "scheduleTitle", nullable = false)
    private String scheduleTitle;
    @Column(name = "scheduledescription", nullable = false)
    private String scheduleDescription;
    @Column(name = "schedulePassword", nullable = false)
    private String schedulePassword;
    @Column(name = "userId", nullable = false)
    private String userId;

    public void update(ScheduleRequestDto updateScheduleRequestDto) {
        this.userName = updateScheduleRequestDto.getUserName();
        this.scheduleDate = updateScheduleRequestDto.getScheduleDate();
        this.scheduleTitle = updateScheduleRequestDto.getScheduleTitle();
        this.scheduleDescription = updateScheduleRequestDto.getScheduleDescription();
    }
}
