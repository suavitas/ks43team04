package ks43team04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ks43team04.mapper.SearchMapMapper;
import ks43team04.dto.LaundryList;

@Service
@Transactional
public class SearchMapService {

	private static final Logger log = LoggerFactory.getLogger(SearchMapService.class);
	private final SearchMapMapper searchMapMapper;

	public SearchMapService(SearchMapMapper searchMapMapper) {
			this.searchMapMapper = searchMapMapper;
		}

	/* 시설 검색 */
	public Map<String, Object> getSearchList(String searchKey, String searchValue, int currentPage) {
		int rowPerPage = 10;

		double rowCount = searchMapMapper.getSearchCount();

		int lastPage = (int) Math.ceil(rowCount / rowPerPage);

		int startRow = (currentPage - 1) * rowPerPage;

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("startRow", startRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);

		int startPageNum = 1;
		int endPageNum = 10;

		if (lastPage > 10) {
			if (currentPage >= 6) {
				startPageNum = currentPage - 4;
				endPageNum = currentPage + 5;

				if (endPageNum >= lastPage) {
					startPageNum = lastPage - 9;
					endPageNum = lastPage;
				}
			}
		} else {
			endPageNum = lastPage;
		}

		log.info("paramMap : {}", paramMap);

		List<Map<String, Object>> searchMapList = searchMapMapper.getSearchList(paramMap);

		if (searchMapList != null) {
			// 향상된 for문
			for (Map<String, Object> LaundryList : searchMapList) {
				String mainCtgCd = LaundryList.get("mainCtgCd").toString();
				if (mainCtgCd != null) {
					if ("gg".equals(mainCtgCd)) {
						LaundryList.put("mainCtgCd", "무인세탁소");
					} else if ("ss".equals(mainCtgCd)) {
						LaundryList.put("mainCtgCd", "일반세탁소");
					}
				}
			}

		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lastPage", lastPage);
		resultMap.put("searchMapList", searchMapList);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);
		return resultMap;
	}
}
