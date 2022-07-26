package ks43team04.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Laundry;
import ks43team04.dto.LoginHistory;
import ks43team04.dto.Member;
import ks43team04.dto.MemberLevel;
import ks43team04.dto.MemberOut;
import ks43team04.dto.UserLevel;
import ks43team04.mapper.AdminMemberMapper;
import ks43team04.mapper.MemberMapper;


@Service
@Transactional
public class AdminMemberService {
	
	private final AdminMemberMapper adminMemberMapper;
	private final MemberMapper memberMapper;
	
	public AdminMemberService(AdminMemberMapper adminMemberMapper, MemberMapper memberMapper) {
		this.adminMemberMapper = adminMemberMapper;
		this.memberMapper = memberMapper;
	}
	
	//관리자페이지 탈퇴 대기사유 작성 전달 
	public int getMemberOutMemo(MemberOut memberout) {
		int result = adminMemberMapper.memberOutWaitMemo(memberout);
		return result;
	}

	
	//관리자페이지 등급관리 삭제
	public int removeUserlevel(Map<String, String> levelCode){
		adminMemberMapper.removeUserlevel(levelCode);
		int result = adminMemberMapper.removeUserlevel2(levelCode);
		return result;
	}
	
	//관리자페이지 등급기준 추가 
	public int addUserLevel(MemberLevel memberlevel, UserLevel userlevel){
		adminMemberMapper.addUserLevel1(memberlevel);
		userlevel.setLevelCode(memberlevel.getLevelCode());
		int addUserLevel2 = adminMemberMapper.addUserLevel2(userlevel);
		return addUserLevel2;
	}
	
	//관리자페이지 가입날짜별 탈퇴회원 조회 검색 (대기)
	public List<MemberOut> searchDateOutList2(String startDate, String endDate){
		List<MemberOut> searchDateOutList2 = adminMemberMapper.searchDateOutList2(startDate, endDate);
		return searchDateOutList2;
	}
	
	//관리자페이지 모든검색조건별 탈퇴회원 조회 검색 (대기)
	public List<MemberOut> allSearchOutList2(String startDate, String endDate, String searchKey, String searchValue){
		List<MemberOut> allSearchOutList2 = adminMemberMapper.allSearchOutList2(searchKey, searchValue);
		return allSearchOutList2;
	}
	
	//관리자페이지 가입날짜별 탈퇴목록 조회 (완료)
	public List<MemberOut> searchDateOutList(String startDate, String endDate){
		List<MemberOut> searchDateOutList = adminMemberMapper.searchDateOutList(startDate, endDate);
		return searchDateOutList;
	}
	
	//관리자페이지 모든검색조건별(버튼) 탈퇴목록 조회 (완료)
	public List<MemberOut> allSearchOutList(String startDate, String endDate, String searchKey, String searchValue){
		List<MemberOut> allSearchOutList = adminMemberMapper.allSearchOutList(searchKey, searchValue);
		return allSearchOutList;
	}
	
	//관리자페이지 가입날짜별 로그인목록 조회
	public List<LoginHistory> searchDateLoginList(String startDate, String endDate){
		List<LoginHistory> searchDateLoginList = adminMemberMapper.searchDateLoginList(startDate, endDate);
		return searchDateLoginList;
	}
	
	//관리자페이지 모든검색조건별(버튼) 로그인목록 조회
	public List<LoginHistory> allSearchLoginList(String startDate, String endDate, String searchKey, String searchValue){
		List<LoginHistory> allSearchLoginList = adminMemberMapper.allSearchLoginList(searchKey, searchValue);
		return allSearchLoginList;
	}
	
	//관리자페이지 가입날짜별 세탁소목록 조회
	public List<Laundry> searchDateLaundryList(String startDate, String endDate){
		List<Laundry> searchDateLaundryList = adminMemberMapper.searchDateLaundryList(startDate, endDate);
		return searchDateLaundryList;
	}
	
	//관리자페이지 모든검색조건별(버튼) 세탁소목록 조회
	public List<Laundry> allSearchLaundryList(String startDate, String endDate, String searchKey, String searchValue){
		List<Laundry> allSearchLaundryList = adminMemberMapper.allSearchLaundryList(searchKey, searchValue);
		return allSearchLaundryList;
	}
	
	//관리자페이지 가입날짜별 회원목록 조회
	public List<Member> searchDateMemberList(String startDate, String endDate){
		List<Member> searchDateMemberList = adminMemberMapper.searchDateMemberList(startDate, endDate);
		return searchDateMemberList;
	}
	
	//관리자페이지 모든검색조건별(버튼) 회원 목록 조회
	public List<Member> allSearchMemberList(String startDate, String endDate, String searchKey, String searchValue){
		List<Member> allSearchMemberList = adminMemberMapper.allSearchMemberList(searchKey, searchValue);
		return allSearchMemberList;
	}
	
	
	//관리자페이지 검색조건별(셀렉박스) 세탁소 목록 조회
	public List<Laundry> conditionLaundryList(String searchKey, String searchValue){
		List<Laundry> conditionLaundryList = adminMemberMapper.conditionLaundryList(searchKey, searchValue);	
		return conditionLaundryList;
	}
	
	//관리자페이지 검색조건별(셀렉박스) 회원 목록 조회
	public List<Member> conditionMemberList(String searchKey, String searchValue){
		List<Member> conditionMemberList = adminMemberMapper.conditionMemberList(searchKey, searchValue);	
		return conditionMemberList;
	}
	
