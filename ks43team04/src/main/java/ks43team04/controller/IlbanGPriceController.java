package ks43team04.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.IlbanGprice;
import ks43team04.dto.IlbanSkill;
import ks43team04.service.IlbanGPriceService;
import ks43team04.service.IlbanSkillService;
import ks43team04.service.LaundryService;

@Controller
@RequestMapping("/admin")
public class IlbanGPriceController {

	private final LaundryService laundryService;
	private final IlbanSkillService ilbanSkillService;
	private final IlbanGPriceService ilbanGPriceService;
	
	public IlbanGPriceController(LaundryService laundryService,IlbanSkillService ilbanSkillService,IlbanGPriceService ilbanGPriceService){
	this.laundryService = laundryService;
	this.ilbanSkillService = ilbanSkillService;
	this.ilbanGPriceService = ilbanGPriceService;
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
		System.out.println("____________세탁소 매장 가격표를 가지고옵니다.____________");
		System.out.println(resultMap.get("ilbangoodsPrice"));
		
		return "admin/goodsPrice/goodsPrice";
	}
	
	/* 세탁소별 세탁물 가격 추가하기 위해 정보를 가저오는 컨트롤러 */
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
	
	/* 세탁소별 세탁물 가격 삭제페이지에 정보 불러오기*/
	@GetMapping("/goodsPrice/removeGoodsPrice")
	public String removeGoodsPrice(@RequestParam(name = "ilbanGPriceCode", required=false) String ilbanGPriceCode,
								@RequestParam(name = "laundryName", required=false) String laundryName,
								@RequestParam(name = "skillCate", required=false) String skillCate,
								@RequestParam(name = "gName", required=false) String gName,
								@RequestParam(name = "gPrice", required=false) String gPrice,
								@RequestParam(name = "gPriceUseState", required=false) String gPriceUseState,
								Model model) {
			
		System.out.println("_____세탁물 가격을 삭제하기 위해서 정보를 받아왔습니다____");
		System.out.println("_____gPriceUseState____"+gPriceUseState);
		System.out.println("_____ilbanGPriceCode____"+ilbanGPriceCode);
		System.out.println("_____laundryName____"+laundryName);
		System.out.println("_____skillCate____"+skillCate);
		System.out.println("_____gName____"+gName);
		System.out.println("_____gPrice____"+gPrice);
		
		model.addAttribute("ilbanGPriceCode", ilbanGPriceCode);
		model.addAttribute("skillCate", skillCate);
		model.addAttribute("laundryName", laundryName);
		model.addAttribute("gName", gName);
		model.addAttribute("gPrice", gPrice);
		model.addAttribute("gPriceUseState", gPriceUseState);
	
		return "admin/goodsPrice/removeGoodsPrice";
	}
	/* 세탁소별 세탁물 가격 삭제쿼리 실행*/
	@PostMapping("/goodsPrice/removeGoodsPrice")
	public String removeGoodsPrice(String ilbanGPriceCode,
								   String gPriceUseState) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		
		if(gPriceUseState.equals("use")) {
			gPriceUseState = "unuse";
		} else {
			gPriceUseState = "use";
		}
		paramMap.put("ilbanGPriceCode", ilbanGPriceCode);
		paramMap.put("gPriceUseState", gPriceUseState);
		
		
		ilbanSkillService.removeGoodsPrice(paramMap);
		System.out.println("________일반세탁소 가격 삭제를 실행합니다._________"+ilbanGPriceCode);
		return "redirect:/admin/goodsPrice/goodsPrice";
	}	
	
	/* 세탁소별 세탁물 가격 수정페이지에 정보 불러오기*/
	@GetMapping("/goodsPrice/changeGoodsPrice")
	public String changeGoodsPrice(@RequestParam(name = "ilbanGPriceCode", required=false) String ilbanGPriceCode,
								@RequestParam(name = "skillCate", required=false) String skillCate,
								@RequestParam(name = "gName", required=false) String gName,
								@RequestParam(name = "gPrice", required=false) String gPrice,
								@RequestParam(name = "gPriceUseState", required=false) String gPriceUseState,
								Model model) {
			
		System.out.println("_____세탁물 가격을 수정하기 위해서 정보를 받아왔습니다____");
		System.out.println("________ilbanGPriceCode______"+ilbanGPriceCode);
		System.out.println("________skillCate______"+skillCate);
		System.out.println("________gName______"+gName);
		System.out.println("________gPrice______"+gPrice);
		System.out.println("________gPriceUseState______"+gPriceUseState);
		
		model.addAttribute("ilbanGPriceCode",ilbanGPriceCode);
		model.addAttribute("skillCate", skillCate);
		model.addAttribute("gName", gName);
		model.addAttribute("gPrice", gPrice);
		model.addAttribute("gPriceUseState", gPriceUseState);
	
		return "admin/goodsPrice/changeGoodsPrice";
	}
	
	/* 세탁소별 세탁물 가격 수정쿼리 실행*/
	@PostMapping("/goodsPrice/changeGoodsPrice")
	public String changeGoodsPrice(IlbanGprice ilbanGPriceCode) {
		
		ilbanGPriceService.modifyGoodsPrice(ilbanGPriceCode);
		System.out.println("________일반세탁소 가격 수정를 실행합니다._________"+ilbanGPriceCode);
		return "redirect:/admin/goodsPrice/goodsPrice";
	}	
	
	
	

}