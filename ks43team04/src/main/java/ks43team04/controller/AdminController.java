package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.LaundryList;
import ks43team04.dto.MuinMachienSpec;
import ks43team04.dto.YearlyHoliday;
import ks43team04.service.AdminService;
import ks43team04.service.LaundryService;
import ks43team04.service.MemberService;
import ks43team04.dto.Member;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final AdminService adminService;
	private final MemberService memberService;
	private final LaundryService laundryService;
	

	public AdminController(AdminService adminService ,LaundryService laundryService ,MemberService memberService) {
		this.adminService = adminService;
		this.laundryService = laundryService;
		this.memberService = memberService;
	}

	/* 전체 회원 조회 */
	@GetMapping("/adminMember")
	public String memberList(Model model) {

		List<Member> MemberList = memberService.getMemberList();

		model.addAttribute("MemberList", MemberList);
		return "admin/adminMember";
	}

	/* 전 매장 장비 스팩 */
	@GetMapping("/machineState")
	public String machineState(Model model) {
		
		 List<MuinMachienSpec> MachineSpecList = laundryService.machineSpecList();
		 
		 model.addAttribute("MachineSpecList", MachineSpecList); 
		 
		 
		return "admin/machineState";
	}
	
	


	/* 전 매장 월별 수입 */
	@GetMapping("/income")
	public String income() {
		return "admin/income";
	}

	/* 전 매장 월별 환불퍼센트 */
	@GetMapping("/retrun")
	public String retrun() {
		return "admin/retrun";
	}

	/* 회원별 포인트 */
	@GetMapping("/memberPoint")
	public String memberPoint() {
		return "admin/memberPoint";
	}

	/* 전 매장 장비 현황 */
	@GetMapping("/machine")
	public String machine() {
		return "admin/machine";
	}



	/* 세탁소별 월별 수입 */
	@GetMapping("/lundryIncome")
	public String lundryIncome() {
		return "admin/lundryIncome";
	}

	/* 세탁소별 월별 환불 퍼센트 */
	@GetMapping("/lundryReturn")
	public String lundryReturn() {
		return "admin/lundryReturn";
	}

	/* 세탁소별 장비 현황 */
	@GetMapping("/lundrymachine")
	public String lundrymachine() {
		return "admin/lundrymachine";
	}

	/* 세탁소별 회원목록 */
	@GetMapping("/lundryUser")
	public String lundryUser() {
		return "admin/lundryUser";
	}

	/* 세탁소별 회원 포인트 */
	@GetMapping("/lundryUserPoint")
	public String lundryUserPoint() {
		return "admin/lundryUserPoint";
	}

	/* 세탁소 회원별 질문사항 */
	@GetMapping("/lundryUserQA")
	public String lundryUserQA() {
		return "admin/lundryUserQA";
	}

}
