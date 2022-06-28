package ks43team04.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ks43team04.mapper.SearchMapMapper;
import ks43team04.service.SearchMapService;
import ks43team04.dto.LaundryList;


@Controller
public class SearchMapController {
	private static final Logger log = LoggerFactory.getLogger(SearchMapController.class);

	private final SearchMapService searchMapService;
	private final SearchMapMapper searchMapMapper;
	public SearchMapController(SearchMapService searchMapService, SearchMapMapper searchMapMapper) {
		this.searchMapService = searchMapService;
		this.searchMapMapper = searchMapMapper;
	}
	/*검색*/
	@PostMapping("/searchMapList")
	public String getSearchMapList(@RequestParam(name="searchKey")String searchKey
								  ,@RequestParam(name="searchValue", required = false)String searchValue
								  ,@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage
								  ,Model model) {
		
		log.info("searchKey : {}", searchKey);
		log.info("searchValue : {}", searchValue);
		if("facilityNm".equals(searchKey)) {
			searchKey = "f.facility_nm";
		
		}
		
		Map<String, Object> resultMap = searchMapService.getSearchList(searchKey, searchValue, currentPage);
		
		log.info("resultMap : {}",resultMap);
		
		if(resultMap != null) {
			
		log.info("resultMap.get(\"searchMapList\") : {}",resultMap.get("searchMapList"));
		
		model.addAttribute("resultMap", 			resultMap);
		model.addAttribute("currentPage", 			currentPage);
		model.addAttribute("SearchMapList",			resultMap.get("SearchMapList"));
		model.addAttribute("lastPage", 				resultMap.get("lastPage"));
		model.addAttribute("startPageNum", 			resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", 			resultMap.get("endPageNum"));
		model.addAttribute("title", "전체 시설 목록 조회");
		
		}
		return "map/map2";
	}
	public SearchMapMapper getSearchMapMapper() {
		return searchMapMapper;
	}
}