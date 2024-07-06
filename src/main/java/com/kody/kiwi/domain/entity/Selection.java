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
    @EmbeddedId
    private SelectionId id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    @MapsId("id")
    private User user;

    @Builder
    public Selection(User user) {
        this.id = new SelectionId(user.getId(), SelectionMode.NONE);
        this.user = user;
    }
}
