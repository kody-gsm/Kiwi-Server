package com.kody.kiwi.domain.mapper;

import com.kody.kiwi.domain.response.CalendarResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Mapper
@Transactional
public interface CalenderMapper {
    @Select("SELECT u.gender,u.username,u.school_number,c.mode,c.date FROM kiwiuser u NATURAL JOIN calendar c WHERE c.date = #{date}")
    List<CalendarResponse> FindAllByDate(LocalDate date);
}
