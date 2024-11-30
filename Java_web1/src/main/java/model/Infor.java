package model;

public class Infor {
	private String SoCMND;
	private String HoTen;
	private String MaNganhTN;
	private String MaTruong;
	private String MaNganhCty;
	private String tenCty;
	private String tgianLam;
		
		public Infor(String SoCMND, String HoTen, String MaNganhTN, String MaTruong, String MaNganhCty, String tenCty,
				String tgianLam) {
			this.SoCMND = SoCMND;
			this.HoTen = HoTen;
			this.MaNganhTN = MaNganhTN;
			this.MaTruong = MaTruong;
			this.MaNganhCty = MaNganhCty;
			this.tenCty = tenCty;
			this.tgianLam = tgianLam;
		}

		public String getSoCMND() {
			return SoCMND;
		}

		public void setSoCMND(String soCMND) {
			this.SoCMND = soCMND;
		}

		public String getHoTen() {
			return HoTen;
		}

		public void setHoTen(String hoTen) {
			this.HoTen = hoTen;
		}

		public String getMaNganhTN() {
			return MaNganhTN;
		}

		public void setMaNganhTN(String MaNganhTN) {
			this.MaNganhTN = MaNganhTN;
		}

		public String getMaTruong() {
			return MaTruong;
		}

		public void setMaTruong(String maTruong) {
			this.MaTruong = maTruong;
		}

		public String getMaNganhCty() {
			return MaNganhCty;
		}

		public void setMaNganhCty(String maNganhCty) {
			this.MaNganhCty = maNganhCty;
		}

		public String getTenCty() {
			return tenCty;
		}

		public void setTenCty(String tenCty) {
			this.tenCty = tenCty;
		}

		public String getTgianLam() {
			return tgianLam;
		}

		public void setTgianLam(String tgianLam) {
			this.tgianLam = tgianLam;
		}
		
		public String toString() {
	        return "Infor{" +
	                "SoCMND='" + SoCMND + '\'' +
	                ", HoTen='" + HoTen + '\'' +
	                ", MaNganhTN='" + MaNganhTN + '\'' +
	                ", MaTruong='" + MaTruong + '\'' +
	                ", MaNganhCty='" + MaNganhCty + '\'' +
	                ", tenCty='" + tenCty + '\'' +
	                ", tgianLam='" + tgianLam + '\'' +
	                '}';
	    }
		
		

	}


