package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.HolidayList;
import ks43team04.dto.YearlyHoliday;

@Mapper
public interface HolidayMapper {

	/**
	 *  세탁소 조회
	 */
	public List<HolidayList> holidayList();
	
	/**
	 * 공휴일 조회
	 * 
	 */
	public List<YearlyHoliday> yearlyHolidayList();

}
