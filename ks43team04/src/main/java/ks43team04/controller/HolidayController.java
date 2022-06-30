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

		System.out.println(getLaundryList);

		return "admin/lundryHoliday";
	}
	
	/* 세탁소별 휴일 삭제로 이동 */
	@GetMapping("/changeHoliday")
	public String changeHoliday(@RequestParam(name = "laundryName", required=false) String laundryName,
			@RequestParam(name = "yearlyHolidayName", required=false) String yearlyHolidayName,
			@RequestParam(name = "yearlyHolidayDate", required=false) String yearlyHolidayDate, 
			@RequestParam(name = "holidayCodeUse", required=false) String holidayCodeUse,
			@RequestParam(name = "holidayCode", required=false) String holidayCode,
			@RequestParam(name = "laundryCode", required=false) String laundryCode,
			Model model) {
		
		System.out.println("_____changeHoliday start____");
		//HolidayList modifyHoliday = holidayService.getRemoveHolidayByHolidayCode(holidayCode);
		System.out.println("_____changeHoliday End____");
		
		model.addAttribute("laundryName", laundryName);
		model.addAttribute("holidayCode", holidayCode);
		model.addAttribute("yearlyHolidayName", yearlyHolidayName);
		model.addAttribute("yearlyHolidayDate", yearlyHolidayDate);
		model.addAttribute("holidayCodeUse", holidayCodeUse);
		model.addAttribute("laundryCode", laundryCode);
		//model.addAttribute("modifyHoliday", modifyHoliday);
	
		return "admin/changeHoliday";
	}

	/* 세탁소별 휴일 수정*/
	@PostMapping("/changeHoliday")
	public String changeHoliday(HolidayList Laundryholiday) {

		holidayService.modifyHoliday(Laundryholiday);
		System.out.println("________Laundryholiday이겁니다!!!___________"+Laundryholiday);
		return "redirect:/admin/lundryHoliday";
	}


	/* 공휴일 목록 */
	@GetMapping("/holiday")
	public String holiday(Model model) {
		List<YearlyHoliday> YearlyHolidayList = holidayService.yearlyHolidayList();

		model.addAttribute("YearlyHolidayList", YearlyHolidayList);
		return "admin/holiday";
	}
}
