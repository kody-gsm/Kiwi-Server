package com.kody.kiwi.domain.controller;

import com.kody.kiwi.domain.request.ReservationRequest;
import com.kody.kiwi.domain.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @PostMapping("/reservation")
    public ResponseEntity<String> reservation(@RequestBody ReservationRequest request){
        reservationService.reserve(request.getSchoolId(),request.getMode(),request.getReservationDate());
        return ResponseEntity.ok("asdf");
    }
}