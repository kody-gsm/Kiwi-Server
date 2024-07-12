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

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public List<NoticeResponse> getAllNotices() {
        return noticeMapper.getAllNotices();
    }

    public Optional<NoticeResponse> getNoticeById(Long id) {
        NoticeResponse notice = noticeMapper.getNoticeById(id);
        return Optional.ofNullable(notice);
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
        NoticeResponse noticeResponse = noticeMapper.getNoticeById(id);
        if (noticeResponse == null) {
            throw new RuntimeException("Notice not found");
        }

        Notice notice = toEntity(noticeResponse);
        notice.setTitle(noticeRequest.getTitle());
        notice.setContent(noticeRequest.getContent());

        noticeMapper.updateNotice(notice);
        return noticeMapper.getNoticeById(id);
    }

    public void deleteNotice(Long id) {
        NoticeResponse noticeResponse = noticeMapper.getNoticeById(id);
        if (noticeResponse == null) {
            throw new RuntimeException("Notice not found");
        }

        noticeMapper.deleteNotice(id);
    }

    private NoticeResponse toResponse(Notice notice) {
        NoticeResponse response = new NoticeResponse();
        response.setId(notice.getId());
        response.setTitle(notice.getTitle());
        response.setContent(notice.getContent());
        response.setCreated_at(notice.getCreatedAt());
        return response;
    }

    private Notice toEntity(NoticeResponse response) {
        Notice notice = new Notice();
        notice.setId(response.getId());
        notice.setTitle(response.getTitle());
        notice.setContent(response.getContent());
        notice.setCreatedAt(response.getCreated_at());
        return notice;
    }
}
