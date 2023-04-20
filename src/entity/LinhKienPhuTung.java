package entity;

import java.math.BigDecimal;
import java.util.Objects;

public class LinhKienPhuTung extends MatHang {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hangSX;
	
	
	public LinhKienPhuTung() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LinhKienPhuTung(String maMH, String hangSX) {
		super(maMH);
		this.hangSX = hangSX;
	}


	public LinhKienPhuTung(String maMH, String tenMH, String dvt, String moTa, BigDecimal donGia, int slTon,
			String loaiMH) {
		super(maMH, tenMH, dvt, moTa, donGia, slTon, loaiMH);
		// TODO Auto-generated constructor stub
	}
	public LinhKienPhuTung(String hangSX) {
		super();
		this.hangSX = hangSX;
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
		result = prime * result + Objects.hash(hangSX);
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
		return Objects.equals(hangSX, other.hangSX);
	}
	@Override
	public String toString() {
		return "LinhKienPhuTung [hangSX=" + hangSX + "]";
	}
	
}
