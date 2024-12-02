package com.sonix;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class AuthenticationFilter
 */
@WebFilter("/dashboard") // Applies only to dashboard
public class AuthenticationFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);

		if (session != null && session.getAttribute("username") != null) {
			// System.out.println("In AuthenticationFilter - Start");
			chain.doFilter(request, response); // User is authenticated, proceed
			// System.out.println("In AuthenticationFilter - End");
			System.out.println("Authenticated user accessed " + httpRequest.getRequestURL());
		} else {
			httpResponse.sendRedirect("login.html"); // User is not authenticated,redirect to login
		}
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}