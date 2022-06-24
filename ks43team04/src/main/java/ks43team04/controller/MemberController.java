package ks43team04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks43team04.dto.Laundry;
import ks43team04.dto.Member;
import ks43team04.mapper.MemberMapper;
import ks43team04.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	private final MemberService memberService;
	private final MemberMapper memberMapper;

	public MemberController(MemberService memberService, MemberMapper memberMapper) {
		this.memberService = memberService;
		this.memberMapper = memberMapper;
	}
	/**
	 * 고객 마이페이지 > 환불내역
	 */
	@GetMapping("/myPageRefund")
	public String myPageRefund(Model model, HttpSession session) {

		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");

		Member member = memberService.getMemberInfoById(sessionId);

		model.addAttribute("title", "마이페이지");
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("member", member);

		return "/member/myPageRefund";
	}
	/**
	 * 고객 마이페이지 > 내가 쓴 글 조회
	 */
	@GetMapping("/myPageWrite")
	public String myPageWrite(Model model, HttpSession session) {

		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");

		Member member = memberService.getMemberInfoById(sessionId);

		model.addAttribute("title", "마이페이지");
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("member", member);

		return "/member/myPageWrite";
	}

	/**
	 * 고객 마이페이지 > 포인트 조회
	 */
	@GetMapping("/myPagePoint")
	public String myPagePoint(Model model, HttpSession session) {

		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");

		Member member = memberService.getMemberInfoById(sessionId);

		model.addAttribute("title", "마이페이지");
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("member", member);
		return "/member/myPagePoint";
	}

	/**
	 * 회원가입 아이디 중복체크 
	 * idCheck ajax
	 * @RequestParam(value = "memberId") == request.getParameter("memberId")
	 */
	@PostMapping("/idCheck")
	@ResponseBody
	public boolean isIdCheck(@RequestParam(value = "memberId") String memberId) {
		
		boolean idCheck = false;
		log.info("아이디중복체크 클릭시 요청받은 memberId의 값: {}", memberId);
		
		boolean result = memberMapper.isIdCheck(memberId);
		if(result) idCheck = true;
		
		log.info("아이디중복체크 여부 : {}", result);
		return idCheck;
	}
	
	/**
	 * 무인점주, 일반점주 회원가입 처리
	 * @param member
	 * @param memberId
	 * @param request
	 * @return
	 */
	@PostMapping("/addMemberLaundry")
	public String addMemberLaundry(Laundry laundry
								,@RequestParam(name="laundryCode", required=false) String laundryCode 
								,HttpServletRequest request) {
		log.info("회원가입 화면에서 입력한 data : {}", laundry);
		log.info("세탁소 정보 기입 : {}", laundryCode);
		
		memberService.addMemberLaundry(laundry);
		
		return "redirect:/user/login";	
	}
	/**
	 * 고객, 관리자 회원가입 처리
	 * @param member
	 * @param memberId
	 * @param request
	 * @return
	 */
	@PostMapping("/addMember")
	public String addMember(Member member
							,@RequestParam(name="memberId", required=false) String memberId 
							,HttpServletRequest request) {
		log.info("회원가입 화면에서 입력한 data : {}", member);
		log.info("회원가입 화면에서 입력한 memberId : {}", memberId);
		
		memberService.addMember(member);
		
		return "redirect:/user/login";	
	}	
	
	/**
	 * 고객, 일반점주, 무인점주 마이페이지 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/myPage")
	public String myPage(Model model
						,HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		String sessionLevel = (String) session.getAttribute("SLEVEL");
		
		Member member = memberService.getMemberInfoById(sessionId);

		if(sessionLevel != null && (sessionLevel.equals("level_code_02") || sessionLevel.equals("level_code_03"))) {
			member = memberService.getStoreOwnerInfoById(sessionId);
		}
		
		System.out.println(member);
		
		model.addAttribute("title", "마이페이지");
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("member", member);
		
		return "member/myPage";
	}
	
	/**
	 * 모든회원 로그인처리 
	 * @param member
	 * @param session
	 * @param reAttr
	 * @return
	 */
	@PostMapping("/login")
	public String login(Member member, HttpSession session, RedirectAttributes reAttr) {
		
		String memberId = member.getMemberId();
		String memberPw = member.getMemberPw();

		log.info("{}", member);
		
		Member checkMember = memberMapper.getMemberInfoById(memberId);
		log.info("{}", checkMember);
		
		if(checkMember != null && checkMember.getMemberPw() != null && memberPw.equals(checkMember.getMemberPw())) {
			String sessionName = checkMember.getMemberName();
			String sessionLevel = checkMember.getLevelCode();			
			System.out.println(memberId);
			System.out.println(memberPw);
			session.setAttribute("SID", memberId); 
			session.setAttribute("SNAME", sessionName);
			session.setAttribute("SLEVEL", sessionLevel);			
			
			log.info("로그인성공");
			
			return "redirect:/user/index";
		}		
		reAttr.addAttribute("result", "아이디 또는 비밀번호를 잘못 입력하셨습니다. 다시 확인해주세요.");
		return "redirect:/user/login";		
	}
	
	/**
	 * 모든회원 비밀번호 찾기
	 * @param model
	 * @return
	 */
	@GetMapping("/againPwMember")
	public String againPwMember(Model model) {		
		model.addAttribute("title", "비밀번호찾기");		
		return "member/againPwMember";
	}

	/**
	 * 무인점주, 일반점주 회원가입 
	 * @param model
	 * @return
	 */
	@GetMapping("/addMemberLaundry")
	public String addMemberLaundry(Model model) {		
		model.addAttribute("title", "회원가입");		
		return "member/addMemberLaundry";
	}
	
	/**
	 * 고객, 관리자 회원가입
	 * @param model
	 * @return
	 */
	@GetMapping("/addMember")
	public String addMember(Model model) {		
		model.addAttribute("title", "회원가입");		
		return "member/addMember";		
	}
		
	/**
	 * 메인 로그아웃 
	 * @param member
	 * @param session
	 * @param reAttr
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(Member member, HttpSession session, RedirectAttributes reAttr) {		
		session.invalidate();	
		return "redirect:/user/login";
	}
	/**
	 * 메인화면 로그인  
	 * @return
	 */
	@GetMapping("/login")
	public String login() {		
		return "member/login";
	}

}
