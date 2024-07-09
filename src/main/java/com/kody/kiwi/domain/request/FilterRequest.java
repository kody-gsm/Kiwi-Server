package com.kody.kiwi.domain.request;
import com.kody.kiwi.domain.entity.enums.SelectionMode;
import lombok.Data;

@Data
public class FilterRequest {
    private Short grade;
    private SelectionMode mode;
}