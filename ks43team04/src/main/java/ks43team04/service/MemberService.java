package ks43team04.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Laundry;
import ks43team04.dto.Member;
import ks43team04.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	private final MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
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


	public Member getStoreOwnerInfoById(String memberId) {
		Member laundryOwner = memberMapper.getStoreOwnerInfoById(memberId);
		return laundryOwner;
	}		
	
}
