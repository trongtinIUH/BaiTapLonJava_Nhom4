package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHopDong;
import entity.CuaHang;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVien;

public class HopDong_DAO {
	public boolean update(HopDong hd) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update HopDong set ngayLapHD=?, thoiGianBH=?, loaiHD=?, maNV=?, maCH=?, maKH=? where maHD =? ");
			
			stmt.setDate(1, (Date) hd.getNgaylapHD());
			stmt.setInt(2, hd.getThoiGianBH());
			stmt.setString(3, hd.getLoaiHD());
			stmt.setString(4, hd.getNvLapHD().getMaNV());
			stmt.setString(5, hd.getCuaHang().getMaCH());
			stmt.setString(6, hd.getKhachHang().getMaKH());
//			stmt.setString(7, hd.getCtHD().getMaChiTietHD());
			n = stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
		return n>0;
	}
	
	public boolean createHD(HopDong hd)  {
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert into HopDong values (?,?,?,?,?,?,?)  ");
			stmt.setString(1, hd.getMaHD());
			stmt.setDate(2, (Date) hd.getNgaylapHD());;
			stmt.setInt(3, hd.getThoiGianBH());
			stmt.setString(4, hd.getLoaiHD());
			stmt.setString(5,hd.getNvLapHD().getMaNV());
			stmt.setString(6, hd.getCuaHang().getMaCH());
			stmt.setString(7, hd.getKhachHang().getMaKH());
			n = stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
		return n>0;
	}
	
	public boolean xoaHD(String maHD) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("delete HopDong where maHD =? ");
			stmt.setString(1, maHD);
			n = stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public ArrayList<HopDong> getAllHopDong(){
		ArrayList<HopDong> dsHD = new ArrayList<HopDong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HopDong";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				Date ngaylap =  rs.getDate(2);
				int thoiGianBG = rs.getInt(3);
				String loaiHD = rs.getString(4);
				NhanVien nv = new NhanVien(rs.getString(5));
				CuaHang ch = new CuaHang(rs.getString(6));
				KhachHang kh = new KhachHang(rs.getString(7));
				HopDong hd = new HopDong(maHD, ngaylap, thoiGianBG, loaiHD, nv, ch, kh);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsHD;
	}
	
//	public ArrayList<HoaDon> getHDTheoMaKH(String maKH){
//		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
//		
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			String sql = "select * from HoaDon where  maKh = '"+maKH+"'";
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//				String maHD = rs.getString(1);
//				Date ngaylap =  rs.getDate(2);
//				NhanVien nv = new NhanVien(rs.getString(3));
//				KhachHang kh = new KhachHang(rs.getString(4));
//				ChiTietHoaDon ct = new ChiTietHoaDon(rs.getString(5));
//				HoaDon hd = new HoaDon(maHD, ngaylap, nv, kh, ct);
//				dsHD.add(hd);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		return dsHD;
//	}
}