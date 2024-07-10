package com.kody.kiwi.domain.entity.calendar;

import com.kody.kiwi.domain.entity.User;
import com.kody.kiwi.domain.entity.enums.SelectionMode;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Calendar")
@NoArgsConstructor
@Getter
public class Calendar {
    @EmbeddedId
    private CalendarID id;

    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    @MapsId("id")
    private User user;

    @Enumerated(EnumType.STRING)
    private SelectionMode mode;

    @Builder
    public Calendar(CalendarID id, User user, SelectionMode mode) {
        this.id = id;
        this.user = user;
        this.mode = mode;
    }
}