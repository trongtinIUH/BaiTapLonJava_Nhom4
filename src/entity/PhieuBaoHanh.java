package entity;

import java.io.Serializable;
import java.util.Date;

public class PhieuBaoHanh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String maPhieuBH;
	private HopDong hd;
	private LinhKienPhuTung lkpt;
	private Date ngayBH;
	private String liDo;
	private String loiCuaAi;
	private double giaTienSua;
	private NhanVien nhanVien;
	private KhachHang kh;
	
	public PhieuBaoHanh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhieuBaoHanh(String maPhieuBH, HopDong hd, LinhKienPhuTung lkpt, Date ngayBH, String liDo, String loiCuaAi,
			double giaTienSua, NhanVien nhanVien, KhachHang kh) {
		super();
		this.maPhieuBH = maPhieuBH;
		this.hd = hd;
		this.lkpt = lkpt;
		this.ngayBH = ngayBH;
		this.liDo = liDo;
		this.loiCuaAi = loiCuaAi;
		this.giaTienSua = giaTienSua;
		this.nhanVien = nhanVien;
		this.kh = kh;
	}

	public PhieuBaoHanh(String maPhieuBH) {
		super();
		this.maPhieuBH = maPhieuBH;
	}

	public String getMaPhieuBH() {
		return maPhieuBH;
	}

	public void setMaPhieuBH(String maPhieuBH) {
		this.maPhieuBH = maPhieuBH;
	}

	public HopDong getHd() {
		return hd;
	}

	public void setHd(HopDong hd) {
		this.hd = hd;
	}

	public LinhKienPhuTung getLkpt() {
		return lkpt;
	}

	public void setLkpt(LinhKienPhuTung lkpt) {
		this.lkpt = lkpt;
	}

	public Date getNgayBH() {
		return ngayBH;
	}

	public void setNgayBH(Date ngayBH) {
		this.ngayBH = ngayBH;
	}

	public String getLiDo() {
		return liDo;
	}

	public void setLiDo(String liDo) {
		this.liDo = liDo;
	}

	public String getLoiCuaAi() {
		return loiCuaAi;
	}

	public void setLoiCuaAi(String loiCuaAi) {
		this.loiCuaAi = loiCuaAi;
	}

	public double getGiaTienSua() {
		return giaTienSua;
	}

	public void setGiaTienSua(double giaTienSua) {
		this.giaTienSua = giaTienSua;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	public KhachHang getKh() {
		return kh;
	}

	public void setKh(KhachHang kh) {
		this.kh = kh;
	}

	@Override
	public String toString() {
		return "PhieuBaoHanh [maPhieuBH=" + maPhieuBH + ", hd=" + hd + ", lkpt=" + lkpt + ", ngayBH=" + ngayBH
				+ ", liDo=" + liDo + ", loiCuaAi=" + loiCuaAi + ", giaTienSua=" + giaTienSua + ", nhanVien=" + nhanVien
				+ ", kh=" + kh + "]";
	}
	
}
