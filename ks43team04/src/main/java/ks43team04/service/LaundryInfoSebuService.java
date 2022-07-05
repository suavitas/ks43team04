package ks43team04.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.LaundryInfoSebu;
import ks43team04.mapper.LaundryInfoSebuMapper;

@Service
@Transactional
public class LaundryInfoSebuService {

	private final LaundryInfoSebuMapper laundryInfoSebuMapper;

	public LaundryInfoSebuService(LaundryInfoSebuMapper laundryInfoSebuMapper) {
		this.laundryInfoSebuMapper = laundryInfoSebuMapper;
	}
	public List<LaundryInfoSebu> laundryInfoSebu() {
		List<LaundryInfoSebu> laundryInfoSebu = laundryInfoSebuMapper.laundryInfoSebu();
		return laundryInfoSebu;
	}
	public List<LaundryInfoSebu> getLaundryInfoSebu(HashMap<String, String> search) {
		List<LaundryInfoSebu> laundryInfo = laundryInfoSebuMapper.getLaundryInfoSebu(search);
		return laundryInfo;
	}



}
