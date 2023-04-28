package entity;
import java.util.Objects;

public class Xe extends MatHang{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maXe;
	private String dongXe;
	private String soKhung;
	private String mauXe;
	private int soPK;
	private String soSuon;
	private String xuatSu;
	
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	public String getXuatSu() {
		return xuatSu;
	}
	public void setXuatSu(String xuatSu) {
		this.xuatSu = xuatSu;
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
	
	
	
	public Xe(String maXe, String dongXe, String soKhung, String mauXe, int soPK, String soSuon, String xuatSu) {
		super();
		this.maXe = maXe;
		this.dongXe = dongXe;
		this.soKhung = soKhung;
		this.mauXe = mauXe;
		this.soPK = soPK;
		this.soSuon = soSuon;
		this.xuatSu = xuatSu;
	}
	public Xe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Xe(String maMH, String tenMH, String dvt, String moTa, double donGia, int slTon, String loaiMH) {
		super(maMH, tenMH, dvt, moTa, donGia, slTon, loaiMH);
		// TODO Auto-generated constructor stub
	}
	
	public Xe(String maMH, String tenMH, String dvt, String moTa, double donGia, int slTon, String loaiMH,
			String maXe, String dongXe, String soKhung, String mauXe, int soPK, String soSuon, String xuatSu) {
		super(maMH, tenMH, dvt, moTa, donGia, slTon, loaiMH);
		this.maXe = maXe;
		this.dongXe = dongXe;
		this.soKhung = soKhung;
		this.mauXe = mauXe;
		this.soPK = soPK;
		this.soSuon = soSuon;
		this.xuatSu = xuatSu;
	}
	@Override
	public String toString() {
		return "Xe [dongXe=" + dongXe + ", soKhung=" + soKhung + ", mauXe=" + mauXe + ", soPK=" + soPK + ", soSuon="
				+ soSuon + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dongXe, mauXe, soKhung, soPK, soSuon);
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
		Xe other = (Xe) obj;
		return Objects.equals(dongXe, other.dongXe) && Objects.equals(mauXe, other.mauXe)
				&& Objects.equals(soKhung, other.soKhung) && soPK == other.soPK && Objects.equals(soSuon, other.soSuon);
	}
	
}
