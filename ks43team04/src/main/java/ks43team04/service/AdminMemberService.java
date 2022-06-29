package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Laundry;
import ks43team04.dto.LoginHistory;
import ks43team04.dto.Member;
import ks43team04.dto.MemberOut;
import ks43team04.dto.UserLevel;
import ks43team04.mapper.AdminMemberMapper;


@Service
@Transactional
public class AdminMemberService {
	
	private final AdminMemberMapper adminMemberMapper;
	
	public AdminMemberService(AdminMemberMapper adminMemberMapper) {
		this.adminMemberMapper = adminMemberMapper;
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
	
	//관리자페이지 회원탈퇴 조회
	public List<MemberOut> getMemberOut(){
		List<MemberOut> adminMemberOut = adminMemberMapper.getMemberOut();	
		return adminMemberOut;
	}
	//관리자페이지 회원 기준 및 혜택 정보 조회
	public List<UserLevel> getUserLevel(){	
		List<UserLevel> userLevel = adminMemberMapper.getUserLevel();		
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
