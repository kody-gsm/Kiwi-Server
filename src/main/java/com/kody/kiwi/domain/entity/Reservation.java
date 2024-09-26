package com.kody.kiwi.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Table
@Entity
@Getter
@RequiredArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;

    private String schoolNum;
    private LocalDate date;

    @Builder
    public Reservation(String schoolNum,LocalDate date) {
        this.schoolNum = schoolNum;
        this.date = date;
    }
}
