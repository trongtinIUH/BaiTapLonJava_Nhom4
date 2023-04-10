package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.io.Serializable;

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
	
	//văng các frm vào đây
	
	public TrangChu() {
		super("Hệ Thống Quản Lí Mua Bán Xe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel pNorth = new JPanel();
		JLabel tieuDe = new JLabel();
		pNorth.setLayout(new GridBagLayout());
		pNorth.setPreferredSize(new Dimension(800, 60));
		pNorth.add(tieuDe = new JLabel("Hệ Thống Quản Lí Mua Bán Xe"));
		tieuDe.setFont(new Font("Roboto", Font.BOLD, 30));
		tieuDe.setForeground(Color.DARK_GRAY);
		pNorth.setBackground(new Color(191,247,249));
		add(pNorth, BorderLayout.NORTH);
		
		/*
		 * quăng các frm giao diện vào tabPane theo ví dụ bên dưới
		 */
		tabPane.setFont(new Font("Roboto", Font.BOLD, 15));
		tabPane.setBackground(new Color(144, 238, 237));
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
