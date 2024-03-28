package com.example.locationmanagementapi.service;

import com.example.locationmanagementapi.exception.BusinessException;
import com.example.locationmanagementapi.model.UserModel;

public interface UserService {
    boolean login(UserModel userModel) throws BusinessException;
    long register(UserModel userModel) throws BusinessException;

}
