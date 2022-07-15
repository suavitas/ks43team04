package ks43team04.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.MuinMachienSpec;

@Mapper
public interface MachineMapper {


	/* 세탁소별 매장 가격 수정 */
	public int modifyMachienSpec(MuinMachienSpec MuinMachienSpec);
	
	/**/

}
