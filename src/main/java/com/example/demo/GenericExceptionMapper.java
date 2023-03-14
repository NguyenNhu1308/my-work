package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Date;

public class GenericExceptionMapper implements ExceptionMapper<Exception> {
    @Context
    private HttpServletRequest httpServletRequest;

    private final Log log = LogFactory.getLog(this.getClass());

    @Override
    public Response toResponse(Exception ex) {
        String requestId = (String) httpServletRequest.getAttribute("x-request-id-x");
        log.error(String.format("requestId: %s, [GENERIC EXCEPTION] ==> %s", requestId, ex.getMessage()), ex);
        if (ex instanceof WebApplicationException) {
            WebApplicationException webApplicationException = (WebApplicationException) ex;
            int status = webApplicationException.getResponse().getStatus();
            return Response
                    .status(status)
                    .entity(new ResponseEntity(requestId, new Date(), status, ex.getMessage())).build();
        }
        return Response.ok(new ResponseEntity(requestId, new Date(), 99, ex.getMessage())).build();
    }
}
