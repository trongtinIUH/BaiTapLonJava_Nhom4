package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.Serializable;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class TrangChu extends JFrame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPane= new JTabbedPane();
	private JLabel lblhinhchinh;
	private JButton btnbanhang;
	private JButton btnkhuyenmai;
	private JButton btnsanpham;
	private JButton btnnhanvien;
	private JButton btnkhachhang;
	private Component btnnhaphang;
	private JButton btnthongke;
	private ImageIcon hinhchinh;
	
	//văng các frm vào đây
	
	public TrangChu() {
		super("Hệ Thống Quản Lí Mua Bán Xe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("img\\settings_FILL0_wght400_GRAD0_opsz48.png");
        this.setIconImage(icon);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		//setResizable(false);
		
		JPanel pNorth = new JPanel();
		JLabel tieuDe = new JLabel();
		pNorth.setLayout(new GridBagLayout());
		pNorth.setPreferredSize(new Dimension(800, 60));
		pNorth.add(tieuDe = new JLabel("Hệ Thống Quản Lí Mua Bán Xe"));
		tieuDe.setFont(new Font("Roboto", Font.BOLD, 30));
		tieuDe.setForeground(Color.DARK_GRAY);
		pNorth.setBackground(new Color(191,247,249));
		add(pNorth, BorderLayout.NORTH);
		
	
		
		
		JPanel pnWEST = new JPanel();
		pnWEST.setBackground(Color.blue);
		pnWEST.setLayout(new GridLayout(9, 1));
		
//		label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("img\\logo-cua-hang-xe-may (16).jpg")));
		//pnWEST.add(label);
		add(pnWEST,BorderLayout.WEST);
		
		
		 lblhinhchinh = new JLabel(hinhchinh =new ImageIcon("img//logo-cua-hang-xe-may (16).jpg"));
		 pnWEST.add(lblhinhchinh);	
		
		 //làm tiếp này...
		 ImageIcon iicon= new ImageIcon("icon/banhang.png");
		 btnbanhang= new JButton("Bán Hàng");
		 btnbanhang.setFont(new Font("Times New Roman",0,25));
		 btnbanhang.setIcon(iicon);
		 pnWEST.add(btnbanhang);
		 
		 
		 ImageIcon iicon1= new ImageIcon("icon/khuyenmai.png");
		 btnkhuyenmai= new JButton("Khuyến Mãi");
		 btnkhuyenmai.setFont(new Font("Times New Roman",0,25));
		 btnkhuyenmai.setIcon(iicon1);
		 pnWEST.add(btnkhuyenmai);
		
		 
		 ImageIcon iicon2= new ImageIcon("icon/sanpham.png");
		 btnsanpham= new JButton("Sản Phẩm");
		 btnsanpham.setFont(new Font("Times New Roman",0,25));
		 btnsanpham.setIcon(iicon2);
		 pnWEST.add(btnsanpham);
		 
		 ImageIcon iicon3= new ImageIcon("icon/nhanvien.png");
		 btnnhanvien= new JButton("Nhân Viên");
		 btnnhanvien.setFont(new Font("Times New Roman",0,25));
		 btnnhanvien.setIcon(iicon3);
		 pnWEST.add(btnnhanvien);
		 
		 ImageIcon iicon4= new ImageIcon("icon/khachhang.png");
		 btnkhachhang= new JButton("Khách Hàng");
		 btnkhachhang.setFont(new Font("Times New Roman",0,25));
		 btnkhachhang.setIcon(iicon4);
		 pnWEST.add(btnkhachhang);
		 
		 ImageIcon iicon5= new ImageIcon("icon/nhaphang.png");
		 btnnhaphang= new JButton("Nhập Hàng");
		 btnnhaphang.setFont(new Font("Times New Roman",0,25));
		 btnnhaphang.setPreferredSize(new Dimension(50, 50));
		 ((AbstractButton) btnnhaphang).setIcon(iicon5);
		 pnWEST.add(btnnhaphang);
		 
		 ImageIcon iicon6= new ImageIcon("icon/thongke.png");
		 btnthongke= new JButton("Thống Kê");
		 btnthongke.setFont(new Font("Times New Roman",0,25));
		 btnthongke.setIcon(iicon6);
		 pnWEST.add(btnthongke);
		  
//		  lblkhuyenmai = new JLabel(new ImageIcon("image/ManagerUI/lblKhuyenMai.png"));
//		  b2.add(lblkhuyenmai);
//		  lblsanpham = new JLabel(new ImageIcon("image/ManagerUI/lblSanPham.png"));
//		  b3.add(lblsanpham);
//		  lblnhanvien = new JLabel(new ImageIcon("image/ManagerUI/lblNhanVien.png"));
//		  b4.add(lblnhanvien);
//		  lblkhachhang = new JLabel(new ImageIcon("image/ManagerUI/lblKhachHang.png"));
//		  b5.add(lblkhachhang);
//		  lblnhaphang = new JLabel(new ImageIcon("image/ManagerUI/lblNhapHang.png"));
//		  b6.add(lblnhaphang);
//		  lblthongke = new JLabel(new ImageIcon("image/ManagerUI/lblThongKe.png"));
//		  b7.add(lblthongke);
		  
		
		
//		JPanel pnCenter1 = new JPanel();
//		JLabel label1 = new JLabel();
//		label1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("img\\logo-cua-hang-xe-may (16).jpg")));
//		pnCenter1.add(label1);
//		add(pnCenter1,BorderLayout.EAST);
		
//		JPanel pnCenter2 = new JPanel();
//		JLabel label2 = new JLabel();
//		label2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("img\\logo-cua-hang-xe-may (16).jpg")));
//		pnCenter2.add(label2);
//		add(pnCenter2,BorderLayout.CENTER);
		

		
		/*
		 * quăng các frm giao diện vào tabPane theo ví dụ bên dưới
		 */
	//	tabPane.setFont(new Font("Roboto", Font.BOLD, 15));
//		tabPane.setBackground(new Color(144, 238, 237));
		//vd ở đây
		//tabPane.add("Quản lý thuốc", frmThuoc);
		//tabPane.add("Quản lý nhân viên", frmNhanVien);
		
		super.getContentPane().setBackground(new Color(191,247,249));
		super.getContentPane().add(tabPane);
	}

	

	
	public static void main(String[] args) {
		ImageIcon icon = new ImageIcon("icon/iconxe.png");
		TrangChu frm = new TrangChu();
		frm.setVisible(true);
		frm.setIconImage(icon.getImage());
	}
}
