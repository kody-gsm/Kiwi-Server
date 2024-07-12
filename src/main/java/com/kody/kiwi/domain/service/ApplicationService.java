package com.kody.kiwi.domain.service;

import com.kody.kiwi.domain.entity.Absent;
import com.kody.kiwi.domain.entity.ServiceError;
import com.kody.kiwi.domain.entity.Function;
import com.kody.kiwi.domain.entity.User;
import com.kody.kiwi.domain.repository.AbsentRepository;
import com.kody.kiwi.domain.repository.ServiceErrorRepository;
import com.kody.kiwi.domain.repository.FunctionRepository;
import com.kody.kiwi.domain.request.AbsentRequest;
import com.kody.kiwi.domain.request.ServiceErrorRequest;
import com.kody.kiwi.domain.request.FunctionRequest;
import com.kody.kiwi.domain.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final AuthService authService;
    private final AbsentRepository absentRepository;
    private final FunctionRepository functionRepository;
    private final ServiceErrorRepository serviceErrorRepository;

    @Transactional
    public void createAbsent(AbsentRequest request) {
        User user = authService.getCurrentUser();
        String schoolNumber = user.getSchoolNumber();
        String userName = user.getUsername();
        Absent absent = Absent.builder()
                .schoolNumber(schoolNumber)
                .userName(userName)
                .title(request.getTitle())
                .content(request.getContent())
                .started_at(request.getStarted_at())
                .ended_at(request.getEnded_at())
                .build();
        absentRepository.save(absent);
    }

    @Transactional
    public void createFunction(FunctionRequest request) {
        User user = authService.getCurrentUser();
        String schoolNumber = user.getSchoolNumber();
        String userName = user.getUsername();
        Function function = Function.builder()
                .schoolNumber(schoolNumber)
                .userName(userName)
                .title(request.getTitle())
                .content(request.getContent())
                .affiliation(request.getAffiliation())
                .build();
        functionRepository.save(function);
    }

    @Transactional
    public void createError(ServiceErrorRequest request) {
        User user = authService.getCurrentUser();
        String schoolNumber = user.getSchoolNumber();
        String userName = user.getUsername();
        ServiceError serviceError = ServiceError.builder()
                .schoolNumber(schoolNumber)
                .userName(userName)
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        serviceErrorRepository.save(serviceError);
    }

    public ResponseEntity<List<AbsentResponse>> getAbsents() {
        List<Absent> absentList = absentRepository.findAllByOrderByCreatedAtDesc();
        List<AbsentResponse> responseList = new ArrayList<>();
        for (Absent absent : absentList) {
            AbsentResponse response = new AbsentResponse(absent.getId(), absent.getUserName(), absent.getSchoolNumber());
            responseList.add(response);
        }
        return ResponseEntity.ok(responseList);
    }

    public ResponseEntity<List<FunctionResponse>> getFunctions() {
        List<Function> functionList = functionRepository.findAllByOrderByCreatedAtDesc();
        List<FunctionResponse> responseList = new ArrayList<>();
        for (Function function : functionList) {
            FunctionResponse response = new FunctionResponse(function.getId(), function.getUserName(), function.getSchoolNumber());
            responseList.add(response);
        }
        return ResponseEntity.ok(responseList);
    }

    public ResponseEntity<List<ServiceErrorResponse>> getServiceErrors() {
        List<ServiceError> serviceErrorList = serviceErrorRepository.findAllByOrderByCreatedAtDesc();
        List<ServiceErrorResponse> requestList = new ArrayList<>();
        for (ServiceError serviceError : serviceErrorList) {
            ServiceErrorResponse response = new ServiceErrorResponse(serviceError.getId(), serviceError.getUserName(), serviceError.getSchoolNumber());
            requestList.add(response);
        }
        return ResponseEntity.ok(requestList);
    }

    public AbsentDetailResponse getAbsent(Long id) {
        Absent absent = absentRepository.findById(id).orElseThrow(() -> new RuntimeException("못찾음"));
        return AbsentDetailResponse.builder()
                .id(absent.getId())
                .title(absent.getTitle())
                .content(absent.getContent())
                .started_at(absent.getStarted_at())
                .ended_at(absent.getEnded_at())
                .build();
    }
    public FunctionDetailResponse getFunction(Long id) {
        Function function = functionRepository.findById(id).orElseThrow(() -> new RuntimeException("못찾음"));
        return FunctionDetailResponse.builder()
                .id(function.getId())
                .title(function.getTitle())
                .content(function.getContent())
                .affiliation(function.getAffiliation())
                .build();
    }
    public ServiceErrorDetailResponse getServiceError(Long id) {
        ServiceError serviceError = serviceErrorRepository.findById(id).orElseThrow(() -> new RuntimeException("못찾음"));
        return ServiceErrorDetailResponse.builder()
                .id(serviceError.getId())
                .title(serviceError.getTitle())
                .content(serviceError.getContent())
                .build();
    }
}