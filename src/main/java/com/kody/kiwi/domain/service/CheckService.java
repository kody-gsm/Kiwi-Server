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

    public List<FilterResponse> gradeUser(String grade){
        return userMapper.getGradeUser(grade);
    }

    public void alltendance(){
        selectionMapper.alltendance();
    }
    
    public void atSelect(String sh){
        if (sh == null || sh.equals("0")){
            alltendance();
        } else if (Integer.parseInt(sh) >= 1000) {
            if (Integer.parseInt(sh) / 100 % 10 != 0){
                selectionMapper.clgradance(sh);
            }
            else {
                selectionMapper.gradance(sh);
            }
        }
        else {
            selectionMapper.clattdance(sh);
        }
    }
}
