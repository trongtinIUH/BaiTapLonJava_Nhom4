package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;
import entity.LinhKienPhuTung;

public class LinhKien_DAO {
	public boolean addLinhKien(LinhKienPhuTung lk) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql ="insert into LinhKienPhuTung(maLinhKien, hangSX) VALUES(?,?)";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, lk.getMaLinhKien());
			pst.setString(2, lk.getHangSX());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public LinhKienPhuTung getLinhKienTheoTen(String tenMH) {
		LinhKienPhuTung lk = new LinhKienPhuTung();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LinhKienPhuTung join MatHang on maLinhKien=maMH where tenMH = N'"+tenMH+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maLinhKien");
				String hangSX = rs.getString("hangSX");
				lk = new LinhKienPhuTung(ma, hangSX);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lk;
		
	}
	
	public LinhKienPhuTung getLinhKienTheoMa(String maLK) {
		LinhKienPhuTung lk = new LinhKienPhuTung();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LinhKienPhuTung where maLinhKien = '" +maLK+ "'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maLinhKien");
				String hangSX = rs.getString("hangSX");
				lk = new LinhKienPhuTung(ma, hangSX);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(lk.getMaLinhKien() == null)
			return null;
		return lk;
		
	}
}
