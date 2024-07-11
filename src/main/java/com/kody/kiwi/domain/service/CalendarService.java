package com.kody.kiwi.domain.service;

import com.kody.kiwi.domain.entity.Selection;
import com.kody.kiwi.domain.entity.User;
import com.kody.kiwi.domain.entity.calendar.Calendar;
import com.kody.kiwi.domain.entity.calendar.CalendarID;
import com.kody.kiwi.domain.mapper.CalenderMapper;
import com.kody.kiwi.domain.repository.CalendarRepository;
import com.kody.kiwi.domain.repository.SelectionRepository;
import com.kody.kiwi.domain.repository.UserRepository;
import com.kody.kiwi.domain.response.CalendarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalendarService {
    private final CalendarRepository calendarRepository;
    private final SelectionRepository selectionRepository;
    private final CalenderMapper calenderMapper;

    public void CalendarMC(Long id){ //selection 바뀔때 이거 넣으면 calendar에 추가 or 수정됨
        Selection selection = selectionRepository.findSelectionById(id);
        CalendarID calendarID = new CalendarID(id,selection.getDate());
        calendarRepository.save(Calendar.builder()
                        .id(calendarID)
                        .mode(selection.getMode())
                .build());
    }

    public List<CalendarResponse> getCalendars(LocalDate date){
        return calenderMapper.FindAllByDate(date);
    }
}
