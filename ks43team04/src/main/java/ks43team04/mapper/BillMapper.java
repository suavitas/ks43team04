package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Bill;

@Mapper
public interface BillMapper {
	
	
	public List<Bill> getBillList();
	
	/* 마이페이지 > 결제건수 조회 row 수*/
	public int getBillCount(String memberId);
	
	/* 세탁소별 월별 매출 */
	public List<Bill> laundryIncome();
	
	/* 일반세탁소 오더 목록 */
	public List<Bill> ilbanOrderList(String memberId);
}
