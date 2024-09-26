package com.kody.kiwi.domain.request;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequest {
    private LocalDate reservationDate;
    private String schoolId;
    private SelectionMode mode;
}
