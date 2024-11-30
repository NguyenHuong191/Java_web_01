package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Nganh;


public class NganhDAO {
	private Connection conn;
	
	public NganhDAO() throws SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public List<Nganh> getAllNganh()  {
		List<Nganh> allNganh = new ArrayList<>();
		String query = "select * from java_web1.nganh";
             try {
            	 PreparedStatement pst = conn.prepareStatement(query);
                 ResultSet rs = pst.executeQuery();
                 while(rs.next()) {
                	 Nganh nganh = new Nganh(rs.getInt("MaNganh"), rs.getString("TenNganh"), rs.getString("LoaiNganh"));
                     allNganh.add(nganh);
                 }
                 } catch (SQLException e) {
                      e.printStackTrace();
                 }
			return allNganh;
	}
}
