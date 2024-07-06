package com.kody.kiwi.domain.controller;

import com.kody.kiwi.domain.request.SigninRequest;
import com.kody.kiwi.domain.request.SignupRequest;
import com.kody.kiwi.domain.response.SigninResponse;
import com.kody.kiwi.domain.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignupRequest> signup(@RequestBody @Valid SignupRequest request) {
        authService.signupUser(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<SigninResponse> signin(@Valid @RequestBody SigninRequest request){
        SigninResponse response = authService.signinUser(request);
        return ResponseEntity.ok().body(response);
    }


}
