package com.dbs.weather.forecastApp.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
public class MDCLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            //mdcData value will be referenced by Logging Configuration
            MDC.put("mdcData", String.format("[applicationId: %s | transactionId: %s", app(), requestId()));
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.clear();
        }

    }

    private String app() {
        return "WeatherForecaster";
    }

    private String requestId() {
        return UUID.randomUUID().toString();
    }
}
