package com.kody.kiwi.domain.service;

import com.kody.kiwi.domain.entity.User;
import com.kody.kiwi.domain.entity.enums.Gender;
import com.kody.kiwi.domain.repository.UserRepository;
import com.kody.kiwi.domain.request.SigninRequest;
import com.kody.kiwi.domain.request.SignupRequest;
import com.kody.kiwi.domain.response.SigninResponse;
import com.kody.kiwi.global.config.TokenProvider;
import com.mysql.cj.exceptions.PasswordExpiredException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kody.kiwi.domain.entity.enums.Role;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AttendService attendService;
    private final SelectionService selectionService;

    @Transactional
    public void signupUser(SignupRequest request) {
        if(!userRepository.existsUserByEmail(request.getEmail())) {
            if (!request.getPassword().equals(request.getPwCheck())){
                throw new RuntimeException("비밀번호와 다름");
            }
            User user = User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .gender(Gender.valueOf(request.getGender()))
                    .schoolNumber(request.getSchoolNumber())
                    .role(Role.valueOf(Role.ROLE_STUDENT.getAuthority()))
                    .build();
            userRepository.save(user);
            attendService.CreateAttendance(user.getId());
            selectionService.create(user.getId());
        } else throw new RuntimeException("중복 사용자 이메일");
    }

    @Transactional
    public SigninResponse signinUser(SigninRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("유저가 없습니다"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new PasswordExpiredException();
        String id = user.getId().toString();
        String password = user.getPassword();
        Role role = Role.valueOf((String.valueOf(user.getRole())));
        Authentication authentication = new UsernamePasswordAuthenticationToken(id, password, List.of(role));
        String access = tokenProvider.generateAccessToken(authentication);
        String refresh = tokenProvider.generateRefreshToken(authentication);
        return new SigninResponse(access, refresh);
    }
    @Transactional
    public User getCurrentUser() {
        Short userId = Short.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        log.info(String.valueOf(userId));
        return userRepository.findById(Long.parseLong(String.valueOf(userId)))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
