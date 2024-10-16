package com.sparta.schedule.entity;

import com.sparta.schedule.dto.schedule.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDate scheduleDate;
    @Column(nullable = false)
    private String scheduleTitle;
    @Column(nullable = false, length = 500)
    private String scheduleDescription;


    @OneToMany(mappedBy = "schedule")
    private List<Comments> commentsList = new ArrayList<>();

    public void addComments(Comments comments) {
        this.commentsList.add(comments);
        comments.setSchedule(this);
    }

    public Schedule(ScheduleRequestDto createScheduleRequestDto) {
        this.writerName = createScheduleRequestDto.getWriterName();
        this.scheduleDate = createScheduleRequestDto.getScheduleDate();
        this.scheduleTitle = createScheduleRequestDto.getScheduleTitle();
        this.scheduleDescription = createScheduleRequestDto.getScheduleDescription();
    }
    public void update(ScheduleRequestDto updateScheduleRequestDto) {
        this.scheduleDate = updateScheduleRequestDto.getScheduleDate();
        this.scheduleTitle = updateScheduleRequestDto.getScheduleTitle();
        this.scheduleDescription = updateScheduleRequestDto.getScheduleDescription();
    }
}