package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class PhieuXuat extends HoaDonHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String soPhieu;
	private LocalDate ngayTao;
	private int soLuong;
	public PhieuXuat(MatHang mh, KhachHang kh, NhanVien nv, LocalDate ngayGD) {
		super(mh, kh, nv, ngayGD);
		// TODO Auto-generated constructor stub
	}
	public PhieuXuat(MatHang mh, KhachHang kh, NhanVien nv, LocalDate ngayGD, String soPhieu, LocalDate ngayTao,
			int soLuong) {
		super(mh, kh, nv, ngayGD);
		this.soPhieu = soPhieu;
		this.ngayTao = ngayTao;
		this.soLuong = soLuong;
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
		return String.format("PhieuXuat [soPhieu=%s, ngayTao=%s, soLuong=%s]", soPhieu, ngayTao, soLuong);
	}
	
	

}
