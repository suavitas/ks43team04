package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.As;

@Mapper
public interface AsMapper {

	//AS 삭제
	public int asDel(As as);
	
	//AS 수정
	public int asModify(As as);
	
	//AS 방문(예정)일 변경
	public int asVisitChange(As as);
	
	//AS 완료(상태변경)
	public int asEnd(As as);
	
	//AS 접수(상태변경)
	public int asReceipt(As as);
	
	//AS 작성
	public int asForm(As as);
	
	//AS 상세 조회
	public As getAsDetail(String asCode);
	
	//회원별 AS 목록
	public List<As> asListById(String memberId);
	
	//AS 목록 
	public List<As> getAsList();
	public List<As> readyAsList();
	public List<As> startAsList();
	public List<As> endAsList();
}
