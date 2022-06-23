package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IlbanSalesMapper {
		
	/* 일반 세탁소 튜플수 */
	public int ilbanSalesLookUpCount();
	
	/*일반 세탁소 매출조회 페이징처리*/
	public List<Map<String, Object>> ilbanSalesLookUpList(Map<String, Object> paramMap);
}
