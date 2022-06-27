package ks43team04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.mapper.BillMapper;
import ks43team04.mapper.UserMapper;

@Service
@Transactional
public class UserService {
	
	private UserMapper userMapper;
	private BillMapper billMapper;
	
	public UserService(UserMapper userMapper,BillMapper billMapper) {
		this.userMapper = userMapper;
		this.billMapper = billMapper;
	}
	
	/* 리스트 페이징처리 */
	public Map<String, Object> getPaymentList(int currentPage,HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		String memberId = sessionId;
		
		// 페이지 내 몇개를 보여줄까?
		int rowPerPage = 4;
		int startPageNum = 1;
		int endPageNum = 5;

		// 총 행의 갯수
		double rowCount = billMapper.getBillCount(memberId);

		// 마지막 페이지
		int lastPage = (int) Math.ceil(rowCount / rowPerPage);

		// 페이징 처리
		int startRow = (currentPage - 1) * rowPerPage; // 절대 바뀌지않는다!

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("memberId", memberId);

		List<Map<String, Object>> getPaymentList = userMapper.getPaymentList(paramMap);

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
		resultMap.put("getPaymentList", getPaymentList);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);

		return resultMap;
	}
	
	
}
