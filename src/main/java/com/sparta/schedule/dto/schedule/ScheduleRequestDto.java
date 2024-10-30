package com.sparta.schedule.dto.schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ScheduleRequestDto {
    @NotBlank(message = "일정 작성자 이름을 입력해주세요.")
    @Size(min = 2, max = 15, message = "이름은 2 ~ 15자 사이에서 입력할 수 있습니다.")
    private String writerName;
    @NotNull(message = "일정을 설정할 날짜를 입력해주세요.")
    private LocalDate scheduleDate;
    @NotBlank(message = "일정의 제목을 입력해주세요.")
    private String scheduleTitle;
    @NotBlank(message = "일정의 내용을 입력해주세요.")
    private String scheduleDescription;
    private List<Long> managerKeys;
}

