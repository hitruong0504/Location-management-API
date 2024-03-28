package com.example.locationmanagementapi.service;

import com.example.locationmanagementapi.constant.ErrorType;
import com.example.locationmanagementapi.converter.UserConverter;
import com.example.locationmanagementapi.entity.UserEntity;
import com.example.locationmanagementapi.exception.BusinessException;
import com.example.locationmanagementapi.exception.ErrorModel;
import com.example.locationmanagementapi.model.UserModel;
import com.example.locationmanagementapi.repository.UserEntityRepository;
import com.example.locationmanagementapi.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserValidator userValidator;
    @Override
    public boolean login(UserModel userModel) throws BusinessException {
        List<ErrorModel> errorlList = userValidator.validateRequest(userModel);
        if(!CollectionUtils.isEmpty(errorlList)){
            throw new BusinessException(errorlList);
        }
        boolean isValid = false;
        UserEntity userEntity = userEntityRepository.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        if(userEntity == null){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode(ErrorType.AUTH_INVALID_CREDENTIALS.toString());
            errorModel.setMessage("Invalid email or password");

            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }else{
            isValid = true;
        }
        return isValid;
    }

    @Override
    public long register(UserModel userModel) throws BusinessException {
        List<ErrorModel> errorList = userValidator.validateRequest(userModel);
        if(!CollectionUtils.isEmpty(errorList)){
            throw new BusinessException(errorList);
        }
        if(userEntityRepository.findByEmail(userModel.getEmail()) != null){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode(ErrorType.ALREADY_EXISTS.toString());
            errorModel.setMessage("Email already exists, try with different email");

            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return userEntityRepository.save(userConverter.convertModelToEntity(userModel)).getId();
    }
}
