package com.kody.kiwi.domain.mapper;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import com.kody.kiwi.domain.response.FilterResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface SelectionMapper {
    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM kiwiuser u NATURAL JOIN selection s WHERE mode = #{mode}")
    List<FilterResponse> getModeUser(SelectionMode mode);

    @Update("UPDATE selection SET mode = 'ATTENDANCE'")
    void alltendance();

    @Update("UPDATE selection NATURAL JOIN kiwiuser u SET mode = 'ATTENDANCE' WHERE LEFT(u.school_number, 1) = LEFT(#{schoolNumber},1)")
    void gradance(String grade);

    @Update("UPDATE selection NATURAL JOIN kiwiuser u SET mode = 'ATTENDANCE' WHERE LEFT(u.school_number, 2) = LEFT(#{schoolNumber},2)")
    void clgradance(String grade);

    @Update("UPDATE selection NATURAL JOIN kiwiuser u SET mode = 'ATTENDANCE' WHERE LEFT(u.school_number, 1) = 1 OR LEFT(u.school_number, 1) = 2 OR LEFT(u.school_number, 1) = 3")
    void clattdance(String grade);
}