package ks43team04.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks43team04.dto.Laundry;
import ks43team04.dto.Member;
import ks43team04.mapper.AdminMemberMapper;
import ks43team04.service.AdminMemberService;

@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	private static final Logger log = LoggerFactory.getLogger(AdminMemberController.class);
	
	private final AdminMemberService adminMemberService;
	private final AdminMemberMapper adminMemberMapper;
	
	public AdminMemberController(AdminMemberService adminMemberService,  AdminMemberMapper adminMemberMapper) {
		this.adminMemberService = adminMemberService;
		this.adminMemberMapper = adminMemberMapper;
	}
	//어드민페이지 등급관리 화면
	@GetMapping("/Level")
	public String Level(Model model) {		
		model.addAttribute("title", "등급관리");		
		return "adminmember/Level";		
	}
	
	//어드민페이지 아이디 중복체크 여부
	@PostMapping("/idCheck")
	@ResponseBody
	public boolean isIdCheck(@RequestParam(value = "memberId") String memberId) {
		boolean idCheck = false;
		log.info("아이디중복체크 클릭시 요청받은 memberId의 값: {}", memberId);
		
		boolean result = adminMemberMapper.isIdCheck(memberId);
		if(result) idCheck = true;
		
		log.info("아이디중복체크 여부 : {}", result);
		return idCheck;
	}
	
	//관리자페이지 관리자 회원가입(등록) 처리
	@PostMapping("/addMemberAdmin")
	public String addMemberAdmin(Member member) {	
		log.info("회원가입폼 시작");		
		adminMemberService.addMemberAdmin(member);	
		log.info("회원가입폼에서 입력받은 데이터:{}", member);
		
		return "redirect:/admin";
	}	
	
	//관리자페이지 관리자 회원가입(등록)
	@GetMapping("/addMemberAdmin")
	public String addMemberAdmin(Model model) {	
		model.addAttribute("title", "관리자페이지 관리자 등록");
		model.addAttribute("titleName", "관리자 등록");
		
		return "adminmember/addMemberAdmin";
	}
	
	//관리자페이지 세탁소 전체회원 조회
	@GetMapping("/LaundryList")
	public String getLaundryList(Model model) {
		
		List<Laundry> LaundryList = adminMemberService.getLaundryList();
		log.info("세탁소 회원전체 목록: {}", LaundryList);
		model.addAttribute("LaundryList", LaundryList);
		
		return "adminmember/LaundryList";
	}	
	
	//관리자페이지 전체회원 조회
	@GetMapping("/adminMemberList")
	public String getAdminMemberList(Model model) {
		
		List<Member> adminMemberList = adminMemberService.getAdminMemberList();
		log.info("회원전체 목록: {}", adminMemberList);
		model.addAttribute("adminMemberList", adminMemberList);
		
		return "adminmember/adminMemberList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
