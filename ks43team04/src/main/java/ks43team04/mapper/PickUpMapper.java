package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.PickUp;

@Mapper
public interface PickUpMapper {
	
	//공지사항 목록 조회
	public List<PickUp> getPickUpList();
}