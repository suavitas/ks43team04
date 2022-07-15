package ks43team04.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.dto.Delivery;
import ks43team04.dto.Laundry;
import ks43team04.dto.LaundryList;
import ks43team04.dto.Member;
import ks43team04.dto.PickUp;
import ks43team04.service.BoardService;
import ks43team04.service.DeliveryService;
import ks43team04.service.MemberService;
import ks43team04.service.PickUpService;

@RequestMapping("/admin")
@Controller
public class PickUpController {

	private final PickUpService pickUpService;
	private final DeliveryService deliveryService;
	private final MemberService memberService;
	private final BoardService boardService;

	public PickUpController(PickUpService pickUpService, DeliveryService deliveryService, BoardService boardService, MemberService memberService) {
		this.pickUpService = pickUpService;
		this.deliveryService = deliveryService;
		this.boardService = boardService;
		this.memberService = memberService;

	}
	
	/*매장별 수거 현황*/
	@GetMapping("/pickUpByStore")
	public String pickUpByStore(Model model, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		Member member = memberService.getMemberInfoById(sessionId);
		
		List<Laundry> getMemberLaundryList = boardService.getMemberLaundryList(sessionId);
		System.out.println(getMemberLaundryList);
		List<String> laundryCodeList = new ArrayList<String>();
		if(getMemberLaundryList != null) {
			
			for(Laundry laundry : getMemberLaundryList) {
				laundryCodeList.add(laundry.getLaundryCode());
			}
		}
		System.out.println(laundryCodeList);
		List<PickUp> pickUpListByStore = pickUpService.pickUpListByStore(laundryCodeList);
		
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("getMemberLaundryList", getMemberLaundryList);
		model.addAttribute("member", member);
		model.addAttribute("pickUpListByStore", pickUpListByStore);
		model.addAttribute("laundryCode", getMemberLaundryList);
		System.out.println(getMemberLaundryList);
		System.out.println(pickUpListByStore);
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
