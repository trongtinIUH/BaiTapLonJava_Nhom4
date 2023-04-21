package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {

	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsNhanVien.add(new NhanVien(rs.getString("maNV"), rs.getString("tenNV"), rs.getString("gioiTinh"), rs.getString("diaChi"), 
						rs.getString("sdt"), rs.getString("email"), rs.getDate("ngayVaoLam"), rs.getString("chucVu"),rs.getFloat("luongCoBan"), rs.getString("maCH")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
		
	}
	
	
	//LoadData to ComboBox MaNhanVien
//	public ArrayList<NhanVien> getAllNNhanVienBanHang(){
//		ArrayList<NhanVien> dsTenNV = new ArrayList<NhanVien>();
//		try {
//			ConnectDB.getInstance();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Connection con = ConnectDB.getConnection();
//		try {
//			String sql = "select tenNV,chucVu,sdt from NhanVien where chucVu = N'"+"Nhân viên bán hàng"+"'";
//			Statement sta = con.createStatement();
//			ResultSet rs = sta.executeQuery(sql);
//			while(rs.next()) {
//				String tenNV = rs.getString("tenNV");
//				String chucVu = rs.getString("chucVu");
//				String soDt = rs.getString("sdt");
//				NhanVien nv = new NhanVien(tenNV,chucVu,soDt);
//				dsTenNV.add(nv);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dsTenNV;
//	}
	
	//Load data tenNV lên combobox chucVu
	public String getchucVuNhanVienTheoTen(String tenNV){
		String chucVu = "";
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select chucVu from NhanVien where tenNV = N'"+tenNV+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				chucVu = rs.getString("chucVu");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chucVu;
	}
	
	//Load data tenNV lên combobox sodienthoaiNhanVien
	public String getSoDienThoaiNhanVienTheoTen(String tenNV){
		String sdt = "";
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select sdt from NhanVien where tenNV = N'"+tenNV+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				sdt = rs.getString("sdt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdt;
	}
	
	public NhanVien getNhanVienTheoTen(String tenNV){
		NhanVien nv = null;
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien where tenNV = N'"+tenNV+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				nv = new NhanVien(rs.getString("maNV"), rs.getString("tenNV"), rs.getString("gioiTinh"), rs.getString("diaChi"), 
						rs.getString("sdt"), rs.getString("email"), rs.getDate("ngayVaoLam"), rs.getString("chucVu"),rs.getFloat("luongCoBan"), rs.getString("maCH"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}
}
