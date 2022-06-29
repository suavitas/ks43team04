package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks43team04.dto.LaundryInfoSebu;
import ks43team04.mapper.LaundryInfoSebuMapper;

@Service
public class PayCompleteService {

	private final LaundryInfoSebuMapper laundryInfoSebuMapper;

	public PayCompleteService(LaundryInfoSebuMapper laundryInfoSebuMapper) {
		this.laundryInfoSebuMapper = laundryInfoSebuMapper;
	}

	public List<LaundryInfoSebu> laundryInfoSebu() {

		List<LaundryInfoSebu> laundryInfoSebu = laundryInfoSebuMapper.laundryInfoSebu();

		return laundryInfoSebu;
	}



}
