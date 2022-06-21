package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.IlbanSkill;
import ks43team04.dto.Laundry;
import ks43team04.dto.Member;
import ks43team04.dto.MuinMachine;
import ks43team04.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	private final MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	/*
	 *세탁소 상세정보 조회 public Laundry getLaundryInfo(String memberId) { return
	 * memberMapper.getLaundryInfo(memberId); }
	 */
	
	//회원 상세정보 조회
	public Member getMemberInfoById(String memberId) {
		return memberMapper.getMemberInfoById(memberId);
	}
	
	//관리자 권한 회원가입
	public int addMember(Member member) {		
		member.setLevelCode("level_code_01");	
		int addMember = memberMapper.addMember(member);
		
		return addMember;	
	}
	
	/**
	 * 전체 회원 리스트 조회
	 * @return memberList 
	 */
	public List<Member> getMemberList(){
		List<Member> memberList = memberMapper.memberList();		
		return memberList;
	}
	
	
}
