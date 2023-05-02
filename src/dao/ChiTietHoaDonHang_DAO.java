package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDonHang;
import entity.HoaDonHang;
import entity.MatHang;

public class ChiTietHoaDonHang_DAO {
	public ArrayList<ChiTietHoaDonHang> getAllChiTietHoaDonHang() {
		ArrayList<ChiTietHoaDonHang> dsChiTietHoaDonHang = new ArrayList<ChiTietHoaDonHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietHoaDonHang";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				HoaDonHang HDH = new HoaDonHang(rs.getString(1));
				MatHang m = new MatHang(rs.getString(2));
				int soluong = rs.getInt(3);
				ChiTietHoaDonHang cthdh = new ChiTietHoaDonHang(HDH, m, soluong);
				dsChiTietHoaDonHang.add(cthdh);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsChiTietHoaDonHang;
	}
	
	public ArrayList<ChiTietHoaDonHang> getChiTietHoaDonHangTheoMa(String maHDH) {
		ArrayList<ChiTietHoaDonHang> dsChiTietHoaDonHang = new ArrayList<ChiTietHoaDonHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietHoaDonHang where maHDH='"+ maHDH +"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				HoaDonHang HDH = new HoaDonHang(rs.getString(1));
				MatHang m = new MatHang(rs.getString(2));
				int soluong = rs.getInt(3);
				ChiTietHoaDonHang cthdh = new ChiTietHoaDonHang(HDH, m, soluong);
				dsChiTietHoaDonHang.add(cthdh);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsChiTietHoaDonHang;
	}
	
	public boolean createHDH(ChiTietHoaDonHang cthdh) {
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietHoaDonHang values (?,?,?)  ");
			stmt.setString(1, cthdh.getHdh().getMaHDH());
			stmt.setString(2, cthdh.getMh().getMaMH());
			stmt.setInt(3, cthdh.getSoLuong());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}

		}
		return n > 0;
	}
}
