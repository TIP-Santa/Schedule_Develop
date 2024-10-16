package com.sparta.schedule.dto.comments;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentsRequestDto {
    @NotBlank(message = "댓글을 기록할 일정의 schedule_key를 입력해주세요.")
    private Long scheduleKey;
    @NotBlank(message = "이름을 입력해주세요.")
    private String commenter;
    @NotBlank(message = "댓글 내용을 입력해주세요.")
    private String comments;
}
