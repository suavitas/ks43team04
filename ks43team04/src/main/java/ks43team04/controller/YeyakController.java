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
import ks43team04.dto.IlbanSkill;
import ks43team04.dto.Laundry;
import ks43team04.dto.Member;
import ks43team04.dto.MuinMachine;
import ks43team04.service.BillService;
import ks43team04.service.MemberService;
import ks43team04.service.YeyakService;

@RequestMapping("/user")
@Controller
public class YeyakController {

	private final YeyakService yeyakService;
	private final BillService billService;
	private final MemberService memberService;

	
	public YeyakController(YeyakService yeyakService,BillService billService,MemberService memberService) {
		this.yeyakService = yeyakService;
		this.billService = billService;
		this.memberService = memberService;
	}
	
	@GetMapping("/myPagePayment2")
	public String myPagePayment2(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage
								,Model model,HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		
		Member member = memberService.getMemberInfoById(sessionId);
		//세션 이름 저장
		model.addAttribute("sessionName", sessionName);
		
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
	
	@GetMapping("/muinYeyak")
	public String muinYeyak(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage,
			Model model) {

		List<MuinMachine> muinMachineList = yeyakService.getMuinMachineList();

		Map<String, Object> resultMap = yeyakService.getMuinLaundryList(currentPage);

		model.addAttribute("resultMap", resultMap);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("muinLaundryList", resultMap.get("muinLaundryList"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", resultMap.get("endPageNum"));

		model.addAttribute("muinMachineList", muinMachineList);

		return "/user/yeyak/muinYeyak";
	}

	@GetMapping("/ilbanYeyak")
	public String yeyak(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage,
			Model model) {

		List<IlbanSkill> ilbanSkillList = yeyakService.getIlbanSkillList();
		List<Laundry> ilbanGoodsPriceList = yeyakService.getIlbanGoodsPriceList();

		Map<String, Object> resultMap = yeyakService.getIlbanLaundryList(currentPage);

		model.addAttribute("resultMap", resultMap);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("ilbanLaundryList", resultMap.get("ilbanLaundryList"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", resultMap.get("endPageNum"));

		System.out.println(ilbanGoodsPriceList);

		model.addAttribute("ilbanGoodsPriceList", ilbanGoodsPriceList);
		model.addAttribute("ilbanSkillList", ilbanSkillList);

		return "user/yeyak/ilbanYeyak";
	}
}
