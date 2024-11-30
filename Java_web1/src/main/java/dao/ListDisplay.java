package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Infor;
import model.Student;

public class ListDisplay {
private Connection conn;
	
	public ListDisplay() throws SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public List<Student> getAllStudent(){
		List<Student> listStudent = new ArrayList<>();
		
		try {
			String query = "select * from java_web1.sinh_vien";
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Student student = new Student(
						rs.getString("SoCMND"), 
						rs.getString("HoTen"), 
						rs.getString("Email"), 
						rs.getString("SoDT"), 
						rs.getString("DiaChi"));
				listStudent.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listStudent;
	}
	
	public List<Infor> getAllInfor(){
		List<Infor> listInfor = new ArrayList<>();
		
		try {
			String query = "\r\n"
					+ "select \r\n"
					+ "    sv.SoCMND, \r\n"
					+ "    sv.HoTen, \r\n"
					+ "    n.TenNganh as MaNganhTN, \r\n"
					+ "    t.TenTruong as MaTruong, \r\n"
					+ "    cv.TenCongViec as MaNganhCty, \r\n"
					+ "    cv.TenCongTy, \r\n"
					+ "    cv.ThoiGianLamViec\r\n"
					+ "from \r\n"
					+ "    java_web1.sinh_vien sv\r\n"
					+ "inner join \r\n"
					+ "    java_web1.tot_nghiep tn on sv.SoCMND = tn.SoCMND\r\n"
					+ "inner join \r\n"
					+ "    java_web1.truong t on tn.MaTruong = t.MaTruong\r\n"
					+ "inner join \r\n"
					+ "    java_web1.nganh n on tn.MaNganh = n.MaNganh\r\n"
					+ "inner join \r\n"
					+ "    java_web1.cong_viec cv on sv.SoCMND = cv.SoCMND";
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				String tgianLam = rs.getString("ThoiGianlamViec");
			    
			    if (tgianLam == null) {
			        tgianLam = "Chưa cập nhật"; 
			    }
				Infor infor = new Infor(
						rs.getString("SoCMND"), 
						rs.getString("HoTen"), 
						rs.getString("MaNganhTN"), 
						rs.getString("MaTruong"), 
						rs.getString("MaNganhCty"), 
						rs.getString("TenCongTy"),
						tgianLam
						);
				listInfor.add(infor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listInfor;
	}

}
