package entity;

import java.io.Serializable;
import java.sql.Date;

public class PhieuNhap extends HoaDonHang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String  tenNCC;
	private String soPhieu;
	public PhieuNhap(MatHang mh, NhanVien nv, Date ngayGD, String tenNCC, String soPhieu) {
		super(mh, nv, ngayGD);
		this.tenNCC = tenNCC;
		this.soPhieu = soPhieu;
	}
	public PhieuNhap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhieuNhap(MatHang mh, NhanVien nv, Date ngayGD) {
		super(mh, nv, ngayGD);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public PhieuNhap(String maHDH, MatHang mh, String tenNCC, String soPhieu) {
		super(maHDH, mh);
		this.tenNCC = tenNCC;
		this.soPhieu = soPhieu;
	}
	public PhieuNhap(String maHDH, CuaHang maCH, MatHang mh, String tenNCC, String soPhieu) {
		super(maHDH, maCH, mh);
		this.tenNCC = tenNCC;
		this.soPhieu = soPhieu;
	}
	public PhieuNhap(String maHDH, CuaHang maCH, MatHang mh, Date ngayGD, String tenNCC, String soPhieu) {
		super(maHDH, maCH, mh, ngayGD);
		this.tenNCC = tenNCC;
		this.soPhieu = soPhieu;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getSoPhieu() {
		return soPhieu;
	}
	public void setSoPhieu(String soPhieu) {
		this.soPhieu = soPhieu;
	}
	
	

}
