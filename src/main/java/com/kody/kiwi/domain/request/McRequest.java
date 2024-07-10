package com.kody.kiwi.domain.request;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class McRequest {
    @NotBlank
    private SelectionMode mode;
}
