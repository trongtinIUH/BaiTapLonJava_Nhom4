package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class TraGop extends HopDong implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int  thoiGianTra;
	private double laiSuat;
	public TraGop(String maHD, Date ngaylapHD,int thoiGianBH, String loaiHD, NhanVien nvLapHD, CuaHang cuaHang, KhachHang khachHang) {
		super(maHD, ngaylapHD, thoiGianBH, loaiHD, nvLapHD, cuaHang, khachHang);
		// TODO Auto-generated constructor stub
	}
	public TraGop(String maHD, Date ngaylapHD, int thoiGianBH, String loaiHD, NhanVien nvLapHD, CuaHang cuaHang, KhachHang khachHang,
			int thoiGianTra, double laiSuat) {
		super(maHD, ngaylapHD, thoiGianBH, loaiHD, nvLapHD, cuaHang, khachHang);
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
