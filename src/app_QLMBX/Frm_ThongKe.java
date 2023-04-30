package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frm_ThongKe extends JPanel implements Serializable {


	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle, lblsanPham,lblkhachhang,lblnhanVien, lbldoanhThu;
	private JTextField txtsanpham,txtkhachHang,txtnhanVien,txtDoanhThu;
	
//public static void main(String[] args) {
//	new Frm_ThongKe().setVisible(true);
//}
		public Frm_ThongKe() {
			setSize(990, 600);
//			setDefaultCloseOperation(EXIT_ON_CLOSE);
//			setLocationRelativeTo(null);
			
			JPanel pnControl = new JPanel();
			pnControl.setLayout(new BorderLayout());
			JPanel pnContent = new JPanel();
		//	pnContent.setBackground(Color.white);
			pnContent.setLayout(null);
		
			
			pnContent.add(lblTitle= new JLabel("THỐNG KÊ TỔNG QUÁT"));
			lblTitle.setForeground(Color.black);
			lblTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
			lblTitle.setBounds(330, 10, 400, 40);

			int x = 100, y = 50, width = 360, height = 200;
			
			
			
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
			
			pnContent.add(lbldoanhThu = new JLabel(""));
			lbldoanhThu.setIcon(new ImageIcon("image\\thongKeDoanhThu.png"));
			lbldoanhThu.setBounds(520, y, width, height);
			
			
			x+=200;y = 200;width = 70;height = 50;
			pnContent.add(txtsanpham = new JTextField("150"));
			txtsanpham.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
			txtsanpham.setForeground(Color.black);
			txtsanpham.setEnabled(true);
			txtsanpham.setBounds(170, y, width, height);
			
			
			pnContent.add(txtkhachHang = new JTextField("150"));
			txtkhachHang.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
			txtkhachHang.setForeground(Color.black);
			txtkhachHang.setEnabled(true);
			txtkhachHang.setBounds(600, 200, width, height);
			
			pnContent.add(txtnhanVien = new JTextField("150"));
			txtnhanVien.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
			txtnhanVien.setForeground(Color.black);
			txtnhanVien.setEnabled(true);
			txtnhanVien.setBounds(190, 450, width, height);
			
			pnContent.add(txtDoanhThu = new JTextField("3.346.000VND"));
			txtDoanhThu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
			txtDoanhThu.setForeground(Color.black);
			txtDoanhThu.setEnabled(true);
			txtDoanhThu.setBounds(540, 450, 220, height);
			
		this.add(pnContent);

		}

}
