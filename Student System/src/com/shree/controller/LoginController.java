package com.shree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shree.model.Login;
import com.shree.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	// scan for component dat implement LoginService n inject it as dependency
	@Autowired
	private LoginService loginService;

	@GetMapping("/displayLoginPage")
	public String displayLoginPage(Model model) {

		// create model attribute to bind form data
		Login login = new Login();

		model.addAttribute("login", login);

		return "login-form";
	}

	@PostMapping("/readLoginData")
	public String readLoginData(@ModelAttribute("login") Login login) {

		String uname = login.getUserName();
		String pwd = login.getPassword();

		boolean check = loginService.getUser(uname, pwd);

		if (check == false)
			return "login-form";
		else
			return "redirect:/student/showStudents";

	}

}
