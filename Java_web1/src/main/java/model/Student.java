package model;

import java.util.List;

public class Student {
	private String soCMND;
	private String hoTen;
	private String email;
	private String soDth;
	private String diaChi;

	public Student(String soCMND, String hoTen, String email, String soDth, String diaChi) {
		this.soCMND = soCMND;
		this.hoTen = hoTen;
		this.email = email;
		this.soDth = soDth;
		this.diaChi = diaChi;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDth() {
		return soDth;
	}
	public void setSoDth(String soDth) {
		this.soDth = soDth;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	

}
