package ks43team04.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ks43team04.dto.HolidayList;
import ks43team04.dto.IlbanSkill;
import ks43team04.dto.Laundry;
import ks43team04.dto.LaundryInfoSebu;
import ks43team04.dto.Member;
import ks43team04.service.LaundryInfoSebuService;
import ks43team04.service.MemberService;
import ks43team04.service.YeyakService;


@RequestMapping("/user")
@Controller
public class LaundryInfoSebuController {
	
   private static final Logger log = LoggerFactory.getLogger(LaundryInfoSebuController.class);
  
   private final LaundryInfoSebuService laundryInfoSebuService;
   private final YeyakService yeyakService;
   private final MemberService memberService;
   
   public LaundryInfoSebuController(MemberService memberService,YeyakService yeyakService,LaundryInfoSebuService laundryInfoSebuService) {
      this.laundryInfoSebuService = laundryInfoSebuService;
      this.yeyakService = yeyakService;
      this.memberService = memberService;
   }
   
   
   
   /*test*/
   @GetMapping("/laundryInfo")
   public String LaundryInfoSebu(Model model) {
      List<LaundryInfoSebu> LaundryInfoSebu = laundryInfoSebuService.laundryInfoSebu();
      System.out.println("model : {}" + model);
      model.addAttribute("LaundryInfoSebu", LaundryInfoSebu);
      return "user/laundryInfo";
   }
   
   @PostMapping("/laundryInfo")
   public String getLaundryInfoSebu(@RequestParam(name = "searchKey") String searchKey,
		   							@RequestParam(name = "searchValue", required = false) String searchValue, Model model, HttpSession session) {
	   
	   String sessionId = (String) session.getAttribute("SID");
	   HashMap<String, String> search = new HashMap<>();
	   
	   Member member = memberService.getMemberInfoById(sessionId);
	      log.info("searchKey : {}", searchKey);
	      log.info("searchValue : {}", searchValue);
	      
	      System.out.println(searchKey);
	      System.out.println(searchValue);
	      
	      if ("laundryName".equals(searchKey)) {
	         search.put("searchKey", "l.laundry_name");
	      }else if("laundryName"!=searchKey) {
	         System.out.println("없는 세탁소입니다.");
	      }
	      search.put("searchValue", searchValue);
	      LaundryInfoSebu laundryInfo = laundryInfoSebuService.getLaundryInfoSebu(search);
	      if (laundryInfo != null) {
	         model.addAttribute("laundryInfo", laundryInfo);
	      }
	      List<IlbanSkill> ilbanSkillList = yeyakService.getIlbanSkillList();
	      List<Laundry> ilbanGoodsPriceList = yeyakService.getIlbanGoodsPriceList();
	      
	      model.addAttribute("ilbanSkillList",ilbanSkillList);
	      model.addAttribute("ilbanGoodsPriceList",ilbanGoodsPriceList);
	      model.addAttribute("sessionId", sessionId);
	      model.addAttribute("member", member);
	      
	      System.out.println(ilbanSkillList+"일반스킬리스트");
	      System.out.println(laundryInfo);
      return "user/laundryInfo";
   }
   
   @PostMapping("/laundryDateCheck")
   @ResponseBody
   public String holidayList(@RequestBody Map<String, String> paramMap) throws JsonProcessingException {
	   log.info("Map: {}",paramMap);
	   String laundryCode = paramMap.get("laundryCode");
	   String yeyakDate = paramMap.get("yeyakDate");
	   HolidayList holidayList = laundryInfoSebuService.dateCheck(laundryCode, yeyakDate);
	   
	   ObjectMapper om  = new ObjectMapper();
	   
	   String jsonDelivery = om.writeValueAsString(holidayList);
	   
	return jsonDelivery;   
   }
   
   
   /*매장찾기*/
   @GetMapping("/searchmap/searchMap")
   public String userMain() {
      return "/user/searchmap/searchMap";
   }
}