package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
