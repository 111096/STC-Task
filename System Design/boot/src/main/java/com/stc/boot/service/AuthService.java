package com.stc.boot.service;


import com.stc.boot.dto.LoginDto;

public interface AuthService {

    public String login(LoginDto loginDto);
}
