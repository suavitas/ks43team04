package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ks43team04.dto.Laundry;
import ks43team04.dto.LaundryList;
import ks43team04.service.LaundryService;

@Controller
public class PaymentController {
	
	private final LaundryService laundryService;

	public PaymentController(LaundryService laundryService) {
		this.laundryService = laundryService;

	}
	

	@GetMapping("/user/payment")
	public String payment() {
		return "user/payment/payment";
	}
	
	@GetMapping("/admin/goodsPrice")
	public String ilbanGoodsPrice(Model model) {
		List<Laundry> ilbangoodsPrice = laundryService.eachGoodsPriceList();
		System.out.println(ilbangoodsPrice);
		model.addAttribute("ilbangoodsPrice",ilbangoodsPrice);
		
		return "admin/goodsPrice";
	}

	

}
