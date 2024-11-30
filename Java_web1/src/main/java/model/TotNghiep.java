package model;

import java.sql.Date;

public class TotNghiep {
	private String soCMND;
	private int maTruong;
	private int maNganh;
	private String heTN;
	private Date ngayTN;
	private String loaiTN;
	
	public TotNghiep(String soCMND, int maTruong, int maNganh, String heTN, Date ngayTn2, String loaiTN) {
		super();
		this.soCMND = soCMND;
		this.maTruong = maTruong;
		this.maNganh = maNganh;
		this.heTN = heTN;
		this.ngayTN = ngayTn2;
		this.loaiTN = loaiTN;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public int getMaTruong() {
		return maTruong;
	}
	public void setMaTruong(int maTruong) {
		this.maTruong = maTruong;
	}
	public int getMaNganh() {
		return maNganh;
	}
	public void setMaNganh(int maNganh) {
		this.maNganh = maNganh;
	}
	public String getHeTN() {
		return heTN;
	}
	public void setHeTN(String heTN) {
		this.heTN = heTN;
	}
	public Date getNgayTN() {
		return ngayTN;
	}
	public void setNgayTN(Date ngayTN) {
		this.ngayTN = ngayTN;
	}
	public String getLoaiTN() {
		return loaiTN;
	}
	public void setLoaiTN(String loaiTN) {
		this.loaiTN = loaiTN;
	}
	
	

}
