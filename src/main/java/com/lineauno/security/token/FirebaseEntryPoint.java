package com.lineauno.security.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FirebaseEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseEntryPoint.class);

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.error("fail in commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED 401");
    }
}
