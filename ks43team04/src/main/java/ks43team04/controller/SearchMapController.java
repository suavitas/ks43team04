package ks43team04.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.dto.LaundryInfoSebu;
import ks43team04.service.LaundryInfoSebuService;


@RequestMapping("/user")
@Controller
public class SearchMapController {
	
	private final LaundryInfoSebuService laundryInfoSebuService;

	public SearchMapController(LaundryInfoSebuService laundryInfoSebuService) {
		this.laundryInfoSebuService = laundryInfoSebuService;
	}
	
	/*test*/
	@GetMapping("/laundryInfo")
	public String LaundryInfoSebu(Model model) {
		List<LaundryInfoSebu> LaundryInfoSebu = laundryInfoSebuService.laundryInfoSebu();

		model.addAttribute("LaundryInfoSebu", LaundryInfoSebu);
		return "user/laundryInfo/laundryInfo";
	}
	
	
	
	
	/*매장찾기*/
	@GetMapping("/searchmap/searchMap")
	public String userMain() {
		return "/user/searchmap/searchMap";
	}
}