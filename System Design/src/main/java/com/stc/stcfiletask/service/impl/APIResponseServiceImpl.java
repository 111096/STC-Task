package com.stc.stcfiletask.service.impl;

import com.stc.stcfiletask.dto.common.APIResponse;
import com.stc.stcfiletask.service.APIResponseService;
import org.springframework.stereotype.Service;

@Service
public class APIResponseServiceImpl implements APIResponseService {


    @Override
    public APIResponse generateServiceResponse(String statusCode, String statusMessage, Object responseData) {
        return new APIResponse(statusCode,statusMessage,responseData);
    }
}
