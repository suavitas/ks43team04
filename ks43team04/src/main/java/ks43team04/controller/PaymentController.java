package ks43team04.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.Bill2;
import ks43team04.dto.JJname;
import ks43team04.dto.Laundry;
import ks43team04.dto.Member;
import ks43team04.dto.MemberLevel;
import ks43team04.dto.PayMember;
import ks43team04.service.BillService;
import ks43team04.service.IlbanGPriceService;
import ks43team04.service.LaundryService;
import ks43team04.service.MemberService;
import ks43team04.service.PaymentService;

@RequestMapping("/user")
@Controller
public class PaymentController {
	
	private final LaundryService laundryService;
	private final MemberService memberService;
	private final PaymentService paymentService;
	private final BillService billService;
	
	
	
	public PaymentController(LaundryService laundryService, MemberService memberService, PaymentService paymentService, BillService billService) {
		this.laundryService = laundryService;
		this.memberService = memberService;
		this.paymentService = paymentService;
		this.billService = billService;
	}
	 
	@GetMapping("/myPagePayment2")
	public String myPagePayment2(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage
								,Model model,HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		
		Member member = memberService.getMemberInfoById(sessionId);
		//세션 이름 저장
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("member", member);
		String memberId = sessionId;
		//rowCount > id 결제건수
		int rowCount = billService.getBillCount2(memberId);
		
		model.addAttribute("rowCount", rowCount);
	
		System.out.println(sessionId+"<------- sessionId");
		System.out.println(sessionName+"<------- sessionName");
		System.out.println(memberId+"<------- memberId");
		System.out.println(rowCount+"<------- rowCount");
		//페이징처리시작
		Map<String, Object> resultMap = billService.billPage(currentPage, session);
		
		System.out.println(resultMap.get("billPage"));
		
		model.addAttribute("resultMap", resultMap);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("billPage", resultMap.get("billPage"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", resultMap.get("endPageNum"));
		
		return "/member/myPagePayment2";
	}
	
	@PostMapping("/myPagePayment2")
	public String myPagePayment2(Bill2 bill) {
		
		System.out.println(bill);
		
		billService.addBill2(bill);
		
		return "redirect:/user/myPagePayment2";
	}
	
	
	
	@PostMapping("/paymentComplete")
	public String paymentComplete(Bill2 bill) {
		
		System.out.println(bill);
		
		billService.addBill2(bill);
		
		return "/user/payment/paymentComplete";
	}
	
	@GetMapping("paymentComplete")
	public String paymentComplete() {
		return "user/payment/paymentComplete";
	}
	
	@GetMapping("payment")
	public String payment() {
		return "user/payment/payment";
	}
	
	@PostMapping("payment")
	public String yeyakPayment(@RequestParam(name = "laundryName") String laundryName,
							@RequestParam(name = "goodsName") String goodsName,
							@RequestParam(name = "bill") String bill,
							Model model,
							HttpSession session) {
		
		List<Laundry> laundryGoodsNameAndPrice = laundryService.getLaundryGoodsNameAndPrice(laundryName, goodsName);
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		String sessionLevel = (String) session.getAttribute("SLEVEL");
		
		Member member = memberService.getMemberInfoById(sessionId);
		String mAddr = member.getMemberAddr();
		String mPhone = member.getMemberPhone();
		String mEmail = member.getMemberEmail();
		
		PayMember paymember = paymentService.getPayMInfo(sessionId);
		MemberLevel memberlevel = paymentService.getMemberLevel(sessionLevel);	
		JJname jjname = paymentService.getJJname(laundryName);	
		
		model.addAttribute("laundryGoodsNameAndPrice", laundryGoodsNameAndPrice);
		model.addAttribute("bill", bill);
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("mAddr", mAddr);
		model.addAttribute("mPhone", mPhone);
		model.addAttribute("mEmail", mEmail);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("paymember", paymember);
		model.addAttribute("sessionLevel", sessionLevel);
		model.addAttribute("laundryName", laundryName);
		model.addAttribute("memberlevel", memberlevel);
		model.addAttribute("jjname", jjname);
		
		
		return "user/payment/payment";
	}
	
}
