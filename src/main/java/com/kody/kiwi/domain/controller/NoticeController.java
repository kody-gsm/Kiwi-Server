package com.kody.kiwi.domain.controller;

import com.kody.kiwi.domain.request.NoticeRequest;
import com.kody.kiwi.domain.response.NoticeResponse;
import com.kody.kiwi.domain.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public List<NoticeResponse> getAllNotices() {
        return noticeService.getAllNotices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticeResponse> getNoticeById(@PathVariable Long id) {
        NoticeResponse noticeResponse = noticeService.getNoticeById(id)
                .orElseThrow(() -> new RuntimeException("Notice not found"));
        return ResponseEntity.ok(noticeResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public NoticeResponse createNotice(@RequestBody NoticeRequest noticeRequest) {
        return noticeService.createNotice(noticeRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<NoticeResponse> updateNotice(@PathVariable Long id, @RequestBody NoticeRequest noticeRequest) {
        NoticeResponse updatedNotice = noticeService.updateNotice(id, noticeRequest);
        return ResponseEntity.ok(updatedNotice);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}