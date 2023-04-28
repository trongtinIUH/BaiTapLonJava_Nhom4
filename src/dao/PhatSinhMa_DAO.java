package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import connectDB.ConnectDB;

public class PhatSinhMa_DAO {
	

	public String generateRandomKH() {
		String prefix = "KH";
		int maxNumber = 999;
		int randomNum = new Random().nextInt(maxNumber);
		String suffix = String.format("%03d", randomNum);
		return prefix + suffix;
	}
	
	public String generateRandomHopDong() {
		String prefix = "HD";
		int maxNumber = 999;
		int randomNum = new Random().nextInt(maxNumber);
		String suffix = String.format("%03d", randomNum);
		return prefix + suffix;
	}
	
	public String generateRandomChiTietHopDong() {
		String prefix = "CTHD";
		int maxNumber = 999;
		int randomNum = new Random().nextInt(maxNumber);
		String suffix = String.format("%03d", randomNum);
		return prefix + suffix;
	}

//	public String maKH() {
//		String makh="";
//		try {
//			ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "select CONCAT('KH', RIGHT(CONCAT('0000',ISNULL(right(max(maKH),4),0) + 1),4)) from KhachHang where maKH like 'KH%' ";
//		Statement stm = con.createStatement();
//		ResultSet rs = stm.executeQuery(sql);
//		while(rs.next())
//		{
//			makh = rs.getString(1);
//		}
//		} catch (SQLException e) {
//			// TODO: handle 
//			e.printStackTrace();
//		}
//		return makh;
//	}
//	
//	public String maCTHD() {
//		String macthd="";
//		try {
//			ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "select CONCAT('CTHD', RIGHT(CONCAT('0000',ISNULL(right(max(maChiTietHD),4),0) + 1),4)) from dbo.ChiTietHopDong where maChiTietHD like 'CTHD%' ";
//		Statement stm = con.createStatement();
//		ResultSet rs = stm.executeQuery(sql);
//		while(rs.next())
//		{
//			macthd = rs.getString(1);
//		}
//		} catch (SQLException e) {
//			// TODO: handle 
//			e.printStackTrace();
//		}
//		return macthd;
//	}
//	
//	public String maHD() {
//		String mahd="";
//		try {
//			ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "select CONCAT('HD', RIGHT(CONCAT('0000',ISNULL(right(max(maHD),4),0) + 1),4)) from dbo.HopDong where maHD like 'HD%' ";
//		Statement stm = con.createStatement();
//		ResultSet rs = stm.executeQuery(sql);
//		while(rs.next())
//		{
//			mahd = rs.getString(1);
//		}
//		} catch (SQLException e) {
//			// TODO: handle 
//			e.printStackTrace();
//		}
//		return mahd;
//	}
	

}

