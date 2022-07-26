package ks43team04.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks43team04.dto.Board;
import ks43team04.dto.Laundry;
import ks43team04.dto.Member;
import ks43team04.dto.MemberLevel;
import ks43team04.dto.MemberOut;
import ks43team04.mapper.BillMapper;
import ks43team04.mapper.BoardMapper;
import ks43team04.mapper.MemberMapper;
import ks43team04.service.BillService;
import ks43team04.service.BoardService;
import ks43team04.service.MemberService;
import ks43team04.service.PaymentService;
import ks43team04.service.UserService;

@Controller
@RequestMapping("/user")
public class MemberController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	private final MemberService memberService;
	private final UserService userService;
	private final MemberMapper memberMapper;
	private final BillMapper billMapper;
	private final BillService billService;
	private final PaymentService paymentService;
	private final BoardService boardService;
	private final BoardMapper boardMapper;

	
	public MemberController(MemberService memberService, MemberMapper memberMapper,BillMapper billMapper,UserService userService,BillService billService, PaymentService paymentService, BoardService boardService, BoardMapper boardMapper) {
		this.memberService = memberService;
		this.memberMapper = memberMapper;
		this.billMapper = billMapper;
		this.userService = userService;
		this.billService = billService;
		this.paymentService = paymentService;
		this.boardService = boardService;
		this.boardMapper = boardMapper;
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
	
	/*bill 인서트*/
	@PostMapping("/myPagePayment")
	public String myPagePayment(@RequestParam(value = "memberId") String memberId,
								@RequestParam(value = "laundryCode") String laundryCode,
								@RequestParam(value = "totalPrice") String totalPrice) {
		
		System.out.println(memberId+"<--------- memberId ");
		System.out.println(laundryCode+"<--------- laundryCode ");
		System.out.println(totalPrice+"<--------- totalPrice ");
		
		billService.addBill(memberId, laundryCode, totalPrice);
		
		
		return "redirect:/user/myPagePayment";
	}	
	
	/**
	 * 고객 마이페이지 > 결제내역
	 */
	@GetMapping("/myPagePayment")
	public String myPagePayment(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage,
			Model model, HttpSession session) {

		Map<String, Object> resultMap = userService.getPaymentList(currentPage, session);
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		String memberId = sessionId;
		
		Member member = memberService.getMemberInfoById(sessionId);
		int rowCount = billMapper.getBillCount(memberId);
		
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("title", "마이페이지");
		model.addAttribute("sessionName", sessionName);
		
		model.addAttribute("resultMap", resultMap);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("getPaymentList", resultMap.get("getPaymentList"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", resultMap.get("endPageNum"));
		

		return "/member/myPagePayment";
	}

	
	/**
	 * 고객 마이페이지 > 내가 쓴 글 조회
	 */
	@GetMapping("/myPageWrite")
	public String myPageWrite(Model model, HttpSession session) {

		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		Member member = memberService.getMemberInfoById(sessionId);
		List<Board> myWritingList = boardService.myWritingList(member.getMemberId());
		int myWritingListCount = boardMapper.myWritingListCount(member.getMemberId());

		model.addAttribute("title", "마이페이지");
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("member", member);
		model.addAttribute("myWritingList", myWritingList);
		model.addAttribute("myWritingListCount", myWritingListCount);
		System.out.println(myWritingList);

		return "/member/myPageWrite";
	}

	/**
	 * 고객 마이페이지 > 포인트 조회
	 */
	@GetMapping("/myPagePoint")
	public String myPagePoint(Model model, HttpSession session) {

		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		String sessionLevel = (String) session.getAttribute("SLEVEL");

		Member member = memberService.getMemberInfoById(sessionId);
		MemberLevel memberlevel = paymentService.getMemberLevel(sessionLevel);	

		model.addAttribute("title", "마이페이지");
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("sessionLevel", sessionLevel);
		model.addAttribute("member", member);
		model.addAttribute("memberlevel", memberlevel);
		System.out.println(member);
		System.out.println(memberlevel);
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
	  * 고객, 무인점주, 일반점주 탈퇴 처리
	  * @param memberId
	  * @param memberPw
	  * @param reAttr
	  * @return
	  */
	 @PostMapping("/removeMember")
	 @ResponseBody //ajax통신 자바객체로 변환
	 public Map<String, Object> removeMember(Member member
			 								,@RequestParam(name="memberOutReason", required = false, defaultValue = "") String memberOutReason
			 								,HttpSession session, RedirectAttributes reAttr) {
		 int re = 1;
		 String memberId = member.getMemberId();
		 String memberPw = member.getMemberPw();
		 Member memberCheck = memberService.getMemberInfoById(memberId);
		 MemberOut memberOutCheck = memberService.getMemberOutInfoById(memberId); //대기(점주 탈퇴성공 후 대기상태) 상태라면 탈퇴 불가 
		 System.out.println(memberId);
		 System.out.println(memberOutReason);
		 
		 String levelCode = member.getLevelCode();
		
		 System.out.println(member);
		 System.out.println(levelCode);
		 
		 Map<String, Object> resultMap = new HashMap<String, Object>();
		 
		 if(!ObjectUtils.isEmpty(member.getMemberId()) && !ObjectUtils.isEmpty(memberCheck.getMemberOutCode()) && memberPw.equals(memberCheck.getMemberPw())) { 
			 System.out.println("동작1");
			 if(!ObjectUtils.isEmpty(memberOutCheck) && ("level_code_02".equals(levelCode) || "level_code_03".equals(levelCode))) {
				 //2 = 이미 탈퇴 대기 상태
				 re = 2;
			 }
		 } else {
			 //3 = 비밀번호 틀림
			 re = 3;
		 }
		
		 if(("level_code_04".equals(levelCode) || "level_code_05".equals(levelCode) || "level_code_06".equals(levelCode) || "level_code_07".equals(levelCode) || "level_code_08".equals(levelCode)) && re == 1) {
			 memberService.removeMember(member, memberOutReason);		 
		 } else if(("level_code_02".equals(levelCode) || "level_code_03".equals(levelCode)) && re == 1) {
			 memberService.removeLaundry(member, memberOutReason);
		 }
		 log.info("동작2");
		 if(re == 1) {
			 log.info("회원 탈퇴 성공");	
			 resultMap.put("result", re);
			 resultMap.put("movePage", "/user/login");
			 session.invalidate();
		 }else {
			 resultMap.put("result", re);
			 resultMap.put("movePage", "/user/removeMember");
			 log.info("회원 탈퇴 실패"); 
		 }
		 return resultMap; 
	 }
			 
	/**
	 * 고객, 무인점주, 일반점주 탈퇴 화면
	 * @return
	 */
	@GetMapping("/removeMember")
	public String removeMember(@RequestParam(name="result", required = false) String result
							  ,Model model
							  ,HttpSession session) {
		
		String sessionName = (String) session.getAttribute("SNAME");
		String memberId    = (String) session.getAttribute("SID");
		MemberOut memberOut = memberService.getMemberOutInfoById(memberId);
		
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("title","회원 탈퇴 화면");
		model.addAttribute("memberId", memberId);
		model.addAttribute("memberOut", memberOut);
		
		if(result != null) model.addAttribute("result", result);
		
		return "member/removeMember";
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
								  ,Member member
								  ,@RequestParam(name="laundryCode", required=false) String laundryCode  
								  ,HttpServletRequest request) {
		log.info("회원가입 화면에서 입력한 data : {}", laundry);
		log.info("세탁소 정보 기입 : {}", laundryCode);		
		System.out.println(member);
		
		memberService.addMember(member);
		memberService.addMemberLaundry(laundry);
		
		return "redirect:/user/login";	
	}
	/**
	 * 고객 회원가입 처리
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
	   * 고객, 일반점주, 무인점주 마이페이지 수정 처리
	   * @param member
	   * @return
	   */
	  @PostMapping("/modifyUser") 
	  public String modifyUser(Member member, Laundry laundry, Model model) {	  
		  log.info("마이페이지 상세보기 수정정보:{}", member);
		  
		  Map<String, Object> paramMap = new HashMap<>();
		  
		  System.out.println(member+"<<<<<<<<<<member 값");
		  System.out.println(laundry+"<<<<<<<<<<<<<laundry 값");
		  
		  paramMap.put("member", member);
		  if(laundry.getLaundryCode() != null) {
			  paramMap.put("laundry", laundry);
		  }	  
		  System.out.println("------------------------------------------");	  
		  memberService.modifyUser(paramMap);
		  model.addAttribute("member", member);
		  return "redirect:/user/myPage";
	  }
	
	/**
	 * 고객, 일반점주, 무인점주 마이페이지 수정 조회
	 * @param memberId
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/modifyUser")
	public String modifyUser(@RequestParam (name="memberId", required=false) String memberId 
							,Model model
							,HttpSession session) {
		String sessionName = (String) session.getAttribute("SNAME");
		log.info("화면에서 입력받은 마이페이지 수정보기 data:{}", memberId);
		
		Member member = memberService.getUserInfoById(memberId);
		log.info("member: {}", member);
		
		model.addAttribute("member", member);
		model.addAttribute("sessionName", sessionName);
		return "member/modifyUser";
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
		
		log.info("작동",sessionLevel);
		System.out.println(sessionLevel);
		
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
	public String addMemberLaundry(Model model
								,@RequestParam(name="levelCode", required=false) String levelCode){		
		model.addAttribute("title", "회원가입");		
		model.addAttribute("levelCode", levelCode);
		log.info(levelCode,":::::::::::::::");
		return "member/addMemberLaundry";
	}
	
	/**
	 * 고객, 관리자 회원가입
	 * @param model
	 * @return
	 */
	@GetMapping("/addMember")
	public String addMember(Model model
							,@RequestParam(name="levelCode", required=false) String levelCode) {
		model.addAttribute("title", "회원가입");		
		model.addAttribute("levelCode", levelCode);		
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
