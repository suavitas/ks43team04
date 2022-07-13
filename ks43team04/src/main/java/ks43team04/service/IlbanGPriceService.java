package ks43team04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> eachGoodsPriceList(int currentPage){
		
		int rowPerPage = 10;
		int startPageNum = 1;
		int endPageNum = 5;
		
		double rowCount = ilbanGPriceMapper.GoodsPriceLookUpCount();
		int lastPage = (int) Math.ceil(rowCount / rowPerPage);
		int startRow = (currentPage - 1) * rowPerPage;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		List<Map<String, Object>> ilbangoodsPrice = ilbanGPriceMapper.eachGoodsPriceList(paramMap);
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
	


}
