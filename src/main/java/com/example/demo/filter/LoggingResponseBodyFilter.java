package com.example.demo.filter;

import com.example.demo.common.ServiceAttributes;
import com.example.demo.common.ServiceErrors;
import com.example.demo.common.ServiceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
@Slf4j
@Order(0)
public class LoggingResponseBodyFilter implements ResponseBodyAdvice<Object> {
    private final ObjectMapper objectMapper;
    private final HttpServletRequest httpServletRequest;

    public LoggingResponseBodyFilter(@Qualifier("getObjectMapper") ObjectMapper objectMapper,
                                     HttpServletRequest httpServletRequest) {
        this.objectMapper = objectMapper;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        String requestId = (String) httpServletRequest.getAttribute(ServiceAttributes.REQUEST_ID);

        if (methodParameter.getContainingClass().isAnnotationPresent(RestController.class)) {
            if (o == null) o = new Object();

            if (o.getClass() != ServiceResponse.class) {
                o = new ServiceResponse(requestId, new Date(), ServiceErrors.SUCCESS, o);
            }
        }

        String data = "[REQUEST_ID]: " + requestId + " - " + "[BODY RESPONSE]: " + objectMapper.writeValueAsString(o);
        log.info(data);
        return o;
    }
}
