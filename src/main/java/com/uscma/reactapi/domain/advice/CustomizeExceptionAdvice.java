package com.uscma.reactapi.domain.advice;

import com.uscma.reactapi.domain.exception.CustomizeException;
import com.uscma.reactapi.domain.response.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author rp
 */
@RestControllerAdvice
public class CustomizeExceptionAdvice {
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(CustomizeException.class)
    public ResultVO nonceExpiredException(CustomizeException exception) {
        return ResultVO.fail(exception.getResponseEnum());
    }
}
