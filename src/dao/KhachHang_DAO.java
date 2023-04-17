package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	public List<KhachHang> getAllKhachHang() {
		List<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KhachHang";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsKhachHang.add(new KhachHang(rs.getString("maKH"), rs.getString("tenKH"), rs.getString("gioiTinh"), rs.getString("diaChi"), rs.getString("sdt")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}
}
