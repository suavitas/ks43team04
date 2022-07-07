package ks43team04.dto;



public class BoardAttach {

	private String fileIdx;
	private String originFile;
	private String saveFile;
	private String fileSize;
	private String filePath;
	private String representImg;
	private String uploadId;
	private String uploadTime;
	private String delYn;
	

	
	
	public String getFileIdx() {
		return fileIdx;
	}
	public void setFileIdx(String fileIdx) {
		this.fileIdx = fileIdx;
	}
	public String getOriginFile() {
		return originFile;
	}
	public void setOriginFile(String originFile) {
		this.originFile = originFile;
	}
	public String getSaveFile() {
		return saveFile;
	}
	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getRepresentImg() {
		return representImg;
	}
	public void setRepresentImg(String representImg) {
		this.representImg = representImg;
	}
	public String getUploadId() {
		return uploadId;
	}
	public void setUploadId(String uploadId) {
		this.uploadId = uploadId;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	

	@Override
	public String toString() {
		return "BoardAttach [fileIdx=" + fileIdx + ", originFile=" + originFile + ", saveFile=" + saveFile
				+ ", fileSize=" + fileSize + ", filePath=" + filePath + ", representImg=" + representImg + ", uploadId="
				+ uploadId + ", uploadTime=" + uploadTime + ", delYn=" + delYn + ", relFileWithBoard="
				+ "]";
	}
	
	
	
}
