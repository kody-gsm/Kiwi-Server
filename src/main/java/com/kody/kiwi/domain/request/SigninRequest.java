package com.kody.kiwi.domain.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class SigninRequest {
    @NotBlank(message = "이메일이 비어있습니다.")
    private String email;
    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;
}
