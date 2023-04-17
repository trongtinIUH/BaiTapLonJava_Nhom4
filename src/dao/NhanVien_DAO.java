package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {
	public List<NhanVien> getAllNhanVien() {
		List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
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
				dsNhanVien.add(new NhanVien(rs.getString("maNV"), rs.getString("tenNV"), rs.getString("gioiTinh"), rs.getString("diaChi"), rs.getString("sdt"), rs.getString("email"), rs.getDate("ngayVaoLam"), rs.getString("chucVu"),rs.getFloat("luongCoBan"), rs.getString("maCH")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}
}
