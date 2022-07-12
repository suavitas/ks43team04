package ks43team04.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.HolidayList;
import ks43team04.dto.LaundryList;
import ks43team04.dto.YearlyHoliday;
import ks43team04.service.HolidayService;
import ks43team04.service.LaundryService;

@RequestMapping("/admin")
@Controller
public class HolidayController {

	private final HolidayService holidayService;
	private final LaundryService laundryService;
	
	private static final Logger log = LoggerFactory.getLogger(HolidayController.class);

	
	public HolidayController(HolidayService holidayService, LaundryService laundryService) {
		this.holidayService = holidayService;
		this.laundryService = laundryService;
	}

	/* 세탁소별 휴일 */
	@GetMapping("/lundryHoliday")
	public String LaundryList(@RequestParam(name = "searchKey", defaultValue = "1") String searchKey,
			@RequestParam(name = "searchValue", required = false) String searchValue, Model model) {

		if ("laundryName".equals(searchKey)) {
			searchKey = "laundry_name";
		}else if  ("yearlyHolidayDate".equals(searchKey)) {
			searchKey = "yearly_holiday_date";
		}else {
			searchKey = "laundry_addr";
		}

		List<LaundryList> getLaundryList = laundryService.LaundryList(searchKey, searchValue);
		if (getLaundryList != null)
			model.addAttribute("getLaundryList", getLaundryList);
		System.out.println("_______________세탁소별 휴일 목록을 불러옵니다_______________");
		System.out.println(getLaundryList);

		return "admin/lundryHoliday";
	}

	/* 세탁소별 휴일 삭제페이지로 정보 전달*/
	@GetMapping("/removeHoliday")
	public String removeHoliday(@RequestParam(name = "laundryName", required=false) String laundryName,
			@RequestParam(name = "yearlyHolidayName", required=false) String yearlyHolidayName,
			@RequestParam(name = "yearlyHolidayDate", required=false) String yearlyHolidayDate, 
			@RequestParam(name = "holidayCodeUse", required=false) String holidayCodeUse,
			@RequestParam(name = "holidayCode", required=false) String holidayCode,
			@RequestParam(name = "laundryCode", required=false) String laundryCode,
			Model model) {
		
		System.out.println("_____삭제하기 위해서 정보를 받아왔습니다____");
		
		model.addAttribute("laundryName", laundryName);
		model.addAttribute("holidayCode", holidayCode);
		model.addAttribute("yearlyHolidayName", yearlyHolidayName);
		model.addAttribute("yearlyHolidayDate", yearlyHolidayDate);
		model.addAttribute("holidayCodeUse", holidayCodeUse);
		model.addAttribute("laundryCode", laundryCode);
		//model.addAttribute("modifyHoliday", modifyHoliday);
	
		return "admin/removeHoliday";
	}
	
	/* 세탁소별 휴일 삭제쿼리 실행하기*/
	@PostMapping("/removeHoliday")
	public String removeHoliday(String holidayCode) {

		holidayService.removeHoliday(holidayCode);
		System.out.println("________세탁소별 휴일 정보 삭제를 실행합니다.___________"+holidayCode);
		return "redirect:/admin/lundryHoliday";
	}
	
	
	/* 세탁소별 휴일 수정으로 정보 이동 */
	@GetMapping("/changeHoliday")
	public String changeHoliday(@RequestParam(name = "laundryName", required=false) String laundryName,
			@RequestParam(name = "yearlyHolidayName", required=false) String yearlyHolidayName,
			@RequestParam(name = "yearlyHolidayDate", required=false) String yearlyHolidayDate, 
			@RequestParam(name = "holidayCodeUse", required=false) String holidayCodeUse,
			@RequestParam(name = "holidayCode", required=false) String holidayCode,
			@RequestParam(name = "laundryCode", required=false) String laundryCode,
			Model model) {
		
		System.out.println("_____세탁소별 휴가를 수정하기위해 정보를 불러왔습니다____");
		
		model.addAttribute("laundryName", laundryName);
		model.addAttribute("holidayCode", holidayCode);
		model.addAttribute("yearlyHolidayName", yearlyHolidayName);
		model.addAttribute("yearlyHolidayDate", yearlyHolidayDate);
		model.addAttribute("holidayCodeUse", holidayCodeUse);
		model.addAttribute("laundryCode", laundryCode);
		//model.addAttribute("modifyHoliday", modifyHoliday);
	
		return "admin/changeHoliday";
	}

