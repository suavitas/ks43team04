package ks43team04.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.Member;
import ks43team04.service.LaundryService;
import ks43team04.service.MemberService;

@Controller
public class PaymentController {
	
	private final LaundryService laundryService;
	private final MemberService memberService;

	public PaymentController(LaundryService laundryService, MemberService memberService) {
		this.laundryService = laundryService;
		this.memberService = memberService;

	}
	

	@GetMapping("/user/payment")
	public String payment() {
		return "user/payment/payment";
	}
	
	@GetMapping("/user/paymentComplete")
	public String paymentComplete() {
		return "user/payment/paymentComplete";
	}
	
	@GetMapping("/admin/goodsPrice")
	public String eachGoodsPriceList(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage,
	Model model, HttpSession session) {
		
		
		Map<String, Object> resultMap = laundryService.eachGoodsPriceList(currentPage);
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		
		Member member = memberService.getMemberInfoById(sessionId);
		
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("resultMap", resultMap);
		model.addAttribute("eachGoodsPriceList", resultMap.get("ilbangoodsPrice"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", resultMap.get("endPageNum"));				
		System.out.println(resultMap);
		System.out.println(resultMap.get("ilbangoodsPrice"));
		
		return "admin/goodsPrice";
	}

}
