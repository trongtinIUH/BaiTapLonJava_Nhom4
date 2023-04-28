package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class NV_KyThuat extends NhanVien {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bacTho;
	private int soNamKN;
	
	
	
	

	
	public NV_KyThuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NV_KyThuat(String maNV, String tenNV, String gioiTinh, String diaChi, String sdt, String eMail,
			Date ngayVaoLam, String chucVu, float luongCoBan, String maCH) {
		super(maNV, tenNV, gioiTinh, diaChi, sdt, eMail, ngayVaoLam, chucVu, luongCoBan, maCH);
		// TODO Auto-generated constructor stub
	}
	public NV_KyThuat(String maNV, String tenNV, String gioiTinh, String diaChi, String sdt, String eMail,
			Date ngayVaoLam, String chucVu, float luongCoBan, String maCH, String bacTho, int soNamKN) {
		super(maNV, tenNV, gioiTinh, diaChi, sdt, eMail, ngayVaoLam, chucVu, luongCoBan, maCH);
		this.bacTho = bacTho;
		this.soNamKN = soNamKN;
	}
	public String getBacTho() {
		return bacTho;
	}
	public void setBacTho(String bacTho) {
		this.bacTho = bacTho;
	}
	public int getSoNamKN() {
		return soNamKN;
	}
	public void setSoNamKN(int soNamKN) {
		this.soNamKN = soNamKN;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bacTho, soNamKN);
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
		NV_KyThuat other = (NV_KyThuat) obj;
		return Objects.equals(bacTho, other.bacTho) && soNamKN == other.soNamKN;
	}
	@Override
	public String toString() {
		return String.format("NV_KyThuat [bacTho=%s, soNamKN=%s]", bacTho, soNamKN);
	}
	
}
