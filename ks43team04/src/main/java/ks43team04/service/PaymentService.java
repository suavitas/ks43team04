package ks43team04.service;

import org.springframework.stereotype.Service;

import ks43team04.dto.PayMember;
import ks43team04.mapper.PaymentMapper;

@Service
public class PaymentService {
	private final PaymentMapper paymentMapper;
		
		public PaymentService(PaymentMapper paymentMapper) {
			this.paymentMapper = paymentMapper;
		}

	//회원 상세정보 조회
		public PayMember getPayMInfo(String memberId) {
			return paymentMapper.getPayMInfo(memberId);
		}

}
