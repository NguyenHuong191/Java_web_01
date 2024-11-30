package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Truong;

public class TruongDAO {
private Connection conn;
	
	public TruongDAO() throws SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public List<Truong> getAllTruong()  {
		List<Truong> allTruong = new ArrayList<>();
		String query = "select * from java_web1.truong";
             try {
            	 PreparedStatement pst = conn.prepareStatement(query);
                 ResultSet rs = pst.executeQuery();
                 while(rs.next()) {
                	 Truong truong = new Truong(rs.getInt("MaTruong"), rs.getString("TenTruong"), rs.getString("DiaChi"), rs.getString("SoDT"));
                	 allTruong.add(truong);
                 }
                 } catch (SQLException e) {
                      e.printStackTrace();
                 }
			return allTruong;
	}

}
