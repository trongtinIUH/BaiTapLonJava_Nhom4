package entity;

import java.io.Serializable;
import java.util.Objects;

public class MatHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maMH;
	private String tenMH;
	private String dvt;
	private String moTa;
	private double donGia;
	private int slTon;
	private String loaiMH;
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public String getDvt() {
		return dvt;
	}
	public void setDvt(String dvt) {
		this.dvt = dvt;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}
	public int getSlTon() {
		return slTon;
	}
	public void setSlTon(int slTon) {
		this.slTon = slTon;
	}
	public String getLoaiMH() {
		return loaiMH;
	}
	public void setLoaiMH(String loaiMH) {
		this.loaiMH = loaiMH;
	}
	public MatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MatHang(String maMH) {
		super();
		this.maMH = maMH;
	}
	public MatHang(String maMH, String tenMH, String dvt, String moTa, double donGia, int slTon, String loaiMH) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.dvt = dvt;
		this.moTa = moTa;
		this.donGia = donGia;
		this.slTon = slTon;
		this.loaiMH = loaiMH;
	}
	
	public MatHang(String maMH, String tenMH, double donGia, int slTon) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.donGia = donGia;
		this.slTon = slTon;
	}
	@Override
	public String toString() {
		return "MatHang [maMH=" + maMH + ", tenMH=" + tenMH + ", dvt=" + dvt + ", moTa=" + moTa + ", donGia=" + donGia
				+ ", slTon=" + slTon + ", loaiMH=" + loaiMH + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maMH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatHang other = (MatHang) obj;
		return Objects.equals(maMH, other.maMH);
	}
	
	
}
