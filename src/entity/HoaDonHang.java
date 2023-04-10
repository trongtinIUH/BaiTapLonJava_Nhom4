package entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDonHang {
	private MatHang mh;
	private NhanVien nv;
	private LocalDate ngayGD;

	public HoaDonHang(MatHang mh, NhanVien nv, LocalDate ngayGD) {
		super();
		this.mh = mh;
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
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
