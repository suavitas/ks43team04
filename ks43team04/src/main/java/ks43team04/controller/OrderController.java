package ks43team04.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.dto.Bill;
import ks43team04.service.MemberService;
import ks43team04.service.OrderService;

@Controller
@RequestMapping("/admin")
public class OrderController {

	private final MemberService memberService;
	private final OrderService orderService;

	public OrderController(OrderService orderService,MemberService memberService) {
		this.orderService = orderService;
		this.memberService = memberService;

	}

	@GetMapping("order")
	public String ilbanOrderList(Model model,HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		
		List<Bill> ilbanOrderList = orderService.ilbanOrderList(sessionId);
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("ilbanOrderList", ilbanOrderList);
		System.out.println("________일반세탁소 오더목록 컨트롤러____________"+ilbanOrderList);
		System.out.println("________일반세탁소 오더목록 세션아이디____________"+sessionId);
		System.out.println("________일반세탁소 오더목록 세션이름____________"+sessionName);
		return "admin/order";
	}


}
