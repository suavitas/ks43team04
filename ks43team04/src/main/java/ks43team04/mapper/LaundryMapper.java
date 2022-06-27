package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.IlbanSkill;
import ks43team04.dto.Laundry;
import ks43team04.dto.LaundryList;
import ks43team04.dto.MuinMachienSpec;

@Mapper
public interface LaundryMapper {

	/* 세탁소 조회 */
	public List<LaundryList> LaundryList(String searchKey, String searchValue);
	public List<LaundryList> LaundryList();

	/* 무인 장비 스팩 */
	public List<MuinMachienSpec> machineSpecList();

	/* 일반 세탁소 튜플수 */
	public int ilbanLaundryCount();

	/* 무인 세탁소 튜플수 */
	public int muinLaundryCount();

	/* 전체 일반 세탁소 상품 가격 조회 */
	public List<Laundry> ilbanGoodsPriceList();
	
	/* 매장별 일반 세탁소 상품 가격 페이징 처리 */
	public List<Map<String, Object>> eachGoodsPriceList(Map<String, Object> paramMap);

	/* 매장별 일반 세탁소 상품 튜플수 */
	public int GoodsPriceLookUpCount();

	/* 일반세탁소 스킬 목록 */
	public List<IlbanSkill> ilbanSkillList();

}
