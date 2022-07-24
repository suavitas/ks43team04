package ks43team04.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ks43team04.dto.HolidayList;
import ks43team04.dto.YearlyHoliday;
import ks43team04.service.HolidayService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
	
	private final HolidayService holidayService;
	private static final Logger log = LoggerFactory.getLogger(CalendarController.class);

	public CalendarController(HolidayService holidayService) {
		this.holidayService = holidayService;
	}
	
	@PostMapping("/selectHoliday")
	public String selectHoliday(@RequestBody Map<String, String> scheduleDate) {
		
		String scheduleJson = "";
		log.info("scheduleDate : {}" +scheduleDate);
		
		List<YearlyHoliday> holidayList = holidayService.yearlyHolidayList(scheduleDate);
		
		
      ObjectMapper om = new ObjectMapper();
      try {
         scheduleJson = om.writeValueAsString(holidayList);
      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      log.info(scheduleJson);
      return scheduleJson;
	   
	}
}
