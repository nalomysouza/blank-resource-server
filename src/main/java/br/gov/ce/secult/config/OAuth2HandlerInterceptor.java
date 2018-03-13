package br.gov.ce.secult.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class OAuth2HandlerInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(OAuth2HandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		HttpSession session = request.getSession();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth.getName().equalsIgnoreCase("anonymousUser")) && auth != null) {
			logger.info("preHandle: LoggedIn - " + auth.getPrincipal());
			return true;
		}

		response.sendRedirect("/login");

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle Request Completed");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
		logger.info("afterCompletion Request Completed");

	}

}
