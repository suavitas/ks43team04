package ks43team04.controller;


import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.IlbanSkill;
import ks43team04.dto.Laundry;
import ks43team04.dto.LaundryInfoSebu;
import ks43team04.service.LaundryInfoSebuService;
import ks43team04.service.YeyakService;


@RequestMapping("/user")
@Controller
public class LaundryInfoSebuController {
   private static final Logger log = LoggerFactory.getLogger(LaundryInfoSebuController.class);
   private final LaundryInfoSebuService laundryInfoSebuService;
   private final YeyakService yeyakService;
   public LaundryInfoSebuController(YeyakService yeyakService,LaundryInfoSebuService laundryInfoSebuService) {
      this.laundryInfoSebuService = laundryInfoSebuService;
      this.yeyakService = yeyakService;
   }
   /* 무인세탁소 test */
   @GetMapping("/laundryInfoMuin")
   public String LaundryInfoMuin(Model model) {
      List<LaundryInfoSebu> LaundryInfoSebu = laundryInfoSebuService.laundryInfoSebu();
      System.out.println("model : {}" + model);
      model.addAttribute("LaundryInfoSebu", LaundryInfoSebu);
      return "user/laundryInfoMuin";
   }
   
   @PostMapping("/laundryInfoMuin")
   public String getLaundryInfoMuin(@RequestParam(name = "searchKey") String searchKey,
         @RequestParam(name = "searchValue", required = false) String searchValue, Model model) {
      
      HashMap<String, String> search = new HashMap<>();
      
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
      
      
      System.out.println(ilbanSkillList+"ddd");
      System.out.println(laundryInfo);
      return "user/laundryInfoMuin";
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
         @RequestParam(name = "searchValue", required = false) String searchValue, Model model) {
      
	   HashMap<String, String> search = new HashMap<>();
	      
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
	      
	      
	      System.out.println(ilbanSkillList+"일반스킬리스트");
	      System.out.println(laundryInfo);
      return "user/laundryInfo";
   }
   /*매장찾기*/
   @GetMapping("/searchmap/searchMap")
   public String userMain() {
      return "/user/searchmap/searchMap";
   }
}