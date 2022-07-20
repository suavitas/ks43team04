package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.ContractRider;
import ks43team04.dto.PickUp;

@Mapper
public interface PickUpMapper {

	//매장별 수거 현황
	public List<PickUp> pickUpListByStore(List<String> laundryCodeList);
	
	//배송 업체 목록 조회
	public List<ContractRider> getRiderList();
	
	// 공지사항 목록 조회
	public List<PickUp> getPickUpList();

	public List<PickUp> getPickUpList(String sessionId);
}