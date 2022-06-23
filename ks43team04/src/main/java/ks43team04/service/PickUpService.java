package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

	public List<PickUp> getPickUpList() {

		List<PickUp> getPickUpList = pickUpMapper.getPickUpList();

		return getPickUpList;
	}

	public List<PickUp> getPickUpList(String sessionId) {

		List<PickUp> getPickUpList = pickUpMapper.getPickUpList(sessionId);

		return getPickUpList;
	}

}
