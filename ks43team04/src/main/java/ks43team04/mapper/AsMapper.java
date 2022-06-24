package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.As;

@Mapper
public interface AsMapper {

	//AS 상세 조회
	public As getAsDetail(String asCode);
	
	//AS 목록 
	public List<As> getAsList();
}
