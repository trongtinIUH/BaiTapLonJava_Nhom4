package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.HoaDonHang;

public class HoaDonHang_DAO {
	public boolean addHoaDonHang(HoaDonHang p) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql ="insert into HoaDonHang(maHDH, maCH, ngayGD) VALUES(?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p.getMaHDH());
			pst.setString(2, p.getMaCH());
			pst.setDate(3, p.getNgayGD());
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
