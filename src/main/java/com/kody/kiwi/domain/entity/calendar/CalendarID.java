package com.kody.kiwi.domain.entity.calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Embeddable
@NoArgsConstructor
@Setter
public class CalendarID implements Serializable {
    @Column
    private Long id;

    @Column
    private LocalDate date;

    @Builder
    public CalendarID(Long Id, LocalDate date){
        this.id = Id;
        this.date = date;
    }
}
