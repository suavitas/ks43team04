package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Bill;

@Mapper
public interface PointMapper {
		/* 포인트 사용내역 */
		public List<Bill> getPointUseList();
		
		/*포인트사용 결제 횟수*/
		public List<Bill> getPointUseCount();
}
