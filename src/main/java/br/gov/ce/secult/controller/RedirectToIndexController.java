package br.gov.ce.secult.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.ce.secult.config.UserInfo;

@RestController
public class RedirectToIndexController {

	@RequestMapping("/api")
	public String test() {
		UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return "Welcome, " + userInfo.getEmail();
	}

	@RequestMapping("/principal")
	public Principal resource(Principal principal) {
		return principal;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:layout.xhtml";
	}
}
