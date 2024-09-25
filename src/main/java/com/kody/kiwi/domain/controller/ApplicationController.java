/*
package com.kody.kiwi.domain.controller;

import com.kody.kiwi.domain.request.AbsentRequest;
import com.kody.kiwi.domain.request.ServiceErrorRequest;
import com.kody.kiwi.domain.request.FunctionRequest;
import com.kody.kiwi.domain.response.*;
import com.kody.kiwi.domain.service.ApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping("/absent")
    public void createAbsent(@RequestBody @Valid AbsentRequest request) {
        applicationService.createAbsent(request);
    }
    @PostMapping("/function")
    public void createFunction(@RequestBody @Valid FunctionRequest request) {
        applicationService.createFunction(request);
    }
    @PostMapping("/service-error")
    public void createError(@RequestBody @Valid ServiceErrorRequest request) {
        applicationService.createError(request);
    }

    @GetMapping("/absents")
    public ResponseEntity<List<AbsentResponse>> getAbsents() {
        List<AbsentResponse> responseList = applicationService.getAbsents().getBody();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/functions")
    public ResponseEntity<List<FunctionResponse>> getFunctions() {
        List<FunctionResponse> responseList = applicationService.getFunctions().getBody();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/service-errors")
    public ResponseEntity<List<ServiceErrorResponse>> getServiceErrors() {
        List<ServiceErrorResponse> responseList = applicationService.getServiceErrors().getBody();
        return ResponseEntity.ok(responseList);
    }
    @GetMapping("/absent/{id}")
    public AbsentDetailResponse getAbsent(@PathVariable Long id) {
        return applicationService.getAbsent(id);
    }
    @GetMapping("/function/{id}")
    public FunctionDetailResponse getFunction(@PathVariable Long id) {
        return applicationService.getFunction(id);
    }
    @GetMapping("/service-error/{id}")
    public ServiceErrorDetailResponse getServiceError(@PathVariable Long id) {
        return applicationService.getServiceError(id);
    }
}
*/
