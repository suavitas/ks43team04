package ks43team04.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Member;
import ks43team04.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	private final MemberMapper memberMapper;

	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	/*
	 * 세탁소 상세정보 조회 public Laundry getLaundryInfo(String memberId) { return
	 * memberMapper.getLaundryInfo(memberId); }
	 */

	// 회원 상세정보 조회
	public Member getMemberInfoById(String memberId) {
		return memberMapper.getMemberInfoById(memberId);
	}

	// 고객, 관리자 회원가입
	public int addMember(Member member) {
		int addMember = memberMapper.addMember(member);

		return addMember;
	}

}