	/* 세탁소별 휴일 수정하기*/
	@PostMapping("/changeHoliday")
	public String changeHoliday(HolidayList Laundryholiday) {

		holidayService.modifyHoliday(Laundryholiday);
		System.out.println("________세탁소별 휴일 정보를 수정했습니다.___________"+Laundryholiday);
		return "redirect:/admin/lundryHoliday";
	}
	
	/* 세탁소별 휴가 추가 */
	@PostMapping("/addHoliday")
	public String addHoliday(@RequestParam(name = "laundryCode", required=false) String laundryCode,
			@RequestParam(name = "yearlyHolidayName", required=false) String yearlyHolidayName,
			@RequestParam(name = "yearlyHolidayDate", required=false) String yearlyHolidayDate, 
			Model model) {
		
			holidayService.addHoliday(laundryCode, yearlyHolidayName, yearlyHolidayDate);
			System.out.println("______________"+ laundryCode);
			System.out.println("______________"+ yearlyHolidayName);
			System.out.println("______________"+ yearlyHolidayDate);
		return "redirect:/admin/lundryHoliday";
	}
	
	/* 세탁소별 휴가 추가 */
	@GetMapping("/addHoliday")
	public String addHoliday(Model model) {
		
		List<LaundryList> addLaundryHoliday = holidayService.addHoliday();
		model.addAttribute("addLaundryHoliday",addLaundryHoliday);
		System.out.println("______세탁소별 휴일을 추가하기 위해 정보를 불러왔습니다._________"+addLaundryHoliday);
		return "/admin/addHoliday";
	}
	
	@PostMapping("/allModifyHoliday")
	public String allModifyHoliday(@RequestParam(name="yearlyHolidayCode") String yearlyHolidayCode,
									@RequestParam(name="holidayCodeUse") String holidayCodeUse) {
		System.out.println(yearlyHolidayCode);
		System.out.println(holidayCodeUse);
		
		holidayService.allModifyHolyday(yearlyHolidayCode,holidayCodeUse);
		return "redirect:/admin/holiday";
	}
	
	
	/* 전체 공휴일 수정*/
	@GetMapping("/allModifyHoliday")
	public String allModifyHoliday(@RequestParam(name="yearlyHolidayCode") String yearlyHolidayCode,
									@RequestParam(name="yearlyHolidayDate") String yearlyHolidayDate,
									@RequestParam(name="yearlyHolidayName") String yearlyHolidayName,
									@RequestParam(name="holidayCodeUse") String holidayCodeUse,
									Model model){
		
		model.addAttribute("yearlyHolidayCode", yearlyHolidayCode);
		model.addAttribute("yearlyHolidayDate", yearlyHolidayDate);
		model.addAttribute("yearlyHolidayName", yearlyHolidayName);
		model.addAttribute("holidayCodeUse", holidayCodeUse);
		
		return "/admin/allModifyHoliday";
	}

	/* 전체 공휴일 추가*/
	@GetMapping("/addYearlyHoliday")
	public String addYearlyHoliday() {
		
		return "/admin/addYearlyHoliday";
	}
	
	@PostMapping("/addYearlyHoliday")
	public String addYearlyHoliday(YearlyHoliday yearlyHoliday) {
		holidayService.addYearlyHoliday(yearlyHoliday);
		System.out.println(yearlyHoliday+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return "redirect:/admin/holiday";
	}

	/* 전체 공휴일 목록 */
	@GetMapping("/holiday")
	public String holiday(Model model) {
		List<YearlyHoliday> YearlyHolidayList = holidayService.yearlyHolidayList();

			
		System.out.println(YearlyHolidayList);
		model.addAttribute("YearlyHolidayList", YearlyHolidayList);
		return "admin/holiday";
	}
}
