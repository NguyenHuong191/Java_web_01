package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Infor;
import model.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDAO {
	private Connection conn;
	
	public SearchDAO() throws SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public List<Student> getSearchStudent(String textSearch){
		List<Student> listStudentSearch = new ArrayList<>();
		
		try {
			String query = "SELECT SoCMND, HoTen, Email, SoDT, DiaChi \r\n"
					+ "FROM java_web1.sinh_vien \r\n"
					+ "WHERE SoCMND LIKE ? OR HoTen LIKE ? OR Email LIKE ? OR SoDT LIKE ? OR DiaChi LIKE ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, textSearch);
			pstm.setString(2, textSearch);
			pstm.setString(3, textSearch);
			pstm.setString(4, textSearch);
			pstm.setString(5, textSearch);
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Student student = new Student(
						rs.getString("SoCMND"), 
						rs.getString("HoTen"), 
						rs.getString("Email"), 
						rs.getString("SoDT"), 
						rs.getString("DiaChi"));
				listStudentSearch.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listStudentSearch;
	}
	
	public List<Infor> getSearchInfor(String textSearch){
		List<Infor> listInforSearch = new ArrayList<>();
		
		try {
			String query = "select \r\n"
					+ "    sv.SoCMND, \r\n"
					+ "    sv.HoTen, \r\n"
					+ "    n.TenNganh, \r\n"
					+ "    t.TenTruong, \r\n"
					+ "    cv.TenCongViec, \r\n"
					+ "    cv.TenCongTy, \r\n"
					+ "    cv.ThoiGianLamViec\r\n"
					+ "from  java_web1.sinh_vien sv\r\n"
					+ "inner join java_web1.tot_nghiep tn on sv.SoCMND = tn.SoCMND\r\n"
					+ "inner join java_web1.truong t on tn.MaTruong = t.MaTruong\r\n"
					+ "inner join java_web1.nganh n on tn.MaNganh = n.MaNganh\r\n"
					+ "inner join java_web1.cong_viec cv on sv.SoCMND = cv.SoCMND\r\n"
					+ "where  sv.SoCMND like ? or\r\n"
					+ "       sv.HoTen like ? or\r\n"
					+ "       n.TenNganh like ? or\r\n"
					+ "       t.TenTruong like ? or\r\n"
					+ "       cv.TenCongViec like ? or\r\n"
					+ "       cv.TenCongTy like ? or\r\n"
					+ "       cv.ThoiGianLamViec like ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, textSearch);
			pstm.setString(2, textSearch);
			pstm.setString(3, textSearch);
			pstm.setString(4, textSearch);
			pstm.setString(5, textSearch);
			pstm.setString(6, textSearch);
			pstm.setString(7, textSearch);			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
                String tgianLam = rs.getString("ThoiGianlamViec");
			    
			    if (tgianLam == null) {
			        tgianLam = "Chưa cập nhật"; 
			    }
				Infor infor = new Infor(
						rs.getString("SoCMND"), 
						rs.getString("HoTen"), 
						rs.getString("TenNganh"), 
						rs.getString("TenTruong"), 
						rs.getString("TenCongViec"), 
						rs.getString("TenCongTy"), 
						tgianLam);
				listInforSearch.add(infor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listInforSearch;
	}

}
