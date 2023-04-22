package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.MatHang;
import entity.Xe;

public class Xe_DAO {
	public ArrayList<Xe> getAllXe() {
		ArrayList<Xe> dsXe = new ArrayList<Xe>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from Xe JOIN MatHang on maXe = maMH";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsXe.add(new Xe(rs.getString("maMH"), rs.getString("tenMH"), rs.getString("dvt"), rs.getString("moTa"), rs.getDouble("donGia"), rs.getInt("slTon"), rs.getString("loaiMH"), rs.getString("maXe")
						, rs.getString("dongXe"), rs.getString("soKhung"), rs.getString("mauXe"), rs.getInt("soPK"), rs.getString("soSuon"), rs.getString("xuatXu")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsXe;
		
	}
	
	public Xe getXeTheoTen(String tenMH) {
		Xe xe = null;
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from Xe JOIN MatHang on maXe = maMH where tenMH = N'"+tenMH+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				xe = new Xe(rs.getString("maMH"), rs.getString("tenMH"), rs.getString("dvt"), rs.getString("moTa"), rs.getDouble("donGia"), rs.getInt("slTon"), rs.getString("loaiMH"), rs.getString("maXe")
						, rs.getString("dongXe"), rs.getString("soKhung"), rs.getString("mauXe"), rs.getInt("soPK"), rs.getString("soSuon"), rs.getString("xuatXu"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xe;
		
	}
	
	
	//LoadData tên Xe lên ComboBox Dòng xe
	public String getDongXeTheoTenXe(String tenXe){
		String dongXe ="";
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select dongXe from xe JOIN MatHang ON maXe = maMH where tenMH = N'"+tenXe+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dongXe = rs.getString("dongXe");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dongXe;
	}
	
	//Lấy số lượng tồn từ tên xe
		public int getSoLuongTheoTenXe(String tenXe){
			int soLuongTon=0;
			try {
				ConnectDB.getInstance();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con = ConnectDB.getConnection();
			try {
				String sql = "select slTon from xe JOIN MatHang ON maXe = maMH where tenMH = N'"+tenXe+"'";
				Statement sta = con.createStatement();
				ResultSet rs = sta.executeQuery(sql);
				while(rs.next()) {
					soLuongTon = rs.getInt("slTon");
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return soLuongTon;
		}
}
