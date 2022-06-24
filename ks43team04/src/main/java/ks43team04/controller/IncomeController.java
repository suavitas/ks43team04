package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.dto.LaundryList;
import ks43team04.service.LaundryService;

@RequestMapping("/admin")
@Controller
public class IncomeController {

	private final LaundryService laundryService;

	public IncomeController(LaundryService laundryService) {
		this.laundryService = laundryService;

	}


	/* 매출 */
	@GetMapping("/income")
	public String laundryIncomeList(Model model) {
		List<LaundryList> laundryIncomeList = laundryService.laundryList();
		
		model.addAttribute("laundryIncomeList", laundryIncomeList);
		
		System.out.println(laundryIncomeList);
		return "admin/income";
	}

	
}
