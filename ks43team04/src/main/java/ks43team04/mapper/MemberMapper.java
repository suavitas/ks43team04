package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Laundry;
import ks43team04.dto.Member;

@Mapper
public interface MemberMapper {

	// 마이페이지 무인,일반 점주 사업장정보 조회
	public Laundry getLaundryInfo(String memberId);

	// 무인, 일반 점주 회원가입
	public int addMemberLaundry(Laundry Laundry);

	// 회원 아이디별 정보조회
	public Member getMemberInfoById(String memberId);

	// 고객 회원가입
	public int addMember(Member member);

	// 아이디 중복 체크
	public boolean isIdCheck(String memberId);

	/* 로그인 이력테이블 총 row(튜플) 수 */
	public int getLoginHistoryCount();

	/* 로그인 이력 조회 (페이징) */
	public List<Map<String, Object>> getLoginHistory(Map<String, Object> paramMap);

}
