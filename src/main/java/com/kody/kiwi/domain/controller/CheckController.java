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

        if(mode != null){
            return ResponseEntity.ok(selectionService.findByIdAndMode(grade,mode));
        }

        if (grade == null || grade == 0)
            return ResponseEntity.ok(checkService.allUser());
        else
            return ResponseEntity.ok(checkService.gradeUser(grade));
    }

    @PostMapping("/alltandance")
    public void alltendance(@RequestBody CheckRequest checkRequest){
        Short grade = checkRequest.getGrade();

        checkService.atSelect(grade);
    }
}