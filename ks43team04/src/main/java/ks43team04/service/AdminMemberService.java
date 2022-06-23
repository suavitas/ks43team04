package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Member;
import ks43team04.mapper.AdminMemberMapper;

@Service
@Transactional
public class AdminMemberService {

	private final AdminMemberMapper adminMemberMapper;

	public AdminMemberService(AdminMemberMapper adminMemberMapper) {
		this.adminMemberMapper = adminMemberMapper;
	}

	// 관리자페이지 회원 상세정보 조회
	public Member getMemberInfoById(String memberId) {
		return adminMemberMapper.getMemberInfoById(memberId);
	}

	// 관리자페이지 관리자 권한 회원가입
	public int addMemberAdmin(Member member) {
		int addMemberAdmin = adminMemberMapper.addMemberAdmin(member);

		return addMemberAdmin;
	}

	// 관리자페이지 전체 회원 목록 조회
	public List<Member> getAdminMemberList() {
		List<Member> adminMemberList = adminMemberMapper.getAdminMemberList();
		return adminMemberList;
	}
}
