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
				dsNhanVien.add(new NhanVien(rs.getString("maNV"), rs.getString("tenNV"), rs.getString("gioiTinh"), rs.getString("diaChi"), 
						rs.getString("sdt"), rs.getString("email"), rs.getDate("ngayVaoLam"), rs.getString("chucVu"),rs.getFloat("luongCoBan"), rs.getString("maCH")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
		
	}
	
	
	//LoadData to ComboBox MaNhanVien
//	public ArrayList<NhanVien> getAllNNhanVienBanHang(){
//		ArrayList<NhanVien> dsTenNV = new ArrayList<NhanVien>();
//		try {
//			ConnectDB.getInstance();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Connection con = ConnectDB.getConnection();
//		try {
//			String sql = "select tenNV,chucVu,sdt from NhanVien where chucVu = N'"+"Nhân viên bán hàng"+"'";
//			Statement sta = con.createStatement();
//			ResultSet rs = sta.executeQuery(sql);
//			while(rs.next()) {
//				String tenNV = rs.getString("tenNV");
//				String chucVu = rs.getString("chucVu");
//				String soDt = rs.getString("sdt");
//				NhanVien nv = new NhanVien(tenNV,chucVu,soDt);
//				dsTenNV.add(nv);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dsTenNV;
//	}
	
	//Load data tenNV lên combobox chucVu
	public String getchucVuNhanVienTheoTen(String tenNV){
		String chucVu = "";
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select chucVu from NhanVien where tenNV = N'"+tenNV+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				chucVu = rs.getString("chucVu");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chucVu;
	}
	
	//Load data tenNV lên combobox sodienthoaiNhanVien
	public String getSoDienThoaiNhanVienTheoTen(String tenNV){
		String sdt = "";
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select sdt from NhanVien where tenNV = N'"+tenNV+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				sdt = rs.getString("sdt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdt;
	}
	
	//hàm tìm tín làm
	public ArrayList<NhanVien> Timkiem(String maNV){
		ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien where maNV = N'"+maNV+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gioitinh = rs.getString(3);
				String diachi = rs.getString(4);
				String sdt = rs.getString(5);
				String email = rs.getString(6);
				java.sql.Date ngay = rs.getDate(7);
				String cv = rs.getString(8);
				float luong= rs.getFloat(9);
				String mach = rs.getString(10);
		
				NhanVien nv1 = new NhanVien(ma, ten, gioitinh, diachi, sdt, email, ngay, cv, luong, mach);
				nv.add(nv1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}
	
	public NhanVien getNhanVienTheoTen(String tenNV){
		NhanVien nv = null;
		try {
			ConnectDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien where tenNV = N'"+tenNV+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				nv = new NhanVien(rs.getString("maNV"), rs.getString("tenNV"), rs.getString("gioiTinh"), rs.getString("diaChi"), 
						rs.getString("sdt"), rs.getString("email"), rs.getDate("ngayVaoLam"), rs.getString("chucVu"),rs.getFloat("luongCoBan"), rs.getString("maCH"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
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
	
	public NhanVien getNVTheoMa(String id) {
		NhanVien nv = new NhanVien();
		try {
			ConnectDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien where maNV = '" + id + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				nv = new NhanVien(rs.getString("maNV"), rs.getString("tenNV"), rs.getString("gioiTinh"), rs.getString("diaChi"), 
						rs.getString("sdt"), rs.getString("email"), rs.getDate("ngayVaoLam"), rs.getString("chucVu"),rs.getFloat("luongCoBan"), rs.getString("maCH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(nv.getTenNV() == null)
			return null;
		return nv;
	}
	
	//add nhân  viên kĩ thuật
	public boolean addNhanVien_kythuat(String ma,String bactho,int namkn) throws SQLException {
		ConnectDB.getInstance();
		 Connection con = ConnectDB.getConnection();
		
		 String sql ="insert into NV_KyThuat VALUES(?,?,?)";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,ma );
			pst.setString(2, bactho);
			pst.setInt(3, namkn);
		
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addNhanVien_hanhchinh(String ma,String tenpb,String hocvan) throws SQLException {
		ConnectDB.getInstance();
		 Connection con = ConnectDB.getConnection();
		
		 String sql ="insert into NV_HanhChinh VALUES(?,?,?)";
		 try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,ma );
			pst.setString(2, tenpb);
			pst.setString(3, hocvan);
		
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	






}
