package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.dto.Bill;
import ks43team04.dto.LaundryList;
import ks43team04.service.BillService;
import ks43team04.service.LaundryService;

@RequestMapping("/admin")
@Controller
public class IncomeController {

	private final LaundryService laundryService;
	private final BillService billService;

	public IncomeController(LaundryService laundryService, BillService billService) {
		this.laundryService = laundryService;
		this.billService = billService;

	}


	/* 매출 */
	@GetMapping("/income")
	public String laundryIncomeList(Model model) {
		List<LaundryList> laundryIncomeList = laundryService.laundryList();
		List<LaundryList> Month3laundryList = laundryService.Month3laundryList();
		List<LaundryList> Month6laundryList = laundryService.Month6laundryList();
		List<LaundryList> yearlaundryList = laundryService.yearlaundryList();
		model.addAttribute("laundryIncomeList", laundryIncomeList);
		model.addAttribute("Month3laundryList", Month3laundryList);
		model.addAttribute("Month6laundryList", Month6laundryList);
		model.addAttribute("yearlaundryList", yearlaundryList);
		
		System.out.println(laundryIncomeList);
		System.out.println(Month3laundryList);
		System.out.println(Month6laundryList);
		System.out.println(yearlaundryList);
		return "admin/income";
	}

	/* 세탁소별 월별 수입 */

	@GetMapping("/lundryIncome")
	public String lundryIncome(Model model) {
		List<Bill> laundryIncome = billService.laundryIncome();
		model.addAttribute("laundryIncome", laundryIncome);
		System.out.println("__________모델입니다__________"+model);
		System.out.println("__________세탁소별 월별 수입 조회____________"+laundryIncome);
		return "admin/lundryIncome";
	}

	
	
}
