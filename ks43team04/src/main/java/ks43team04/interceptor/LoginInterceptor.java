package ks43team04.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String requestURI = request.getRequestURI();

		String sessionId = (String) session.getAttribute("SID");

		// 일반 회원은 이 주소로 못 들어가도록 설정
		List<String> member = new ArrayList<String>();
		member.add("/admin/index");
		member.add("/주소");

		// 로그인 안하면 로그인 페이지로 이동
		if (sessionId == null) {
			response.sendRedirect("/login");
			return false;

			// 로그인 했을 때 로그인 한 회원 권한에 따라 주소에 못 들어가도록 설정
		} else {
			String sessionLevelCode = (String) session.getAttribute("SLEVEL");

			// 일반 회원의 경우 위에 선언한 주소로 못 들어간다.
			if (sessionLevelCode != null && "level_code_04".equals(sessionLevelCode)) {
				if (member.contains(requestURI)) {
					response.sendRedirect("/");
					return false;
				}
				// 일반 회원의 경우 /admin 주소는 못 들어간다.
				if (requestURI.indexOf("/admin") > -1) {
					response.sendRedirect("/");
					return false;
				}
			}
		}
		return true;
	}
}
