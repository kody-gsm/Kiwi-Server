package com.kody.kiwi.domain.service;
import com.kody.kiwi.domain.entity.Selection;
import com.kody.kiwi.domain.entity.User;
import com.kody.kiwi.domain.entity.enums.SelectionMode;
import com.kody.kiwi.domain.mapper.FilterMapper;
import com.kody.kiwi.domain.mapper.SelectionMapper;
import com.kody.kiwi.domain.mapper.UserMapper;
import com.kody.kiwi.domain.repository.SelectionRepository;
import com.kody.kiwi.domain.repository.UserRepository;
import com.kody.kiwi.domain.response.FilterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SelectionService {
    private final SelectionRepository selectionRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SelectionMapper selectionMapper;
    private final FilterMapper filterMapper;
    private final CheckService checkService;
    private final CalendarService calendarService;

    public void create(Long id){
        User user = userRepository.findUserById(id);
        Selection selection = Selection.builder()
                .user(user)
                .mode(SelectionMode.NONE)
                .build();
        selectionRepository.save(selection);
        calendarService.CalendarMC(id);
    }

    public List<FilterResponse> findByIdAndMode(String id, SelectionMode mode){
        if((id == null || id.equals("0")) && mode == null){
            return checkService.allUser();
        } else if (mode == null) {
            if (Integer.parseInt(id) >= 1000){
                if(Integer.parseInt(id) / 100 % 10 != 0){
                    return userMapper.getGradeClassUser(id);
                }
                else {
                    return userMapper.getGradeUser(id);
                }
            }
            else{
                return userMapper.getClassUser(id);
            }
        } else if (id == null || id.equals("0")) {
            return selectionMapper.getModeUser(mode);
        }
        else {
            if (Integer.parseInt(id) >= 1000){
                if (Integer.parseInt(id) / 100 % 10 != 0){
                    return filterMapper.getFilterClass(mode,id);
                }
                else {
                    return filterMapper.getFilterGrade(mode,id);
                }
            }
            else {
                return filterMapper.getClassUser(mode,id);
            }
        }
    }

    public void selectmode(SelectionMode mode, String sh, LocalDate date){
        Long ID = userRepository.findUserBySchoolNumber(sh).getId();
        Selection selection = Selection.builder()
                .id(ID)
                .date(date)
                .mode(mode)
                .build();
        selectionRepository.save(selection);
        calendarService.CalendarMC(ID);
    }
}
