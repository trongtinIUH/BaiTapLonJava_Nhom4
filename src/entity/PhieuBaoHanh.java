package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class PhieuBaoHanh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NhanVien nhanVien;
	private LocalDate ngayBH;
	 //private String linhKienBH;
	 private String liDo;
	 private String loiCuaAi;
	 private double giaTienSua;
	public PhieuBaoHanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhieuBaoHanh(NhanVien nhanVien, LocalDate ngayBH, String liDo, String loiCuaAi, double giaTienSua) {
		super();
		this.nhanVien = nhanVien;
		this.ngayBH = ngayBH;
		this.liDo = liDo;
		this.loiCuaAi = loiCuaAi;
		this.giaTienSua = giaTienSua;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public LocalDate getNgayBH() {
		return ngayBH;
	}
	public void setNgayBH(LocalDate ngayBH) {
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
	@Override
	public String toString() {
		return String.format("PhieuBaoHanh [nhanVien=%s, ngayBH=%s, liDo=%s, loiCuaAi=%s, giaTienSua=%s]", nhanVien,
				ngayBH, liDo, loiCuaAi, giaTienSua);
	}
	 
	 
	

}
