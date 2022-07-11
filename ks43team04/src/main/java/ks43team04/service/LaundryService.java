package ks43team04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ks43team04.dto.Delivery;
import ks43team04.dto.Laundry;
import ks43team04.dto.LaundryList;
import ks43team04.dto.MuinMachienSpec;
import ks43team04.mapper.LaundryListMapper;
import ks43team04.mapper.LaundryMapper;
import ks43team04.mapper.UserMapper;

@Service
public class LaundryService {

	private final LaundryMapper laundryMapper;
	private final UserMapper userMapper;
	private final LaundryListMapper laundryListMapper;

	public LaundryService(LaundryMapper laundryMapper, LaundryListMapper laundryListMapper,UserMapper userMapper) {
		this.laundryMapper = laundryMapper;
		this.laundryListMapper = laundryListMapper;
		this.userMapper = userMapper;
	}

	/*일반세탁소별 상품이름으로 사용중인 가격조회*/
	public List<Laundry> getLaundryGoodsNameAndPrice(String laundryName,String goodsName){
		List<Laundry> getLaundryGoodsNameAndPrice = laundryMapper.laundryGoodsNameAndPrice(goodsName, laundryName);
		return getLaundryGoodsNameAndPrice;
	}
	
	public List<LaundryList> LaundryList(String searchKey, String searchValue) {
		List<LaundryList> getLaundryList = laundryMapper.LaundryList(searchKey, searchValue);
		return getLaundryList;
	}

	public List<MuinMachienSpec> machineSpecList() {

		List<MuinMachienSpec> MachineSpecList = laundryMapper.machineSpecList();

		return MachineSpecList;
	}

	/* 세탁소 기간별 매출 */
	public List<LaundryList> laundryList(){
		
		
		List<LaundryList> laundryIncomeList = laundryListMapper.laundryList();

		return laundryIncomeList;
	}
	/* 세탁소 3개월 매출 */
	public List<LaundryList> Month3laundryList(){
				
		List<LaundryList> Month3laundryList = laundryListMapper.Month3laundryList();
		
		return Month3laundryList;
	}
	
	/* 세탁소 6개월 매출 */
	public List<LaundryList> Month6laundryList(){
				
		List<LaundryList> Month6laundryList = laundryListMapper.Month6laundryList();
		
		return Month6laundryList;
	}
	
	/* 세탁소 1년 매출 */
	public List<LaundryList> yearlaundryList(){
				
		List<LaundryList> yearlaundryList = laundryListMapper.yearlaundryList();
		
		return yearlaundryList;
	}
	
	
	public Map<String, Object> eachGoodsPriceList(int currentPage){
		
		int rowPerPage = 10;
		int startPageNum = 1;
		int endPageNum = 5;
		
		double rowCount = laundryMapper.GoodsPriceLookUpCount();
		int lastPage = (int) Math.ceil(rowCount / rowPerPage);
		int startRow = (currentPage - 1) * rowPerPage;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		List<Map<String, Object>> ilbangoodsPrice = laundryMapper.eachGoodsPriceList(paramMap);
		if (currentPage > 6) {
			startPageNum = currentPage - 5;
			endPageNum = currentPage + 4; // 자신 포함 / last-21페이지 픽스. 21-4 = 17부터는 움직이지않겠다. 17커런트로왔을때

			if (endPageNum >= lastPage) { // 17이상부터 클릭시 숫자가 늘어나지않고 고정되는 모습
				startPageNum = lastPage - 9; // 라스트페이지해당 21-9 = 12부터 고정시키겠다.
				endPageNum = lastPage;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lastPage", lastPage);
		resultMap.put("ilbangoodsPrice", ilbangoodsPrice);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);
		
		return resultMap;
		
	}
	
	/* 세탁소별 회원 목록 */
	public List<Delivery> LaundryUserList(){
	
		List<Delivery> LaundryUserList = userMapper.LaundryUserList();
		
		return LaundryUserList;
	}

}
