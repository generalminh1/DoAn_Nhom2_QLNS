package DTO;

public class SalaryDTO {
	private String MaBL;
	private float SoTien;
	public SalaryDTO() {
		
	}
	public SalaryDTO(String maBL, float soTien) {
		this.MaBL = maBL;
		this.SoTien = soTien;
	}
	public String getMaBL() {
		return MaBL;
	}
	public void setMaBL(String maBL) {
		this.MaBL = maBL;
	}
	public float getSoTien() {
		return SoTien;
	}
	public void setSoTien(float soTien) {
		this.SoTien = soTien;
	}
	
}
