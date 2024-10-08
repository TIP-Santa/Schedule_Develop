package com.sparta.schedule_develop.entity;

import com.sparta.schedule_develop.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleKey;

    @Column(name = "username", nullable = false)
    private String userName;
    @Column(name = "schedule_date", nullable = false)
    private LocalDate scheduleDate;
    @Column(name = "schedule_title", nullable = false)
    private String scheduleTitle;
    @Column(name = "schedule_description", nullable = false)
    private String scheduleDescription;
    @Column(name = "schedule_password", nullable = false)
    private String schedulePassword;
    @Column(name = "user_id", nullable = false)
    private String userId;

    public void update(ScheduleRequestDto updateScheduleRequestDto) {
        this.userName = updateScheduleRequestDto.getUserName();
        this.scheduleDate = updateScheduleRequestDto.getScheduleDate();
        this.scheduleTitle = updateScheduleRequestDto.getScheduleTitle();
        this.scheduleDescription = updateScheduleRequestDto.getScheduleDescription();
    }
}
