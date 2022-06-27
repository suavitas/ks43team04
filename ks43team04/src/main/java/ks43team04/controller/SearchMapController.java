package ks43team04.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.IlbanSkill;
import ks43team04.dto.Laundry;
import ks43team04.service.YeyakService;


@Controller
public class SearchMapController {
	private final YeyakService yeyakService;

	public SearchMapController(YeyakService yeyakService) {
		this.yeyakService = yeyakService;
	}
	@GetMapping("/user/searchmap")
	public String searchMap(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage,
							Model model) {
		List<IlbanSkill> ilbanSkillList = yeyakService.getIlbanSkillList();
		List<Laundry> ilbanGoodsPriceList = yeyakService.getIlbanGoodsPriceList();

		Map<String, Object> resultMap = yeyakService.getIlbanLaundryList(currentPage);

		model.addAttribute("resultMap", resultMap);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("ilbanLaundryList", resultMap.get("ilbanLaundryList"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", resultMap.get("endPageNum"));

		System.out.println(ilbanGoodsPriceList);

		model.addAttribute("ilbanGoodsPriceList", ilbanGoodsPriceList);
		model.addAttribute("ilbanSkillList", ilbanSkillList);
		return "/user/searchmap/searchMap";
	}

}