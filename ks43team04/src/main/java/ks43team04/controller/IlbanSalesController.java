package ks43team04.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.Member;
import ks43team04.service.IlbanSalesService;
import ks43team04.service.MemberService;

@Controller
@RequestMapping("/admin")
public class IlbanSalesController {
	
	private final IlbanSalesService ilbanSalesService;
	private final MemberService memberService;
	
	public IlbanSalesController(IlbanSalesService ilbanSalesService, MemberService memberService) {
		this.ilbanSalesService = ilbanSalesService;
		this.memberService = memberService;
	}
	
	@GetMapping("/ilbanSales")
	public String ilbanWoo(@RequestParam(name="currentPage", required = false, defaultValue = "1") int currentPage
				,Model model,HttpSession session) {
		
		Map<String, Object> resultMap = ilbanSalesService.getIlbanSalesLookUp(currentPage);
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		
		Member member = memberService.getMemberInfoById(sessionId);
		
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("resultMap", 		resultMap);
		model.addAttribute("currentPage", 		currentPage);
		model.addAttribute("ilbanSalesLookUpList", 	resultMap.get("ilbanSalesLookUpList"));
		model.addAttribute("lastPage", 			resultMap.get("lastPage"));
		model.addAttribute("startPageNum", 		resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", 		resultMap.get("endPageNum"));
		
		return "/admin/sales/ilbanSales";
	}
}
