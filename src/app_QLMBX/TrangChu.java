package app_QLMBX;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.LayoutStyle.ComponentPlacement;


public class TrangChu extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel lblNewLabel = new JLabel("HỆ THỐNG QUẢN LÍ MUA BÁN XE MÁY");
	private final JPanel panel_1 = new JPanel();
	private ImageIcon hinhgt;
	private JButton btnBanHang;
	private JButton btnKhuyenMai;
	private JButton btnNhanVien;
	private JButton btnKhachHang;
	private JButton btnNhaphang;
	private JTabbedPane tabbedPane;
	private JButton btnSanPham;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	new TrangChu().setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public TrangChu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 1280, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		lblNewLabel.setBackground(new Color(128, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		
		panel.add(lblNewLabel);
		panel_1.setBorder(new CompoundBorder());
		panel_1.setBackground(Color.CYAN);
		
		this.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 8, 1));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setForeground(Color.WHITE);
		panel_1.add(panel_2);
		
		 btnBanHang = new JButton("Bán Hàng");
		btnBanHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBanHang.setForeground(Color.BLACK);
		btnBanHang.setBackground(Color.pink);
		btnBanHang.setBorderPainted(false);
		btnBanHang.setIcon(new ImageIcon("D:\\QuanLyMuaBanXe\\icon\\banhang.png"));
		btnBanHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		 btnKhuyenMai = new JButton("Khuyến Mãi");
		btnKhuyenMai.setIcon(new ImageIcon("D:\\QuanLyMuaBanXe\\icon\\khuyenmai.png"));
		btnKhuyenMai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhuyenMai.setForeground(Color.BLACK);
		btnKhuyenMai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnKhuyenMai.setBackground(Color.WHITE);
		
		btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setIcon(new ImageIcon("D:\\QuanLyMuaBanXe\\icon\\sanpham.png"));
		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSanPham.setForeground(Color.BLACK);
		btnSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSanPham.setBackground(Color.WHITE);
		
		 btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setIcon(new ImageIcon("D:\\QuanLyMuaBanXe\\icon\\nhanvien.png"));
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNhanVien.setForeground(Color.BLACK);
		btnNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNhanVien.setBackground(Color.WHITE);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 165, 0));
		lblNewLabel_1.setIcon(new ImageIcon("D:\\QuanLyMuaBanXe\\img\\logo-cua-hang-xe-may (16).jpg"));
		panel_3.add(lblNewLabel_1);
		
		 btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhachHang.setIcon(new ImageIcon("D:\\QuanLyMuaBanXe\\icon\\khachhang.png"));
		btnKhachHang.setForeground(Color.BLACK);
		btnKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnKhachHang.setBackground(Color.WHITE);
		
		 btnNhaphang = new JButton("Nhập Hàng");
		btnNhaphang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNhaphang.setIcon(new ImageIcon("D:\\QuanLyMuaBanXe\\icon\\nhaphang.png"));
		btnNhaphang.setForeground(Color.BLACK);
		btnNhaphang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNhaphang.setBackground(Color.WHITE);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnKhuyenMai, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnBanHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnSanPham, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnKhachHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnNhaphang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBanHang, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnKhuyenMai, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSanPham, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNhanVien, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnKhachHang, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNhaphang, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(235))
		);
		panel_2.setLayout(gl_panel_2);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("");
		hinhgt= new ImageIcon("D:\\QuanLyMuaBanXe\\img\\hinhgioithieu.jpg");
		Image image = hinhgt.getImage();
		Image newImage = image.getScaledInstance(1050, 650, java.awt.Image.SCALE_SMOOTH);
		hinhgt= new ImageIcon(newImage);
		lblNewLabel_2.setIcon(hinhgt);
		tabbedPane.addTab("tab_GioiThieu\r\n", null, lblNewLabel_2, null);
		
		
		
		btnKhachHang.addActionListener(this);
		btnSanPham.addActionListener(this);
		btnBanHang.addActionListener(this);
		btnKhuyenMai.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnNhaphang.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o= e.getSource();
		if(o.equals(btnKhachHang)) {
		
		}
		if(o.equals(btnBanHang)) {
			
		}
		if(o.equals(btnKhuyenMai)) {
			
		}
	}


}
