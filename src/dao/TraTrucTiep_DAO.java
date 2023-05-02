package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HopDong;
import entity.TraTrucTiep;

public class TraTrucTiep_DAO {
	public ArrayList<TraTrucTiep> getAllHDTraTrucTiep(){
		ArrayList<TraTrucTiep> dsHDTraTrucTiep = new ArrayList<TraTrucTiep>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TraTrucTiep";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				HopDong HD = new HopDong(rs.getString(1));
				double phanTramMienGiam = rs.getDouble(2);
				double soTienTra = rs.getDouble(3);
				TraTrucTiep hdTTT = new TraTrucTiep(HD, phanTramMienGiam, soTienTra);
				dsHDTraTrucTiep.add(hdTTT);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsHDTraTrucTiep;
		}
	
	public boolean createHDTraTrucTiep(TraTrucTiep hdTTT) {
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
			stmt = con.prepareStatement("insert into TraTrucTiep values(?,?,?)"); 
			stmt.setString(1, hdTTT.getHd().getMaHD());
			stmt.setDouble(2, hdTTT.getPhanTramMienGiam());
			stmt.setDouble(3, hdTTT.getSoTienTra());
			n = stmt.executeUpdate();
			
			} catch (SQLException e) {
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
}
