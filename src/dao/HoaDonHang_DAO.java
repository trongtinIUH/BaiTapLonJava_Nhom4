package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CuaHang;
import entity.HoaDonHang;

public class HoaDonHang_DAO {
	public ArrayList<HoaDonHang> getAllHoaDonHang() {
		ArrayList<HoaDonHang> dsHoaDonHang = new ArrayList<HoaDonHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from HoaDonHang";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsHoaDonHang.add(new HoaDonHang(rs.getString("maHDH"), new CuaHang(rs.getString("maCH")), rs.getDate("ngayGD")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDonHang;
	}
	
	public boolean addHoaDonHang(HoaDonHang p) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql ="insert into HoaDonHang(maHDH, maCH, ngayGD) VALUES(?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p.getMaHDH());
			pst.setString(2, p.getCh().getMaCH());
			pst.setDate(3, p.getNgayGD());
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public CuaHang getCuaHangTheoMaHoaDonHang(String HDH) {
		CuaHang ch = new CuaHang();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from CuaHang where maHDH='"+ HDH +"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				ch = new CuaHang(rs.getString("maCH"),rs.getString("tenCuaHang"), rs.getString("diaChi"), rs.getString("sdt"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ch;
	}
}
