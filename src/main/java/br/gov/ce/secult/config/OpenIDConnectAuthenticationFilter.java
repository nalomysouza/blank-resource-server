package br.gov.ce.secult.config;

import static java.util.Optional.empty;
import static org.springframework.security.core.authority.AuthorityUtils.NO_AUTHORITIES;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class OpenIDConnectAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
	@Value("${security.oauth2.resource.userInfoUri}")
	private String userInfoUri;

	@Resource
	private OAuth2RestOperations restTemplate;

	protected OpenIDConnectAuthenticationFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
		setAuthenticationManager(authentication -> authentication); 
		// AbstractAuthenticationProcessingFilter requires
		// an authentication manager.
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		final ResponseEntity<UserInfo> userInfoResponseEntity = restTemplate.getForEntity(userInfoUri, UserInfo.class);
		return new PreAuthenticatedAuthenticationToken(userInfoResponseEntity.getBody(), empty(), NO_AUTHORITIES);
	}
}
