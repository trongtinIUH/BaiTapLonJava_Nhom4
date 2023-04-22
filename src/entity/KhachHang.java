package entity;

import java.io.Serializable;
import java.util.Objects;

public class KhachHang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String maKH;
	private String tenKH;
	private String gioiTinh;
	private String diaChi;
	private String sdt;
	
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH, String tenKH, String gioiTinh, String diaChi, String sdt) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}
	
	public KhachHang(String maKH) {
		this.maKH = maKH;
	}
	
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi
				+ ", sdt=" + sdt + "]";
	}
	
	
	
}
