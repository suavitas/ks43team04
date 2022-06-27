package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Bill;

@Mapper
public interface BillMapper {
	
	
	public List<Bill> getBillList();
	
	/* 마이페이지 > 결제건수 조회 row 수*/
	public int getBillCount(String memberId);
}
