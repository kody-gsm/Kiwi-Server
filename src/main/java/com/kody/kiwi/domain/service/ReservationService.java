package com.kody.kiwi.domain.service;

import com.kody.kiwi.domain.entity.Reservation;
import com.kody.kiwi.domain.entity.User;
import com.kody.kiwi.domain.entity.enums.SelectionMode;
import com.kody.kiwi.domain.repository.ReservationRepository;
import com.kody.kiwi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ReservationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ReservationRepository reservationRepository;

    public void reserve(String schoolNum, SelectionMode mode, LocalDate date) throws Exception{
        Reservation reservation = Reservation.builder()
                .schoolNum(schoolNum)
                .date(date)
                .build();
        User user = userRepository.findUserBySchoolNumber(schoolNum);
        if(user == null){
            throw new Exception("We can't find any user");
        }

        user = User.builder()
                .ID(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .gender(user.getGender())
                .schoolNumber(user.getSchoolNumber())
                .mode(mode)
                .build();

        reservationRepository.save(reservation);
        userRepository.save(user);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduling() {
        List<Reservation> reservation = reservationRepository.findAll();
        LocalDate today = LocalDate.now();

        for(Reservation reser : reservation) {
            LocalDate date = reser.getDate();
            if(today.isBefore(date) || today.isEqual(date)) {
                User user = userRepository.findUserBySchoolNumber(reser.getSchoolNum());
                user =  User.builder()
                        .ID(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .role(user.getRole())
                        .gender(user.getGender())
                        .schoolNumber(reser.getSchoolNum())
                        .mode(SelectionMode.ATTENDANCE)
                        .build();
                userRepository.save(user);
            }
        }
    }
}
