package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CuaHang;
import entity.KhachHang;

public class CuaHang_DAO {
	public ArrayList<CuaHang> getAllCuaHang() {
		ArrayList<CuaHang> dsCuaHang = new ArrayList<CuaHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from CuaHang";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsCuaHang.add(new CuaHang(rs.getString("maCH"), rs.getString("tenCuaHang"), rs.getString("diaChi"), rs.getString("sdt")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCuaHang;
	}
	
	public CuaHang getCuaHangTheoTen(String tenCH) {
		CuaHang ch = null;
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from CuaHang where tenCuaHang = N'"+tenCH+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				ch = new CuaHang(rs.getString("maCH"), rs.getString("tenCuaHang"), rs.getString("diaChi"), rs.getString("sdt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ch;
	}
}
