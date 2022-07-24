package ks43team04.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Laundry;
import ks43team04.dto.Member;
import ks43team04.dto.MemberOut;
import ks43team04.mapper.AdminMemberMapper;
import ks43team04.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	private final MemberMapper memberMapper;
	private final AdminMemberMapper adminMemberMapper;

	public MemberService(MemberMapper memberMapper, AdminMemberMapper adminMemberMapper) {
		this.memberMapper = memberMapper;
		this.adminMemberMapper = adminMemberMapper;
	}
	
	//탈퇴 대기 회원조회
	public MemberOut getMemberOutInfoById(String memberId) {
		MemberOut memberout = memberMapper.getMemberOutInfoById(memberId);
		return memberout;
	}


	//탈퇴 자동승인 회원(고객) 탈퇴 
	public int removeMember(Member member, String memberOutReason) {
		String memberId = member.getMemberId();
		
		memberMapper.getMemberInfoById(memberId);
		memberMapper.memberOut(memberId);
		
		int removeMember = memberMapper.removeMember(memberId, memberOutReason);
		
		return removeMember;
	}
	
	//탈퇴 미승인 대기회원(일반점주, 무인점주) 탈퇴 
	public int removeLaundry(Member member, String memberOutReason) {
		String memberId = member.getMemberId();
		
		memberMapper.getMemberInfoById(memberId);
		
		int removeLaundry = memberMapper.removeLaundry(memberId, memberOutReason);
		
		return removeLaundry;
	}	
	
	//고객, 일반점주, 무인점주 마이페이지 수정 처리
	public int modifyUser(Map<String, Object> paramMap) {
		System.out.println(paramMap);	
		int result = 0;
		if(paramMap.get("laundry") == null) {
			result = adminMemberMapper.modifyMember((Member)paramMap.get("member"));
		} else {
			result = memberMapper.modifyUser(paramMap);
		}
		return result;
	}
	
	//고객, 일반점주, 무인점주 마이페이지 수정 조회
	public Member getUserInfoById(String memberId) {
		return memberMapper.getUserInfoById(memberId);
	}
	
	//일반, 무인 점주 회원가입
	public int addMemberLaundry(Laundry laundry) {		
		int addMemberLaundry = memberMapper.addMemberLaundry(laundry);		
		return addMemberLaundry;	
	}
		
	//회원 상세정보 조회
	public Member getMemberInfoById(String memberId) {
		return memberMapper.getMemberInfoById(memberId);
	}
	
	//고객, 관리자(메인화면) 회원가입 
	public int addMember(Member member) {		
		int addMember = memberMapper.addMember(member);	
		return addMember;	
	}

	//점주 상세정보 조회
	public Member getStoreOwnerInfoById(String memberId) {
		Member laundryOwner = memberMapper.getStoreOwnerInfoById(memberId);
		return laundryOwner;
	}


}
