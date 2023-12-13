package com.learn.jaa.config;

import com.learn.jaa.exception.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.*;
import org.springframework.security.web.util.matcher.*;
import org.springframework.web.filter.*;

import java.io.*;

/**
 * @author Krishna Chaitanya
 */
@Slf4j
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.error("Came to ApiKeyAuthenticationFilter");
//        if(true) {
//            throw new TokenAuthorizationException("Error throwing from ApiKeyAuthenticationFilter");
//        }
//        response.sendError(HttpServletResponse.SC_FORBIDDEN);
//        final String errorJson = """
//                {
//                    "status" : "error",
//                    "reason" : "token authentication is failed"
//                }
//                """;
//        response.getWriter().write(errorJson);
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        log.error("shouldNotFilter is called in ApiKeyAuthenticationFilter");
        RequestMatcher swagger = new NegatedRequestMatcher(new AntPathRequestMatcher("/swagger-ui/**"));
        RequestMatcher v3 = new NegatedRequestMatcher(new AntPathRequestMatcher("/v3/docs/**"));
        RequestMatcher error = new NegatedRequestMatcher(new AntPathRequestMatcher("/error"));
        return !swagger.matches(request) || !v3.matches(request) || !error.matches(request);
    }
}
