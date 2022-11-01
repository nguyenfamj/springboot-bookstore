package com.serverprogramming.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {
	
	@RequestMapping(value="/login")
	public String login() {
		return "loginPage";
	}
}
