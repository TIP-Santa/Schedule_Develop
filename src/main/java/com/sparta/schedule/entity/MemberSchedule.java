package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "member_schedule")
public class MemberSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberScheduleKey;

    @ManyToOne
    @JoinColumn(name = "user_key")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "schedule_key")
    private Schedule schedule;
}
