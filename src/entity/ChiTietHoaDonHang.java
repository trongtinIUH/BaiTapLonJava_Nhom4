package entity;

public class ChiTietHoaDonHang {
	private HoaDonHang hdh;
	private MatHang mh;
	private int soLuong;
	
	public HoaDonHang getHdh() {
		return hdh;
	}
	public void setHdh(HoaDonHang hdh) {
		this.hdh = hdh;
	}
	public MatHang getMh() {
		return mh;
	}
	public void setMh(MatHang mh) {
		this.mh = mh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
	public ChiTietHoaDonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDonHang(HoaDonHang hdh, MatHang mh, int soLuong) {
		super();
		this.hdh = hdh;
		this.mh = mh;
		this.soLuong = soLuong;
	}
	
	
	public ChiTietHoaDonHang(HoaDonHang hdh) {
		super();
		this.hdh = hdh;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDonHang [hdh=" + hdh + ", mh=" + mh + ", soLuong=" + soLuong + "]";
	}
	
	
}
