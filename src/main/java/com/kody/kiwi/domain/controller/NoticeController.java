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
// 모든 공지사항을 조회
    @GetMapping
    public List<NoticeResponse> getAllNotices() {
        return noticeService.getAllNotices();
    }
// 특정 ID를 가진 공지사항을 조회
    @GetMapping("/{id}")
    public ResponseEntity<NoticeResponse> getNoticeById(@PathVariable Long id) {
        NoticeResponse noticeResponse = noticeService.getNoticeById(id)
                .orElseThrow(() -> new RuntimeException("Notice not found"));
        return ResponseEntity.ok(noticeResponse);
    }
// 새로운 공지사항을 생성
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public NoticeResponse createNotice(@RequestBody NoticeRequest noticeRequest) {
        return noticeService.createNotice(noticeRequest);
    }
// 기존 공지사항을 수정
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<NoticeResponse> updateNotice(@PathVariable Long id, @RequestBody NoticeRequest noticeRequest) {
        NoticeResponse updatedNotice = noticeService.updateNotice(id, noticeRequest);
        return ResponseEntity.ok(updatedNotice);
    }
// 특정 ID를 가진 공지사항을 삭제
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}