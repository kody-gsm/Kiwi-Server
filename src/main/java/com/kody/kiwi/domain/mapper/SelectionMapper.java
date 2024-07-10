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
    @Select("SELECT u.gender,u.username,u.school_number,s.mode FROM user u NATURAL JOIN selection s WHERE mode = #{mode}")
    List<FilterResponse> getModeUser(SelectionMode mode);

    @Update("UPDATE selection SET mode = 'ATTENDANCE'")
    void alltendance();

    @Update("UPDATE selection NATURAL JOIN kody.user u SET mode = 'ATTENDANCE' WHERE u.school_number >= #{schoolNumber} AND u.school_number <= #{schoolNumber} + 418")
    void gradance(Short grade);

    @Update("UPDATE selection NATURAL JOIN kody.user u SET mode = 'ATTENDANCE' WHERE u.school_number >= #{schoolNumber} AND u.school_number <= #{schoolNumber} + 18")
    void clgradance(Short grade);

    @Update("UPDATE selection NATURAL JOIN kody.user u SET mode = 'ATTENDANCE' WHERE u.school_number >= #{schoolNumber} + 1000 AND u.school_number <= #{schoolNumber} + 18 + 1000 OR u.school_number >= #{schoolNumber} + 2000 AND u.school_number <= #{schoolNumber} + 18 + 2000 OR u.school_number >= #{schoolNumber} + 3000 AND u.school_number <= #{schoolNumber} + 18 + 3000")
    void clattdance(Short grade);
}