package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Bill;
import ks43team04.mapper.PointMapper;

@Service
@Transactional
public class PointService {

	private PointMapper pointMapper;
	
	public PointService(PointMapper pointMapper) {
		this.pointMapper = pointMapper;
	}
	
	public List<Bill> getPointUseList(){
		List<Bill> getPointUseList = pointMapper.getPointUseList();
		return getPointUseList;
	}
}
