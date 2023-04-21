package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.MatHang;

public class MatHang_DAO {
	public ArrayList<MatHang> getAllMatHang() {
		ArrayList<MatHang> dsMatHang = new ArrayList<MatHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from MatHang";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsMatHang.add(new MatHang(rs.getString("maMH"), rs.getString("tenMH"), rs.getString("dvt"), rs.getString("moTa"), rs.getDouble("donGia"), rs.getInt("slTon"), rs.getString("loaiMH")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsMatHang;
		
	}
	
	public MatHang getMatHangTheoTen(String tenMh) {
		MatHang mh = null;
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from MatHang where tenMH = N'"+tenMh+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				mh = new MatHang(rs.getString("maMH"), rs.getString("tenMH"), rs.getString("dvt"), rs.getString("moTa"), rs.getDouble("donGia"), rs.getInt("slTon"), rs.getString("loaiMH"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mh;
		
	}
}
