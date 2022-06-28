package ks43team04.controller;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.LaundryInfoSebu;
import ks43team04.dto.YearlyHoliday;
import ks43team04.service.HolidayService;
import ks43team04.service.LaundryInfoSebuService;
import ks43team04.service.LaundryService;


@Controller
@RequestMapping("/user")
public class SearchMapController {
	
	private final LaundryInfoSebuService laundryInfoSebuService;

	public SearchMapController(LaundryInfoSebuService laundryInfoSebuService) {
		this.laundryInfoSebuService = laundryInfoSebuService;
	}
	@GetMapping("/laundryInfo/laundryInfo")
	public String LaundryInfoSebu(Model model) {
		List<LaundryInfoSebu> laundryInfoSebu = laundryInfoSebuService.laundryInfoSebu();

		model.addAttribute("laundryInfoSebu", laundryInfoSebu);
		return "user/search/laundrySearch";
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/searchmap/searchMap")
	public String userMain() {
		return "/user/searchmap/searchMap";
	}
}