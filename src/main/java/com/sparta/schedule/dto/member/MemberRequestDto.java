package com.sparta.schedule.dto.member;

import com.sparta.schedule.entity.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class MemberRequestDto {
    @NotBlank(message = "이름을 입력해주세요.")
    private String userName;
    @Email(message = "유효한 이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String userEmail;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
    @NotNull(message = "권한을 입력해주세요.")
    private UserRoleEnum userRole;
}
