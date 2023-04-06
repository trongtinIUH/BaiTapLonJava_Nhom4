package du_an;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachNhanVien implements Serializable{
	private ArrayList<NhanVien> ls;

	public DanhSachNhanVien() {
		super();
		ls = new ArrayList<>();
	}
	public boolean themNV(NhanVien nv) {
		for (int i = 0; i < ls.size(); i++) 
			if(ls.get(i).getMaNV().equalsIgnoreCase(nv.getMaNV())) {
				return false;
			}
		ls.add(nv);
		return true;
	}
	public ArrayList<NhanVien> getList(){
		return ls;
	}
	public boolean xoa(int vitri) {
		if(vitri>=0&&vitri<=ls.size()) {
			ls.remove(vitri);
			return true;
		}
		return false;
	}
	public boolean kiemtra(String manv)
	{
		NhanVien nv= new NhanVien();
		if(ls.contains(nv))
		{
			return true;
		}
		return false;
	}
	public int timkiemNV(String manv)
	{
		for (int i = 0; i < ls.size(); i++) {
			if(ls.get(i).getMaNV().equalsIgnoreCase(manv))
				return i;
		}
		return -1;
	}
	
	public boolean sua(String manv, String honv, String tennv, String phai, int tuoi, double tienLuong)
	{
		NhanVien nv = new NhanVien(manv, honv, tennv, phai, tuoi, tienLuong);
		if(ls.contains(nv)) {
			nv.setMaNV(manv);
			nv.setHo(honv);
			nv.setTenNV(tennv);
			nv.setPhai(phai);
			nv.setTuoi(tuoi);
			nv.setTienLuong(tienLuong);
			return true;
		}
		return false;
	}
	
	
}
