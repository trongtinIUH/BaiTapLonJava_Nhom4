package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHopDong;
import entity.HopDong;
import entity.MatHang;


public class ChiTietHopDong_DAO {
	private HopDong_DAO hddao = new HopDong_DAO();
	private MatHang_DAO mhdao = new MatHang_DAO();

	public boolean update(ChiTietHopDong cthd) {
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
			stmt = con.prepareStatement("update ChiTietHopDong set maMH=?, soLuong=?");
			stmt.setString(1, cthd.getMatHang().getMaMH());
			stmt.setInt(2, cthd.getSoLuong());
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
	
	public boolean createCTHD(ChiTietHopDong cthd) {
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
			stmt = con.prepareStatement("insert into ChiTietHopDong values(?,?,?,?)"); 
			stmt.setString(1, cthd.getHopDong().getMaHD());
			stmt.setString(2, cthd.getMaChiTietHD());
			stmt.setString(3, cthd.getMatHang().getMaMH());
			stmt.setInt(4, cthd.getSoLuong());
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
	
	public boolean XoaCTHD(String maCTHD){
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
			stmt = con.prepareStatement("delete ChiTietHopDong where maChiTietHD = ?");
			stmt.setString(1, maCTHD);
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

	
	public ArrayList<ChiTietHopDong> getAllCTHD(){
		ArrayList<ChiTietHopDong> dsCTHD = new ArrayList<ChiTietHopDong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from ChiTietHopDong";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				HopDong HD = new HopDong(rs.getString(1));
				String maCTHD = rs.getString(2);
				MatHang m = new MatHang(rs.getString(3));
				int soluong = rs.getInt(4);
				ChiTietHopDong cthd = new ChiTietHopDong(HD, maCTHD, m, soluong);
				dsCTHD.add(cthd);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsCTHD;
		}

	public double getTongDoanhThuThuoc(){
		double doanhthu=0;
		
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "SELECT doanhthu=sum(ChiTietHopDong.soLuong*MatHang.donGia)\r\n" + 
					"FROM MatHang INNER JOIN\r\n" + 
					"ChiTietHopDong ON MatHang.maMH = ChiTietHopDong.maMH";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				doanhthu = Double.parseDouble(rs.getString(1));
			}
				 
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return doanhthu;
	}
	
	public ChiTietHopDong getCTHDTheoMa(String macthd){
		ChiTietHopDong cthd = null;
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from ChiTietHopDong where  maChiTietHD = '"+macthd+"'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				HopDong HD = new HopDong(rs.getString(1));
				String maCTHD = rs.getString(2);
				int soluong = rs.getInt(3);
				MatHang m = new MatHang(rs.getString(4));
				cthd = new ChiTietHopDong(HD, maCTHD, m, soluong);	
			
			}
		
			}catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
				return cthd;		
	}
	
	public ArrayList<ChiTietHopDong> getCTHDTheoMaHD (String id) {
		ArrayList<ChiTietHopDong> dscthd = new ArrayList<ChiTietHopDong>();
		ChiTietHopDong cthd = new ChiTietHopDong();
		HopDong hd = new HopDong();
		MatHang mh = new MatHang();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietHopDong where maHD = '" + id + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				hd = hddao.getHopDongTheoMa(maHD);
				String maCTHD = rs.getString("maCTHD");
				String maMH = rs.getString("maMH");
				mh = mhdao.getMHTheoMa(maMH);
				int soluong = rs.getInt("soLuong");
				cthd = new ChiTietHopDong(hd, maCTHD, mh, soluong);
				dscthd.add(cthd);
			}
			if(dscthd.size() == 0) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscthd;
	}
}
