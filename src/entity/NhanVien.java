package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class NhanVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String maNV;
	private String tenNV;
	private boolean gioiTinh;
	private String diaChi;
	private String sdt;
	private String eMail;
	private LocalDate ngayVaoLam;
	private String chucVu;
	private double luongCoBan;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNV, String tenNV, boolean gioiTinh, String diaChi, String sdt, String eMail,
			LocalDate ngayVaoLam, String chucVu, double luongCoBan) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.eMail = eMail;
		this.ngayVaoLam = ngayVaoLam;
		this.chucVu = chucVu;
		this.luongCoBan = luongCoBan;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
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
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public double getLuongCoBan() {
		return luongCoBan;
	}
	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	@Override
	public String toString() {
		return String.format(
				"NhanVien [maNV=%s, tenNV=%s, gioiTinh=%s, diaChi=%s, sdt=%s, eMail=%s, ngayVaoLam=%s, chucVu=%s, luongCoBan=%s]",
				maNV, tenNV, gioiTinh, diaChi, sdt, eMail, ngayVaoLam, chucVu, luongCoBan);
	}
	
	

}
