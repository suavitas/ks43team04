package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import groovy.util.logging.Log;
import ks43team04.dto.PickUp;
import ks43team04.dto.YearlyHoliday;
import ks43team04.service.PickUpService;

@RequestMapping("/admin")
@Controller
public class PickUpController {
	
	private final PickUpService pickUpService;
	
	public PickUpController(PickUpService pickUpService) {
		this.pickUpService = pickUpService;
	
	}
	
	/* 수거 예약 목록*/
	@GetMapping("/pickUp")
	public String pickUp(Model model) {
		List<PickUp> getPickUpList = pickUpService.getPickUpList();
		
		model.addAttribute("getPickUpList", getPickUpList);
		System.out.println(getPickUpList);

		return "admin/pickUp";
	}

	
}
