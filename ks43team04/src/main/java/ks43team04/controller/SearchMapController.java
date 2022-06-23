package ks43team04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchMapController {

	@GetMapping("/user/searchmap")
	public String searchMap() {
		return "/user/searchmap/searchMap";
	}

}
