package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks43team04.dto.ContractRider;
import ks43team04.dto.PickUp;
import ks43team04.dto.YearlyHoliday;
import ks43team04.mapper.HolidayMapper;
import ks43team04.mapper.PickUpMapper;

@Service
public class PickUpService {

	private final PickUpMapper pickUpMapper;

	public PickUpService(PickUpMapper pickUpMapper) {
		this.pickUpMapper = pickUpMapper;
	}
	
	/*배송 업체 목록*/
	public List<ContractRider> getRiderList(){
		List<ContractRider> getRiderList = pickUpMapper.getRiderList();
		return getRiderList;
	}

	/*매장별 수거 목록(점주)*/
	public List<PickUp> pickUpListByStore(List<String> laundryCodeList){
		List<PickUp> pickUpListByStore = pickUpMapper.pickUpListByStore(laundryCodeList);
		return pickUpListByStore;
	}
	
	public List<PickUp> getPickUpList() {

		List<PickUp> getPickUpList = pickUpMapper.getPickUpList();

		return getPickUpList;
	}

	public List<PickUp> getPickUpList(String sessionId) {

		List<PickUp> getPickUpList = pickUpMapper.getPickUpList(sessionId);

		return getPickUpList;
	}

}
