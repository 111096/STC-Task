package com.stc.stcfiletask.service;

import com.stc.stcfiletask.dto.common.APIResponse;

public interface APIResponseService {

    public APIResponse generateServiceResponse(String statusCode, String statusMessage,Object responseData)  ;

}


