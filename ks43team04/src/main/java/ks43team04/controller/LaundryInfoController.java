package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ks43team04.dto.Laundry;
import ks43team04.dto.LaundryList;
import ks43team04.service.LaundryService;

@Controller
public class LaundryInfoController {
	
	
	

	@GetMapping("/user/laundryInfo")
	public String laundryInfo() {
		return "user/laundryInfo/laundryInfo";
	}
	
	

	

}
