package du_an;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Database {
	public void saveFile(String filename,Object o) {
		FileOutputStream fos=  null;
		ObjectOutputStream oos= null;
		try {
			fos=  new FileOutputStream(filename);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "IO Error!");
			return;
		}
	}
	public Object readFile(String filename) {
		Object o=  null;
		FileInputStream fis= null;
		ObjectInputStream ois= null;
		try {
			fis=  new FileInputStream(filename);
			ois=new ObjectInputStream(fis);
			o= ois.readObject();
			ois.close();
		}catch (Exception ex) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "IO Error!");
			
		} return o;
	}
	
	//lam doc file txt
	public DanhSachNhanVien read_nv(String part)throws Exception{
		DanhSachNhanVien ds = new DanhSachNhanVien();
		File f = new File(part);
		if(f.exists()) {
			Scanner sc= new Scanner(f);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String []data= line.split(",");
				NhanVien nv =new NhanVien(data[0], data[1], data[2], data[3],Integer.parseInt(data[4]),Double.parseDouble(data[5]));
				ds.themNV(nv);
			}
			sc.close();
		}
		else {
			f.createNewFile();
		}
		return ds;
	}
	
	//ghi file txt
	public void writeNV(String part,DanhSachNhanVien ds) throws Exception{
		try (
			PrintWriter out= new PrintWriter(new FileOutputStream(part),true)) {
			for(NhanVien nv: ds.getList()) {
				String data= nv.getMaNV()+","+nv.getHo()+","+nv.getTenNV()+","+nv.getPhai()+","+nv.getTuoi()+","+nv.getTienLuong();
				out.println(data);
			}
				
			}
		
	}
}
