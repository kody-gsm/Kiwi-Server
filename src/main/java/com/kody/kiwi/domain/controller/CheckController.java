package com.kody.kiwi.domain.controller;

import com.kody.kiwi.domain.entity.enums.SelectionMode;
import com.kody.kiwi.domain.request.CalendarRequest;
import com.kody.kiwi.domain.request.CheckRequest;
import com.kody.kiwi.domain.request.FilterRequest;
import com.kody.kiwi.domain.request.McRequest;
import com.kody.kiwi.domain.service.CalendarService;
import com.kody.kiwi.domain.service.CheckService;
import com.kody.kiwi.domain.service.SelectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CheckController {
    private final CheckService checkService;
    private final SelectionService selectionService;
    private final CalendarService calendarService;

    @PostMapping("/check") //지금은 안 쓰는거 건희가 만들어는 두라고 해서 만듦
    public ResponseEntity<?> check(@RequestBody CheckRequest checkRequest){
        String grade = checkRequest.getGrade();

        if (grade == null || grade.equals("0"))
            return ResponseEntity.ok(checkService.allUser());
        else
            return ResponseEntity.ok(checkService.gradeUser(grade));
    }

    @PostMapping("/filter") //filter 기능
    public ResponseEntity<?> filter(@RequestBody FilterRequest filterRequest){
        String grade = filterRequest.getGrade();
        SelectionMode mode = filterRequest.getMode();

        System.out.println(grade);
        System.out.println(mode);

        if (grade == null || grade.equals("0"))
            return ResponseEntity.ok(selectionService.findByIdAndMode(grade,mode));
        else if (Integer.parseInt(grade) < 100 || Integer.parseInt(grade) >= 3500)
            return ResponseEntity.badRequest().body("잘못된 값입니다.");
        else
            return ResponseEntity.ok(selectionService.findByIdAndMode(grade,mode));
    }

    @PostMapping("/alltendance")//일괄 출석
    public ResponseEntity<?> alltendance(@RequestBody CheckRequest checkRequest){
        String grade = checkRequest.getGrade();
        System.out.println(grade+"as");
        if (grade == null || grade.equals("0")) {
            checkService.atSelect(grade);
            return ResponseEntity.ok("실행 완료됐습니다.");
        }
        else if (Integer.parseInt(grade) < 100 || Integer.parseInt(grade) >= 3500)
            return ResponseEntity.badRequest().body("값이 잘못되었습니다.");
        else {
            checkService.atSelect(grade);
            return ResponseEntity.ok("실행 완료됐습니다.");
        }
    }

//    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    @PostMapping("/mc")//변환시킬때 권한 필요 (나중에 추가)
    public void mc(@RequestBody McRequest mcRequest){
        System.out.println(mcRequest.getMode());
        System.out.println(mcRequest.getId());
        selectionService.selectmode(mcRequest.getMode(),mcRequest.getId(),mcRequest.getDate());
    }

    @PostMapping("/calendar")
    public ResponseEntity<?> calendar(@RequestBody CalendarRequest calendarRequest){
        System.out.println(calendarRequest.getDate());
        return ResponseEntity.ok(calendarService.getCalendars(calendarRequest.getDate()));
    }
}