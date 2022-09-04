package ks43team04.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ks43team04.dto.HolidayList;
import ks43team04.dto.LaundryInfoSebu;
@Mapper
public interface LaundryInfoSebuMapper {

	/*test*/
	public List<LaundryInfoSebu> laundryInfoSebu();
	
	public HolidayList dateCheck(String laundryCode, String yeyakDate);
	
	public LaundryInfoSebu getLaundryInfoSebu(HashMap<String, String> search);

	
}
