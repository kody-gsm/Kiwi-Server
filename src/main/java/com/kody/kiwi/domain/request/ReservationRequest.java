package com.kody.kiwi.domain.request;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationRequest {
    private Date date;
    private String schoolId;
    private SelectionMode mode;
}
