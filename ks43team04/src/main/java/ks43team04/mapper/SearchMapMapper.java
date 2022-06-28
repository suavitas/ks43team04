package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import ks43team04.dto.LaundryList;

@Mapper
public interface SearchMapMapper {


	public double getSearchCount();
	//시설 검색
	public List<Map<String, Object>> getSearchList(Map<String, Object> paramMap);
}