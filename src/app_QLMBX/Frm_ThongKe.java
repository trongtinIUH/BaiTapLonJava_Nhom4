package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.Serializable;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ThongKe_DAO;

public class Frm_ThongKe extends JPanel implements Serializable {


	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblsanPham,lblkhachhang,lblnhanVien, lbldoanhThu;
	private JTextField txtsanpham,txtkhachHang,txtnhanVien,txtDoanhThu;
	private ThongKe_DAO thongke ;

	
	//
//public static void main(String[] args) {
//	new Frm_ThongKe().setVisible(true);
//}
		public Frm_ThongKe() {
			setSize(990, 600);
			thongke =new ThongKe_DAO();
//			setDefaultCloseOperation(EXIT_ON_CLOSE);
//			setLocationRelativeTo(null);
			
			JPanel pnControl = new JPanel();
			pnControl.setBackground(Color.white);
			pnControl.setLayout(new BorderLayout());
			JPanel pnNorth = new JPanel();
			JLabel lblTitle = new JLabel("THỐNG KÊ TỔNG QUÁT");
			lblTitle.setForeground(Color.black);
			lblTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
			
			pnNorth.add(lblTitle);
			pnControl.add(pnNorth, BorderLayout.NORTH);
			JPanel pnContent = new JPanel();
			pnContent.setLayout(null);
			pnContent.setPreferredSize(new Dimension(990, 600));
			

			int x = 300, y = 200, width = 70, height = 50;

			pnContent.add(txtsanpham = new JTextField(10));
			txtsanpham.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
			txtsanpham.setEnabled(false);
			txtsanpham.setBounds(170, y, width, height);
			int sp = thongke.getAllSanPham();
			txtsanpham.setForeground(Color.red);
			txtsanpham.setText(Integer.toString(sp));
			
			
			pnContent.add(txtkhachHang = new JTextField(10));
			txtkhachHang.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
			txtkhachHang.setEnabled(false);
			txtkhachHang.setForeground(Color.red);
			txtkhachHang.setBounds(600, 200, width, height);
			int tk = thongke.getAllKhachHang();
			txtkhachHang.setText(Integer.toString(tk));
			
			
			pnContent.add(txtnhanVien = new JTextField(10));
			txtnhanVien.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
			txtnhanVien.setEnabled(false);
			txtnhanVien.setForeground(Color.red);
			txtnhanVien.setBounds(190, 450, width, height);
			int nv = thongke.getAllNhanVien();
			txtnhanVien.setText(Integer.toString(nv));
			
		
			
			pnContent.add(txtDoanhThu = new JTextField(15));
			txtDoanhThu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
			txtDoanhThu.setForeground(Color.red);
			txtDoanhThu.setEnabled(false);
			txtDoanhThu.setBounds(540, 450, 260, height);
			DecimalFormat df = new DecimalFormat("#,##0.00 VNĐ");
			String doanhthu =df.format(thongke.getAllMoney());
			txtDoanhThu.setText(doanhthu);
			
			
			 x = 100; y = 50; width = 360; height = 200;
			pnContent.add(lblsanPham = new JLabel(""));
			lblsanPham.setIcon(new ImageIcon("image\\thongkesanpham.png"));
			lblsanPham.setBounds(x, y, width, height);
		//y+=30;
			pnContent.add(lblkhachhang = new JLabel(""));
			lblkhachhang.setIcon(new ImageIcon("image\\thongKeKhachHang.png"));
			lblkhachhang.setBounds(520, y, width, height);
			//y+=30;
			
			y+=250;
			pnContent.add(lblnhanVien = new JLabel(""));
			lblnhanVien.setIcon(new ImageIcon("image\\thongKeNhanVien.png"));
			lblnhanVien.setBounds(x, y, width, height);
			lblnhanVien.setForeground(Color.white);
			
			
			pnContent.add(lbldoanhThu = new JLabel(""));
			lbldoanhThu.setIcon(new ImageIcon("image\\thongKeDoanhThu.png"));
			lbldoanhThu.setBounds(520, y, width, height);
	
			
			
			
			
			pnControl.add(pnContent, BorderLayout.CENTER);
			this.add(pnControl);

		}
		public void loadData() {
			int sp = thongke.getAllSanPham();
			txtsanpham.setText(Integer.toString(sp));
			int tk = thongke.getAllKhachHang();
			txtkhachHang.setText(Integer.toString(tk));
			int nv = thongke.getAllNhanVien();
			txtnhanVien.setText(Integer.toString(nv));
			DecimalFormat df = new DecimalFormat("#,##0.00 VNĐ");
			String doanhthu =df.format(thongke.getAllMoney());
			txtDoanhThu.setText(doanhthu);
		}

}
