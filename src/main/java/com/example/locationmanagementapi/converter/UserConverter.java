package com.example.locationmanagementapi.converter;

import com.example.locationmanagementapi.entity.UserEntity;
import com.example.locationmanagementapi.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertModelToEntity(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(userModel.getFullName());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setMobileNumber(userModel.getMobileNumber());
        userEntity.setPassword(userModel.getPassword());
        return userEntity;
    }
}
