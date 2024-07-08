package com.kody.kiwi.domain.entity.enums;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor
public enum Role implements GrantedAuthority {
    ROLE_STUDENT("ROLE_STUDENT"),
    ROLE_TEACHER("ROLE_TEACHER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}