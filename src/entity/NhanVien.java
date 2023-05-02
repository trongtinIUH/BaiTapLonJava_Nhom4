package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class NhanVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String maNV;
	private String tenNV;
	private String gioiTinh;
	private String diaChi;
	private String sdt;
	private String eMail;
	private Date ngayVaoLam;
	private String chucVu;
	private float luongCoBan;
	private String maCH;
	
	
	public NhanVien(String maNV, String tenNV, String gioiTinh, String diaChi, String sdt, String eMail,
			Date ngayVaoLam, String chucVu, float luongCoBan, String maCH) {
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
		this.maCH = maCH;
	}
	
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien(String maNV) {
		this.maNV = maNV;
	}
	
	public NhanVien(String tenNV, String chucVu, String sdt) {
		this.tenNV = tenNV;
		this.chucVu = chucVu;
		this.sdt = sdt;
	}


	public String getMaCH() {
		return maCH;
	}
	public void setMaCH(String maCH) {
		this.maCH = maCH;
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
	
	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
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
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public float getLuongCoBan() {
		return luongCoBan;
	}
	public void setLuongCoBan(float luongCoBan) {
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
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi
				+ ", sdt=" + sdt + ", eMail=" + eMail + ", ngayVaoLam=" + ngayVaoLam + ", chucVu=" + chucVu
				+ ", luongCoBan=" + luongCoBan + ", maCH=" + maCH + "]";
	}
	
	
	

}
