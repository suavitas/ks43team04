package ks43team04.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ks43team04.dto.Delivery;
import ks43team04.dto.Member;
import ks43team04.dto.PickUp;
import ks43team04.service.DeliveryService;
import ks43team04.service.MemberService;
import ks43team04.service.PickUpService;

@Controller
public class DeliveryController {

	private final MemberService memberService;
	private final PickUpService pickUpService;
	private final DeliveryService deliveryService;

	public DeliveryController(MemberService memberService, PickUpService pickUpService,
			DeliveryService deliveryService) {
		this.memberService = memberService;
		this.pickUpService = pickUpService;
		this.deliveryService = deliveryService;

	}

	@GetMapping("/user/myPageDelivery")
	public String myPageDelivery(Model model, HttpSession session) {

		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");

		Member member = memberService.getMemberInfoById(sessionId);
		List<PickUp> getPickUpList = pickUpService.getPickUpList(sessionId);
		List<Delivery> getDeliveryList = deliveryService.getDeliveryList(sessionId);

		model.addAttribute("title", "개인 배송 및 수거");
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("member", member);
		model.addAttribute("getPickUpList", getPickUpList);
		model.addAttribute("getDeliveryList", getDeliveryList);

		System.out.println(getPickUpList);

		return "member/myPageDelivery";
	}

}
