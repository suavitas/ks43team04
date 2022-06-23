package ks43team04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DeliveryController {
	
	@GetMapping("/user/myPageDelivery")
	public String myPageDelivery() {
		
		
		return "/member/myPageDelivery";
	}
	
	
}
