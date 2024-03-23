package com.seabooks.exception;

import com.seabooks.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 14745
 * @date 2023/12/4 22:00
 */
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result serviceException(ServiceException e){
// 当ServiceException触发时,向前端发送异常信息:{code:401,msg:"请登录"
        return new Result(Result.ERROR,e.getMessage());
    }
}