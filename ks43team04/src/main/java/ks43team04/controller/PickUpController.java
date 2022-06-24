package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.dto.Delivery;
import ks43team04.dto.PickUp;
import ks43team04.service.DeliveryService;
import ks43team04.service.PickUpService;

@RequestMapping("/admin")
@Controller
public class PickUpController {

	private final PickUpService pickUpService;
	private final DeliveryService deliveryService;

	public PickUpController(PickUpService pickUpService, DeliveryService deliveryService) {
		this.pickUpService = pickUpService;
		this.deliveryService = deliveryService;

	}
	
	/*매장별 수거 배송 현황*/
	@GetMapping("/pickUpByStore")
	public String pickUpByStore() {
		
		return "admin/pickUpByStore";
	}
	

	/* 수거 현황 */
	@GetMapping("/pickUp")
	public String pickUp(Model model) {
		List<PickUp> getPickUpList = pickUpService.getPickUpList();

		model.addAttribute("getPickUpList", getPickUpList);
		System.out.println(getPickUpList);

		List<Delivery> getDeliveryList = deliveryService.getDeliveryList();

		model.addAttribute("getDeliveryList", getDeliveryList);
		System.out.println(getDeliveryList);

		return "admin/pickUp";
	}

}
