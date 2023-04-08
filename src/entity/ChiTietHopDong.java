package entity;

import java.io.Serializable;

public class ChiTietHopDong implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MatHang matHang;
	private int soLuong;
	private double donGia;
	public ChiTietHopDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHopDong(MatHang matHang, int soLuong, double donGia) {
		super();
		this.matHang = matHang;
		this.soLuong = soLuong;
		this.donGia = donGia;
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
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	

}
