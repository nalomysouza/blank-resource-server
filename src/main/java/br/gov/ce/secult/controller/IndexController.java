package br.gov.ce.secult.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.ce.secult.config.UserInfo;

@RestController
public class IndexController {

	@RequestMapping("/api")
	public String test() {
		UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return "Welcome, " + userInfo.getEmail();
	}
}
