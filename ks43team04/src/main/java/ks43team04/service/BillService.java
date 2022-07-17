package ks43team04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Bill;
import ks43team04.dto.Bill2;
import ks43team04.mapper.BillMapper;

@Service
@Transactional
public class BillService {

	private final BillMapper billMapper;

	public BillService(BillMapper billMapper) {
		this.billMapper = billMapper;
	}
	
	/* 리스트 페이징처리 */
	public Map<String, Object> billPage(int currentPage,HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		String memberId = sessionId;
		
		// 페이지 내 몇개를 보여줄까?
		int rowPerPage = 4;
		int startPageNum = 1;
		int endPageNum = 5;

		// 총 행의 갯수
		double rowCount = billMapper.getBillCount2(memberId);

		// 마지막 페이지
		int lastPage = (int) Math.ceil(rowCount / rowPerPage);

		// 페이징 처리
		int startRow = (currentPage - 1) * rowPerPage; // 절대 바뀌지않는다!

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("memberId", memberId);

		List<Map<String, Object>> billPage = billMapper.billPage(paramMap);

		// 동적 페이지번호
		if (currentPage > 6) {
			startPageNum = currentPage - 5;
			endPageNum = currentPage + 4; // 자신 포함 / last-21페이지 픽스. 21-4 = 17부터는 움직이지않겠다. 17커런트로왔을때

			if (endPageNum >= lastPage) { // 17이상부터 클릭시 숫자가 늘어나지않고 고정되는 모습
				startPageNum = lastPage - 9; // 라스트페이지해당 21-9 = 12부터 고정시키겠다.
				endPageNum = lastPage;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lastPage", lastPage);
		resultMap.put("billPage", billPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);

		return resultMap;
	}
	
	
	/*예약 -> 결제 -> 결제건수 조회*/
	public int getBillCount2(String memberId) {
		int rowCount = billMapper.getBillCount2(memberId);
		return rowCount;
	}
	
	/*예약 -> 결제 -> 인서트작업*/
	public int addBill2(Bill2 bill) {
		int result = billMapper.addBill2(bill);
		return result;
	}
	
	public int addBill(String memberId, String laundryCode, String totalPrice) {
		
		int addBill = billMapper.addBill(memberId, laundryCode, totalPrice);
		
		return addBill;
	}
	
	public List<Bill> getBillList() {

		List<Bill> BillList = billMapper.getBillList();

		return BillList;

	}
	
	public int getBillCount(String memberId){
		int getBillCount = billMapper.getBillCount(memberId);
		return getBillCount;
	}
	
	public Map<String, Object> eachLaundryIncome(int currentPage){
		
		int rowPerPage = 10;
		int startPageNum = 1;
		int endPageNum = 5;
		
		double rowCount = billMapper.laundryIncomeLookUpCount();
		int lastPage = (int) Math.ceil(rowCount / rowPerPage);
		int startRow = (currentPage - 1) * rowPerPage;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		List<Map<String, Object>> laundryByIncome = billMapper.eachLaundryIncome(paramMap);
		if (currentPage > 6) {
			startPageNum = currentPage - 5;
			endPageNum = currentPage + 4; // 자신 포함 / last-21페이지 픽스. 21-4 = 17부터는 움직이지않겠다. 17커런트로왔을때

			if (endPageNum >= lastPage) { // 17이상부터 클릭시 숫자가 늘어나지않고 고정되는 모습
				startPageNum = lastPage - 9; // 라스트페이지해당 21-9 = 12부터 고정시키겠다.
				endPageNum = lastPage;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lastPage", lastPage);
		resultMap.put("laundryByIncome", laundryByIncome);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);
		
		return resultMap;
	}
}
