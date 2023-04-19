package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;

public class KhachHang_DAO {
	public List<KhachHang> getAllKhachHang() {
		List<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KhachHang";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				dsKhachHang.add(new KhachHang(rs.getString("maKH"), rs.getString("tenKH"), rs.getString("gioiTinh"),
						rs.getString("diaChi"), rs.getString("sdt")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	public boolean create(KhachHang kh) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang values (?, ?, ?, ?, ?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getGioiTinh());
			stmt.setString(4, kh.getDiaChi());
			stmt.setString(5, kh.getSdt());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean update(KhachHang kh) {
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
			stmt = con.prepareStatement("update KhachHang set tenKH=?, gioiTinh=?, diaChi=?, sdt=? where maKH=? ");
			stmt.setString(1, kh.getTenKH());
			stmt.setString(2, kh.getGioiTinh());
			stmt.setString(3, kh.getDiaChi());
			stmt.setString(4, kh.getSdt());
			stmt.setString(5, kh.getMaKH());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean xoa(String ma) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete KhachHang where maKH = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public ArrayList<KhachHang> getKHTheoMa(String id) {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KhachHang where maKH = '" + id + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String phai = rs.getString(3);
				String diaChi = rs.getString(4);
				String sdt = rs.getString(5);
				KhachHang kh = new KhachHang(ma, ten, phai, diaChi, sdt);
				dskh.add(kh);
			}
			if(dskh.size() == 0) {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}

	public ArrayList<KhachHang> getKHTheoSDT(String sdt) {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KhachHang where sdt = '" + sdt + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String phai = rs.getString(3);
				String diaChi = rs.getString(4);
				String dt = rs.getString(5);
				KhachHang kh = new KhachHang(ma, ten, phai, diaChi, dt);
				dskh.add(kh);
			}
			if(dskh.size() == 0) {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}
	
	public ArrayList<KhachHang> getKHTheoTen(String tenKH) {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KhachHang where tenKH like '%" + tenKH + "%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String phai = rs.getString(3);
				String diaChi = rs.getString(4);
				String dt = rs.getString(5);
				KhachHang kh = new KhachHang(ma, ten, phai, diaChi, dt);
				dskh.add(kh);
			}
			if(dskh.size() == 0) {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}
}
