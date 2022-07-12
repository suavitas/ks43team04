
package ks43team04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.service.LaundryService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final LaundryService laundryService;

	public AdminController(LaundryService laundryService) {
		this.laundryService = laundryService;

	}
	


	// 전 매장 월별 환불퍼센트
	@GetMapping("/retrun")
	public String retrun() {
		return "admin/retrun";
	}
	
	// 세탁소별 월별 환불 퍼센트

	@GetMapping("/lundryReturn")
	public String lundryReturn() {
		return "admin/lundryReturn";
	}

	// 세탁소별 장비 현황

	@GetMapping("/lundrymachine")
	public String lundrymachine() {
		return "admin/lundrymachine";
	}



	// 세탁소별 회원 포인트

	@GetMapping("/lundryUserPoint")
	public String lundryUserPoint() {
		return "admin/lundryUserPoint";
	}

	// 세탁소 회원별 질문사항

	@GetMapping("/lundryUserQA")
	public String lundryUserQA() {
		return "admin/lundryUserQA";
	}


	// 일반 세탁소 수거 및 배송 완료 체크

	@GetMapping("/OrderbyAllCheck")
	public String AllCheck() {
		return "admin/order/AllCheck";
	}

	
}
