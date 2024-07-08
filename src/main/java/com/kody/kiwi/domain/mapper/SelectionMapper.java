package com.kody.kiwi.domain.mapper;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import com.kody.kiwi.domain.response.FilterResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface SelectionMapper {
    @Select("SELECT u.gender,u.username,u.id,s.mode FROM user u NATURAL JOIN selection s WHERE mode = #{mode}")
    List<FilterResponse> getModeUser(SelectionMode mode);
}