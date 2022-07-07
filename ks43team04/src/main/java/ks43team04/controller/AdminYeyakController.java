package ks43team04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.service.YeyakService;

@RequestMapping("/admin")
@Controller
public class AdminYeyakController {

	private final YeyakService yeyakService;

	public AdminYeyakController(YeyakService yeyakService) {
		this.yeyakService = yeyakService;
	}

	@GetMapping("/yeyakStatus")
	public String muinYeyak(Model model) {

		return "/admin/yeyak/yeyakStatus";
	}

}
