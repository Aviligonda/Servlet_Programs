package com.sonix;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Servlet implementation class LoggingFilter
 */
@WebFilter("/*") // Applies to all URLs
public class LoggingFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println("Request URL: " + httpRequest.getRequestURL() + " is Requested");
// Pass control to the next filter or servlet in the chain 
		chain.doFilter(request, response);
		System.out.println("Response for URL " + httpRequest.getRequestURL() + " Request Sent to Client.");
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}