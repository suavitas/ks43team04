package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.dto.Bill;
import ks43team04.service.PointService;

@Controller
@RequestMapping("/admin")
public class PointController {

	private PointService pointService;
	
	public PointController(PointService pointService) {
		this.pointService = pointService;
	}
	
	// 회원별 포인트
	@GetMapping("/memberPoint")
	public String memberPoint(Model model) {
		
		List<Bill> getPointUseList = pointService.getPointUseList();
		
		System.out.println(getPointUseList+"<--------- getPointUseList 리스트 출력");
		
		model.addAttribute("getPointUseList", getPointUseList);
		
		return "admin/point/memberPoint";
	}
}
