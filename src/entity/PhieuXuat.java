package entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class PhieuXuat extends HoaDonHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String soPhieu;
	
	public PhieuXuat(MatHang mh, KhachHang kh, NhanVien nv, Date ngayGD) {
		super(mh, nv, ngayGD);
		// TODO Auto-generated constructor stub
	}
	public PhieuXuat(MatHang mh, KhachHang kh, NhanVien nv, Date ngayGD, String soPhieu) {
		super(mh, nv, ngayGD);
		this.soPhieu = soPhieu;
	}
	
	public PhieuXuat(String soPhieu) {
		this.soPhieu = soPhieu;
	}
	
	public String getSoPhieu() {
		return soPhieu;
	}
	public void setSoPhieu(String soPhieu) {
		this.soPhieu = soPhieu;
	}

	@Override
	public String toString() {
		return String.format("PhieuXuat [soPhieu=%s]", soPhieu);
	}
	
	

}
