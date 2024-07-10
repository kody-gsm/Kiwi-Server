package com.kody.kiwi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "error")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Error extends BaseTime{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String schoolNumber;

    @Column
    private String title;

    @Column
    private String content;
}
