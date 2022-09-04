package ks43team04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

	@GetMapping("/project")
	public String project() {
		return "project/project";
	}

	@GetMapping("/user/index")
	public String returnindex() {
		return "user/index";
	}
}
