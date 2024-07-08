package com.kody.kiwi.domain.controller;


import com.kody.kiwi.domain.response.UserResponse;
import com.kody.kiwi.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/mypage")
    public ResponseEntity<UserResponse> getMy() {
        UserResponse userResponse = userService.getMyPage();
        return ResponseEntity.ok(userResponse);
    }
}
