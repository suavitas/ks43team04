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

import ks43team04.dto.Bill2;
import ks43team04.dto.IlbanSkill;
import ks43team04.dto.Laundry;
import ks43team04.dto.MuinMachine;
import ks43team04.service.BillService;
import ks43team04.service.YeyakService;

@RequestMapping("/user")
@Controller
public class YeyakController {

	private final YeyakService yeyakService;
	private final BillService billService;

	
	public YeyakController(YeyakService yeyakService,BillService billService) {
		this.yeyakService = yeyakService;
		this.billService = billService;
	}
	
	@GetMapping("myPagePayment2")
	public String myPagePayment2(Model model) {
		
		return "/user/myPagePayment2";
	}
	
	@PostMapping("/myPagePayment2")
	public String myPagePayment2(Bill2 bill) {
		
		System.out.println(bill);
		
		billService.addBill2(bill);
		
		return "/member/myPagePayment2";
	}
	
	@GetMapping("/muinYeyak")
	public String muinYeyak(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage,
			Model model) {

		List<MuinMachine> muinMachineList = yeyakService.getMuinMachineList();

		Map<String, Object> resultMap = yeyakService.getMuinLaundryList(currentPage);

		model.addAttribute("resultMap", resultMap);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("muinLaundryList", resultMap.get("muinLaundryList"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", resultMap.get("endPageNum"));

		model.addAttribute("muinMachineList", muinMachineList);

		return "/user/yeyak/muinYeyak";
	}

	@GetMapping("/ilbanYeyak")
	public String yeyak(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage,
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

		return "user/yeyak/ilbanYeyak";
	}
}
