package com.rahul.loginApp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/app")
public class UserController {
	
	@RequestMapping(value="/home")
	public String loadHomePage() {
		
		return "home";
	}
	
	@RequestMapping(value="/validate", method=RequestMethod.POST)
	public String loadProfile(@RequestParam Map<String, String> requestParams) {
		String email = requestParams.get("email");
		String password = requestParams.get("password");
		String redirectTo = "";
		if(email.equals("user") && password.equals("password")) {
			redirectTo = "app/profile";
		} else {
			redirectTo = "app/home";
		}
		System.out.println("Logged in with username: " + email + " password: " + password);
		return "redirect:/" + redirectTo;
//		return null;
	}
	
	@RequestMapping(value="/profile")
	public String loadProfilePage() {
		return "profile";
	}
	
	
}
