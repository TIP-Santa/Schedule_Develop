package com.sparta.schedule.dto.comments;

import lombok.Getter;

@Getter
public class CommentsRequestDto {
    private Long scheduleKey;
    private String commenter;
    private String comments;
}
