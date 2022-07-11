package ks43team04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")

public class ReservationStatus {
	@GetMapping("/myPageReservationStatus")
	public String reservationStatus() {
		return "/member/myPageReservationStatus";
	}
}
