package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmSanPham extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMaSP, lblTenSP, lblLoaiSP, lblsoLuong, lblDonViTinh, lblDonGia, lblTim;
	private JTextField  txtMaSP, txtTenSP, txtLoaiSP, txtsoLuong, txtDonViTinh, txtDonGia, txtTim;
	private JTable tblSanPham;
	private DefaultTableModel model;
	private String[] cols = {"Mã SP", "Loại SP", "Tên SP", "Số lượng", "Đơn Vị Tính", "Đơn Giá"};
	private JButton btnThem, btnLuu, btnXoa, btnTim, btnXemTT;
	private JComboBox<String> cboLoaiSP;
	public FrmSanPham() {
		setSize(990, 600);
		JPanel pnControl = new JPanel();
		pnControl.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JLabel lblTitle = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		pnNorth.add(lblTitle);
		pnControl.add(pnNorth, BorderLayout.NORTH);
		JPanel pnContent = new JPanel();
		pnContent.setLayout(null);
		int x = 100, y = 50, width = 100, height = 30;
		pnContent.add(lblMaSP = new JLabel("Mã SP:"));
		lblMaSP.setBounds(x, y, width, height);
		pnContent.add(lblLoaiSP = new JLabel("Loại SP:"));
//		y+=30;
		lblLoaiSP.setBounds(520, y, width, height);
		pnContent.add(lblTenSP = new JLabel("Tên SP:"));
		y+=30;
		lblTenSP.setBounds(x, y, width, height);
		pnContent.add(lblsoLuong = new JLabel("Số lượng:"));
//		y+=30;
		lblsoLuong.setBounds(520, y, width, height);
		pnContent.add(lblDonViTinh = new JLabel("Đơn vị tính:"));
		y+=30;
		lblDonViTinh.setBounds(x, y, width, height);
		pnContent.add(lblDonGia = new JLabel("Đơn Giá:"));
//		y+=30;
		lblDonGia.setBounds(520, y, width, height);
		pnContent.add(lblTim = new JLabel("Tìm:"));
		y+=30;
		lblTim.setBounds(x, y, width, height);
		
		
		x+=100;y = 56;width = 300;height = 20;
		pnContent.add(txtMaSP = new JTextField(20));
		txtMaSP.setBounds(x, y, width, height);
		
		pnContent.add(cboLoaiSP = new JComboBox<String>());
//		y += 30;
		cboLoaiSP.addItem("Linh Kiện");
		cboLoaiSP.addItem("Xe");
		cboLoaiSP.setBounds(620, y, width, height);
		pnContent.add(txtTenSP = new JTextField(20));
		y += 30;
		txtTenSP.setBounds(x, y, width, height);
		pnContent.add(txtsoLuong = new JTextField(20));
		txtsoLuong.setBounds(620, y, width, height);
		pnContent.add(txtDonViTinh = new JTextField(20));
		y += 30;
		txtDonViTinh.setBounds(x, y, width, height);
		pnContent.add(txtDonGia = new JTextField(20));
		txtDonGia.setBounds(620, y, width, height);
		pnContent.add(txtTim = new JTextField(20));
		y += 30;
		txtTim.setBounds(x, y, width, height);
		
		pnContent.add(btnThem = new JButton("Thêm"));
		width = 100; height = 30; x = 150;
		y+=30; 
		btnThem.setBounds(x, y, width, height);
		pnContent.add(btnXoa = new JButton("Xóa"));
		x+=120; 
		btnXoa.setBounds(x, y, width, height);
		pnContent.add(btnLuu = new JButton("Lưu"));
		x+=120;
		btnLuu.setBounds(x, y, width, height);
		pnContent.add(btnTim = new JButton("Tìm"));
		x+=120;
		btnTim.setBounds(x, y, width, height);
		pnContent.add(btnXemTT = new JButton("Xem thông tin chi tiết"));
		x+=120;
		btnXemTT.setBounds(x, y, 200, height);
		
		model = new DefaultTableModel(cols, 0);
		tblSanPham = new JTable(model);
		tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(120);
		tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(600);
		tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(120);
		tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(120);
		JScrollPane sp = new JScrollPane(tblSanPham);
		width = 990; height = 400;
		y+=50;
		sp.setBounds(0, y, width, height);
		pnContent.add(sp);
		pnContent.setPreferredSize(new Dimension(990, 600));
		pnControl.add(pnContent, BorderLayout.CENTER);
		this.add(pnControl);
	}
}
