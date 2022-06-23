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
	
	public List<Delivery> getDeliveryList(){	
			
			List<Delivery> getDeliveryList = deliveryMapper.getDeliveryList();
			
			return getDeliveryList;
		}
	
}
