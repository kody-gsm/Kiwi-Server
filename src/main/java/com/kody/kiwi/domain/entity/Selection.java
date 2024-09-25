package com.kody.kiwi.domain.entity;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "selection")
@NoArgsConstructor
@Getter
@Setter
public class Selection {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    private SelectionMode mode;

    private LocalDate date;

    @Builder
    public Selection(User user, Long id, SelectionMode mode, LocalDate date) {
        this.id = id;
        this.date = date != null ? date : LocalDate.now();
        this.user = user;
        this.mode = mode;
    }
}
