package com.seabooks.common;

import lombok.Data;

/**
 * @author 14745
 * @date 2023/12/4 21:57
 */
//响应数据
@Data
public class Result<T> {
    public static final Integer OK = 200;
    public static final Integer FILE = 400;
    public static final Integer ERROR = 401;
    // 状态码
    private Integer code;
    // 错误信息
    private String msg;
    // 携带数据
    private T data;

    public Result(String msg, T data) {
        this.code = OK;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
