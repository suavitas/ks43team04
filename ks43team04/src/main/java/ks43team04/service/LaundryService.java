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
	
	

	/* 세탁소별 회원 목록 */
	public List<Delivery> LaundryUserList(){
	
		List<Delivery> LaundryUserList = userMapper.LaundryUserList();
		
		return LaundryUserList;
	}

}
