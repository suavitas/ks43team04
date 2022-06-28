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

import ks43team04.dto.Delivery;
import ks43team04.dto.Laundry;
import ks43team04.dto.LoginHistory;
import ks43team04.dto.Member;
import ks43team04.dto.MemberOut;
import ks43team04.dto.UserLevel;
import ks43team04.mapper.AdminMemberMapper;
import ks43team04.mapper.UserMapper;
import ks43team04.service.AdminMemberService;

@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	private static final Logger log = LoggerFactory.getLogger(AdminMemberController.class);
	
	private final AdminMemberService adminMemberService;
	private final AdminMemberMapper adminMemberMapper;
	private final UserMapper userMapper;
	
	public AdminMemberController(AdminMemberService adminMemberService,  AdminMemberMapper adminMemberMapper,UserMapper userMapper) {
		this.adminMemberService = adminMemberService;
		this.adminMemberMapper = adminMemberMapper;
		this.userMapper = userMapper;
	}
	
	//관리자페이지 세탁점주 상세정보조회
	@GetMapping("/detailLaundry")
	public String getDetailLaundryInfo(Model model
									,@RequestParam(name="laundryCode", required = false) String laundryCode) {
		Laundry laundry = adminMemberService.getLaundryInfoByCode(laundryCode);
		log.info("세탁소 상세정보:{}", laundry);
		model.addAttribute("title", "세탁소 점주회원 관리");
		model.addAttribute("titleName", "세탁소 상세정보");
		model.addAttribute("laundry", laundry);
		return "adminmember/detailLaundry";
	}
	
	
	//관리자페이지 회원관리 상세정보조회 
	@GetMapping("/detailMember")
	public String getDetailMemberInfo(Model model
									,@RequestParam(name="memberId", required = false) String memberId) {		
		Member member = adminMemberService.getMemberInfoById(memberId);		
		log.info("회원 상세정보:{}", member);		
		model.addAttribute("title", "회원 관리");
		model.addAttribute("titleName", "회원 상세정보");
		model.addAttribute("member", member);
		return "adminmember/detailMember";
	}
	
	
	//관리자페이지 로그인 회원접속내역 화면
	@GetMapping("/loginHistory")
	public String loginHistory(Model model) {
		List<LoginHistory> loginHistory = adminMemberService.getLoginHistory();
		log.info("회원접속내역 :{}", loginHistory);		
		model.addAttribute("title", "회원접속내역");
		model.addAttribute("loginHistory", loginHistory);
		return "adminmember/loginHistory";
	}
	
	//관리자페이지 회원탈퇴 화면
	@GetMapping("/adminMemberOut")
	public String adminMemberOut(Model model) {
		List<MemberOut> adminMemberOut = adminMemberService.getMemberOut();
		log.info("회원탈퇴 :{}", adminMemberOut);		
		model.addAttribute("title", "회원탈퇴");
		model.addAttribute("adminMemberOut", adminMemberOut);
		return "adminmember/adminMemberOut";
	}
	
	//관리자페이지 등급관리 화면
	@GetMapping("/userLevel")
	public String userLevel(Model model) {		
		List<UserLevel> userLevel = adminMemberService.getUserLevel();		
		log.info("고객 등급혜택 :{}", userLevel);		
		model.addAttribute("title", "등급관리");
		model.addAttribute("titleName", "회원 등급 혜택 및 기준");
		model.addAttribute("userLevel", userLevel);
		
		return "adminmember/userLevel";
	}
	
	//관리자페이지 아이디 중복체크 여부
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
	
	
	@GetMapping("/lundryUser")
	public String LaundryUserList(Model model) {
		List<Delivery> LaundryUserList = userMapper.LaundryUserList();
		model.addAttribute("LaundryUserList",LaundryUserList);
		System.out.println(LaundryUserList);
		return "admin/lundryUser";
	}
	
	
	
}
