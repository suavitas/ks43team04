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
	
	
}
