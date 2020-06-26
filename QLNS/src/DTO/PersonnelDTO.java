/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Huy
 */
public class PersonnelDTO {
    private String MaNV;
    private String Hoten;
    private String NgaySinh;
    private String QueQuan;
    private String GioiTinh;
    private String DanToc;
    private String SDT;
    private String MaPB;
    private String MaCV;
    private String MaTDHV;
    private String BacLuong;
    private String CMND;

    public PersonnelDTO() {
    }

    public PersonnelDTO(String MaNV, String Hoten, String NgaySinh, String QueQuan, String GioiTinh, String DanToc, String SDT, String MaPB, String MaCV, String MaTDHV, String BacLuong,String CMND) {
        this.MaNV = MaNV;
        this.Hoten = Hoten;
        this.NgaySinh = NgaySinh;
        this.QueQuan = QueQuan;
        this.GioiTinh = GioiTinh;
        this.DanToc = DanToc;
        this.SDT = SDT;
        this.MaPB = MaPB;
        this.MaCV = MaCV;
        this.MaTDHV = MaTDHV;
        this.BacLuong = BacLuong;
        this.CMND= CMND;
    }

    public String getCMND() {
		return CMND;
	}

	public void setCMND(String CMND) {
		this.CMND = CMND;
	}

	public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDanToc() {
        return DanToc;
    }

    public void setDanToc(String DanToc) {
        this.DanToc = DanToc;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getMaTDHV() {
        return MaTDHV;
    }

    public void setMaTDHV(String MaTDHV) {
        this.MaTDHV = MaTDHV;
    }

    public String getBacLuong() {
        return BacLuong;
    }

    public void setBacLuong(String BacLuong) {
        this.BacLuong = BacLuong;
    }
    
    
}
