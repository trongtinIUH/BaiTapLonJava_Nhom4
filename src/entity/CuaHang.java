package entity;

import java.io.Serializable;
import java.util.Objects;

public class CuaHang  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String tenCuaHang;
	private String diaChi;
	private  String sdt;
	
	public CuaHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CuaHang(String tenCuaHang, String diaChi, String sdt) {
		super();
		this.tenCuaHang = tenCuaHang;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}
	public String getTenCuaHang() {
		return tenCuaHang;
	}
	public void setTenCuaHang(String tenCuaHang) {
		this.tenCuaHang = tenCuaHang;
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
		return Objects.hash(tenCuaHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuaHang other = (CuaHang) obj;
		return Objects.equals(tenCuaHang, other.tenCuaHang);
	}
	@Override
	public String toString() {
		return String.format("CuaHang [tenCuaHang=%s, diaChi=%s, sdt=%s]", tenCuaHang, diaChi, sdt);
	}
	
	
}
