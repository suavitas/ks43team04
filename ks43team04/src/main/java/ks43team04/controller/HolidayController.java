package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.LaundryList;
import ks43team04.dto.YearlyHoliday;
import ks43team04.service.HolidayService;
import ks43team04.service.LaundryService;

@RequestMapping("/admin")
@Controller
public class HolidayController {

	private final HolidayService holidayService;
	private final LaundryService laundryService;

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
		}if ("yearlyHolidayDate".equals(searchKey)) {
			searchKey = "yearly_holiday_date";
		} else {
			searchKey = "laundry_addr";
		}

		List<LaundryList> getLaundryList = laundryService.LaundryList(searchKey, searchValue);
		if (getLaundryList != null)
			model.addAttribute("getLaundryList", getLaundryList);

		System.out.println(getLaundryList);

		return "admin/lundryHoliday";
	}

	/* 공휴일 목록 */
	@GetMapping("/holiday")
	public String holiday(Model model) {
		List<YearlyHoliday> YearlyHolidayList = holidayService.yearlyHolidayList();

		model.addAttribute("YearlyHolidayList", YearlyHolidayList);
		return "admin/holiday";
	}

}
