package com.kody.kiwi.domain.mapper;

import com.kody.kiwi.domain.response.FilterResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface UserMapper {
    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM kiwiuser u NATURAL JOIN selection s WHERE LEFT(u.school_number, 1) = LEFT(#{schoolNumber},1)")
    List<FilterResponse> getGradeUser(String schoolNumber);

    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM kiwiuser u NATURAL JOIN selection s WHERE LEFT(u.school_number, 2) = LEFT(#{schoolNumber},2)")
    List<FilterResponse> getGradeClassUser(String schoolNumber);

    @Select("SELECT kiwiuser.gender,kiwiuser.username,kiwiuser.school_number, selection.mode FROM kiwiuser NATURAL JOIN selection")
    List<FilterResponse> getAllUser();

    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM kiwiuser u NATURAL JOIN selection s WHERE LEFT(u.school_number, 1) = 1 OR LEFT(u.school_number, 1) = 2 OR LEFT(u.school_number, 1) = 3")
    List<FilterResponse> getClassUser(String schoolNumber);
}