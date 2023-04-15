package entity;

import java.time.LocalDate;
import java.util.Objects;

public class NV_HanhChinh extends NhanVien {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hocVan;

	public String getHocVan() {
		return hocVan;
	}

	public void setHocVan(String hocVan) {
		this.hocVan = hocVan;
	}

	public NV_HanhChinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NV_HanhChinh(String maNV, String tenNV, boolean gioiTinh, String diaChi, String sdt, String eMail,
			LocalDate ngayVaoLam, String chucVu, double luongCoBan) {
		super(maNV, tenNV, gioiTinh, diaChi, sdt, eMail, ngayVaoLam, chucVu, luongCoBan);
		// TODO Auto-generated constructor stub
	}

	public NV_HanhChinh(String hocVan) {
		super();
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
		return String.format("NhanVienKyThuat [hocVan=%s]", hocVan);
	}
	
}