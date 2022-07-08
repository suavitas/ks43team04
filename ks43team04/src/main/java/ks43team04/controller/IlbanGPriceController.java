package ks43team04.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.IlbanSkill;
import ks43team04.service.IlbanSkillService;
import ks43team04.service.LaundryService;

@Controller
@RequestMapping("/admin")
public class IlbanGPriceController {

	private final LaundryService laundryService;
	private final IlbanSkillService ilbanSkillService;
	
	public IlbanGPriceController(LaundryService laundryService,IlbanSkillService ilbanSkillService){
	this.laundryService = laundryService;
	this.ilbanSkillService = ilbanSkillService;
	}
	
	@GetMapping("/goodsPrice/goodsPrice")
	public String eachGoodsPriceList(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage,
	Model model, HttpSession session) {
		
		
		Map<String, Object> resultMap = laundryService.eachGoodsPriceList(currentPage);
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		
				
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("resultMap", resultMap);
		model.addAttribute("eachGoodsPriceList", resultMap.get("ilbangoodsPrice"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", resultMap.get("endPageNum"));				
		System.out.println(resultMap);
		System.out.println(resultMap.get("ilbangoodsPrice"));
		
		return "admin/goodsPrice/goodsPrice";
	}
	
	/* 세탁소별 세탁물 가격하기 위해 정보를 가저오는 컨트롤러 */
	@PostMapping("/goodsPrice/addGoodsPrice")
	public String addGoodsPrice(@RequestParam(name = "ilbanSkillCode", required=false) String ilbanSkillCode,
			@RequestParam(name = "gName", required=false) String gName,
			@RequestParam(name = "gPrice", required=false) String gPrice, 
			Model model) {
		
			ilbanSkillService.addGoodsPrice(ilbanSkillCode, gName, gPrice);
			System.out.println("______________"+ ilbanSkillCode);
			System.out.println("______________"+ gName);
			System.out.println("______________"+ gPrice);
		return "redirect:/admin/goodsPrice/goodsPrice";
	}
	
	
	/* 세탁소별 세탁물 가격 추가 메서드 실행 */
	@GetMapping("/goodsPrice/addGoodsPrice")
	public String addHoliday(Model model) {
		
		List<IlbanSkill> IlbanSkill = ilbanSkillService.IlbanSkill();
		model.addAttribute("IlbanSkill",IlbanSkill);
		System.out.println("______세탁소별 가격을 추가하기 위해 정보를 불러왔습니다._________"+IlbanSkill);
		return "admin/goodsPrice/addGoodsPrice";
	}
	
	/* 세탁소별 세탁물 가격 삭제 */
	@GetMapping("/goodsPrice/removeGoodsPrice")
	public String removeHoliday(@RequestParam(name = "ilbanGPriceCode", required=false) String ilbanGPriceCode,
			Model model) {
		
		System.out.println("_____세탁물 가격을 삭제하기 위해서 정보를 받아왔습니다____"+ilbanGPriceCode);
		
		model.addAttribute("ilbanGPriceCode", ilbanGPriceCode);
	
		return "admin/goodsPrice/removeGoodsPrice";
	}
	
	
	
	

}