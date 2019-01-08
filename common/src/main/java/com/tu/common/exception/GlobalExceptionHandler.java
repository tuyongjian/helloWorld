package com.tu.common.exception;

import com.tu.common.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tuyongjian on 2019/1/8.
 */
@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler {

    @ExceptionHandler(AjaxException.class)
    @ResponseBody
    public ErrorInfo<String> ajaxException(HttpServletRequest req, Exception e) {
        ErrorInfo<String> errInfo = new ErrorInfo<String>();
        errInfo.setCode(ErrorInfo.ERROR);
        errInfo.setMessage(e.getMessage());
        errInfo.setUrl(req.getRequestURI().toString());
        errInfo.setData(e.getMessage());
        return errInfo;
    }
}
