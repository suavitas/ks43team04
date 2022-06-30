package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Bill;

@Mapper
public interface PointMapper {

		public List<Bill> getPointUseList();
}
