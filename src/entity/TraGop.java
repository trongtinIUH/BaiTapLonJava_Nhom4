package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class TraGop extends HopDong implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int  thoiGianTra;
	private double laiSuat;
	public TraGop(String maHD, LocalDate ngaylapHD, NhanVien nvLapHD, KhachHang khachHang, CuaHang cuaHang) {
		super(maHD, ngaylapHD, nvLapHD, khachHang, cuaHang);
		// TODO Auto-generated constructor stub
	}
	public TraGop(String maHD, LocalDate ngaylapHD, NhanVien nvLapHD, KhachHang khachHang, CuaHang cuaHang,
			int thoiGianTra, double laiSuat) {
		super(maHD, ngaylapHD, nvLapHD, khachHang, cuaHang);
		this.thoiGianTra = thoiGianTra;
		this.laiSuat = laiSuat;
	}
	public int getThoiGianTra() {
		return thoiGianTra;
	}
	public void setThoiGianTra(int thoiGianTra) {
		this.thoiGianTra = thoiGianTra;
	}
	public double getLaiSuat() {
		return laiSuat;
	}
	public void setLaiSuat(double laiSuat) {
		this.laiSuat = laiSuat;
	}
	@Override
	public String toString() {
		return String.format("TraGop [thoiGianTra=%s, laiSuat=%s]", thoiGianTra, laiSuat);
	}
	
	

}
