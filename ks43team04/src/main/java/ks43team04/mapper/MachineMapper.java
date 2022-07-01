package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.HolidayList;
import ks43team04.dto.LaundryList;
import ks43team04.dto.YearlyHoliday;

@Mapper
public interface MachineMapper {

	/**
	 * 세탁소 조회
	 */
	public List<HolidayList> holidayList();

	/**
	 * 공휴일 조회
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
	

}
