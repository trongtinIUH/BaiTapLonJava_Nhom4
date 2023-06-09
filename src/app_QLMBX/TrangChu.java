package app_QLMBX;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
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
	private JButton btnBanHang;
	private JButton btnHopDong;
	private JButton btnNhanVien;
	private JButton btnKhachHang;
	private JButton btnNhaphang;
	private JButton btnBaoHanh;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JButton btnSanPham;
	private JButton btnThongKe;

	//thêm các frm
	FrmBanHang banHang = new FrmBanHang();
	FrmKhachHang khachHang = new FrmKhachHang();
	Frm_DanhDachHopDong dsHopDong = new Frm_DanhDachHopDong(); // vẫn đề lại là khuyến mãi cho đễ sữa lại
	FrmNhanVien nhanVien = new FrmNhanVien();
	FrmNhapHang nhapHang = new FrmNhapHang();
	FrmSanPham sanPham = new FrmSanPham();
	FrmBaoHanh baohanh= new FrmBaoHanh();
	Frm_ThongKe thongke= new Frm_ThongKe();
	

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
		super("QuanLyMuaBanXe.java");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 1280, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(55, 129, 240));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		lblNewLabel.setBackground(new Color(128, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
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
		btnBanHang.setBackground(Color.white);
		//btnBanHang.setBorderPainted(false);
		btnBanHang.setIcon(new ImageIcon("icon\\banhang.png"));
		btnBanHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		 btnHopDong = new JButton("Hợp Đồng");
		 btnHopDong.setIcon(new ImageIcon("icon\\khuyenmai.png"));
		 btnHopDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 btnHopDong.setForeground(Color.BLACK);
		 btnHopDong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnHopDong.setBackground(Color.WHITE);
		
		btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setIcon(new ImageIcon("icon\\sanpham.png"));
		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSanPham.setForeground(Color.BLACK);
		btnSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSanPham.setBackground(Color.WHITE);
		
		 btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setIcon(new ImageIcon("icon\\nhanvien.png"));
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
		lblNewLabel_1.setIcon(new ImageIcon("img\\logo-cua-hang-xe-may (16).jpg"));
		panel_3.add(lblNewLabel_1);
		
		 btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhachHang.setIcon(new ImageIcon("icon\\khachhang.png"));
		btnKhachHang.setForeground(Color.BLACK);
		btnKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnKhachHang.setBackground(Color.WHITE);
		
		///bảo hành
		
		 btnBaoHanh = new JButton("Bảo Hành");
		 btnBaoHanh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		 btnBaoHanh.setIcon(new ImageIcon("icon\\baohanh.png"));
		 btnBaoHanh.setForeground(Color.BLACK);
		 btnBaoHanh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnBaoHanh.setBackground(Color.WHITE);
		
		///bao hành
		
		 btnNhaphang = new JButton("Nhập Hàng");
		btnNhaphang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNhaphang.setIcon(new ImageIcon("icon\\nhaphang.png"));
		btnNhaphang.setForeground(Color.BLACK);
		btnNhaphang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNhaphang.setBackground(Color.WHITE);
		//thống kê 
		 btnThongKe = new JButton("Thống Kê");
		 btnThongKe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		 btnThongKe.setIcon(new ImageIcon("icon\\thongke.png"));
		 btnThongKe.setForeground(Color.BLACK);
		 btnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnThongKe.setBackground(Color.WHITE);
		 
		 
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
								.addComponent(btnHopDong, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnBanHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnSanPham, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnKhachHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnBaoHanh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnNhaphang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnThongKe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBanHang, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHopDong, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSanPham, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNhanVien, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnKhachHang, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBaoHanh, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNhaphang, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnThongKe, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					
					.addGap(235))
		);
		panel_2.setLayout(gl_panel_2);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon hinhgt= new ImageIcon("img\\hinhgioithieu.jpg");
		Image image = hinhgt.getImage();
		Image newImage = image.getScaledInstance(1050, 650, java.awt.Image.SCALE_SMOOTH);
		hinhgt = new ImageIcon(newImage);
		lblNewLabel_2.setIcon(hinhgt);
		tabbedPane.addTab("tab_GioiThieu\r\n", null, lblNewLabel_2, null);
		
		btnKhachHang.addActionListener(this);
		btnSanPham.addActionListener(this);
		btnBanHang.addActionListener(this);
		btnHopDong.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnBaoHanh.addActionListener(this);
		btnNhaphang.addActionListener(this);
		btnThongKe.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o= e.getSource();
		if(o.equals(btnKhachHang)) {
			 int count = tabbedPane.getTabCount();
			    for (int i = count - 1; i >= 0; i--) {
			        String title = tabbedPane.getTitleAt(i);
			        if (!title.equals("tab_GioiThieu") && !title.equals("tab_Khách Hàng")) {
			            tabbedPane.removeTabAt(i);
			        }
			    } 
			khachHang.clearTable();
			khachHang.loadData();
			setBackground();
			btnKhachHang.setBackground(Color.pink);
			tabbedPane.addTab("tab_Khách Hàng\r\n", null, khachHang, null);
			tabbedPane.setSelectedIndex(getIndex(khachHang));
		}
		if(o.equals(btnBanHang)) {
			 int count = tabbedPane.getTabCount();
			    for (int i = count - 1; i >= 0; i--) {
			        String title = tabbedPane.getTitleAt(i);
			        if (!title.equals("tab_GioiThieu") && !title.equals("tab_Bán Hàng")) {
			            tabbedPane.removeTabAt(i);
			        }
			    } 
			    
			setBackground();
			btnBanHang.setBackground(Color.pink);
			tabbedPane.addTab("tab_Bán Hàng\r\n", null, banHang, null);
			tabbedPane.setSelectedIndex(getIndex(banHang));
		}
		if(o.equals(btnHopDong)) {
			 int count = tabbedPane.getTabCount();
			    for (int i = count - 1; i >= 0; i--) {
			        String title = tabbedPane.getTitleAt(i);
			        if (!title.equals("tab_GioiThieu") && !title.equals("tab_Hợp Đồng")) {
			            tabbedPane.removeTabAt(i);
			        }
			    } 
			dsHopDong.clearTable();
			dsHopDong.loadData();
			setBackground();
			btnHopDong.setBackground(Color.pink);
			tabbedPane.addTab("tab_Hợp Đồng\r\n", null, dsHopDong, null);
			tabbedPane.setSelectedIndex(getIndex(dsHopDong));
		}
		if(o.equals(btnNhanVien)) {
			 int count = tabbedPane.getTabCount();
			    for (int i = count - 1; i >= 0; i--) {
			        String title = tabbedPane.getTitleAt(i);
			        if (!title.equals("tab_GioiThieu") && !title.equals("tab_Nhân viên")) {
			            tabbedPane.removeTabAt(i);
			        }
			    } 
			nhanVien.clearTable();
			nhanVien.loadData();
			setBackground();
			btnNhanVien.setBackground(Color.pink);
			tabbedPane.addTab("tab_Nhân Viên\r\n", null, nhanVien, null);
			tabbedPane.setSelectedIndex(getIndex(nhanVien));
		}
		if(o.equals(btnNhaphang)) {
			 int count = tabbedPane.getTabCount();
			    for (int i = count - 1; i >= 0; i--) {
			        String title = tabbedPane.getTitleAt(i);
			        if (!title.equals("tab_GioiThieu") && !title.equals("tab_Nhập Hàng")) {
			            tabbedPane.removeTabAt(i);
			        }
			    } 
			nhapHang.clearTable();
			nhapHang.loadData();
			setBackground();
			btnNhaphang.setBackground(Color.pink);
			tabbedPane.addTab("tab_Nhập Hàng\r\n", null, nhapHang, null);
			tabbedPane.setSelectedIndex(getIndex(nhapHang));
		}
		if(o.equals(btnSanPham)) {
			 int count = tabbedPane.getTabCount();
			    for (int i = count - 1; i >= 0; i--) {
			        String title = tabbedPane.getTitleAt(i);
			        if (!title.equals("tab_GioiThieu") && !title.equals("tab_sản Phẩm")) {
			            tabbedPane.removeTabAt(i);
			        }
			    } 
			sanPham.clearTableFrmSanPham();
			sanPham.loadDataFrmSanPham();
			setBackground();
			btnSanPham.setBackground(Color.pink);
			tabbedPane.addTab("tab_Sản Phẩm\r\n", null, sanPham, null);
			tabbedPane.setSelectedIndex(getIndex(sanPham));
		}
		if(o.equals(btnBaoHanh)) {
			 int count = tabbedPane.getTabCount();
			    for (int i = count - 1; i >= 0; i--) {
			        String title = tabbedPane.getTitleAt(i);
			        if (!title.equals("tab_GioiThieu") && !title.equals("tab_Bảo Hành")) {
			            tabbedPane.removeTabAt(i);
			        }
			    }  
			baohanh.clearTable();
			baohanh.loadData();
			setBackground();
			btnBaoHanh.setBackground(Color.pink);
			tabbedPane.addTab("tab_Bảo Hành\r\n", null,baohanh , null);
			tabbedPane.setSelectedIndex(getIndex(baohanh));
		}
		if(o.equals(btnThongKe)) {
			 int count = tabbedPane.getTabCount();
			    for (int i = count - 1; i >= 0; i--) {
			        String title = tabbedPane.getTitleAt(i);
			        if (!title.equals("tab_GioiThieu") && !title.equals("tab_Thống Kê")) {
			            tabbedPane.removeTabAt(i);
			        }
			    }  
			    thongke.loadData();
			    setBackground();
			    btnThongKe.setBackground(Color.pink);
			    tabbedPane.addTab("tab_Thống Kê\r\n", null, thongke, null);
			 //   tabbedPane.setSelectedIndex(getIndex(thongke));
			    tabbedPane.setSelectedComponent(thongke);
		}
	}

	public void setBackground() {
		btnBanHang.setBackground(Color.white);
		btnKhachHang.setBackground(Color.white);
		btnHopDong.setBackground(Color.white);
		btnNhanVien.setBackground(Color.white);
		btnNhaphang.setBackground(Color.white);
		btnSanPham.setBackground(Color.white);
		btnBaoHanh.setBackground(Color.white);
		btnThongKe.setBackground(Color.white);
		
	}
	
	public int getIndex(Component obj) {
		return tabbedPane.indexOfComponent(obj);
	}
}
