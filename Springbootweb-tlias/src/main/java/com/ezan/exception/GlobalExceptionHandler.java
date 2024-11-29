package com.ezan.exception;

import com.ezan.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result ex(Exception e) {
        e.printStackTrace();
        return Result.error("对不起，操作失败");
    }
}
