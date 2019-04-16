package com.github.springcloudhystrix.advice.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

/**
 * <p>
 * 创建时间为 16:15 2019-04-16
 * 项目名称 spring-cloud-hystrix
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestControllerAdvice
public class HttpClientErrorExceptionHandler {

    @ExceptionHandler(value = HttpClientErrorException.class)
    public String handler(HttpClientErrorException exception) {
        System.out.println("HttpClientErrorException:" + exception.getMessage());
        return "HttpClientErrorException";
    }

}
