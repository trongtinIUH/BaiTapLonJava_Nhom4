package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class HopDong implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String maHD;
	private Date ngaylapHD;
	private int thoiGianBH;
	private String loaiHD;
	private NhanVien nvLapHD;
	private CuaHang cuaHang;
	private KhachHang khachHang;
	
	public HopDong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HopDong(String maHD, Date ngaylapHD, int thoiGianBH, String loaiHD, NhanVien nvLapHD, CuaHang cuaHang,
			KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.ngaylapHD = ngaylapHD;
		this.thoiGianBH = thoiGianBH;
		this.loaiHD = loaiHD;
		this.nvLapHD = nvLapHD;
		this.cuaHang = cuaHang;
		this.khachHang = khachHang;
	}
	
	public HopDong(String maHD) {
		this.maHD = maHD;
	}


	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public Date getNgaylapHD() {
		return ngaylapHD;
	}

	public void setNgaylapHD(Date ngaylapHD) {
		this.ngaylapHD = ngaylapHD;
	}

	public int getThoiGianBH() {
		return thoiGianBH;
	}

	public void setThoiGianBH(int thoiGianBH) {
		this.thoiGianBH = thoiGianBH;
	}

	public String getLoaiHD() {
		return loaiHD;
	}

	public void setLoaiHD(String loaiHD) {
		this.loaiHD = loaiHD;
	}

	public NhanVien getNvLapHD() {
		return nvLapHD;
	}

	public void setNvLapHD(NhanVien nvLapHD) {
		this.nvLapHD = nvLapHD;
	}

	public CuaHang getCuaHang() {
		return cuaHang;
	}

	public void setCuaHang(CuaHang cuaHang) {
		this.cuaHang = cuaHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "HopDong [maHD=" + maHD + ", ngaylapHD=" + ngaylapHD + ", thoiGianBH=" + thoiGianBH + ", loaiHD="
				+ loaiHD + ", nvLapHD=" + nvLapHD + ", cuaHang=" + cuaHang + ", khachHang=" + khachHang + "]";
	}

	
}
