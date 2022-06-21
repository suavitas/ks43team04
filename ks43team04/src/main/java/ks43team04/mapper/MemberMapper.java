package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Member;

@Mapper
public interface MemberMapper {
	
	/*
	 * //마이페이지 세탁소 조회 public Laundry getLaundryInfo(String memberId);
	 */
	
	//회원 상세정보 조회
	public Member getMemberInfoById(String memberId);

	//회원가입
	public int addMember(Member member);
	
	//모든 회원 아이디 중복 체크
	public boolean isIdCheck(String memberId);
	
	
	/* 로그인 이력테이블 총 row(튜플) 수 */
	public int getLoginHistoryCount();
	
	/* 로그인 이력 조회 (페이징) */
	public List<Map<String, Object>> getLoginHistory(Map<String, Object> paramMap);
	
	/**
	 * 전체 회원 조회
	 */
	public List<Member> memberList();
}
