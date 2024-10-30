package com.sparta.schedule.dto.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberRequestDto {
    @NotBlank(message = "이름을 입력해주세요.")
    @Size(min = 2, max = 15, message = "이름은 2 ~ 15자리로 정할 수 있습니다.")
    private String username;
    @Email(message = "유효한 이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String userEmail;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "비밀번호는 대문자, 소문자, 숫자, 특수문자를 포함하여 8자 이상이어야 합니다.")
    private String password;

    private boolean userRole = false;
}
