package com.kody.kiwi.domain.controller;

import com.kody.kiwi.domain.request.ReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    @PostMapping("/reservation")
    public ResponseEntity<String> reservation(@RequestBody ReservationRequest request){
        String id = request.getSchoolId();
        return ResponseEntity.ok("asdf");
    }
}