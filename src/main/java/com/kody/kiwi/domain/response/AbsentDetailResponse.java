package com.kody.kiwi.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AbsentDetailResponse {
    private Long id;
    private String title;
    private String content;
    private String started_at;
    private String ended_at;
}