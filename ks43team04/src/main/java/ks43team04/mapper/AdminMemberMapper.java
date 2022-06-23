package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Member;

@Mapper
public interface AdminMemberMapper {

	// 관리자페이지 회원상세정보 조회
	public Member getMemberInfoById(String memberId);

	// 관리자페이지 관리자등록 (회원가입)
	public int addMemberAdmin(Member member);

	// 관리자페이지 관리자 아이디중복체크
	public boolean isIdCheck(String memberId);

	// 관리자페이지 전체 회원 목록 조회
	public List<Member> getAdminMemberList();

	/* 로그인 이력테이블 총 row(튜플) 수 */
	public int getLoginHistoryCount();

	/* 로그인 이력 조회 (페이징) */
	public List<Map<String, Object>> getLoginHistory(Map<String, Object> paramMap);

}
