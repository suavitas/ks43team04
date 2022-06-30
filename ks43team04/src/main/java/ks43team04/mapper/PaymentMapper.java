package ks43team04.mapper;
import org.apache.ibatis.annotations.Mapper;
import ks43team04.dto.PayMember;
@Mapper
public interface PaymentMapper {
	/* 회원 정보 가져오기 */
	public PayMember getPayMInfo(String memberId);


}