package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HopDong;
import entity.KhachHang;
import entity.LinhKienPhuTung;
import entity.NhanVien;
import entity.PhieuBaoHanh;

public class BaoHanh_DAO {
	public boolean update(PhieuBaoHanh bh){
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
			stmt = con.prepareStatement(
					"update PhieuBaoHanh set maHD=?, maLinhKien=?, ngayBH=?, liDo=?, loiCuaAi=?, giaTienSua=?, maNVBH=?, maKH=? where maPhieu =? ");

			stmt.setString(1, bh.getHd().getMaHD());
			stmt.setString(2, bh.getLkpt().getMaLinhKien());
			stmt.setDate(3, (Date) bh.getNgayBH());
			stmt.setString(4, bh.getLiDo());
			stmt.setString(5, bh.getLoiCuaAi());
			stmt.setDouble(6, bh.getGiaTienSua());
			stmt.setString(7, bh.getNhanVien().getMaNV());
			stmt.setString(8, bh.getKh().getMaKH());
			stmt.setString(9, bh.getMaPhieuBH());
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
		return n > 0;
	}

	public boolean createBH(PhieuBaoHanh bh) {
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
			stmt = con.prepareStatement("insert into PhieuBaoHanh values (?,?,?,?,?,?,?,?,?)  ");
			stmt.setString(1, bh.getMaPhieuBH());
			stmt.setString(2, bh.getHd().getMaHD());
			stmt.setString(3, bh.getLkpt().getMaLinhKien());
			stmt.setDate(4, (Date) bh.getNgayBH());
			stmt.setString(5, bh.getLiDo());
			stmt.setString(6, bh.getLoiCuaAi());
			stmt.setDouble(7, bh.getGiaTienSua());
			stmt.setString(8, bh.getNhanVien().getMaNV());
			stmt.setString(9, bh.getKh().getMaKH());
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

	public boolean xoaHD(String maBH) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete PhieuBaoHanh where maPhieu=? ");
			stmt.setString(1, maBH);
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
		return n > 0;
	}

	public ArrayList<PhieuBaoHanh> getAllPhieuBaoHanh() {
		ArrayList<PhieuBaoHanh> dsBH = new ArrayList<PhieuBaoHanh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from PhieuBaoHanh";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maPhieu = rs.getString(1);
				HopDong hd = new HopDong(rs.getString(2));
				LinhKienPhuTung lk = new LinhKienPhuTung(rs.getString(3));
				Date ngayBH = rs.getDate(4);
				String liDo = rs.getString(5);
				String loiCuaAi = rs.getString(6);
				double giaTienSua = rs.getDouble(7);
				NhanVien nv = new NhanVien(rs.getString(8));
				KhachHang kh = new KhachHang(rs.getString(9));
				PhieuBaoHanh bh = new PhieuBaoHanh(maPhieu, hd, lk, ngayBH, liDo, loiCuaAi, giaTienSua, nv, kh);
				dsBH.add(bh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsBH;
	}
	
	public PhieuBaoHanh getPhieuBaoHanhTheoMa(String id) {
		PhieuBaoHanh bh = new PhieuBaoHanh();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from PhieuBaoHanh where maPhieu = '" + id + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieu = rs.getString(1);
				HopDong hd = new HopDong(rs.getString(2));
				LinhKienPhuTung lk = new LinhKienPhuTung(rs.getString(3));
				Date ngayBH = rs.getDate(4);
				String liDo = rs.getString(5);
				String loiCuaAi = rs.getString(6);
				double giaTienSua = rs.getDouble(7);
				NhanVien nv = new NhanVien(rs.getString(8));
				KhachHang kh = new KhachHang(rs.getString(9));
				bh = new PhieuBaoHanh(maPhieu, hd, lk, ngayBH, liDo, loiCuaAi, giaTienSua, nv, kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bh;
	}
	
	public ArrayList<PhieuBaoHanh> getPhieuBaoHanhTheoMaKH(String makh) {
		ArrayList<PhieuBaoHanh> dsbh = new ArrayList<PhieuBaoHanh>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from PhieuBaoHanh where maKH = '" + makh + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieu = rs.getString(1);
				HopDong hd = new HopDong(rs.getString(2));
				LinhKienPhuTung lk = new LinhKienPhuTung(rs.getString(3));
				Date ngayBH = rs.getDate(4);
				String liDo = rs.getString(5);
				String loiCuaAi = rs.getString(6);
				double giaTienSua = rs.getDouble(7);
				NhanVien nv = new NhanVien(rs.getString(8));
				KhachHang kh = new KhachHang(rs.getString(9));
				dsbh.add(new PhieuBaoHanh(maPhieu, hd, lk, ngayBH, liDo, loiCuaAi, giaTienSua, nv, kh));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsbh;
	}

}
