package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import ks43team04.dto.LaundryInfoSebu;
@Mapper
public interface PayCompleteMapper {

	/*test*/
	public List<LaundryInfoSebu> laundryInfoSebu();
}