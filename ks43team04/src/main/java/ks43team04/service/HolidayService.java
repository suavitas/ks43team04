package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

	public List<YearlyHoliday> yearlyHolidayList() {

		List<YearlyHoliday> yearlyHolidayList = holidayMapper.yearlyHolidayList();

		return yearlyHolidayList;
	}

	/* 세탁소별 휴일 정보 */
	public HolidayList getHolidayByHolidayCode(String holidayCode) {
		
		System.out.println("________ServiceStart__________");
		HolidayList getHolidayByHolidayCode = holidayMapper.getHolidayByHolidayCode(holidayCode);
		System.out.println("________ServiceEnd__________");
		
		return getHolidayByHolidayCode;
	}

	/* 세탁소별 휴일 수정 */
	public int modifyHoliday(HolidayList Laundryholiday) {
		int result = holidayMapper.modifyHoliday(Laundryholiday);

		return result;
	}
	
	/* 세탁소별 휴일 추가를 위한 세탁소 이름 조회 */
	public List<LaundryList> addHoliday() {
		
		List<LaundryList> addlaundryName = laundryListMapper.addlaundryName();

		return addlaundryName;
	}
	
	/* 세탁소별 휴일 정보 */
	public int addHoliday(String laundryCode, String yearlyHolidayName,String yearlyHolidayDate){
		
		
		int result = holidayMapper.addHoliday(laundryCode, yearlyHolidayName, yearlyHolidayDate);
		
		return result;
	}
	

}
