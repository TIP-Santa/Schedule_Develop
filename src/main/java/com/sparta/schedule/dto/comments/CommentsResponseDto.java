package com.sparta.schedule.dto.comments;

import lombok.Getter;

@Getter
public class CommentsResponseDto {
    private Long scheduleKey;
    private Long commentsKey;
    private String commenter;
    private String comments;
}
