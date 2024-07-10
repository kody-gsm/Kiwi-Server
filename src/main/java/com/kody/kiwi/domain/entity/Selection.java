package com.kody.kiwi.domain.entity;


import com.kody.kiwi.domain.entity.enums.SelectionMode;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "selection")
@NoArgsConstructor
@Getter
public class Selection {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private SelectionMode mode;
    @Builder
    public Selection(User user,Long id,SelectionMode mode) {
        this.id = id;
        this.user = user;
        this.mode = mode;
    }
}
