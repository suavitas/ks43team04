package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.IlbanSkill;
import ks43team04.dto.Laundry;
import ks43team04.dto.MuinMachine;

@Mapper
public interface YeyakMapper {


	
	/*일반 세탁소 페이징처리*/
	public List<Map<String, Object>> ilbanLaundryList(Map<String, Object> paramMap);
	
	/*무인 세탁소 페이징처리*/
	public List<Map<String, Object>> muinLaundryList(Map<String, Object> paramMap);
	
	/*무인세탁소 장비 조회*/
	public List<MuinMachine> muinMachineList();
	

	
}
