package com.example.demo.filter;

import com.example.demo.common.ServiceAttributes;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

@ControllerAdvice
@Slf4j
@Order(0)
public class LoggingRequestBodyFilter extends RequestBodyAdviceAdapter {

    private final HttpServletRequest httpServletRequest;
    private final ObjectMapper objectMapper;

    public LoggingRequestBodyFilter(@Qualifier("getObjectMapper") ObjectMapper objectMapper, HttpServletRequest httpServletRequest) {
        this.objectMapper = objectMapper;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage,
                                MethodParameter parameter, Type targetType,
                                Class<? extends HttpMessageConverter<?>> converterType) {
        Object requestId = httpServletRequest.getAttribute(ServiceAttributes.REQUEST_ID);
        String data = "[REQUEST_ID]: " + requestId + " - [BODY REQUEST]: " + objectMapper.writeValueAsString(body);
        log.info(cutString(data));

        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

    private String cutString(String str) {
        if (!StringUtils.hasText(str)) {
            return str;
        } else {
            return str.length() <= 200 ? str : str.substring(0, 200) + "...";
        }
    }
}
