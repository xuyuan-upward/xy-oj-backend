package com.xyoj.exception;

import com.xyoj.common.ErrorCode;

/**
 * 自定义异常类
 *
 * @author xuyuan
 *  
 */
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     *
     * @param errorCode
     * @param message 如果是附加的信息，就用附加的信息来表示
     */
    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
