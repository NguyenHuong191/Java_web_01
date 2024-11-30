package model;

public class Nganh {
	private int id;
	private String ten;
	private String loai;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public Nganh(int id, String ten, String loai) {
		super();
		this.id = id;
		this.ten = ten;
		this.loai = loai;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	
	

}
