package com.kody.kiwi.domain.entity;
import com.kody.kiwi.domain.entity.enums.SelectionMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SelectionId implements Serializable {
    @JoinColumn(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private SelectionMode mode;
}