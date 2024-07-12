package com.kody.kiwi.domain.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NoticeResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created_at;
}