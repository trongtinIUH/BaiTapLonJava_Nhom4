package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {

	public List<NhanVien> getAllNhanVien() {
		List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsNhanVien.add(new NhanVien(rs.getString("maNV"), rs.getString("tenNV"), rs.getString("gioiTinh"), rs.getString("diaChi"), rs.getString("sdt"), rs.getString("email"), rs.getDate("ngayVaoLam"), rs.getString("chucVu"),rs.getFloat("luongCoBan"), rs.getString("maCH")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}
	public void DeleteNV(String manv) throws SQLException {
		ConnectDB.getInstance();
		PreparedStatement pst = null;
		 Connection con = ConnectDB.getConnection();
		
		 String sql ="DELETE FROM NhanVien WHERE maNV =?";
		 try {
			 pst = con.prepareStatement(sql);
			pst.setString(1,manv);

			 pst.executeUpdate() ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pst);
		}
	}
	
	//hàm thêm nv
	public boolean addNhanVien(NhanVien lh) throws SQLException {
		ConnectDB.getInstance();
		 Connection con = ConnectDB.getConnection();
		
		 String sql ="insert into NhanVien VALUES(?,?,?,?,?,?,?,?,?,?)";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, lh.getMaNV());
			pst.setString(2, lh.getTenNV());
			pst.setString(3, lh.getGioiTinh());
			pst.setString(4, lh.getDiaChi());
			pst.setString(5, lh.getSdt());
			pst.setString(6, lh.geteMail());
			pst.setDate(7, lh.getNgayVaoLam());
			pst.setString(8, lh.getChucVu());
			pst.setFloat(9, lh.getLuongCoBan());
			pst.setString(10, lh.getMaCH());
			
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	private void close(PreparedStatement pst) {
		if (pst !=null) {
			try {
				pst.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	//hàm tìm kiếm trong table
	public int timkiem(String manv) {
		for (int i = 0; i < getAllNhanVien().size(); i++) {
				if(getAllNhanVien().get(i).getMaNV().equalsIgnoreCase(manv)) {
					return i;
				}
		} return -1;
	}
}
