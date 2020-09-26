package com.uscma.reactapi.domain.exception;

import com.uscma.reactapi.enums.ResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author rp
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CustomizeException extends RuntimeException {
    private Integer code;
    private String msg;
    private ResponseEnum responseEnum;

    public CustomizeException(ResponseEnum responseEnum) {
        super(responseEnum.getMsg());
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
        this.responseEnum = responseEnum;
    }

}