	//관리자페이지 권한별 탈퇴회원 조회 검색 (대기)
	public List<MemberOut> searchLevelMemberOutList2(String levelName) {
		List<MemberOut> searchLevelMemberOutList2 = adminMemberMapper.searchLevelMemberOutList2(levelName);
		return searchLevelMemberOutList2;
	}
	
	//관리자페이지 권한별 탈퇴회원 조회 검색 (완료)
	public List<MemberOut> searchLevelMemberOutList(String levelName) {
		List<MemberOut> searchLevelMemberOutList = adminMemberMapper.searchLevelMemberOutList(levelName);
		return searchLevelMemberOutList;
	}
	
	//관리자페이지 권한별 회원접속내역 조회 검색
	public List<LoginHistory> searchLevelLoginList(String levelName) {
		List<LoginHistory> searchLevelLoginList = adminMemberMapper.searchLevelLoginList(levelName);
		return searchLevelLoginList;
	}
	
	//관리자페이지 권한별 점주(일반/무인) 조회 검색
	public List<Laundry> searchLevelLaundryList(String levelName) {
		List<Laundry> searchLevelLaundryList = adminMemberMapper.searchLevelLaundryList(levelName);
		return searchLevelLaundryList;
	}

	//관리자페이지 권한별 회원(관리자/회원/일반/무인) 조회 검색
	public List<Member> searchLevelMemberList (String levelName) {
		List<Member> searchLevelMemberList = adminMemberMapper.searchLevelMemberList(levelName);
		return searchLevelMemberList;
	}
	
	//관리자페이지 전체회원목록 회원 삭제
	public int deleteMember(String memberId, String levelCode) {
		
		 if("level_code_04".equals(levelCode) || "level_code_05".equals(levelCode) || "level_code_06".equals(levelCode) || "level_code_07".equals(levelCode) || "level_code_08".equals(levelCode)) {
			 adminMemberMapper.deleteMember(memberId);
		 }else if("level_code_02".equals(levelCode) || "level_code_03".equals(levelCode)) {
			 adminMemberMapper.deleteLaundry(memberId);
		 }
		 
		adminMemberMapper.deleteMember(memberId);
		int deleteMember = adminMemberMapper.deleteMember(memberId);
		return deleteMember;
	}
	
	//관리자페이지 탈퇴 복구
	public int adminReStore(Member member) {
		System.out.println(member);			
		adminMemberMapper.memberOutRemove(member.getMemberId());	//탈퇴테이블에서 지움 
		
		return adminMemberMapper.adminReStore(member);
	}
	
	//관리자페이지 탈퇴 삭제
	public int adminRemove(String memberId, String memberOutReason) {
		System.out.println(memberId);			
		adminMemberMapper.memberOutRemove(memberId);	//탈퇴테이블에서 지움 
		int removeMember = memberMapper.removeMember(memberId, memberOutReason);
		memberMapper.memberOut(memberId);
		
		return removeMember;
	}
	
	//관리자페이지 등급관리 기준수정 수정 
	public int getModifyLevelInfo(MemberLevel memberlevel) {
	  System.out.println(memberlevel); 
	  return adminMemberMapper.getModifyLevelInfo(memberlevel); 
	}	 
	
	//관리자페이지 등급관리 기준수정 조회
	public MemberLevel getLevelInfoByCode(String levelCode) {
		return adminMemberMapper.getLevelInfoByCode(levelCode);
	}	

	//관리자페이지 세탁소점주 상세정보 수정
	public int modifyLaundry(Laundry laundry) {
		System.out.println(laundry);		
		return adminMemberMapper.modifyLaundry(laundry);
	}

	//관리자페이지 회원 상세정보 수정
	public int modifyMember(Member member) {		
		System.out.println(member);		
		return adminMemberMapper.modifyMember(member);
	}
	
	//관리자페이지 세탁소점주 상세정보 조회
	public Laundry getLaundryInfoByCode(String laundryCode) {
		return adminMemberMapper.getLaundryInfoByCode(laundryCode);
	}
	
	//관리자페이지 로그인 회원접속내역 조회
	public List<LoginHistory> getLoginHistory(){
		List<LoginHistory> loginHistory = adminMemberMapper.getLoginHistory();	
		return loginHistory;
	}
	
	//관리자페이지 회원탈퇴 대기 조회
	public List<MemberOut> getMemberNotOut(){
		List<MemberOut> getMemberNotOut = adminMemberMapper.getMemberNotOut();	
		return getMemberNotOut;
	}
	
	//관리자페이지 회원탈퇴 조회
	public List<MemberOut> getMemberOut(){
		List<MemberOut> adminMemberOut = adminMemberMapper.getMemberOut();	
		return adminMemberOut;
	}
	
	//관리자페이지 등급관리 조회
	public List<UserLevel> getUserLevelList() {
		List<UserLevel> userLevel = adminMemberMapper.getUserLevelList();
		return userLevel;
	}
	
	//관리자페이지 세탁소점주 정보조회
	public List<Laundry> getLaundryList() {		
		   List<Laundry> LaundryList = adminMemberMapper.getLaundryList();		
		return LaundryList;
	}
	
	//관리자페이지 회원 상세정보 조회
	public Member getMemberInfoById(String memberId) {
		return adminMemberMapper.getMemberInfoById(memberId);
	}
	
	//관리자페이지 관리자 권한 회원가입
	public int addMemberAdmin(Member member) {		
		int addMemberAdmin = adminMemberMapper.addMemberAdmin(member);		
		return addMemberAdmin;	
	}
	
	//관리자페이지 전체회원 목록 조회
	public List<Member> getAdminMemberList() {		
		   List<Member> adminMemberList = adminMemberMapper.getAdminMemberList();
		return adminMemberList;
	}



	
}
