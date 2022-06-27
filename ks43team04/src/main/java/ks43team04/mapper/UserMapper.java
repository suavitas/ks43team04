package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	/*결제내역 페이징처리*/
	public List<Map<String, Object>> getPaymentList(Map<String, Object> paramMap);
	
}
