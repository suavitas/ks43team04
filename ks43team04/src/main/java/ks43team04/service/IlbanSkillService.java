package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.IlbanSkill;
import ks43team04.mapper.IlbanGPriceMapper;

@Service
@Transactional
public class IlbanSkillService {

	private final IlbanGPriceMapper ilbanGPriceMapper;

	public IlbanSkillService(IlbanGPriceMapper ilbanGPriceMapper) {
		this.ilbanGPriceMapper = ilbanGPriceMapper;
	}

	public List<IlbanSkill> IlbanSkill() {

		List<IlbanSkill> IlbanSkill = ilbanGPriceMapper.IlbanSkill();
		System.out.println("______일반 스킬 리스트 서비스________"+IlbanSkill);

		return IlbanSkill;

	}

	public int addGoodsPrice(String skillCate, String gName, String gPrice) {

		int result = ilbanGPriceMapper.addGoodsPrice(skillCate, gName, gPrice);

		return result;
	}

}
