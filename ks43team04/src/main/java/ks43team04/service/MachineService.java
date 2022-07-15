package ks43team04.service;

import org.springframework.stereotype.Service;

import ks43team04.dto.MuinMachienSpec;
import ks43team04.mapper.MachineMapper;

@Service
public class MachineService {

	private final MachineMapper machineMapper;
	

	public MachineService(MachineMapper machineMapper) {
		this.machineMapper = machineMapper;

	}


	/* 전체 장비 스팩 수정 */
	public int modifyMachienSpec(MuinMachienSpec MuinMachienSpec) {
		int result = machineMapper.modifyMachienSpec(MuinMachienSpec);
		System.out.println("________전체 장비 스팩 수정 실행 서비스__________"+MuinMachienSpec);
		return result;
	}
	
	/*전체 장비 스팩 추가*/
	public int addMachienSpec(MuinMachienSpec muinMachienSpec){
		   int result = machineMapper.addMachienSpec(muinMachienSpec);
		   System.out.println("________전체 장비 스팩 추가 실행 서비스__________"+muinMachienSpec);
		return result;
	}
	/*전체 장비 스팩 삭제*/
	public int removeMachienSpec(String MachineSpecCode) {
		
		  int result = machineMapper.removeMachienSpec(MachineSpecCode);
		  System.out.println("________전체 장비 스팩 삭제 실행 서비스__________"+MachineSpecCode);
			return result;
	}
	
	
	
	
	
}
