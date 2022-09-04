package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.dto.MuinMachine;
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
		List<MuinMachine> muinMachineList = yeyakService.muinMachineList();
		
		System.out.println(muinMachineList);
		
		model.addAttribute("muinMachineList", muinMachineList);
		
		return "/admin/yeyak/yeyakStatus";
	}

}
