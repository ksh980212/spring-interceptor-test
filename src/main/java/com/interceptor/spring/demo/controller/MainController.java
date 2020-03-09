package com.interceptor.spring.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class MainController {

	private final HttpSession httpSession;

	@GetMapping("/api/v1/session/set")
	public String setSession() {
		httpSession.setAttribute("SESSION", "GOOD");
		return "SUCEESS";
	}

	@GetMapping("/api/v1/session/get")
	public String getSession() {
		return httpSession.getAttribute("SESSION").toString();
	}

	@GetMapping("/admin/real") // 관리자만 접근 가능
	public String adminPage() {
		return "ADMIN";
	}

	@GetMapping("/admin/test")
	public String normalPage() { // 아무나 접근 가능
		return "TEST OK";
	}

}
