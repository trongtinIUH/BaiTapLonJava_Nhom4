package entity;

import java.util.Objects;

public class LinhKienPhuTung extends MatHang {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maLinhKien;
	private String tenLinhKien;
	private String hangSX;
	public LinhKienPhuTung() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LinhKienPhuTung(String maMH, String dvt, String moTa, double donGia, int slTon) {
		super(maMH, dvt, moTa, donGia, slTon);
		// TODO Auto-generated constructor stub
	}
	public LinhKienPhuTung(String maMH, String dvt, String moTa, double donGia, int slTon, String maLinhKien,
			String tenLinhKien, String hangSX) {
		super(maMH, dvt, moTa, donGia, slTon);
		this.maLinhKien = maLinhKien;
		this.tenLinhKien = tenLinhKien;
		this.hangSX = hangSX;
	}
	public String getMaLinhKien() {
		return maLinhKien;
	}
	public void setMaLinhKien(String maLinhKien) {
		this.maLinhKien = maLinhKien;
	}
	public String getTenLinhKien() {
		return tenLinhKien;
	}
	public void setTenLinhKien(String tenLinhKien) {
		this.tenLinhKien = tenLinhKien;
	}
	public String getHangSX() {
		return hangSX;
	}
	public void setHangSX(String hangSX) {
		this.hangSX = hangSX;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(maLinhKien);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinhKienPhuTung other = (LinhKienPhuTung) obj;
		return Objects.equals(maLinhKien, other.maLinhKien);
	}
	@Override
	public String toString() {
		return String.format("LinhKienPhuTung [maLinhKien=%s, tenLinhKien=%s, hangSX=%s]", maLinhKien, tenLinhKien,
				hangSX);
	}
	
}
