package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Bill;
import ks43team04.dto.Bill2;

@Mapper
public interface BillMapper {
	
	
	public List<Bill> getBillList();
	
	/* 마이페이지 > 결제건수 조회 row 수*/
	public int getBillCount(String memberId);
	
	/* 세탁소별 월별 매출 */
	public List<Bill> laundryIncome();
	
	/* 일반세탁소 오더 목록 */
	public List<Bill> ilbanOrderList(String memberId);
	
	public int addBill(String memberId, String laundryCode, String totalPrice);
	
	/*예약 -> 결제 -> 인서트작업*/
	public int addBill2(Bill2 bill);
	
	/*예약 -> 결제 -> 결제건수 조회*/
	public int getBillCount2(String memberId);
	
	/*예약 -> 결제 -> 페이징처리*/
	public List<Map<String, Object>> billPage(Map<String, Object> paramMap);
}
