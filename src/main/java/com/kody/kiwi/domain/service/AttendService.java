package com.kody.kiwi.domain.service;

import com.kody.kiwi.domain.entity.Attend;
import com.kody.kiwi.domain.entity.User;
import com.kody.kiwi.domain.mapper.AttendMapper;
import com.kody.kiwi.domain.repository.AttendRepository;
import com.kody.kiwi.domain.repository.UserRepository;
import com.kody.kiwi.domain.request.CheckRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AttendService {
    private final AttendRepository attendRepository;
    private final UserRepository userRepository;
    private final AttendMapper attendMapper;

    public Optional<CheckRequest> SelectAttendance(Long id) {
        if (attendMapper.findAttendanceById(id).isPresent()) {
            return attendMapper.findAttendanceById(id);
        }
        return Optional.empty();
    }

    public void CreateAttendance(Long id) {
        User user = userRepository.findUserById(id);
        Attend attend = attendRepository.save(
                Attend.builder()
                        .user(user)
                        .absent((short) 0)
                        .dise_absent((short) 0)
                        .etc_absent((short) 0)
                        .reco_absent((short) 0)
                        .late((short) 0)
                        .dise_late((short) 0)
                        .etc_late((short) 0)
                        .reco_late((short) 0)
                        .early_leave((short) 0)
                        .dise_leave((short) 0)
                        .etc_leave((short) 0)
                        .reco_leave((short) 0)
                        .attendance((short) 0)
                        .outing((short) 0)
                        .dise_outing((short) 0)
                        .etc_outing((short) 0)
                        .reco_outing((short) 0)
                        .build()
        );
    }
}