package com.kody.kiwi.domain.service;

import com.kody.kiwi.domain.entity.Notice;
import com.kody.kiwi.domain.request.NoticeRequest;
import com.kody.kiwi.domain.response.NoticeResponse;
import com.kody.kiwi.domain.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class NoticeService {


    @Autowired
    private NoticeMapper noticeMapper;

    public List<NoticeResponse> getAllNotices() {
        List<Notice> notices = noticeMapper.getAllNotices();
        return notices.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public Optional<NoticeResponse> getNoticeById(Long id) {
        Notice notice = noticeMapper.getNoticeById(id);
        return Optional.ofNullable(notice).map(this::toResponse);
    }

    public NoticeResponse createNotice(NoticeRequest noticeRequest) {
        Notice notice = new Notice();
        notice.setTitle(noticeRequest.getTitle());
        notice.setContent(noticeRequest.getContent());
        notice.setCreatedAt(LocalDateTime.now());

        noticeMapper.insertNotice(notice);
        return toResponse(notice);
    }

    public NoticeResponse updateNotice(Long id, NoticeRequest noticeRequest) {
        Notice notice = noticeMapper.getNoticeById(id);
        if (notice == null) {
            throw new RuntimeException("Notice not found");
        }

        notice.setTitle(noticeRequest.getTitle());
        notice.setContent(noticeRequest.getContent());

        noticeMapper.updateNotice(notice);
        return toResponse(notice);
    }

    public void deleteNotice(Long id) {
        Notice notice = noticeMapper.getNoticeById(id);
        if (notice == null) {
            throw new RuntimeException("Notice not found");
        }

        noticeMapper.deleteNotice(id);
    }

    private NoticeResponse toResponse(Notice notice) {
        NoticeResponse response = new NoticeResponse();
        response.setId(notice.getId());
        response.setTitle(notice.getTitle());
        response.setContent(notice.getContent());
        response.setCreatedAt(notice.getCreatedAt());
        return response;
    }
}
