package app_QLMBX;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.KhachHang;

public class FrmBanHang extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTenKH;
	private JTextField txtTenKH;
	private JLabel lblDiaChi;
	private JTextField txtDiaChi;
	private JLabel lblSoDt;
	private JTextField txtSoDt;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private JLabel lblGioiTinh;

	private JButton btnThem;
	private JButton btnXoaTrang;
	private JLabel lblLoaiXe;
	private JLabel lblSoLuong;
	private JTextField txtTenXe;
	private JLabel lblTenXe;
	private JTextField txtLoaiXe;
	private JTextField txtSoLuong;
	private JButton btnThemXe;
	private String col[] = {"Mã hợp đồng", "Tên mặt hàng", "Số lượng", "Đơn gia", "Thành tiền"};
	private JScrollPane scrollTable;
	private DefaultTableModel tblModel;
	private JTable tblHopDong;
	private JButton btnXoaSanPham;
	private JButton btnSuaSanPham;
	private JLabel lblMaKH;
	private JLabel lblNgayLapHD;
	private JTextField txtNgayLapHD;
	private ButtonGroup grbSex;
	private JLabel lblMa;
	private JLabel lblTen;
	private JLabel lblMaNV;
	private JLabel lblTenNV;
	private JComboBox cbxMaNV;
	private JComboBox cbxTenNV;
	private JLabel lblTongTT;
	private JTextField txtTongTT;
	private JButton btnThemNV;
	private JLabel lblMaXe;
	private JComboBox cbxMaXe;
	private JComboBox cbxTenXe;
	private JTextField txtMaKH;
	private JLabel lblMaNVTT;
	private JTextField txtMaNVTT;
	private JLabel lblHinhThucTT;
	private JComboBox cbxHinhThucTT;
	private JLabel lblCuaHang;
	private JTextField txtCuaHang;
	private JComboBox cbxCuaHang;
	private JLabel lblTimHD;
	private JComboBox cbxTimHD;

	public FrmBanHang() {
		
		setLayout(null);
		int x = 10, y = 10, width = 400, height = 200;
		JPanel pnKhachHang = new JPanel();
		pnKhachHang.setBounds(x,y,width, height);
		pnKhachHang.setBorder(BorderFactory.createTitledBorder("Nhập thông tin khách hàng"));
		pnKhachHang.setLayout(null);
		
		pnKhachHang.add(lblTenKH = new JLabel("Tên khách hàng:"));
		lblTenKH.setBounds(30, 30, 120, 20);
		pnKhachHang.add(lblDiaChi = new JLabel("Địa chỉ:"));
		lblDiaChi.setBounds(30, 60, 120, 20);
		pnKhachHang.add(lblSoDt = new JLabel("Số điện thoại:"));
		lblSoDt.setBounds(30, 90, 120, 20);
		pnKhachHang.add(lblGioiTinh = new JLabel("Giới tính:"));
		lblGioiTinh.setBounds(30, 120, 120, 20);

		pnKhachHang.add(txtTenKH = new JTextField());
		txtTenKH.setBounds(160, 30, 200, 20);
		pnKhachHang.add(txtDiaChi = new JTextField());
		txtDiaChi.setBounds(160, 60, 200, 20);
		pnKhachHang.add(txtSoDt = new JTextField());
		txtSoDt.setBounds(160, 90, 200, 20);
		pnKhachHang.add(radNam = new JRadioButton("Nam"));
		radNam.setBounds(160, 120, 60, 20);
		pnKhachHang.add(radNu = new JRadioButton("Nữ"));
		radNu.setBounds(220, 120, 60, 20);
		grbSex = new ButtonGroup();
		grbSex.add(radNam);
		grbSex.add(radNu);

		
		pnKhachHang.add(btnThem = new JButton("Thêm khách hàng"));
		pnKhachHang.add(btnXoaTrang = new JButton("Xóa trắng"));
		btnThem.setBounds(110, 160, 150, 30);
		btnXoaTrang.setBounds(270, 160, 100, 30);
		add(pnKhachHang);
		
		JPanel pnXe = new JPanel();
		pnXe.setBorder(BorderFactory.createTitledBorder("Nhập thông tin xe cần mua:"));
		pnXe.setLayout(null);
		x = 420; y=10; width=300; height=200;
		pnXe.setBounds(x, y, width, height);
		
		pnXe.add(lblMaXe = new JLabel("Mã xe:"));
		lblMaXe.setBounds(30, 30, 120, 20);
		pnXe.add(lblTenXe = new JLabel("Loại xe:"));
		lblTenXe.setBounds(30, 60, 120, 20);
		pnXe.add(lblSoLuong = new JLabel("Số lượng xe:"));
		lblSoLuong.setBounds(30, 90, 120, 20);
		
		pnXe.add(cbxMaXe = new JComboBox());
		cbxMaXe.setBounds(160, 30, 120, 20);
		pnXe.add(cbxTenXe = new JComboBox());
		cbxTenXe.setBounds(160, 60, 120, 20);
		pnXe.add(txtSoLuong = new JTextField());
		txtSoLuong.setBounds(160, 90, 120, 20);
		
		pnXe.add(btnThemXe = new JButton("Thêm vào hóa đơn"));
		btnThemXe.setBounds(100, 160, 150, 30);
		add(pnXe);
		
		JPanel pnNV = new JPanel();
		pnNV.setBorder(BorderFactory.createTitledBorder("Nhân viên lập hóa đơn"));
		pnNV.setLayout(null);
		pnNV.setBounds(730, 10, 240, 200);
		pnNV.add(lblMaNV = new JLabel("Mã nhân viên"));
		lblMaNV.setBounds(10, 50, 100, 20);
		pnNV.add(lblTenNV = new JLabel("Tên nhân viên"));
		lblTenNV.setBounds(10, 80, 100, 20);
		pnNV.add(cbxMaNV = new JComboBox());
		cbxMaNV.setBounds(115, 50, 100, 20);
		pnNV.add(cbxTenNV = new JComboBox());
		cbxTenNV.setBounds(115, 80, 100, 20);
		pnNV.add(btnThemNV = new JButton("Thêm nhân viên"));
		btnThemNV.setBounds(40, 160, 150, 30);
		add(pnNV);
		
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(null);
		pnThongTin.setBounds(10, 250, 950, 40); 
		pnThongTin.add(lblMaKH = new JLabel("Mã khách hàng: "));
		lblMaKH.setBounds(5, 0, 100, 20);
		pnThongTin.add(txtMaKH = new JTextField());
		txtMaKH.setBounds(110, 0, 100, 20);
		txtMaKH.setEditable(false);
		pnThongTin.add(lblMaNVTT = new JLabel("Mã nhân viên: "));
		lblMaNVTT.setBounds(250, 0, 100, 20);
		pnThongTin.add(txtMaNVTT = new JTextField());
		txtMaNVTT.setBounds(360, 0, 100, 20);
		txtMaNVTT.setEditable(false);
		pnThongTin.add(lblCuaHang = new JLabel("Cửa hàng"));
		lblCuaHang.setBounds(480, 0, 70, 20);
		pnThongTin.add(cbxCuaHang = new JComboBox());
		cbxCuaHang.setBounds(560, 0, 100, 20);
		pnThongTin.add(lblNgayLapHD = new JLabel("Ngày lập hợp đồng: "));
		lblNgayLapHD.setBounds(700, 0, 120, 20);
		pnThongTin.add(txtNgayLapHD = new JTextField()); 
		txtNgayLapHD.setBounds(830, 0, 100, 20);
		add(pnThongTin);
		
		JPanel pnTable = new JPanel();
		pnTable.setBorder(BorderFactory.createTitledBorder("Chi tiết hợp đồng"));
		pnTable.setBounds(10, 290, 950, 200);
		pnTable.setLayout(null);
		
		tblModel = new DefaultTableModel(col,0);
		tblHopDong = new JTable(tblModel);
		scrollTable = new JScrollPane(tblHopDong);
		scrollTable.setBounds(10, 25, 930, 170);
		pnTable.add(scrollTable);
		add(pnTable);
		
		JPanel pnControl = new JPanel();
		pnControl.setBounds(10, 500, 950, 40);
		pnControl.setLayout(null);
		pnControl.add(lblTongTT = new JLabel("Tổng thành tiền: "));
		lblTongTT.setBounds(10, 5, 120, 20);
		pnControl.add(txtTongTT = new JTextField());
		txtTongTT.setBounds(140, 5, 100, 20);
		txtTongTT.setEditable(false);
		pnControl.add(lblHinhThucTT = new JLabel("Chọn hình thức thanh toán: "));
		lblHinhThucTT.setBounds(250, 5, 170, 20);
		pnControl.add(cbxHinhThucTT = new JComboBox());
		cbxHinhThucTT.setBounds(430, 5, 120, 20);
		cbxHinhThucTT.addItem("Trả trực tiếp");
		cbxHinhThucTT.addItem("Trả góp");
		pnControl.add(btnXoaSanPham = new JButton("Xóa sản phẩm"));
		btnXoaSanPham.setBounds(600, 5, 150, 30);
		btnXoaSanPham.setForeground(Color.red);
		pnControl.add(btnSuaSanPham = new JButton("Sửa"));
		btnSuaSanPham.setBounds(760, 5, 150, 30);
		add(pnControl);
	}
}