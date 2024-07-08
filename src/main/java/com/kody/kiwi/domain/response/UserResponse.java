package com.kody.kiwi.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private Short schoolNumber;
    private String gender;
    private String username;

    private short attendance;
    private short absent;
    private short etcAbsent;
    private short recoAbsent;
    private short diseAbsent;
    private short late;
    private short etcLate;
    private short recoLate;
    private short diseLate;
    private short earlyLeave;
    private short etcLeave;
    private short recoLeave;
    private short diseLeave;
    private short outing;
    private short etcOuting;
    private short recoOuting;
    private short diseOuting;
}
