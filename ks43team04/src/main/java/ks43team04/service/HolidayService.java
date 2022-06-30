package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks43team04.dto.HolidayList;
import ks43team04.dto.LaundryList;
import ks43team04.dto.YearlyHoliday;
import ks43team04.mapper.HolidayMapper;

@Service
public class HolidayService {

	private final HolidayMapper holidayMapper;

	public HolidayService(HolidayMapper holidayMapper) {
		this.holidayMapper = holidayMapper;
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

}
