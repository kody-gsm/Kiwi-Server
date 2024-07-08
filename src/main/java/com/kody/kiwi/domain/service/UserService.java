package com.kody.kiwi.domain.service;

import com.kody.kiwi.domain.entity.Attend;
import com.kody.kiwi.domain.entity.User;
import com.kody.kiwi.domain.repository.UserRepository;
import com.kody.kiwi.domain.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final AuthService authService;
    private final UserRepository userRepository;

    public UserResponse getMyPage() {
        User user = authService.getCurrentUser();
        Attend attend = user.getAttend();
        UserResponse userResponse = new UserResponse(
                user.getSchoolNumber(),
                user.getGender().toString(),
                user.getUsername(),
                attend.getAttendance(),
                attend.getAbsent(),
                attend.getEtc_absent(),
                attend.getReco_absent(),
                attend.getDise_absent(),
                attend.getLate(),
                attend.getEtc_late(),
                attend.getReco_late(),
                attend.getDise_late(),
                attend.getEarly_leave(),
                attend.getEtc_leave(),
                attend.getReco_leave(),
                attend.getDise_leave(),
                attend.getOuting(),
                attend.getEtc_outing(),
                attend.getReco_outing(),
                attend.getDise_outing()
        );

        return userResponse;
    }
}
