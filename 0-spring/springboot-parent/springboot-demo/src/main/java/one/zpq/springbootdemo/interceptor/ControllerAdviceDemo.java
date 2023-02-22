package one.zpq.springbootdemo.interceptor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import one.zpq.springbootdemo.exception.NotFoundException;

/**
 * 控制器拦截
 * 
 * @author 22517
 *
 */
@ControllerAdvice(basePackages = "one.zpq.springbootdemo.controller", annotations = { RestController.class,
        Controller.class })
public class ControllerAdviceDemo {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
    public Map handleException(NotFoundException exception) {
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("code", exception.getCode());
        retMap.put("msg", exception.getMessage());
        return retMap;
    }
}
