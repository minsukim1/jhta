package com.simple.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.simple.vo.User;

public class LoginCheckFilter implements Filter {

	private String loginCheckURL;
	private String loginUncheckURL;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		loginCheckURL = filterConfig.getInitParameter("checkURL");
		loginUncheckURL = filterConfig.getInitParameter("uncheckURL");
		System.out.println("로그인 체크 URL : " + loginCheckURL);
		System.out.println("로그인 언체크 URL : " + loginUncheckURL);

	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		String requestURI = httpReq.getRequestURI();


		if (requestURI.equals(loginCheckURL)) {
			// 로그인 여부를 확인한다.
			HttpSession session = httpReq.getSession();
			User user = (User) session.getAttribute("loginUser");
			// 로그인되어 있지 않으면 에러페이지로 보낸다.
			if (user == null) {
				httpReq.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
				return;
			}
			// 로그인되어 있는 경우 다음 필터를 실행한다.
			chain.doFilter(request, response);
		} 
		// 요청url과 로그인체크 url이 일치하지 않는경우
		// 로그인여부를 체크할 필요가 없으므로 다음번 필터나 서블릿을 실행한다.
		chain.doFilter(request, response);			


	}
}
