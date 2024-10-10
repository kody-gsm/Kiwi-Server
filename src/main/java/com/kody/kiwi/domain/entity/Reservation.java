package com.kody.kiwi.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Table(name = "reservation")
@Entity
@Getter
@RequiredArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolNum;

    private LocalDate date;

    @Builder
    public Reservation(String schoolNum,LocalDate date) {
        this.schoolNum = schoolNum;
        this.date = date;
    }
}
