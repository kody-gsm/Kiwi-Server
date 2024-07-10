package com.kody.kiwi.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CalendarRequest {
    @NotBlank(message = "Date must not be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
