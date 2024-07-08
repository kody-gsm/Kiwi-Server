package com.kody.kiwi.domain.entity;


import com.kody.kiwi.domain.entity.enums.SelectionMode;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@Getter
public class Selection {
    @Id
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    @MapsId("id")
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
