package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Student;
import model.TotNghiep;

public class AddStudentDAO {
	private Connection conn;
	
	public AddStudentDAO() throws SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	public int getTruongId(String name) {
		String query = "select MaTruong from java_web1.truong where TenTruong = ?";
             try {
            	 PreparedStatement pst = conn.prepareStatement(query);
                 pst.setString(1, name);
                 ResultSet rs = pst.executeQuery();
                 while(rs.next()) {
                	 int idTruong = rs.getInt("MaTruong");
                	 System.out.println("db"+idTruong);
                	 return idTruong;
                 }
                 } catch (SQLException e) {
                      e.printStackTrace();
                 }
			return -1;
	}
	
	public int getNganhId(String name) {
		String query = "select MaNganh from java_web1.nganh where TenNganh = ?";
             try {
            	 PreparedStatement pst = conn.prepareStatement(query);
                 pst.setString(1, name);
                 ResultSet rs = pst.executeQuery();
                 while(rs.next()) {
                	 int idNganh = rs.getInt("MaNganh");
                	 System.out.println("db nganh"+idNganh);
                	 return idNganh;
                 }
                 } catch (SQLException e) {
                      e.printStackTrace();
                 }
			return -1;
	}
	
	public boolean isSinhVienExist(String soCMND) {
        String query = "SELECT COUNT(*) FROM java_web1.sinh_vien WHERE SoCMND = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, soCMND);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                return true;  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

	public boolean insertSvien(Student student) {
		boolean isAdded = false;
		
        String query = "INSERT INTO java_web1.sinh_vien(SoCMND, HoTen, Email, SoDT, DiaChi) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, student.getSoCMND());
            pst.setString(2, student.getHoTen());
            pst.setString(3, student.getEmail());
            pst.setString(4, student.getSoDth());
            pst.setString(5, student.getDiaChi());
            int result = pst.executeUpdate();
            if (result > 0) {
                isAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
	}
	
	public boolean insertTotNghiep(TotNghiep totNghiep) {
		boolean isAdded = false;
		String tt = totNghiep.getSoCMND();
		int tt1= totNghiep.getMaTruong();
		int tt2= totNghiep.getMaNganh();
        String tt4 = totNghiep.getHeTN();
        Date tt5 = totNghiep.getNgayTN() ;
        String tt6=  totNghiep.getLoaiTN() ;
        System.out.println(tt);
        System.out.println(tt1);
        System.out.println(tt2);
        System.out.println(tt4);
        System.out.println(tt5);
        System.out.println(tt6);
		
		String query = "INSERT INTO java_web1.tot_nghiep(SoCMND, MaTruong, MaNganh, HeTN, NgayTN,LoaiTN) VALUES (?,?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, totNghiep.getSoCMND() );
            pst.setInt(2, totNghiep.getMaTruong() );
            pst.setInt(3, totNghiep.getMaNganh() );
            pst.setString(4, totNghiep.getHeTN() );
            pst.setDate(5, totNghiep.getNgayTN() );
            pst.setString(6, totNghiep.getLoaiTN() );
            
            int result = pst.executeUpdate();
            if (result > 0) {
                isAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
	}
}
