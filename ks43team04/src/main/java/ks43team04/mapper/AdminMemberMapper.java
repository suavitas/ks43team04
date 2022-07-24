package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Laundry;
import ks43team04.dto.LoginHistory;
import ks43team04.dto.Member;
import ks43team04.dto.MemberLevel;
import ks43team04.dto.MemberOut;
import ks43team04.dto.UserLevel;

@Mapper
public interface AdminMemberMapper {
	
	//관리자페이지 등급관리 삭제 (2)
	public int removeUserlevel2(Map<String, String> levelCode);
	
	//관리자페이지 등급관리 삭제 (1)
	public int removeUserlevel(Map<String, String> levelCode);
	
	//관리자페이지 등급기준 추가  (2)
	public int addUserLevel2(UserLevel userlevel);
	
	//관리자페이지 등급기준 추가  (1)
	public int addUserLevel1(MemberLevel memberlevel);
	
	//관리자페이지 가입날짜별 탈퇴목록 조회 -대기
	public List<MemberOut> searchDateOutList2(String startDate, String endDate);
	
	//관리자페이지 모든검색조건별(버튼) 탈퇴목록 조회 -대기
	public List<MemberOut> allSearchOutList2(String startDate, String endDate);
	
	//관리자페이지 가입날짜별 탈퇴목록 조회
	public List<MemberOut> searchDateOutList(String startDate, String endDate);
	
	//관리자페이지 모든검색조건별(버튼) 탈퇴목록 조회
	public List<MemberOut> allSearchOutList(String startDate, String endDate);
	
	//관리자페이지 가입날짜별 로그인목록 조회
	public List<LoginHistory> searchDateLoginList(String startDate, String endDate);
	
	//관리자페이지 모든검색조건별(버튼) 로그인목록 조회
	public List<LoginHistory> allSearchLoginList(String searchKey, String searchValue);
	
	//관리자페이지 가입날짜별 세탁소목록 조회
	public List<Laundry> searchDateLaundryList(String startDate, String endDate);
	
	//관리자페이지 모든검색조건별(버튼) 세탁소목록 조회
	public List<Laundry> allSearchLaundryList(String searchKey, String searchValue);
	
	//관리자페이지 가입날짜별 회원목록 조회
	public List<Member> searchDateMemberList(String startDate, String endDate);
	
	//관리자페이지 모든검색조건별(버튼) 회원 목록 조회
	public List<Member> allSearchMemberList(String searchKey, String searchValue);
	
	//관리자페이지 검색조건별 세탁소 목록 조회
	public List<Laundry> conditionLaundryList(String searchKey, String searchValue);
	
	//관리자페이지 검색조건별 회원 목록 조회
	public List<Member> conditionMemberList(String searchKey, String searchValue);
	
	//관리자페이지 권한별 탈퇴회원 조회 검색 (완료)
	public List<MemberOut> searchLevelMemberOutList2(String levelName);
	
	//관리자페이지 권한별 탈퇴회원 조회 검색 (대기)
	public List<MemberOut> searchLevelMemberOutList(String levelName);
	
	//관리자페이지 권한별 회원접속내역 조회 검색
	public List<LoginHistory> searchLevelLoginList(String levelName);
	
	//관리자페이지 권한별 세탁소 리스트 (일반/무인) 조회 검색
	public List<Laundry> searchLevelLaundryList(String levelName);
	
	//관리자페이지 권한별 회원 리스트 (관리자/회원/일반/무인) 조회 검색 
	public List<Member> searchLevelMemberList(String levelName);
	
	//관리자페이지 전체회원관리 점주 삭제 
	public int deleteLaundry(String memberId);
	
	//관리자페이지 전체회원관리 회원 삭제 
	public int deleteMember(String memberId);
	
	//관리자페이지 탈퇴 회원관리 삭제 
	public int memberOutRemove(String memberId);
	
	//관리자페이지 탈퇴 회원관리 복구 (수정)
	public int adminReStore(Member member);
	
	//관리자페이지 등급관리 기준수정 수정
	public int getModifyLevelInfo(MemberLevel memberlevel); 
	
	//관리자페이지 등급관리 기준수정 조회
	public MemberLevel getLevelInfoByCode(String levelCode);	
	
	//관리자페이지 세탁소점주 상세정보 수정
	public int modifyLaundry(Laundry laundry);
	
	//관리자페이지  회원상세정보 수정
	public int modifyMember(Member member);
	 
	//관리자페이지 세탁소점주 상세정보 조회
	public Laundry getLaundryInfoByCode(String laundryCode);

	//관리자페이지  로그인 회원접속내역 조회
	public List<LoginHistory> getLoginHistory();
	
	//관리자페이지 회원탈퇴 미승인 조회
	public List<MemberOut> getMemberNotOut();
	
	//관리자페이지 회원탈퇴 승인 조회
	public List<MemberOut> getMemberOut();
	
	//관리자페이지 등급관리 조회
	public List<UserLevel> getUserLevelList();
	
	//관리자페이지 회원상세정보 조회
	public Member getMemberInfoById(String memberId);

	//관리자페이지 관리자등록 (회원가입)
	public int addMemberAdmin(Member member);
	
	//관리자페이지 관리자 아이디중복체크 
	public boolean isIdCheck(String memberId);
	
	//관리자페이지 세탁소 전체목록 조회
	public List<Laundry> getLaundryList();
	
	//관리자페이지 전체 회원 목록 조회
	public List<Member> getAdminMemberList();
	
	
	
	
	
	
	
	
	
	
	/* 로그인 이력테이블 총 row(튜플) 수 */
	public int getLoginHistoryCount();
	
	/* 로그인 이력 조회 (페이징) */
	public List<Map<String, Object>> getLoginHistory(Map<String, Object> paramMap);






}
