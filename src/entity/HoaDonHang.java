package entity;

import java.sql.Date;

public class HoaDonHang {
	private String maHDH;
	private CuaHang ch;
	private MatHang mh;
	private NhanVien nv;
	private Date ngayGD;

	public HoaDonHang(MatHang mh, NhanVien nv, Date ngayGD) {
		super();
		this.mh = mh;
		this.nv = nv;
		this.ngayGD = ngayGD;
	}

	public HoaDonHang(String maHDH, CuaHang ch, Date ngayGD) {
		super();
		this.maHDH = maHDH;
		this.ch = ch;
		this.ngayGD = ngayGD;
	}

	public HoaDonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HoaDonHang(String maHDH, CuaHang ch, MatHang mh) {
		super();
		this.maHDH = maHDH;
		this.ch = ch;
		this.mh = mh;
	}
	
	

	public HoaDonHang(String maHDH, MatHang mh) {
		super();
		this.maHDH = maHDH;
		this.mh = mh;
	}

	public HoaDonHang(String maHDH, CuaHang ch, MatHang mh, Date ngayGD) {
		super();
		this.maHDH = maHDH;
		this.ch = ch;
		this.mh = mh;
		this.ngayGD = ngayGD;
	}

	public HoaDonHang(String maHDH) {
		super();
		this.maHDH = maHDH;
	}

	public String getMaHDH() {
		return maHDH;
	}

	public void setMaHDH(String maHDH) {
		this.maHDH = maHDH;
	}
	
	public CuaHang getCh() {
		return ch;
	}

	public void setCh(CuaHang ch) {
		this.ch = ch;
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

	public Date getNgayGD() {
		return ngayGD;
	}

	public void setNgayGD(Date ngayGD) {
		this.ngayGD = ngayGD;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
