package com.kody.kiwi.domain.response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LogoutResponse {
    private String access;

    private String refresh;
}
