package com.example.demo.filter;

import com.example.demo.common.ServiceAttributes;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(-1)
@Slf4j
public class LoggingRequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestId = (String) httpServletRequest.getAttribute(ServiceAttributes.REQUEST_ID);
        httpServletRequest.setAttribute(ServiceAttributes.REQUEST_ID, requestId);
        long begin = System.currentTimeMillis();

//        StringBuilder requestInfoBuilder = new StringBuilder();
//        requestInfoBuilder.append("[REQUEST_ID]: ").append(requestId);
//        requestInfoBuilder.append(" - [REMOTE IP]: ").append(getRemoteIp(httpServletRequest));
//        requestInfoBuilder.append(" - [METHOD]: ").append(httpServletRequest.getMethod());
//        requestInfoBuilder.append(" - [URI]: ").append(httpServletRequest.getRequestURI());
//        requestInfoBuilder.append(" - [QUERY STRING]: ").append(httpServletRequest.getQueryString());
//        log.info("[HTTP REQUEST] ===> " + requestInfoBuilder);

        filterChain.doFilter(servletRequest, servletResponse);

        String responseInfoBuilder = "[REQUEST_ID]: " + requestId + " - [IN]: " +
                (System.currentTimeMillis() - begin) + " ms";
        log.info("[HTTP RESPONSE] ===> " + responseInfoBuilder);
    }

    private String getRemoteIp(HttpServletRequest httpServletRequest) {
        String remoteIp = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (StringUtils.isBlank(remoteIp)) {
            return httpServletRequest.getRemoteAddr();
        }
        return remoteIp;
    }
}
