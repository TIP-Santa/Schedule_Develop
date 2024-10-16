package com.sparta.schedule.dto.schedule;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleRequestDto {
    @NotBlank(message = "일정 작성자 이름을 입력해주세요.")
    private String writerName;
    @NotBlank(message = "일정을 설정할 날짜를 입력해주세요.")
    private LocalDate scheduleDate;
    @NotBlank(message = "일정의 제목을 입력해주세요.")
    private String scheduleTitle;
    @NotBlank(message = "일정의 내용을 입력해주세요.")
    private String scheduleDescription;
}

