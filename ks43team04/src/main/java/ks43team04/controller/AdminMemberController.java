package ks43team04.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ks43team04.dto.Delivery;
import ks43team04.dto.Laundry;
import ks43team04.dto.LoginHistory;
import ks43team04.dto.Member;
import ks43team04.dto.MemberLevel;
import ks43team04.dto.MemberOut;
import ks43team04.dto.Refund;
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
	
	public AdminMemberController(AdminMemberService adminMemberService,  AdminMemberMapper adminMemberMapper, UserMapper userMapper) {
		this.adminMemberService = adminMemberService;
		this.adminMemberMapper = adminMemberMapper;
		this.userMapper = userMapper;
	}

	//관리자페이지 일반세탁소 관리 - 환불 신청
	@GetMapping("/laundryReturn")
	public String refund(Model model){
		log.info("환불 신청 목록");		
		
		model.addAttribute("title", "환불 신청 목록");
		List<Refund> getRefundList = adminMemberService.getRefundList();
		model.addAttribute("getRefundList", getRefundList);
		System.out.println(getRefundList+"<---------getRefundList 리스트값");
		
		return "admin/laundryReturn";
	}
	
	//관리자페이지 탈퇴 대기사유 작성 전달 
	@PostMapping("/memberOutWaitMemo")
	public String memberOutWaitMemo(Model model
								   ,MemberOut memberOut){
		model.addAttribute("memberId", memberOut.getMemberId());
		adminMemberService.getMemberOutMemo(memberOut);
		
		log.info("작동-------------------");
		return "redirect:/admin/adminMemberOut";
	}
	
	//관리자페이지 등급기준 삭제
	@PostMapping("/removeUserlevel")
	@ResponseBody
	public int removeUserlevel(@RequestBody Map <String, String> levelCode){
		   int result = adminMemberService.removeUserlevel(levelCode);
		   return result;
	}
	 
	//관리자페이지 등급기준 추가 처리
	@PostMapping("/addUserLevel") 
	public String addUserLevel(Model model
			  				  ,MemberLevel memberlevel, UserLevel userlevel){ 
		  adminMemberService.addUserLevel(memberlevel, userlevel);
		  return "redirect:/admin/userLevel"; 
	} 
	
	//관리자페이지 등급기준 추가 
	@GetMapping("/addUserLevel")
	public String addUserLevel(){
		  return "adminmember/addUserLevel";
	}
	 
	//관리자페이지 가입날짜별 탈퇴목록 조회 (달력)
	@GetMapping("/searchDateOutList") 
	public String searchDateOutList(Model model 
			  						  ,@RequestParam(value="startDate", required = false) String startDate
									  ,@RequestParam(value="endDate", required = false) String endDate
	  								  ,@RequestParam(value="URLHash", required = false) String URLHash){
		  log.info("시작날짜 검색:{}", startDate); 
		  
		  List<MemberOut> searchDateOutList = adminMemberService.searchDateOutList(startDate, endDate);
		  List<MemberOut> searchDateOutList2 = adminMemberService.searchDateOutList2(startDate, endDate); //O
		  
		  model.addAttribute("adminMemberOut", searchDateOutList); //완료
		  model.addAttribute("getMemberNotOut", searchDateOutList2); //대기
		  model.addAttribute("URLHash", URLHash);
		  
		  System.out.println(startDate+"<-----------------startDate");
		  System.out.println(endDate+"<-----------------endDate");
		  System.out.println(searchDateOutList+"<-----------------OutList");
		  return "adminmember/adminMemberOut"; 
	  
	 }
	  
	 //관리자페이지 모든검색 조건별 탈퇴목록 조회 (오늘, 일주일 ..)
	 @PostMapping("/allSearchOutList") 
	 public String allSearchOutList(Model model
		  	  						 ,@RequestParam(value="startDate", required = false) String startDate
	  	  							 ,@RequestParam(value="endDate", required = false) String endDate
	  								 ,@RequestParam(value="searchKey", required = false, defaultValue = "") String searchKey
	  								 ,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue){
		log.info("시작날짜 검색:{}", startDate);
		log.info("종료날짜 검색:{}", endDate);
		log.info("가입기간별 탈퇴목록 검색:{}", searchKey);
		log.info("가입기간별 탈퇴목록 검색:{}", searchValue);
		
		List<MemberOut> allSearchOutList2 = adminMemberService.allSearchOutList2(startDate, endDate, searchKey, searchValue); //O
		List<MemberOut> allSearchOutList = adminMemberService.allSearchOutList(startDate, endDate, searchKey, searchValue);
		
		model.addAttribute("adminMemberOut", allSearchOutList); //완료 O
		model.addAttribute("getMemberNotOut", allSearchOutList2); //대기 X
		
		return "adminmember/adminMemberOut";
	}		 
	
	 //관리자페이지 가입날짜별 로그인목록 조회
	 @GetMapping("/searchDateLoginList") 
	 public String searchDateLoginList(Model model 
			  							,@RequestParam(value="startDate", required = false) String startDate
  										,@RequestParam(value="endDate", required = false) String endDate) {
		  log.info("시작날짜 검색:{}", startDate); 
		  log.info("종료날짜 검색:{}", endDate);
		  
		  List<LoginHistory> searchDateLoginList = adminMemberService.searchDateLoginList(startDate, endDate);
		  adminMemberService.searchDateLoginList(startDate, endDate);
		  model.addAttribute("loginHistory", searchDateLoginList);
		  
		  System.out.println(startDate+"<-----------------startDate");
		  System.out.println(endDate+"<-----------------endDate");
		  System.out.println(searchDateLoginList+"<-----------------LoginList");
		  return "adminmember/loginHistory"; 
	  
	 }
		
	 //관리자페이지 모든검색 조건별 로그인목록 조회
	 @PostMapping("/allSearchLoginList") 
	 public String allSearchLoginList(Model model
		  	  						   ,@RequestParam(value="startDate", required = false) String startDate
	  	  							   ,@RequestParam(value="endDate", required = false) String endDate
  	  								   ,@RequestParam(value="searchKey", required = false, defaultValue = "") String searchKey
  	  								   ,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue) {
		log.info("시작날짜 검색:{}", startDate);
		log.info("종료날짜 검색:{}", endDate);
		log.info("가입기간별 로그인목록 검색:{}", searchKey);
		log.info("가입기간별 로그인목록 검색:{}", searchValue);
		
		List<LoginHistory> allSearchLoginList = adminMemberService.allSearchLoginList(startDate, endDate, searchKey, searchValue);
		model.addAttribute("loginHistory", allSearchLoginList);
		return "adminmember/loginHistory";
	}
	 
	
	//관리자페이지 가입날짜별 세탁소목록 조회
	@GetMapping("/searchDateLaundryList")  
	public String searchDateLaundryList(Model model
									   ,@RequestParam(value="startDate", required = false) String startDate
									   ,@RequestParam(value="endDate", required = false) String endDate) {
		log.info("시작날짜 검색:{}", startDate);
		log.info("종료날짜 검색:{}", endDate);
		List<Laundry> searchDateLaundryList = adminMemberService.searchDateLaundryList(startDate, endDate);
		model.addAttribute("LaundryList", searchDateLaundryList);
		
		System.out.println(startDate+"<-----------------startDate");
		System.out.println(endDate+"<-----------------endDate");
		System.out.println(searchDateLaundryList+"<-----------------LaundryList");
		return "adminmember/LaundryList";
	}
		
	//관리자페이지 모든검색 조건별 세탁소목록 조회 
	@PostMapping("/allSearchLaundryList")
	public String allSearchLaundryList(Model model
								  	  ,@RequestParam(value="startDate", required = false) String startDate
									  ,@RequestParam(value="endDate", required = false) String endDate
									  ,@RequestParam(value="searchKey", required = false, defaultValue = "") String searchKey
									  ,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue) {
	  
		log.info("시작날짜 검색:{}", startDate);
		log.info("종료날짜 검색:{}", endDate);
		log.info("가입기간별 세탁소 검색:{}", searchKey);
		log.info("가입기간별 세탁소 검색:{}", searchValue);
		List<Laundry> allSearchLaundryList = adminMemberService.allSearchLaundryList(startDate, endDate, searchKey, searchValue);
		model.addAttribute("LaundryList", allSearchLaundryList);
		return "adminmember/LaundryList";
	}
	
	//관리자페이지 가입날짜별 회원목록 조회
	@GetMapping("/searchDateMemberList")  
	public String searchDateMemberList(Model model
									   ,@RequestParam(value="startDate", required = false) String startDate
									   ,@RequestParam(value="endDate", required = false) String endDate) {
		log.info("시작날짜 검색:{}", startDate);
		log.info("종료날짜 검색:{}", endDate);
		List<Member> searchDateMemberList = adminMemberService.searchDateMemberList(startDate, endDate);
		model.addAttribute("adminMemberList", searchDateMemberList);
		
		System.out.println(startDate+"<-----------------startDate");
		System.out.println(endDate+"<-----------------endDate");
		System.out.println(searchDateMemberList+"<-----------------adminMemberList");
		return "adminmember/adminMemberList";
	}
	
	//관리자페이지 모든검색 조건별 회원목록 조회 
	@PostMapping("/allSearchMemberList")
	public String allSearchMemberList(Model model
								  	  ,@RequestParam(value="startDate", required = false) String startDate
									  ,@RequestParam(value="endDate", required = false) String endDate
									  ,@RequestParam(value="searchKey", required = false, defaultValue = "") String searchKey
									  ,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue) {
	  
		log.info("시작날짜 검색:{}", startDate);
		log.info("종료날짜 검색:{}", endDate);
		log.info("가입기간별 회원 검색:{}", searchKey);
		log.info("가입기간별 회원 검색:{}", searchValue);
		List<Member> allSearchMemberList = adminMemberService.allSearchMemberList(startDate, endDate, searchKey, searchValue);
		model.addAttribute("adminMemberList", allSearchMemberList);
		return "adminmember/adminMemberList";
	}
	
	//관리자페이지 검색조건별(셀렉박스) 세탁소 목록 조회
	@GetMapping("/conditionLaundryList")
	public String conditionLaundryList(Model model
									   ,@RequestParam(value="searchKey", required = false) String searchKey
									   ,@RequestParam(value="searchValue", required = false) String searchValue) {			
		log.info("조건별 회원 검색:{}", searchValue);						
		List<Laundry> conditionLaundryList = adminMemberService.conditionLaundryList(searchKey, searchValue);
		model.addAttribute("LaundryList", conditionLaundryList);
		log.info("conditionLaundryList : {}", conditionLaundryList);
		return "adminmember/LaundryList";
	}
		
	//관리자페이지 검색조건별(셀렉박스) 회원 목록 조회
	@GetMapping("/conditionMemberList")
	public String conditionMemberList(Model model
									  ,@RequestParam(value="searchKey", required = false) String searchKey
									  ,@RequestParam(value="searchValue", required = false) String searchValue) {			
		log.info("조건별 회원 검색:{}", searchValue);						
		List<Member> conditionMemberList = adminMemberService.conditionMemberList(searchKey, searchValue);
		model.addAttribute("adminMemberList", conditionMemberList);
		log.info("conditionMemberList : {}",conditionMemberList);
		return "adminmember/adminMemberList";
	}
	
	//관리자페이지 권한별 탈퇴회원 조회 검색
	@GetMapping("/searchLevelMemberOutList")
	public String searchLevelMemberOutList(Model model
										  ,@RequestParam(value="levelName", required = false) String levelName
										  ,@RequestParam(value="URLHash", required = false) String URLHash) {
		log.info("권한별 탈퇴 조회:{}", levelName);
		log.info("권한별 탈퇴 조회:{}", URLHash);

		List<MemberOut> adminMemberOut = adminMemberService.searchLevelMemberOutList2(levelName); //완료
		List<MemberOut> getMemberNotOut = adminMemberService.searchLevelMemberOutList(levelName); //대기
		
		log.info("회원탈퇴 :{}", adminMemberOut);		
		model.addAttribute("title", "회원탈퇴");
		model.addAttribute("adminMemberOut", adminMemberOut);
		model.addAttribute("getMemberNotOut", getMemberNotOut);
		model.addAttribute("URLHash", URLHash);
		return "adminmember/adminMemberOut";
	}
	
	//관리자페이지 권한별 회원접속내역 조회 검색
	@GetMapping("/searchLevelLoginList")
	public String searchLevelLoginList(Model model
									  ,@RequestParam(value="levelName", required = false) String levelName) {
		log.info("권한별 로그인 접속내역 조회:{}", levelName);
		List <LoginHistory> searchLevelLoginList = adminMemberMapper.searchLevelLoginList(levelName);
		model.addAttribute("loginHistory", searchLevelLoginList);
		return "adminmember/loginHistory";
	}
	
	//관리자페이지 권한별 점주(일반/무인) 조회 검색
	@GetMapping("/searchLevelLaundryList")
	public String searchLevelLaundryList(Model model
										,@RequestParam(value="levelName", required = false) String levelName){
		log.info("권한별 점주 조회:{}", levelName);
		List<Laundry> searchLevelLaundryList = adminMemberService.searchLevelLaundryList(levelName);
		model.addAttribute("LaundryList", searchLevelLaundryList);
		return "adminmember/LaundryList";
	}
	
	//관리자페이지 권한별 회원(관리자/회원/일반/무인) 조회 검색
	@GetMapping("/searchLevelMemberList")
	public String searchLevelMemberList(Model model
										,@RequestParam(value="levelName", required = false) String levelName){
		log.info("권한별 회원 조회:{}", levelName);
		List<Member> searchLevelMemberList = adminMemberService.searchLevelMemberList(levelName);	
		model.addAttribute("adminMemberList", searchLevelMemberList);
		return "adminmember/adminMemberList";
	}
	
	//관리자페이지 회원관리 관리자/회원/점주 삭제 
	@PostMapping("/deleteMember")
	@ResponseBody
	public String deleteMember(@RequestBody Map <String, String> paramMap) throws JsonProcessingException {
		log.info("paramMap:{}", paramMap);
		
		String memberId  = paramMap.get("memberId");
		String levelCode = paramMap.get("levelCode");
		int result = adminMemberService.deleteMember(memberId, levelCode);
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(result);
	}

	//관리자페이지 세탁점주 상세정보 수정처리
	@PostMapping("/modifyLaundry")
	public String modifyLaundry(Laundry laundry) {		
		log.info("세탁점주 상세보기 수정정보:{}", laundry);			
		adminMemberService.modifyLaundry(laundry);			
		return "redirect:/admin/LaundryList";
	}
	
	//관리자페이지 세탁점주 상세정보 수정화면
	@GetMapping("/modifyLaundry")
	public String modifyLaundry(@RequestParam (name="laundryCode", required=false) String laundryCode
								,Model model) {
		log.info("화면에서 입력받은 data: {}", laundryCode);
		Laundry laundry = adminMemberService.getLaundryInfoByCode(laundryCode);		
		model.addAttribute("laundry", laundry);		
		return "adminmember/modifyLaundry";
	}
	
	//관리자페이지 회원관리 상세정보 수정처리
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {		
		log.info("회원 상세보기 수정정보:{}", member);			
		adminMemberService.modifyMember(member);			
		return "redirect:/admin/adminMemberList";
	}
	
	//관리자페이지 회원관리 상세정보 수정화면 
	@GetMapping("/modifyMember")
	public String modifyMember(@RequestParam (name="memberId", required=false) String memberId
							   ,Model model) {
		log.info("화면에서 입력받은 data: {}", memberId);
		Member member = adminMemberService.getMemberInfoById(memberId);		
		model.addAttribute("member", member);		
		return "adminmember/modifyMember";
	}
	
	//관리자페이지 세탁점주 상세정보 조회
	@GetMapping("/detailLaundry")
	public String getDetailLaundryInfo(Model model
									  ,@RequestParam(name="laundryCode", required = false) String laundryCode) {
		Laundry laundry = adminMemberService.getLaundryInfoByCode(laundryCode);
		log.info("세탁소 상세보기:{}", laundry);
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
		log.info("회원 상세보기:{}", member);		
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
	
	//관리자페이지 탈퇴 회원관리 삭제 
	@GetMapping("/adminRemove")
	public String adminRemove(@RequestParam (name = "memberId") String memberId
							 ,@RequestParam (name = "memberOutReason") String memberOutReason) {
		adminMemberService.adminRemove(memberId, memberOutReason);
		return "redirect:/admin/adminMemberOut";
	}
	
	//관리자페이지 탈퇴 회원관리 복구 (수정)
	@GetMapping("/adminReStore")
	public String adminReStore(Member member) {	
		log.info("동작!");
		adminMemberService.adminReStore(member);
		return "redirect:/admin/adminMemberOut";
	}
	
	//관리자페이지 회원탈퇴 화면
	@GetMapping("/adminMemberOut")
	public String adminMemberOut(Model model) {
		
		List<MemberOut> adminMemberOut = adminMemberService.getMemberOut();
		List<MemberOut> getMemberNotOut = adminMemberService.getMemberNotOut();
		
		log.info("회원탈퇴 :{}", adminMemberOut);		
		model.addAttribute("title", "회원탈퇴");
		model.addAttribute("adminMemberOut", adminMemberOut);
		model.addAttribute("getMemberNotOut", getMemberNotOut);
		
		return "adminmember/adminMemberOut";
	}
	

	//관리자페이지 등급관리 기준수정 처리
	 @PostMapping("/detailLevel") 
	 public String getModifyLevelInfo(MemberLevel memberlevel
			 						 ,UserLevel userLevel) {
		 log.info("등급관리 기준수정 수정 :{}", memberlevel);
		 memberlevel.setUserLevel(userLevel);
		 adminMemberService.getModifyLevelInfo(memberlevel);			
		 return "redirect:/admin/userLevel"; 
	 }
	 

	//관리자페이지 등급관리 기준수정 조회
	@GetMapping("/detailLevel")
	public String getDetailLevelInfo(Model model
									,@RequestParam(name="levelCode", required = false) String levelCode) {
		MemberLevel memberLevel = adminMemberService.getLevelInfoByCode(levelCode);
		log.info("등급관리 기준수정 조회:{}", memberLevel);
		System.out.println(memberLevel +  "________________");
		model.addAttribute("memberLevel", memberLevel);
		
		return "adminmember/detailLevel";
	}
	
	//관리자페이지 등급관리 화면
	@GetMapping("/userLevel")
	public String userLevel(Model model) {
		log.info("회원등급 목록 요청");		
		model.addAttribute("title", "회원등급 목록");
		
		List<UserLevel> getUserLevelList = adminMemberService.getUserLevelList();
		
		model.addAttribute("getUserLevelList", getUserLevelList);
		System.out.println(getUserLevelList+"<---------------getUserLevelList 리스트값");
		
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
		System.out.println(member);
		
		adminMemberService.addMemberAdmin(member);	
		log.info("회원가입폼에서 입력받은 데이터:{}", member);
		
		return "redirect:/admin";
	}	
	
	//관리자페이지 관리자 회원가입(등록)
	@GetMapping("/addMemberAdmin")
	public String addMemberAdmin(Model model	
								,@RequestParam(name="levelCode", required=false) String levelCode){
		model.addAttribute("title", "관리자페이지 관리자 등록");
		model.addAttribute("levelCode", levelCode);
		
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
