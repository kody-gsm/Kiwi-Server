package com.kody.kiwi.domain.request;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ReservationRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank(message = "ReservationDate must not be blank")
    private LocalDate reservationDate;
    @NotBlank(message = "SchoolId must not be blank")
    private String schoolId;
    @NotBlank(message = "Mode must not be blank")
    private SelectionMode mode;
}
