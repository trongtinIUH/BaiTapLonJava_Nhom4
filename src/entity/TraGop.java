package entity;

import java.io.Serializable;
import java.util.Date;

public class TraGop extends HopDong implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HopDong hd;
	private Date ngayTra;
	private double laiSuat;
	private String nguoiTra;
	private double soTienTra;

	public TraGop(String maHD, Date ngaylapHD, int thoiGianBH, String loaiHD, NhanVien nvLapHD, CuaHang cuaHang,
			KhachHang khachHang) {
		super(maHD, ngaylapHD, thoiGianBH, loaiHD, nvLapHD, cuaHang, khachHang);
		// TODO Auto-generated constructor stub
	}

	public TraGop(String maHD, Date ngaylapHD, int thoiGianBH, String loaiHD, NhanVien nvLapHD, CuaHang cuaHang,
			KhachHang khachHang, HopDong hd, Date ngayTra, double laiSuat, String nguoiTra, double soTienTra) {
		super(maHD, ngaylapHD, thoiGianBH, loaiHD, nvLapHD, cuaHang, khachHang);
		this.hd = hd;
		this.ngayTra = ngayTra;
		this.laiSuat = laiSuat;
		this.nguoiTra = nguoiTra;
		this.soTienTra = soTienTra;
	}

	public TraGop(HopDong hd, Date ngayTra, double laiSuat, String nguoiTra, double soTienTra) {
		super();
		this.hd = hd;
		this.ngayTra = ngayTra;
		this.laiSuat = laiSuat;
		this.nguoiTra = nguoiTra;
		this.soTienTra = soTienTra;
	}

	public TraGop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TraGop(String maHD) {
		super(maHD);
		// TODO Auto-generated constructor stub
	}

	public HopDong getHd() {
		return hd;
	}

	public void setHd(HopDong hd) {
		this.hd = hd;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public double getLaiSuat() {
		return laiSuat;
	}

	public void setLaiSuat(double laiSuat) {
		this.laiSuat = laiSuat;
	}

	public String getNguoiTra() {
		return nguoiTra;
	}

	public void setNguoiTra(String nguoiTra) {
		this.nguoiTra = nguoiTra;
	}

	public double getSoTienTra() {
		return soTienTra;
	}

	public void setSoTienTra(double soTienTra) {
		this.soTienTra = soTienTra;
	}

	@Override
	public String toString() {
		return "TraGop [hd=" + hd + ", ngayTra=" + ngayTra + ", laiSuat=" + laiSuat + ", nguoiTra=" + nguoiTra
				+ ", soTienTra=" + soTienTra + "]";
	}

}
