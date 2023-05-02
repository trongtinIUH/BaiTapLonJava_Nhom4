package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.HopDong;
import entity.TraGop;

public class TraGop_DAO {
	public ArrayList<TraGop> getAllHDTraGop(){
		ArrayList<TraGop> dsHDTraGop = new ArrayList<TraGop>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TraGop";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				HopDong HD = new HopDong(rs.getString(1));
				Date ngayTra = rs.getDate(2);
				double laiSuat= rs.getDouble(3);
				String nguoiTra = rs.getString(4);
				double soTienTra = rs.getDouble(5);
				TraGop hdTG = new TraGop(HD, ngayTra, laiSuat, nguoiTra, soTienTra);
				dsHDTraGop.add(hdTG);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsHDTraGop;
		}
	
	public boolean createHDTraGop(TraGop hdTG) {
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
			stmt = con.prepareStatement("insert into TraGop values(?,?,?,?,?)"); 
			stmt.setString(1, hdTG.getHd().getMaHD());
			stmt.setDate(2, (java.sql.Date) hdTG.getNgayTra());
			stmt.setDouble(3, hdTG.getLaiSuat());
			stmt.setString(4, hdTG.getNguoiTra());
			stmt.setDouble(5, hdTG.getSoTienTra());
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
	
	public ArrayList<TraGop> getTraGopTheoMa(String id) {
		ArrayList<TraGop> dstg = new ArrayList<TraGop>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from TraGop where maHD = '" + id + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				Date ngayTra = rs.getDate("ngayTra");
				Double laisuat = rs.getDouble("laiSuat");
				String nguoiTra = rs.getString("nguoiTra");
				Double soTienTra = rs.getDouble("soTienTra");
				HopDong hd = new HopDong(maHD);
				TraGop tg = new TraGop(hd, ngayTra, laisuat, nguoiTra, soTienTra);
				dstg.add(tg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dstg;
	}
}
