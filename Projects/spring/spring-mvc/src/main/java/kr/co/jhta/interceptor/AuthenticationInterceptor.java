package kr.co.jhta.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.jhta.dao.RoleDao;
import kr.co.jhta.vo.User;

// 인증여부를 체크하는 인터셉터
// 이미 가입을 했고, 정상적인 로그인 과정을 통과한 사용자
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	RoleDao roleDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		// 요청 URI 조회
		String requestURI = request.getRequestURI();
		// 요청 URL에 접근하기 위해서 필요한 접근권한 조회 및 요청객체에 담기
		List<String> reqRoles = roleDao.getRolesByUrl(requestURI);
		request.setAttribute("reqRoles", reqRoles);
		
		// 접근권한이 필요한 경우 - 우선 로그인된 사용자인지 체크
		if (!reqRoles.isEmpty()) {
			// 세션에서 로그인된 사용자 정보 조회
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("LOGIN_USER");
			// 로그인된 사용자 정보가 존재하지 않으면 로그인폼으로 이동
			if (user == null) {
				response.sendRedirect("/signin.do?error=deny");
				return false;
			} 
			// 로그인된 사용자 정보가 존재하면,
			// 인증과정 통과여부와 로그인된 사용자가 소유한 접근권한을 요청객체에 담기
			request.setAttribute("auth", "pass");
			request.setAttribute("hasRoles", user.getRoles());
		} else {
			// 접근권한이 필요없는 경우 - 인증과정 통과여부를 skip으로 요청객체에 담기
			request.setAttribute("auth", "skip");
		}
		
		return true;
	}
	
}






