package entity;

import java.sql.Date;
import java.util.Objects;

public class NV_HanhChinh extends NhanVien {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tenPB;
	private String hocVan;

	
	





	public NV_HanhChinh() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	public NV_HanhChinh(String maNV, String tenNV, String gioiTinh, String diaChi, String sdt, String eMail,
			Date ngayVaoLam, String chucVu, float luongCoBan, String maCH, String tenPB, String hocVan) {
		super(maNV, tenNV, gioiTinh, diaChi, sdt, eMail, ngayVaoLam, chucVu, luongCoBan, maCH);
		this.tenPB = tenPB;
		this.hocVan = hocVan;
	}




	public NV_HanhChinh(String maNV, String tenNV, String gioiTinh, String diaChi, String sdt, String eMail,
			Date ngayVaoLam, String chucVu, float luongCoBan, String maCH) {
		super(maNV, tenNV, gioiTinh, diaChi, sdt, eMail, ngayVaoLam, chucVu, luongCoBan, maCH);
		// TODO Auto-generated constructor stub
	}




	public NV_HanhChinh(String tenNV, String chucVu, String sdt) {
		super(tenNV, chucVu, sdt);
		// TODO Auto-generated constructor stub
	}




	public NV_HanhChinh(String maNV) {
		super(maNV);
		// TODO Auto-generated constructor stub
	}




	public String getTenPB() {
		return tenPB;
	}



	public void setTenPB(String tenPB) {
		this.tenPB = tenPB;
	}



	public String getHocVan() {
		return hocVan;
	}

	public void setHocVan(String hocVan) {
		this.hocVan = hocVan;
	}
	
	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hocVan);
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
		NV_HanhChinh other = (NV_HanhChinh) obj;
		return Objects.equals(hocVan, other.hocVan);
	}



	@Override
	public String toString() {
		return String.format("NV_HanhChinh [hocVan=%s, tenPB=%s]", hocVan, tenPB);
	}


	
}
