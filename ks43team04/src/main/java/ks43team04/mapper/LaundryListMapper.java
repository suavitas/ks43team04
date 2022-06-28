package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.LaundryList;

@Mapper
public interface LaundryListMapper {

	public List<LaundryList> laundryList();
	
	public List<LaundryList> Month3laundryList();
	
	public List<LaundryList> Month6laundryList();
	
	public List<LaundryList> yearlaundryList();
	
	
	
}
