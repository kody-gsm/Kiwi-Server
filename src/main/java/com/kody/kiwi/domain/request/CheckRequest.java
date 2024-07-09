package com.kody.kiwi.domain.request;

import com.kody.kiwi.domain.entity.enums.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckRequest {
    private Short grade;
}
