package entity;

import java.io.Serializable;
import java.util.Objects;

public class ChiTietHopDong implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HopDong hopDong;
	private String maChiTietHD;
	private MatHang matHang;
	private int soLuong;
	public ChiTietHopDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChiTietHopDong(String maChiTietHD) {
		this.maChiTietHD = maChiTietHD;
	}

	public ChiTietHopDong(HopDong hopDong, String maChiTietHD, MatHang matHang, int soLuong) {
		super();
		this.hopDong = hopDong;
		this.maChiTietHD = maChiTietHD;
		this.matHang = matHang;
		this.soLuong = soLuong;
	}
	
	
	public HopDong getHopDong() {
		return hopDong;
	}

	public void setHopDong(HopDong hopDong) {
		this.hopDong = hopDong;
	}

	public String getMaChiTietHD() {
		return maChiTietHD;
	}
	public void setMaChiTietHD(String maChiTietHD) {
		this.maChiTietHD = maChiTietHD;
	}
	public MatHang getMatHang() {
		return matHang;
	}
	public void setMatHang(MatHang matHang) {
		this.matHang = matHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(maChiTietHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHopDong other = (ChiTietHopDong) obj;
		return Objects.equals(maChiTietHD, other.maChiTietHD);
	}

	@Override
	public String toString() {
		return "ChiTietHopDong [hopDong=" + hopDong + ", maChiTietHD=" + maChiTietHD + ", matHang=" + matHang
				+ ", soLuong=" + soLuong + "]";
	}
}
