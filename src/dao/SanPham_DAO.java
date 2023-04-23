package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.LinhKienPhuTung;
import entity.MatHang;
import entity.Xe;

public class SanPham_DAO {
	public List<MatHang> getAllSanPham() {
		List<MatHang> dsSanPham = new ArrayList<MatHang>();
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
				dsSanPham.add(new MatHang(rs.getString("maMH"), rs.getString("tenMH"), rs.getString("dvt"), rs.getString("moTa"), rs.getBigDecimal("donGia"), rs.getInt("slTon"), rs.getString("loaiMH")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSanPham;
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
			pst.setBigDecimal(5, sp.getDonGia());
			pst.setInt(6, sp.getSlTon());
			pst.setString(7, sp.getLoaiMH());
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addXe(Xe x) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql ="insert into Xe(maXe, dongXe, soKhung, mauXe, soPK, soSuon, xuatXu) VALUES(?,?,?,?,?,?,?)";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, x.getMaMH());
			pst.setString(2, x.getDongXe());
			pst.setString(3, x.getSoKhung());
			pst.setString(4, x.getMauXe());
			pst.setInt(5, x.getSoPK());
			pst.setString(6, x.getSoSuon());
			pst.setString(7, x.getXuatSu());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean addLinhKien(LinhKienPhuTung lk) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql ="insert into LinhKienPhuTung(maLinhKien, hangSX) VALUES(?,?)";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, lk.getMaMH());
			pst.setString(2, lk.getHangSX());
			return pst.executeUpdate() > 0;
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
				BigDecimal dg = rs.getBigDecimal(5);
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
	
}
