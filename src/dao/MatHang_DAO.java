package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CuaHang;
import entity.HopDong;
import entity.KhachHang;
import entity.MatHang;
import entity.NhanVien;

public class MatHang_DAO {
	public ArrayList<MatHang> getAllMatHang() {
		ArrayList<MatHang> dsMatHang = new ArrayList<MatHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from MatHang";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsMatHang.add(new MatHang(rs.getString("maMH"), rs.getString("tenMH"), rs.getString("dvt"), rs.getString("moTa"), rs.getDouble("donGia"), rs.getInt("slTon"), rs.getString("loaiMH")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsMatHang;
		
	}
	
	public MatHang getMatHangTheoTen(String tenMh) {
		MatHang mh = null;
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from MatHang where tenMH = N'"+tenMh+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				mh = new MatHang(rs.getString("maMH"), rs.getString("tenMH"), rs.getString("dvt"), rs.getString("moTa"), rs.getDouble("donGia"), rs.getInt("slTon"), rs.getString("loaiMH"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mh;
		
	}
	public boolean addSanPham(MatHang sp) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		 String sql ="insert into MatHang(maMH, tenMH, dvt, moTa, donGia, slTon, loaiMH) VALUES(?,?,?,?,?,?,?)";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, sp.getMaMH());
			pst.setString(2, sp.getTenMH());
			pst.setString(3, sp.getDvt());
			pst.setString(4, sp.getMoTa());
			pst.setDouble(5, sp.getDonGia());
			pst.setInt(6, sp.getSlTon());
			pst.setString(7, sp.getLoaiMH());
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean Delete(String maMH) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		 String sql ="DELETE FROM MatHang WHERE maMH =?";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, maMH);
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<MatHang> getSPTheoTen(String tenSP) {
		ArrayList<MatHang> dssp = new ArrayList<MatHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from MatHang where tenMH like '%" + tenSP + "%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String dvt = rs.getString(3);
				String mota = rs.getString(4);
				double dg = rs.getDouble(5);
				int sl = rs.getInt(6);
				String loai = rs.getString(7);
				MatHang mh = new MatHang(ma, ten, dvt, mota, dg, sl, loai);
				dssp.add(mh);
			}
			if(dssp.size() == 0) {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dssp;
	}
	
	public boolean update(int sl, BigDecimal dg, String ma) {
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Connection con = ConnectDB.getConnection();
		
		 String sql ="UPDATE MatHang SET slTon = ?, donGia =? WHERE maMH = ?";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sl);
			pst.setBigDecimal(2, dg);
			pst.setString(3, ma);
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public MatHang getMHTheoMa(String id) {
		MatHang mh = new MatHang();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from MatHang where maMH = '" + id + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maMH = rs.getString("maMH");
				String ten = rs.getString("tenMH");
				String dvt = rs.getString("dvt");
				String moTa = rs.getString("moTa");
				double donGia = rs.getDouble("donGia");
				int soLuongTon = rs.getInt("slTon");
				String loaiMH = rs.getString("loaiMH");
				mh = new MatHang(maMH, ten, dvt, moTa, donGia, soLuongTon, loaiMH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (mh.getMaMH() == null)
			return null;
		return mh;
	}
}
