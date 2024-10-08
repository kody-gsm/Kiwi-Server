package com.kody.kiwi.domain.request;
import com.kody.kiwi.domain.entity.enums.SelectionMode;
import lombok.Data;

@Data
public class FilterRequest {
    private String grade;
    private SelectionMode mode;
}