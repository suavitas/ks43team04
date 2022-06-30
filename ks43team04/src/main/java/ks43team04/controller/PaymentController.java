package ks43team04.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.Laundry;
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
	
	@PostMapping("/user/payment")
	public String payment(@RequestParam(name = "laundryName") String laundryName,
							@RequestParam(name = "goodsName") String goodsName
							,Model model) {
		
		List<Laundry> laundryGoodsNameAndPrice = laundryService.getLaundryGoodsNameAndPrice(laundryName, goodsName);
		
		System.out.println(laundryName+" <----------세탁소이름");
		System.out.println(goodsName+" <----------상품이름");
		System.out.println(laundryGoodsNameAndPrice+" <----------laundryGoodsNameAndPrice 리스트값");
		
		model.addAttribute("laundryGoodsNameAndPrice", laundryGoodsNameAndPrice);
		
		return "user/payment/payment";
	}

	@GetMapping("/user/payment")
	public String payment() {
		return "user/payment/payment";
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
