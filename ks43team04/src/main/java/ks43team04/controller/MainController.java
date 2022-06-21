package ks43team04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String userMain() {
		return "user/index";
	}
	
	@GetMapping("/admin")
	public String adminMain() {
		return "admin/index";
	}
}
