package com.kody.kiwi.domain.response;

import com.kody.kiwi.domain.entity.enums.Gender;
import com.kody.kiwi.domain.entity.enums.SelectionMode;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CalendarResponse {
    private String username;
    private Gender gender;
    private Short school_number;
    private SelectionMode mode;
    private LocalDate date;
}
