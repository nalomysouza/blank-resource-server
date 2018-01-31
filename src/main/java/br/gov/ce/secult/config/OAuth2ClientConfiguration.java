package br.gov.ce.secult.config;

import static java.util.Arrays.asList;
import static org.springframework.security.oauth2.common.AuthenticationScheme.form;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
public class OAuth2ClientConfiguration {
	private static final Logger log = LoggerFactory.getLogger(OAuth2ClientConfiguration.class);

	@Value("${security.oauth2.client.clientId}")
	private String clientId;

	@Value("${security.oauth2.client.clientSecret}")
	private String clientSecret;

	@Value("${security.oauth2.client.accessTokenUri}")
	private String accessTokenUri;

	@Value("${security.oauth2.client.userAuthorizationUri}")
	private String userAuthorizationUri;

	@Bean
	public OAuth2ProtectedResourceDetails loginCulturaOAuth2Details() {
		AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
		details.setAuthenticationScheme(form);
		details.setClientAuthenticationScheme(form);
		details.setClientId(clientId);
		details.setClientSecret(clientSecret);
		details.setUserAuthorizationUri(userAuthorizationUri);
		details.setAccessTokenUri(accessTokenUri);
		details.setScope(asList("openid", "email", "public_profile"));

		log.info("AuthorizationCodeResourceDetails", details);
		return details;
	}

	@Resource
	private OAuth2ClientContext oAuth2ClientContext;

	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
	public OAuth2RestOperations loginCulturaOAuth2RestTemplate() {
		return new OAuth2RestTemplate(loginCulturaOAuth2Details(), oAuth2ClientContext);
	}
}