package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Bill;

@Mapper
public interface IlbanSalesMapper {
		
	/* 일반 세탁소 튜플수 */
	public int ilbanSalesLookUpCount();
	
	/*일반 세탁소 매출조회 페이징처리*/
	public List<Map<String, Object>> ilbanSalesLookUpList(Map<String, Object> paramMap);
	
	/*영수증 정보*/
	public Bill getBillInfoByCode(String billCode);
	
	/*영수증 리스트 삭제*/
	public int removeIlbanSalesLookUpList(String billCode);
}
