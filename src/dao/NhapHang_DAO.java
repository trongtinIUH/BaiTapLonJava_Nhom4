package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.MatHang;
import entity.PhieuNhap;

public class NhapHang_DAO {
	public ArrayList<PhieuNhap> getAllNhapHang() {
		ArrayList<PhieuNhap> dsNhapHang = new ArrayList<PhieuNhap>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select n.maPhieu, mh.maMH, tenMH, soLuong, donGia, tenNCC from PhieuNhap n join HoaDonHang h on h.maHDH = n.maHDH join ChiTietHoaDonHang ct on ct.maHDH = h.maHDH join MatHang mh on mh.maMH = ct.maMH";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsNhapHang.add(new PhieuNhap(rs.getString("maPhieu"), new MatHang(rs.getString("maMH"), rs.getString("tenMH"), rs.getDouble("donGia"), rs.getInt("soLuong")), rs.getString("tenNCC"), rs.getString("maPhieu")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhapHang;
	}
	public ArrayList<PhieuNhap> getPhieuTheoTen(String tenSP) {
		ArrayList<PhieuNhap> dsPhieu = new ArrayList<PhieuNhap>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select n.maPhieu, mh.maMH, tenMH, soLuong, donGia, tenNCC from PhieuNhap n join HoaDonHang h on h.maHDH = n.maHDH join ChiTietHoaDonHang ct on ct.maHDH = h.maHDH join MatHang mh on mh.maMH = ct.maMH where tenMH like '%" + tenSP + "%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieu = rs.getString(1);
				String maSP = rs.getString(2);
				String ten = rs.getString(3);
				int sl = rs.getInt(4);
				double dg = rs.getDouble(5);
				String tenNCC = rs.getString(6);
				PhieuNhap pn = new PhieuNhap(maPhieu, new MatHang(maSP, ten, dg, sl), tenNCC, maPhieu);
				dsPhieu.add(pn);
			}
			if(dsPhieu.size() == 0) {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhieu;
	}
	public boolean addPhieuNhap(PhieuNhap p) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql ="insert into PhieuNhap(maPhieu, tenNCC, maHDH) VALUES(?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p.getSoPhieu());
			pst.setString(2, p.getTenNCC());
			pst.setString(3, p.getMaHDH());
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean addCTHD(String maHDH, String maMH, int sl) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		 String sql ="insert into ChiTietHoaDonHang VALUES(?,?,?)";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, maHDH);
			pst.setString(2, maMH);
			pst.setInt(3, sl);
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean Delete(String maHDH) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		 String sql ="DELETE FROM HoaDonHang WHERE maHDH =?";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, maHDH);
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
