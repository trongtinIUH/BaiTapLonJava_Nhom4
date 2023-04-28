package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class TraTrucTiep extends HopDong implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HopDong hd;
	private String  maUuDai;
	private double phanTramMienGiam;
	
	public TraTrucTiep(String maHD, Date ngaylapHD, int thoiGianBH, String loaiHD, NhanVien nvLapHD, CuaHang cuaHang, KhachHang khachHang) {
		super(maHD, ngaylapHD, thoiGianBH, loaiHD, nvLapHD, cuaHang, khachHang);
		// TODO Auto-generated constructor stub
	}

	public TraTrucTiep(String maHD, Date ngaylapHD, int thoiGianBH, String loaiHD, NhanVien nvLapHD,  CuaHang cuaHang,KhachHang khachHang,
			HopDong hd, String maUuDai, double phanTramMienGiam) {
		super(maHD, ngaylapHD, thoiGianBH, loaiHD, nvLapHD, cuaHang, khachHang);
		this.hd = hd;
		this.maUuDai = maUuDai;
		this.phanTramMienGiam = phanTramMienGiam;
	}

	public TraTrucTiep(HopDong hd, String maUuDai, double phanTramMienGiam) {
		super();
		this.hd = hd;
		this.maUuDai = maUuDai;
		this.phanTramMienGiam = phanTramMienGiam;
	}
	
	

	public HopDong getHd() {
		return hd;
	}

	public void setHd(HopDong hd) {
		this.hd = hd;
	}

	public String getMaUuDai() {
		return maUuDai;
	}

	public void setMaUuDai(String maUuDai) {
		this.maUuDai = maUuDai;
	}

	public double getPhanTramMienGiam() {
		return phanTramMienGiam;
	}

	public void setPhanTramMienGiam(double phanTramMienGiam) {
		this.phanTramMienGiam = phanTramMienGiam;
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
		return "TraTrucTiep [hd=" + hd + ", maUuDai=" + maUuDai + ", phanTramMienGiam=" + phanTramMienGiam + "]";
	}
}
