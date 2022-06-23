package ks43team04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

	@GetMapping("/user/payment")
	public String payment() {
		return "user/payment/payment";
	}

}
