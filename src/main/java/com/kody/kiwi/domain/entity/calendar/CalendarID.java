package com.kody.kiwi.domain.entity.calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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
    public CalendarID(Long id, LocalDate date){
        this.id = id;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarID that = (CalendarID) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }
}
