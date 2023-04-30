package entity;
import java.util.Objects;

public class LinhKienPhuTung extends MatHang {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maLinhKien;
	private String hangSX;
	
	
	public LinhKienPhuTung() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public LinhKienPhuTung(String maMH, String tenMH, String dvt, String moTa, double donGia, int slTon,
			String loaiMH) {

		super(maMH, tenMH, dvt, moTa, donGia, slTon, loaiMH);
		// TODO Auto-generated constructor stub
	}
	
	
	public LinhKienPhuTung(String maMH, String tenMH, String dvt, String moTa, double donGia, int slTon, String loaiMH,
			String maLinhKien, String hangSX) {
		super(maMH, tenMH, dvt, moTa, donGia, slTon, loaiMH);
		this.maLinhKien = maLinhKien;
		this.hangSX = hangSX;
	}
	
	
	public LinhKienPhuTung(String maLinhKien) {
		this.maLinhKien = maLinhKien;
	}

	public LinhKienPhuTung(String maLinhKien, String hangSX) {
		super();
		this.maLinhKien = maLinhKien;
		this.hangSX = hangSX;
	}


	public String getMaLinhKien() {
		return maLinhKien;
	}


	public void setMaLinhKien(String maLinhKien) {
		this.maLinhKien = maLinhKien;
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
		return "LinhKienPhuTung [maLinhKien=" + maLinhKien + ", hangSX=" + hangSX + "]";
	}
	
	
	
	
}
