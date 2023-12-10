package com.stc.stcfiletask.service;

import com.stc.stcfiletask.enumeration.PermissionEnum;

public interface UserAuthorityService {



    public boolean checkIfUserAuthorized(String userName, PermissionEnum permissionEnum, Long permissionGroupId) throws Exception;

}


