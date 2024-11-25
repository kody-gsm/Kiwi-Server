package com.kody.kiwi.domain.mapper;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import com.kody.kiwi.domain.response.FilterResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface FilterMapper {
    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM kiwiuser u NATURAL JOIN selection s WHERE mode = #{mode} AND LEFT(u.school_number, 1) = LEFT(#{schoolNumber},1)")
    List<FilterResponse> getFilterGrade(SelectionMode mode, String schoolNumber);

    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM kiwiuser u NATURAL JOIN selection s WHERE mode = #{mode} AND LEFT(u.school_number, 2) = LEFT(#{schoolNumber},2)")
    List<FilterResponse> getFilterClass(SelectionMode mode, String schoolNumber);

    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM kiwiuser u NATURAL JOIN selection s WHERE mode = #{mode} AND LEFT(u.school_number, 1) = 1 OR LEFT(u.school_number, 1) = 2 OR LEFT(u.school_number, 1) = 3")
    List<FilterResponse> getClassUser(SelectionMode mode, String schoolNumber);
}