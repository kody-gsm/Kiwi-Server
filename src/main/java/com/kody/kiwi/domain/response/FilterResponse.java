package com.kody.kiwi.domain.response;

import lombok.Data;

@Data
public class FilterResponse {
    private String gender;
    private Short school_number;
    private String mode;
    private String username;
}