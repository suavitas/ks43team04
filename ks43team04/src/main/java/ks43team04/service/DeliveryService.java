package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks43team04.dto.Delivery;
import ks43team04.mapper.DeliveryMapper;

@Service
public class DeliveryService {

	private final DeliveryMapper deliveryMapper;

	public DeliveryService(DeliveryMapper deliveryMapper) {
		this.deliveryMapper = deliveryMapper;
	}
	
	/*매장별 배송 목록(점주)*/
	public List<Delivery> deliveryListByStore(List<String> laundryCodeList){
		List<Delivery> deliveryListByStore = deliveryMapper.deliveryListByStore(laundryCodeList);
		return deliveryListByStore;
	}
	
	public List<Delivery> getDeliveryList() {

		List<Delivery> getDeliveryList = deliveryMapper.getDeliveryList();

		return getDeliveryList;
	}

	public List<Delivery> getDeliveryList(String sessionId) {

		List<Delivery> getDeliveryList = deliveryMapper.getDeliveryList(sessionId);

		return getDeliveryList;
	}

}
