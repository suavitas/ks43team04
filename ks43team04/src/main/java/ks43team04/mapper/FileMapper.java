package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
	
	public void uploadFile(List<Map<String, String>> dtoFileList);

	public void uploadRelationFile(List<Map<String, String>> relationFileList);
	
	// 게시판, 파일 릴레이션 테이블 삽입
	public void uploadRelationFileWithBoard(List<Map<String, String>> relationFileList);

}
