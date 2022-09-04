package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.HolidayList;
import ks43team04.dto.LaundryList;
import ks43team04.dto.YearlyHoliday;

@Mapper
public interface HolidayMapper {

	/**
	 * 세탁소 조회
	 * @param scheduleDate 
	 */
	public List<HolidayList> holidayList(Map<String, String> scheduleDate);

	/**
	 * 공휴일 조회
	 * @param scheduleDate 
	 * 
	 */
	public List<YearlyHoliday> yearlyHolidayList();
	
	
	/* 세탁소별 휴일 정보 넘기는 메서드*/
	public HolidayList getHolidayByHolidayCode(String holidayCode);

	/* 세탁소별 휴일 정보 수정 */
	public int modifyHoliday(HolidayList Laundryholiday);
	
	/* 세탁소별 휴일 추가 실행 메서드 */
	public int addHoliday(String laundryCode, String yearlyHolidayName,String yearlyHolidayDate);

	/* 세탁소별 휴일 삭제 쿼리 실행 메서드 */
	public int removeHoliday(String holidayCode);
	
	/* 전체 공휴일 수정 */
	public int allModifyHolyday(String yearlyHolidayCode,String holidayCodeUse);
	
	/* 전체 공휴일 추가*/
	public int addYearlyHoliday(YearlyHoliday yearlyHoliday);
	
		/* 세탁소 매장별 휴일 페이지 튜플수 */
	public int LaundryHolidayLookUpCount();
	
	/* 세탁소 매장별 휴일 페이징 처리 */
	public List<Map<String, Object>> eachLaundryHoliday(Map<String, Object> paramMap);

	public List<YearlyHoliday> yearlyHolidayListByDate(Map<String, String> scheduleDate);

}
