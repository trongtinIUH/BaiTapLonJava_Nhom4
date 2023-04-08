package entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDonHang {
	private MatHang mh;
	private KhachHang kh;
	private NhanVien nv;
	private LocalDate ngayGD;
	public HoaDonHang(MatHang mh, KhachHang kh, NhanVien nv, LocalDate ngayGD) {
		super();
		this.mh = mh;
		this.kh = kh;
		this.nv = nv;
		this.ngayGD = ngayGD;
	}
	public HoaDonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatHang getMh() {
		return mh;
	}
	public void setMh(MatHang mh) {
		this.mh = mh;
	}
	public KhachHang getKh() {
		return kh;
	}
	public void setKh(KhachHang kh) {
		this.kh = kh;
	}
	public NhanVien getNv() {
		return nv;
	}
	public void setNv(NhanVien nv) {
		this.nv = nv;
	}
	public LocalDate getNgayGD() {
		return ngayGD;
	}
	public void setNgayGD(LocalDate ngayGD) {
		this.ngayGD = ngayGD;
	}
	@Override
	public int hashCode() {
		return Objects.hash(kh, mh, ngayGD, nv);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonHang other = (HoaDonHang) obj;
		return Objects.equals(kh, other.kh) && Objects.equals(mh, other.mh) && Objects.equals(ngayGD, other.ngayGD)
				&& Objects.equals(nv, other.nv);
	}
	@Override
	public String toString() {
		return String.format("HoaDonHang [mh=%s, kh=%s, nv=%s, ngayGD=%s]", mh, kh, nv, ngayGD);
	}
	
}
