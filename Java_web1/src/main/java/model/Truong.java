package model;

public class Truong {
	private int id;
	private String name;
	private String diaChi;
	private String sdt;
	
	public Truong(int id, String name, String diaChi, String sdt) {
		this.id = id;
		this.name = name;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	

}
