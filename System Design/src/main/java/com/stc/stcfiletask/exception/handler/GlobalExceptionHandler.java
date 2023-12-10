package com.stc.stcfiletask.exception.handler;

import com.stc.stcfiletask.dto.common.APIResponse;
import com.stc.stcfiletask.exception.ParentItemNotFoundException;
import com.stc.stcfiletask.exception.PermissionGroupNotFoundException;
import com.stc.stcfiletask.exception.UserNotAuthorizedException;
import com.stc.stcfiletask.service.APIResponseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private APIResponseService apiResponseService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValidRequest(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);
        APIResponse apiResponse = apiResponseService.generateServiceResponse(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.getReasonPhrase(), result);
        return  ResponseEntity.badRequest().body(apiResponse);
    }
    @ExceptionHandler(UserNotAuthorizedException.class)
    public ResponseEntity<?> userNotAuthorized(UserNotAuthorizedException ex, HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();
        result.put("errors", ex.getMessage());

        APIResponse apiResponse = apiResponseService.generateServiceResponse(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), result);
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiResponse);
    }
    @ExceptionHandler({PermissionGroupNotFoundException.class, ParentItemNotFoundException.class})
    public ResponseEntity<?> notValidPermissionGroup(PermissionGroupNotFoundException ex, HttpServletRequest request) {

        Map<String, String> result = new HashMap<>();
        result.put("errors", ex.getMessage());

        APIResponse apiResponse = apiResponseService.generateServiceResponse(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.getReasonPhrase(), result);
        return  ResponseEntity.badRequest().body(apiResponse);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> internalServerError(Exception ex, HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();
        result.put("errors", ex.getMessage());
        APIResponse apiResponse = apiResponseService.generateServiceResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), result);
        return  ResponseEntity.internalServerError().body(apiResponse);
    }
}
