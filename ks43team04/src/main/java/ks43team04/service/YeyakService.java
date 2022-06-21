package ks43team04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.IlbanSkill;
import ks43team04.dto.Laundry;
import ks43team04.dto.MuinMachine;
import ks43team04.mapper.LaundryMapper;
import ks43team04.mapper.YeyakMapper;

@Service
@Transactional
public class YeyakService {

	private final YeyakMapper yeyakMapper;
	private final LaundryMapper laundryMapper;
	
	
	public YeyakService(YeyakMapper yeyakMapper,LaundryMapper laundryMapper) {
		this.yeyakMapper = yeyakMapper;
		this.laundryMapper = laundryMapper;
	}

	public List<Laundry> getIlbanGoodsPriceList(){
		List<Laundry> ilbanGoodsPriceList = laundryMapper.ilbanGoodsPriceList();
		return ilbanGoodsPriceList;
	}
	
	public List<IlbanSkill> getIlbanSkillList(){
		List<IlbanSkill> ilbanSkillList = laundryMapper.ilbanSkillList();
		return ilbanSkillList;
	}
	
	/**
	 * 무인세탁소 장비 조회
	 * @return muinMachineList
	 */
	public List<MuinMachine> getMuinMachineList(){
		List<MuinMachine> muinMachineList = yeyakMapper.muinMachineList();
		return muinMachineList;
	}
	
	/**
	 * 전체 무인 세탁소 조회
	 * @return muinLaundryList
	 */
	public Map<String, Object> getMuinLaundryList(int currentPage){
		//페이지 내 몇개를 보여줄까? (5) 행 노출
		   int rowPerPage = 5; 
		   int startPageNum = 1;
		   int endPageNum = 5;
		   
		   //총 행의 갯수
		   double rowCount =  laundryMapper.muinLaundryCount();
		   
		   //마지막 페이지
		   int lastPage = (int) Math.ceil(rowCount/rowPerPage);
		   
		   //페이징 처리
		   int startRow = (currentPage-1) * rowPerPage; //절대 바뀌지않는다!
		   
		   Map<String, Object> paramMap = new HashMap<String, Object>();
		   paramMap.put("startRow", startRow);
		   paramMap.put("rowPerPage", rowPerPage);
		   
		  List<Map<String, Object>> muinLaundryList = yeyakMapper.muinLaundryList(paramMap);
		  
		  //동적 페이지번호
		  if(currentPage > 6) {
			  startPageNum = currentPage - 5;
			  endPageNum = currentPage + 4; //자신 포함  / last-21페이지 픽스. 21-4 = 17부터는 움직이지않겠다. 17커런트로왔을때 
			  
			  if(endPageNum >= lastPage) { //17이상부터 클릭시 숫자가 늘어나지않고 고정되는 모습
				  startPageNum = lastPage - 9; //라스트페이지해당 21-9 = 12부터 고정시키겠다. 
				  endPageNum = lastPage; 
			  } 
		  }
		  
		  Map<String, Object> resultMap = new HashMap<String, Object>();
		  resultMap.put("lastPage", lastPage);
		  resultMap.put("muinLaundryList", muinLaundryList);	  
		  resultMap.put("startPageNum", startPageNum);	  
		  resultMap.put("endPageNum", endPageNum);	  
		   
		  return resultMap;

	}
	
	/**
	 * 전체 일반 세탁소 조회
	 * @return ilbanLaundryList
	 */
	public Map<String, Object> getIlbanLaundryList(int currentPage){
		//페이지 내 몇개를 보여줄까? (5) 행 노출
		   int rowPerPage = 5; 
		   int startPageNum = 1;
		   int endPageNum = 5;
		   
		   //총 행의 갯수
		   double rowCount =  laundryMapper.ilbanLaundryCount();
		   
		   //마지막 페이지
		   int lastPage = (int) Math.ceil(rowCount/rowPerPage);
		   
		   //페이징 처리
		   int startRow = (currentPage-1) * rowPerPage; //절대 바뀌지않는다!
		   
		   Map<String, Object> paramMap = new HashMap<String, Object>();
		   paramMap.put("startRow", startRow);
		   paramMap.put("rowPerPage", rowPerPage);
		   
		  List<Map<String, Object>> ilbanLaundryList = yeyakMapper.ilbanLaundryList(paramMap);
		  
		  //동적 페이지번호
		  if(currentPage > 6) {
			  startPageNum = currentPage - 5;
			  endPageNum = currentPage + 4; //자신 포함  / last-21페이지 픽스. 21-4 = 17부터는 움직이지않겠다. 17커런트로왔을때 
			  
			  if(endPageNum >= lastPage) { //17이상부터 클릭시 숫자가 늘어나지않고 고정되는 모습
				  startPageNum = lastPage - 9; //라스트페이지해당 21-9 = 12부터 고정시키겠다. 
				  endPageNum = lastPage; 
			  } 
		  }
		  Map<String, Object> resultMap = new HashMap<String, Object>();
		  resultMap.put("lastPage", lastPage);
		  resultMap.put("ilbanLaundryList", ilbanLaundryList);	  
		  resultMap.put("startPageNum", startPageNum);	  
		  resultMap.put("endPageNum", endPageNum);	  
		   
		  return resultMap;
	}
	
	
}
