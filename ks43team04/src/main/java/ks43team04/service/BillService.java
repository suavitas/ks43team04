package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Bill;
import ks43team04.dto.Bill2;
import ks43team04.mapper.BillMapper;

@Service
@Transactional
public class BillService {

	private final BillMapper billMapper;

	public BillService(BillMapper billMapper) {
		this.billMapper = billMapper;
	}
	
	/*결제내역 insert*/
	public int addBill2(Bill2 bill) {
		int result = billMapper.addBill2(bill);
		return result;
	}
	
	public int addBill(String memberId, String laundryCode, String totalPrice) {
		
		int addBill = billMapper.addBill(memberId, laundryCode, totalPrice);
		
		return addBill;
	}
	
	public List<Bill> getBillList() {

		List<Bill> BillList = billMapper.getBillList();

		return BillList;

	}
	
	public int getBillCount(String memberId){
		int getBillCount = billMapper.getBillCount(memberId);
		return getBillCount;
	}
	public List<Bill> laundryIncome(){
		List<Bill> laundryIncome = billMapper.laundryIncome();
		return laundryIncome;
	}
}
