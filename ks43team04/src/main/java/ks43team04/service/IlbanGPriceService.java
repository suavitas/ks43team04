package ks43team04.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.IlbanGprice;
import ks43team04.mapper.IlbanGPriceMapper;

@Service
@Transactional
public class IlbanGPriceService {

	private final IlbanGPriceMapper ilbanGPriceMapper;

	public IlbanGPriceService(IlbanGPriceMapper ilbanGPriceMapper) {
		this.ilbanGPriceMapper = ilbanGPriceMapper;
	}

	/* 일반세탁소 가격  수정 */
	public int modifyGoodsPrice(IlbanGprice IlbanGprice) {
		int result = ilbanGPriceMapper.modifyGoodsPrice(IlbanGprice);
		System.out.println("______일반세탁소 가격을 수정하기 위한 서비스_____"+IlbanGprice);
		return result;
	}


}
