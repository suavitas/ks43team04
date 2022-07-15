package ks43team04.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.MuinMachienSpec;

@Mapper
public interface MachineMapper {


	/* 세탁소별 매장 가격 수정 */
	public int modifyMachienSpec(MuinMachienSpec MuinMachienSpec);
	
	/*전체 장비 스팩 추가*/
	public int addMachienSpec(MuinMachienSpec muinMachienSpec);
	
	/*전체 장비 스팩 삭제*/
	public int removeMachienSpec(String MachineSpecCode);
	
	

}
