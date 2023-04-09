package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class PhieuNhap extends HoaDonHang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String  tenNCC;
	private String soPhieu;
	private LocalDate ngayTao;
	private int soLuong;
	public PhieuNhap(MatHang mh, KhachHang kh, NhanVien nv, LocalDate ngayGD) {
		super(mh, kh, nv, ngayGD);
		// TODO Auto-generated constructor stub
	}
	public PhieuNhap(MatHang mh, KhachHang kh, NhanVien nv, LocalDate ngayGD, String tenNCC, String soPhieu,
			LocalDate ngayTao, int soLuong) {
		super(mh, kh, nv, ngayGD);
		this.tenNCC = tenNCC;
		this.soPhieu = soPhieu;
		this.ngayTao = ngayTao;
		this.soLuong = soLuong;
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
	public LocalDate getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return String.format("PhieuNhap [tenNCC=%s, soPhieu=%s, ngayTao=%s, soLuong=%s]", tenNCC, soPhieu, ngayTao,
				soLuong);
	}
	
	
	

}
