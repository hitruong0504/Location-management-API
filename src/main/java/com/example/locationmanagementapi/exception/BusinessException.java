package com.example.locationmanagementapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BusinessException extends Exception{
    private List<ErrorModel> errors;
}
