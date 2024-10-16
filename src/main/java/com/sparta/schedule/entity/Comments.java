package com.sparta.schedule.entity;

import com.sparta.schedule.dto.comments.CommentsRequestDto;
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
    private String comments;

    @ManyToOne
    @JoinColumn(name = "schedule_key")
    private Schedule schedule;

    public Comments(CommentsRequestDto createCommentsRequestDto) {
        this.commenter = createCommentsRequestDto.getCommenter();
        this.comments = createCommentsRequestDto.getComments();
    }

    public void update(CommentsRequestDto updateCommentsRequestDto) {
        this.comments = updateCommentsRequestDto.getComments();
    }
}
