package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhieuXuat;

public class PhieuXuat_DAO {
	public ArrayList<PhieuXuat> getAllPhieuXuat() {
		ArrayList<PhieuXuat> dsPhieuXuat = new ArrayList<PhieuXuat>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from PhieuXuat";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String HDH = rs.getString(1);
				PhieuXuat x = new PhieuXuat(HDH);
				dsPhieuXuat.add(x);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuXuat;
	}
	
	public boolean createPX(PhieuXuat x) {
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
			stmt = con.prepareStatement("insert into PhieuXuat values (?)  ");
			stmt.setString(1, x.getSoPhieu());
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
