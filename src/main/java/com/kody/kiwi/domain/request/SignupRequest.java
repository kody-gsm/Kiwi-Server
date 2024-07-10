package com.kody.kiwi.domain.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {
    @NotBlank(message = "이름이 비어있습니다.")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "이름은 특수문자를 제외한 2~10자리여야 합니다.")
    private String username;

    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;
    private String pwCheck;

    @NotBlank(message = "이메일이 비어있습니다.")
    private String email;

    @NotBlank(message = "성별이 비어있습니다.")
    private String gender;

    @NotNull(message = "학번이 비어있습니다.")
    private Short schoolNumber;
}
