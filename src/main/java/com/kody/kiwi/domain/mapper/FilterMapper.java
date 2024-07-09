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
    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM user u NATURAL JOIN selection s WHERE mode = #{mode} AND u.school_number >= #{schoolNumber} AND u.school_number <= #{schoolNumber}+418")
    List<FilterResponse> getFilterGrade(SelectionMode mode, Short schoolNumber);

    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM user u NATURAL JOIN selection s WHERE mode = #{mode} AND u.school_number >= #{schoolNumber} AND u.school_number <= #{schoolNumber}+18")
    List<FilterResponse> getFilterClass(SelectionMode mode, Short schoolNumber);
}