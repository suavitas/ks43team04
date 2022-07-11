package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Bill;
import ks43team04.mapper.BillMapper;

@Service
@Transactional
public class OrderService {

	private final BillMapper billMapper;

	public OrderService(BillMapper billMapper) {
		this.billMapper = billMapper;
	}

	public List<Bill> ilbanOrderList(String memberId){
		
		List<Bill> ilbanOrderList = billMapper.ilbanOrderList(memberId);
		
		return ilbanOrderList;
	}
	

	
}
