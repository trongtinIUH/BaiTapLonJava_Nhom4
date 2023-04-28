package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CuaHang;
import entity.KhachHang;
import entity.NhanVien;

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
	
	public CuaHang getCHTheoMa (String id) {
		CuaHang ch = new CuaHang();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from CuaHang where maCH = '" + id + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ch = new CuaHang(rs.getString("maCH"), rs.getString("tenCuaHang"), rs.getString("diaChi"), rs.getString("sdt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (ch.getMaCH() == null)
			return null;
		return ch;
	}
}
