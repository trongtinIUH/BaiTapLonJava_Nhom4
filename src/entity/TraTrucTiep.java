package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TraTrucTiep extends HopDong implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HopDong hd;
	private double phanTramMienGiam;
	private double soTienTra;
	
	public TraTrucTiep(String maHD, Date ngaylapHD, int thoiGianBH, String loaiHD, NhanVien nvLapHD, CuaHang cuaHang, KhachHang khachHang) {
		super(maHD, ngaylapHD, thoiGianBH, loaiHD, nvLapHD, cuaHang, khachHang);
		// TODO Auto-generated constructor stub
	}

	public TraTrucTiep(String maHD, Date ngaylapHD, int thoiGianBH, String loaiHD, NhanVien nvLapHD,  CuaHang cuaHang,KhachHang khachHang,
			HopDong hd, double phanTramMienGiam, double soTienTra) {
		super(maHD, ngaylapHD, thoiGianBH, loaiHD, nvLapHD, cuaHang, khachHang);
		this.hd = hd;
		this.phanTramMienGiam = phanTramMienGiam;
		this.soTienTra = soTienTra;
	}

	public TraTrucTiep(HopDong hd, double phanTramMienGiam, double soTienTra) {
		super();
		this.hd = hd;
		this.phanTramMienGiam = phanTramMienGiam;
		this.soTienTra = soTienTra;
	}
	
	

	public HopDong getHd() {
		return hd;
	}

	public void setHd(HopDong hd) {
		this.hd = hd;
	}

	public double getPhanTramMienGiam() {
		return phanTramMienGiam;
	}

	public void setPhanTramMienGiam(double phanTramMienGiam) {
		this.phanTramMienGiam = phanTramMienGiam;
	}
	

	public double getSoTienTra() {
		return soTienTra;
	}

	public void setSoTienTra(double soTienTra) {
		this.soTienTra = soTienTra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TraTrucTiep other = (TraTrucTiep) obj;
		return Objects.equals(hd, other.hd);
	}

	@Override
	public String toString() {
		return "TraTrucTiep [hd=" + hd + ", phanTramMienGiam=" + phanTramMienGiam + ", soTienTra=" + soTienTra + "]";
	}
}
