package com.kody.kiwi.domain.controller;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import com.kody.kiwi.domain.request.CheckRequest;
import com.kody.kiwi.domain.request.FilterRequest;
import com.kody.kiwi.domain.service.CheckService;
import com.kody.kiwi.domain.service.SelectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CheckController {
    private final CheckService checkService;
    private final SelectionService selectionService;

    @PostMapping("/check")
    public ResponseEntity<?> check(@RequestBody CheckRequest checkRequest){
        Short grade = checkRequest.getGrade();

        if (grade == null || grade == 0)
            return ResponseEntity.ok(checkService.allUser());
        else
            return ResponseEntity.ok(checkService.gradeUser(grade));
    }

    @PostMapping("/filter")
    public ResponseEntity<?> filter(@RequestBody FilterRequest filterRequest){
        Short grade = filterRequest.getGrade();
        SelectionMode mode = filterRequest.getMode();

        if (grade == null || grade == 0)
            return ResponseEntity.ok(selectionService.findByIdAndMode(grade,mode));
        else if (grade < 100 || grade >= 3500)
            return ResponseEntity.badRequest().body("잘못된 값입니다.");
        else
            return ResponseEntity.ok(selectionService.findByIdAndMode(grade,mode));
    }

    @PostMapping("/alltendance")
    public ResponseEntity<?> alltendance(@RequestBody CheckRequest checkRequest){
        Short grade = checkRequest.getGrade();
        if (grade == null || grade == 0) {
            checkService.atSelect(grade);
            return ResponseEntity.ok("실행 완료됐습니다.");
        }
        else if (grade < 100 || grade >= 3500)
            return ResponseEntity.badRequest().body("값이 잘못되었습니다.");
        else {
            checkService.atSelect(grade);
            return ResponseEntity.ok("실행 완료됐습니다.");
        }
    }
}