package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.LinhKienPhuTung;

public class LinhKien_DAO {
	public boolean addLinhKien(LinhKienPhuTung lk) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql ="insert into LinhKienPhuTung(maLinhKien, hangSX) VALUES(?,?)";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, lk.getMaMH());
			pst.setString(2, lk.getHangSX());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
