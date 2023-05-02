package entity;

import java.sql.Date;

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



	public NV_KyThuat(String ma, String bactho2, int namkm) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	




	public NV_KyThuat(String maNV, String tenNV, String gioiTinh, String diaChi, String sdt, String eMail,
			Date ngayVaoLam, String chucVu, float luongCoBan, String maCH) {
		super(maNV, tenNV, gioiTinh, diaChi, sdt, eMail, ngayVaoLam, chucVu, luongCoBan, maCH);
		// TODO Auto-generated constructor stub
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
	public String toString() {
		return String.format("NV_KyThuat [bacTho=%s, soNamKN=%s]", bacTho, soNamKN);
	}
	
	

	
	
	


}
