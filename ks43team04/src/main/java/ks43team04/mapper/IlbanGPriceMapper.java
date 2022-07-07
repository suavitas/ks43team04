package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.IlbanSkill;

@Mapper
public interface IlbanGPriceMapper {
	
	/* 세탁소별 매장 가격을 추가하기 위한 스킬리스트 */
	public List<IlbanSkill> IlbanSkill();

	/* 세탁소별 매장 가격 추가 */
	public int addGoodsPrice(String ilbanSkillCode, String gName, String gPrice);
	
	
}
