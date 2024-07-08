package com.kody.kiwi.domain.entity;
import com.kody.kiwi.domain.entity.enums.Gender;
import com.kody.kiwi.domain.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@NoArgsConstructor
@Getter
public class User extends BaseTime{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 5)
    private String username;

    @Column(length = 60)
    private String password;

    @Column(length = 4)
    private String schoolNumber;

    @Column(length = 6)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Attend attend;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Selection selection;

    @Builder
    public User(Long ID, String username,String password, String schoolNumber, String email, Role role, Gender gender) {
        this.id = ID;
        this.username = username;
        this.password = password;
        this.schoolNumber = schoolNumber;
        this.email = email;
        this.role = role;
        this.gender = gender;
    }
}