package com.kody.kiwi.domain.response;

import lombok.Data;

@Data
public class FilterResponse {
    private String Gender;
    private String username;
    private Long id;
    private String mode;
}