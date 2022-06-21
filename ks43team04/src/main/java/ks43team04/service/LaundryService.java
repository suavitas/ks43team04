package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks43team04.dto.LaundryList;
import ks43team04.dto.MuinMachienSpec;
import ks43team04.mapper.LaundryMapper;

@Service
public class LaundryService {

	private final LaundryMapper laundryMapper;
	
	public LaundryService(LaundryMapper laundryMapper) {	
		this.laundryMapper = laundryMapper;		
	}
	
	 public List<LaundryList> LaundryList(String searchKey, String searchValue){
			List<LaundryList> getLaundryList = laundryMapper.LaundryList(searchKey, searchValue);
			return getLaundryList;
	 }
	 
		
	public List<MuinMachienSpec> machineSpecList(){
			
		List<MuinMachienSpec> MachineSpecList = laundryMapper.machineSpecList();
			
		return MachineSpecList;
	}
	
	
}
