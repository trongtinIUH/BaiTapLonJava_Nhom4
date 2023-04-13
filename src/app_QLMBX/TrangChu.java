package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.Serializable;

import javax.swing.Box;
import javax.swing.ImageIcon;
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
	private JLabel lblBanHang;
	
	//văng các frm vào đây
	
	public TrangChu() {
		super("Hệ Thống Quản Lí Mua Bán Xe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("img\\settings_FILL0_wght400_GRAD0_opsz48.png");
        this.setIconImage(icon);
		setSize(900, 800);
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
		
		
//		JPanel pnEast = new JPanel();
//		JPanel pnWest = new JPanel();
//		add(pnEast,BorderLayout.EAST);
//		add(pnWest,BorderLayout.WEST);
//		JPanel pnSoth = new JPanel();
//		add(pnSoth,BorderLayout.SOUTH);
		
		
		
		Box b= Box.createVerticalBox();
		Box b1= Box.createHorizontalBox();
		Box b2= Box.createHorizontalBox();
		Box b3= Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		
		JPanel pnWEST = new JPanel();
		pnWEST.add(b);
//		label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("img\\logo-cua-hang-xe-may (16).jpg")));
		//pnWEST.add(label);
		add(pnWEST,BorderLayout.WEST);
		
		  lblBanHang = new JLabel(new ImageIcon("image/ManagerUI/lblBanHang.png"));
		  b1.add(lblBanHang);
		  
		
		
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
