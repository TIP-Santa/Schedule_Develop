package com.sparta.schedule.dto.comments;

import com.sparta.schedule.entity.Comments;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentsResponseDto {
    private Long scheduleKey;
    private Long commentsKey;
    private String commenter;
    private String comments;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;

    public CommentsResponseDto(Comments comments) {
        this.scheduleKey = comments.getSchedule().getScheduleKey();
        this.commentsKey = comments.getCommentsKey();
        this.commenter = comments.getCommenter();
        this.comments = comments.getComments();
        this.createdDateTime = comments.getCreatedDateTime();
        this.modifiedDateTime = comments.getModifiedDateTime();
    }
}
