package entity;

import java.io.Serializable;
import java.util.Objects;

public class MatHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maMH;
	private String dvt;
	private String moTa;
	private double donGia;
	private int slTon;
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
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
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSlTon() {
		return slTon;
	}
	public void setSlTon(int slTon) {
		this.slTon = slTon;
	}
	public MatHang(String maMH, String dvt, String moTa, double donGia, int slTon) {
		super();
		this.maMH = maMH;
		this.dvt = dvt;
		this.moTa = moTa;
		this.donGia = donGia;
		this.slTon = slTon;
	}
	public MatHang() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return String.format("MatHang [maMH=%s, dvt=%s, moTa=%s, donGia=%s, slTon=%s]", maMH, dvt, moTa, donGia, slTon);
	}
}
