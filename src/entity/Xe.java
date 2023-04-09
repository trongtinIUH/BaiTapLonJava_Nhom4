package entity;

import java.util.Objects;

public class Xe extends MatHang{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maXe;
	private String tenXe;
	private String dongXe;
	private String soKhung;
	private String mauXe;
	private int soPK;
	private String soSuon;
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public String getDongXe() {
		return dongXe;
	}
	public void setDongXe(String dongXe) {
		this.dongXe = dongXe;
	}
	public String getSoKhung() {
		return soKhung;
	}
	public void setSoKhung(String soKhung) {
		this.soKhung = soKhung;
	}
	public String getMauXe() {
		return mauXe;
	}
	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}
	public int getSoPK() {
		return soPK;
	}
	public void setSoPK(int soPK) {
		this.soPK = soPK;
	}
	public String getSoSuon() {
		return soSuon;
	}
	public void setSoSuon(String soSuon) {
		this.soSuon = soSuon;
	}
	public Xe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Xe(String maMH, String dvt, String moTa, double donGia, int slTon, String maXe, String tenXe, String dongXe,
			String soKhung, String mauXe, int soPK, String soSuon) {
		super(maMH, dvt, moTa, donGia, slTon);
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.dongXe = dongXe;
		this.soKhung = soKhung;
		this.mauXe = mauXe;
		this.soPK = soPK;
		this.soSuon = soSuon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maXe);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Xe other = (Xe) obj;
		return Objects.equals(maXe, other.maXe);
	}
	@Override
	public String toString() {
		return String.format("Xe [maXe=%s, tenXe=%s, dongXe=%s, soKhung=%s, mauXe=%s, soPK=%s, soSuon=%s]", maXe, tenXe,
				dongXe, soKhung, mauXe, soPK, soSuon);
	}
	
}
