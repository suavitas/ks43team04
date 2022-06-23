package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.Bill;
import ks43team04.dto.LaundryList;
import ks43team04.dto.YearlyHoliday;
import ks43team04.service.BillService;
import ks43team04.service.HolidayService;
import ks43team04.service.LaundryService;

@RequestMapping("/admin")
@Controller
public class BillController {

	private final BillService billService;

	public BillController(BillService billService) {
		this.billService = billService;

	}

	

	/* 매출 */
	@GetMapping("/income")
	public String BillList(Model model) {
		List<Bill> BillList = billService.getBillList();
		
		model.addAttribute("BillList", BillList);
		return "admin/income";
	}

	
}
