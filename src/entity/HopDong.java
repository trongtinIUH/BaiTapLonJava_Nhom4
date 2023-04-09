package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class HopDong implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String maHD;
	private LocalDate ngaylapHD;
	private NhanVien nvLapHD;
	private KhachHang khachHang;
	private CuaHang cuaHang;
	public HopDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HopDong(String maHD, LocalDate ngaylapHD, NhanVien nvLapHD, KhachHang khachHang, CuaHang cuaHang) {
		super();
		this.maHD = maHD;
		this.ngaylapHD = ngaylapHD;
		this.nvLapHD = nvLapHD;
		this.khachHang = khachHang;
		this.cuaHang = cuaHang;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public LocalDate getNgaylapHD() {
		return ngaylapHD;
	}
	public void setNgaylapHD(LocalDate ngaylapHD) {
		this.ngaylapHD = ngaylapHD;
	}
	public NhanVien getNvLapHD() {
		return nvLapHD;
	}
	public void setNvLapHD(NhanVien nvLapHD) {
		this.nvLapHD = nvLapHD;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public CuaHang getCuaHang() {
		return cuaHang;
	}
	public void setCuaHang(CuaHang cuaHang) {
		this.cuaHang = cuaHang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HopDong other = (HopDong) obj;
		return Objects.equals(maHD, other.maHD);
	}
	@Override
	public String toString() {
		return String.format("HopDong [maHD=%s, ngaylapHD=%s, nvLapHD=%s, khachHang=%s, cuaHang=%s]", maHD, ngaylapHD,
				nvLapHD, khachHang, cuaHang);
	}
	

}
