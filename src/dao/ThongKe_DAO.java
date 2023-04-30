package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import connectDB.ConnectDB;


public class ThongKe_DAO {

	public int  getAllKhachHang() {
		 int so_kh = 0;
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select count(*) as so_kh from khachhang ";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				so_kh = rs.getInt("so_kh");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return so_kh;
		
	}
	
	public int  getAllSanPham() {
		 int so_sp = 0;
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select count(*) as so_sp from MatHang ";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				so_sp = rs.getInt("so_sp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return so_sp;
		
	}
	
	public int  getAllNhanVien() {
		 int so_nv = 0;
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select count(*) as so_nv from NhanVien ";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				so_nv = rs.getInt("so_nv");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return so_nv;
		
	}
	
	public double  getAllMoney() {
		 double doanh_thu = 0;
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "SELECT SUM(soTienTra) AS doanhthu  FROM (SELECT soTienTra FROM TraGop UNION ALL SELECT soTienTra FROM TraTrucTiep) AS TongHop";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				doanh_thu = rs.getDouble("doanhthu");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doanh_thu;
		
	}
}
