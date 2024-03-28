package com.example.locationmanagementapi.controller;

import com.example.locationmanagementapi.exception.BusinessException;
import com.example.locationmanagementapi.model.UserModel;
import com.example.locationmanagementapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public ResponseEntity<Boolean> login(@RequestBody UserModel userModel) throws BusinessException {
        boolean result = userService.login(userModel);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/users/register")
    public ResponseEntity<Long> register(@RequestBody UserModel userModel) throws BusinessException {
        Long result = userService.register(userModel);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
