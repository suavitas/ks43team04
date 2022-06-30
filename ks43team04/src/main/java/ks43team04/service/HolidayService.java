package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks43team04.dto.HolidayList;
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
	
	/* 세탁소별 휴일 삭제 서비스 */
	public boolean getRemoveHolidayByHolidayCode(String holidayCode) {
		
		boolean holidayCodeCheck = false;

		HolidayList holidayList = holidayMapper.getRemoveHolidayByHolidayCode(holidayCode);
		if (holidayList != null) {
			String billCodeCheck = holidayList.getHolidayCode();
			if (holidayCode.equals(billCodeCheck)) {
				holidayCodeCheck = true;
				holidayMapper.getRemoveHolidayByHolidayCode(holidayCode);
		
			}
		}
				return holidayCodeCheck;
	}

}
