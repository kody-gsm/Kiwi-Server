package com.kody.kiwi.domain.service;

import com.kody.kiwi.domain.mapper.SelectionMapper;
import com.kody.kiwi.domain.mapper.UserMapper;
import com.kody.kiwi.domain.response.FilterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CheckService {
    private final UserMapper userMapper;
    private final SelectionMapper selectionMapper;
    public List<FilterResponse> allUser(){
        return userMapper.getAllUser();
    }

    public List<FilterResponse> gradeUser(Short grade){
        return userMapper.getGradeUser(grade);
    }

    public void alltendance(){
        selectionMapper.alltendance();
    }
    
    public void attendanceAdd(Short sh){
        if (sh == null || sh == 0 ){
            alltendance();
        } else if (sh/100%10 > 9) {
            
        }
    }
}
