package com.seabooks.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 14745
 * @date 2023/12/4 21:54
 */

// 异常处理
public class MyExceptionHandler {
    @ControllerAdvice
    public class MyException {
        @ResponseBody
        @ExceptionHandler
        public String handlerExp(Exception e){
            return "系统当前出了点小差...";
        }
    }
}
