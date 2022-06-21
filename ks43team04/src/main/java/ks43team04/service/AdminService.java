package ks43team04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ks43team04.dto.LaundryList;
import ks43team04.dto.Member;
import ks43team04.dto.MuinMachienSpec;
import ks43team04.dto.YearlyHoliday;
import ks43team04.mapper.HolidayMapper;
import ks43team04.mapper.LaundryMapper;
import ks43team04.mapper.MemberMapper;


@Service
public class AdminService {

	private final MemberMapper memberMapper;
	private final LaundryMapper laundryMapper;
	private final HolidayMapper holidayMapper;
	
	public AdminService(MemberMapper memberMapper,LaundryMapper laundryMapper, HolidayMapper holidayMapper) {
		
		this.memberMapper = memberMapper;
		this.laundryMapper = laundryMapper;
		this.holidayMapper = holidayMapper;
	}
	


	
	
	
	 public Map<String, Object> getLoginHistory(int currentPage){
		   
		   //페이지 내 몇개를 보여줄까? (5) 행 노출
		   int rowPerPage = 5; 
		   int startPageNum = 1;
		   int endPageNum = 10;
		   
		   //총 행의 갯수
		   double rowCount =  memberMapper.getLoginHistoryCount();
		   
		   //마지막 페이지
		   int lastPage = (int) Math.ceil(rowCount/rowPerPage);
		   
		   //페이징 처리
		   int startRow = (currentPage-1) * rowPerPage; //절대 바뀌지않는다!
		   
		   Map<String, Object> paramMap = new HashMap<String, Object>();
		   paramMap.put("startRow", startRow);
		   paramMap.put("rowPerPage", rowPerPage);
		   
		  List<Map<String, Object>> loginHistoryList = memberMapper.getLoginHistory(paramMap);
		  
		  //동적 페이지번호
		  if(currentPage > 6) {
			  startPageNum = currentPage - 5;
			  endPageNum = currentPage + 4; //자신 포함  / last-21페이지 픽스. 21-4 = 17부터는 움직이지않겠다. 17커런트로왔을때 
			  
			  if(endPageNum >= lastPage) { //17이상부터 클릭시 숫자가 늘어나지않고 고정되는 모습
				  startPageNum = lastPage - 9; //라스트페이지해당 21-9 = 12부터 고정시키겠다. 
				  endPageNum = lastPage; 
			  } 
		  }
		  
		  Map<String, Object> resultMap = new HashMap<String, Object>();
		  resultMap.put("lastPage", lastPage);
		  resultMap.put("loginHistoryList", loginHistoryList);	  
		  resultMap.put("startPageNum", startPageNum);	  
		  resultMap.put("endPageNum", endPageNum);	  
		   
		  return resultMap;
	 }
		

		
	 
}