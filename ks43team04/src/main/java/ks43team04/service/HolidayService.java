package ks43team04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.HolidayList;
import ks43team04.dto.LaundryList;
import ks43team04.dto.YearlyHoliday;
import ks43team04.mapper.HolidayMapper;
import ks43team04.mapper.LaundryListMapper;

@Service
public class HolidayService {

	private final HolidayMapper holidayMapper;
	private final LaundryListMapper laundryListMapper;

	public HolidayService(HolidayMapper holidayMapper, LaundryListMapper laundryListMapper) {
		this.holidayMapper = holidayMapper;
		this.laundryListMapper = laundryListMapper;
	}

	
	  public int addYearlyHoliday(YearlyHoliday yearlyHoliday) { int
		  addYearlyHoliday = holidayMapper.addYearlyHoliday(yearlyHoliday); 
	  return addYearlyHoliday; 
	  }
	 
	
	
	public int allModifyHolyday(String yearlyHolidayCode,String holidayCodeUse) {
		int allModifyHolyday = holidayMapper.allModifyHolyday(yearlyHolidayCode,holidayCodeUse);
		return allModifyHolyday;
	}
	
	public List<YearlyHoliday> yearlyHolidayList() {

		List<YearlyHoliday> yearlyHolidayList = holidayMapper.yearlyHolidayList();

		return yearlyHolidayList;
	}
	public List<YearlyHoliday> yearlyHolidayList(Map<String, String> scheduleDate) {
		
		List<YearlyHoliday> yearlyHolidayList = holidayMapper.yearlyHolidayListByDate(scheduleDate);
		
		return yearlyHolidayList;
	}


	/* 세탁소별 휴일 정보 넘기는 메서드 */
	public HolidayList getHolidayByHolidayCode(String holidayCode) {
		
			HolidayList getHolidayByHolidayCode = holidayMapper.getHolidayByHolidayCode(holidayCode);
			return getHolidayByHolidayCode;
	}

	/* 세탁소별 휴일 수정 */
	public int modifyHoliday(HolidayList Laundryholiday) {
		int result = holidayMapper.modifyHoliday(Laundryholiday);

		return result;
	}
	
	/* 세탁소별 휴일 삭제 */
	public int removeHoliday(String holidayCode) {
		int result = holidayMapper.removeHoliday(holidayCode);

		return result;
	}
	
	
	/* 세탁소별 휴일 추가를 위한 세탁소 이름으로 조회 */
	public List<LaundryList> addHoliday() {
		
		List<LaundryList> addlaundryName = laundryListMapper.addlaundryName();

		return addlaundryName;
	}
	
	/* 세탁소별 휴일 추가할 정보 */
	public int addHoliday(String laundryCode, String yearlyHolidayName,String yearlyHolidayDate){
		
		
		int result = holidayMapper.addHoliday(laundryCode, yearlyHolidayName, yearlyHolidayDate);
		
		return result;
	}
	
	
	public Map<String, Object> eachLaundryHoliday(int currentPage,String searchKey,	String searchValue) {
		
		int rowPerPage = 10;
		int startPageNum = 1;
		int endPageNum = 5;
		
		double rowCount = holidayMapper.LaundryHolidayLookUpCount();
		int lastPage = (int) Math.ceil(rowCount / rowPerPage);
		int startRow = (currentPage - 1) * rowPerPage;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		List<Map<String, Object>> eachLaundryHoliday = holidayMapper.eachLaundryHoliday(paramMap);
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
		resultMap.put("eachLaundryHoliday", eachLaundryHoliday);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);
		System.out.println("__________searchKey______________"+searchKey);
		System.out.println("__________searchValue______________"+searchValue);
		
		return resultMap;
		
	}
	

}
