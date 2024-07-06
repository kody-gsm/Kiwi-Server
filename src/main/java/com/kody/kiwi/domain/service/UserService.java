package com.kody.kiwi.domain.service;
import com.kody.kiwi.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserService {
    private final AuthService authService;

    @PostMapping("/dd")
    public String dd() {
        return "ang";
    }
}
