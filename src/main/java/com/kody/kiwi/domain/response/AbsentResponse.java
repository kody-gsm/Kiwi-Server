package com.kody.kiwi.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AbsentResponse {
    private Long id;
    private String userName;
    private String schoolNumber;
}
