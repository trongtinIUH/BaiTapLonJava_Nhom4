package du_an_2;

import java.io.Serializable;

public class NhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maNV;
	private String ho;
	private String tenNV;
	private String phai;
	private int tuoi;
	private double tienLuong;
	public NhanVien(String maNV, String ho, String tenNV, String phai, int tuoi, double tienLuong) {
		super();
		this.maNV = maNV;
		this.ho = ho;
		this.tenNV = tenNV;
		this.phai = phai;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
	}
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getPhai() {
		return phai;
	}
	public void setPhai(String phai) {
		this.phai = phai;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public double getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}
	
}
