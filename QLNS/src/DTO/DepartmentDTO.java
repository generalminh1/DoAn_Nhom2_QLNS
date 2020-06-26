package DTO;

public class DepartmentDTO {
	private String MaPB;
	private String TenPB;
	
	public DepartmentDTO(String maPB, String tenPB) {
		this.MaPB = maPB;
		this.TenPB = tenPB;
	}
	public DepartmentDTO() {
		this.MaPB=null;
		this.TenPB=null;
	}
	public String getMaPB() {
		return MaPB;
	}
	public void setMaPB(String maPB) {
		this.MaPB = maPB;
	}
	public String getTenPB() {
		return TenPB;
	}
	public void setTenPB(String tenPB) {
		this.TenPB = tenPB;
	}
	
}
