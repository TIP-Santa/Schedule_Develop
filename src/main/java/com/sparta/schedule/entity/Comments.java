package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Comments")
@NoArgsConstructor
public class Comments extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentsKey;
    @Column(nullable = false)
    private String commenter;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private String commentsPassword;
    @Column(nullable = false)
    private Long userKey;

//    @ManyToOne
//    @JoinColumn
//    private Schedule scheduleKey;

}
