package com.kody.kiwi.domain.mapper;

import com.kody.kiwi.domain.entity.Notice;
import com.kody.kiwi.domain.response.NoticeResponse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("SELECT * FROM notice WHERE id = #{id}")
    NoticeResponse getNoticeById(Long id);

    @Select("SELECT * FROM notice")
    List<NoticeResponse> getAllNotices();

    @Insert("INSERT INTO notice (title, content, created_at) VALUES (#{title}, #{content}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertNotice(Notice notice);

    @Update("UPDATE notice SET title = #{title}, content = #{content} WHERE id = #{id}")
    void updateNotice(Notice notice);

    @Delete("DELETE FROM notice WHERE id = #{id}")
    void deleteNotice(Long id);
}
