package DTO;

public class PositionDTO {
	private String MaCV;
	private String TenCV;
	public PositionDTO() {
		this.MaCV=null;
		this.TenCV=null;
	}
	public PositionDTO(String maCV, String tenCV) {
		super();
		MaCV = maCV;
		TenCV = tenCV;
	}
	public String getMaCV() {
		return MaCV;
	}
	public void setMaCV(String maCV) {
		MaCV = maCV;
	}
	public String getTenCV() {
		return TenCV;
	}
	public void setTenCV(String tenCV) {
		TenCV = tenCV;
	}
	
}
