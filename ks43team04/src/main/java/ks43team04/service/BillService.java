package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Bill;
import ks43team04.mapper.BillMapper;

@Service
@Transactional
public class BillService {

	private final BillMapper billMapper;

	public BillService(BillMapper billMapper) {
		this.billMapper = billMapper;
	}

	public List<Bill> getBillList() {

		List<Bill> BillList = billMapper.getBillList();

		return BillList;

	}
	
	public int getBillCount(String memberId){
		int getBillCount = billMapper.getBillCount(memberId);
		return getBillCount;
	}
}
