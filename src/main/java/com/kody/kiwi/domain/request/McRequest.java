package com.kody.kiwi.domain.request;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class McRequest {
    @NotBlank
    private SelectionMode mode;
    @NotNull
    private Short id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;}
