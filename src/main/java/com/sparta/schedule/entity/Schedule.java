package com.sparta.schedule.entity;

import com.sparta.schedule.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="schedule")
@NoArgsConstructor
public class Schedule extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleKey;
    @Column(nullable = false)
    private String writerName;
    @Column(nullable = false)
    private String scheduleTitle;
    @Column(nullable = false, length = 500)
    private String scheduleDescription;
    @Column(nullable = false)
    private String schedulePassword;
    @Column(nullable = false)
    private Long userKey;

    public Schedule(ScheduleRequestDto createScheduleRequestDto) {
        this.writerName = createScheduleRequestDto.getWriterName();
        this.scheduleTitle = createScheduleRequestDto.getScheduleTitle();
        this.scheduleDescription = createScheduleRequestDto.getScheduleDescription();
        this.schedulePassword = createScheduleRequestDto.getSchedulePassword();
    }
    public void update(ScheduleRequestDto updateScheduleRequestDto) {
        this.scheduleTitle = updateScheduleRequestDto.getScheduleTitle();
        this.scheduleDescription = updateScheduleRequestDto.getScheduleDescription();
        this.schedulePassword = updateScheduleRequestDto.getSchedulePassword();
    }
}