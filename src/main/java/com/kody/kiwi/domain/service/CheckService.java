package com.kody.kiwi.domain.service;

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

    public List<FilterResponse> allUser(){
        return userMapper.getAllUser();
    }

    public List<FilterResponse> gradeUser(Short grade){
        return userMapper.getGradeUser(grade);
    }
}
