package com.kody.kiwi.domain.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Entity

@Table(name = "notice")
@Data
public class Notice extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;
}