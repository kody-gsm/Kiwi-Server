package com.kody.kiwi.domain.mapper;
import com.kody.kiwi.domain.response.CheckResponse;
import com.kody.kiwi.domain.response.FilterResponse;
import com.kody.kiwi.domain.response.UserResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface UserMapper {
    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM user u NATURAL JOIN selection s WHERE u.school_number >= #{id} AND u.school_number <= #{schoolNumber} + 418")
    List<FilterResponse> getGradeUser(Short schoolNumber);

    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM user u NATURAL JOIN selection s WHERE u.school_number >= #{id} AND u.school_number <= #{schoolNumber} + 18")
    List<FilterResponse> getClassUser(Short schoolNumber);

    @Select("SELECT user.gender,user.username,user.school_number, selection.mode FROM user NATURAL JOIN selection")
    List<FilterResponse> getAllUser();
}