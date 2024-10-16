package com.sparta.schedule.dto.comments;

import com.sparta.schedule.entity.Comments;
import lombok.Getter;

@Getter
public class CommentsResponseDto {
    private Long scheduleKey;
    private Long commentsKey;
    private String commenter;
    private String comments;

    public CommentsResponseDto(Comments comments) {
        this.scheduleKey = comments.getSchedule().getScheduleKey();
        this.commentsKey = comments.getCommentsKey();
        this.commenter = comments.getCommenter();
        this.comments = comments.getComments();
    }
}