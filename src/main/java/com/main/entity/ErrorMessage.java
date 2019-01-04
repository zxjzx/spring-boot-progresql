package com.main.entity;

import com.main.pagemodel.BaseResult;

public class ErrorMessage {
    public static BaseResult forbidRequest() {
        return BaseResult.getSuccessResult();
    }
}
