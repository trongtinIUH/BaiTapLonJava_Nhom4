package app_QLMBX;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import connectDB.ConnectDB;
import dao.ChiTietHoaDonHang_DAO;
import dao.ChiTietHopDong_DAO;
import dao.CuaHang_DAO;
import dao.HoaDonHang_DAO;
import dao.HopDong_DAO;
import dao.KhachHang_DAO;
import dao.MatHang_DAO;
import dao.NhanVien_DAO;
import dao.PhatSinhMa_DAO;
import dao.PhieuXuat_DAO;
import dao.TraGop_DAO;
import dao.TraTrucTiep_DAO;
import dao.Xe_DAO;
import entity.ChiTietHoaDonHang;
import entity.ChiTietHopDong;
import entity.CuaHang;
import entity.HoaDonHang;
import entity.HopDong;
import entity.KhachHang;
import entity.MatHang;
import entity.NhanVien;
import entity.PhieuXuat;
import entity.TraGop;
import entity.TraTrucTiep;
import entity.Xe;

public class FrmBanHang extends JPanel implements ActionListener, ItemListener, MouseListener{
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

	private JButton btnXoaTrang;
	private JLabel lblTenXe;
	private JButton btnThemXe;
	private String col[] = {"Mã chi tiết hợp đồng", "Tên mặt hàng", "Số lượng", "Đơn giá", "Thành tiền"};
	private JScrollPane scrollTable;
	private DefaultTableModel tblModel;
	private JTable tblHopDong;
	private JLabel lblMaKH;
	private JLabel lblNgayLapHD;
	private ButtonGroup grbSex;
	private JLabel lblTenNV;
	private JComboBox<String> cbxTenNV;
	private JLabel lblTongTT;
	private JTextField txtTongTT;
	private JButton btnThemNV;
	private JComboBox<String> cbxTenXe;
	private JTextField txtMaKH;
	private JLabel lblHinhThucTT;
	private JComboBox<String> cbxHinhThucTT;
	private JLabel lblCuaHang;
	private JComboBox<String> cbxCuaHang;
	private JTextField txtTenNVTT;
	private JLabel lblChucVu;
	private JComboBox<String> cbxChucVu;
	private JComboBox<String> cbxSoDT;
	private JLabel lblSoDtNhanVien;
	private JComboBox<String> cbxDongXe;
	private JLabel lblDongXe;
	private DecimalFormat df = new DecimalFormat("#");
	private JLabel lblTGBH;
	private JTextField txtBaoHanh;
	private NhanVien_DAO nv_dao;
	private ChiTietHopDong_DAO cthd_dao;
	private CuaHang_DAO ch_DAO;
	private Xe_DAO xe_DAO;
	private HopDong_DAO hd_dao;
	private KhachHang_DAO kh_dao;
	private NhanVien_DAO nv;
	private Xe_DAO xe;
	private JLabel lblTenNVTT;
	private JButton btnXoaTrangKH;
	private JButton btnXoaDong;
	private JButton btnThanhToan;
	private MatHang_DAO matHang_DAO;
	private JTextField txtSoLuongMua;
	private JLabel lblSoLuongMua;
	private JLabel lblSoLuongTon;
	private JTextField txtSoLuongTon;
	private String maHd;
	private JLabel lblGiam;
	private JTextField txtGiam;
	private JLabel lblLaiSuat;
	private JTextField txtLaiSuat;
	private JLabel lblTienDua;
	private JTextField txtTienDua;
	private TraGop_DAO traGop_dao;
	private TraTrucTiep_DAO traTrucTiep_dao;
	private JRadioButton radCu;
	private JRadioButton radMoi;
	private ButtonGroup grbType;
	private JButton btnLayTTKH;
	private String maPhieuXuat;
	private JTextField txtNgay;
	private HoaDonHang_DAO hdh_dao;
	private ChiTietHoaDonHang_DAO cthdHang_dao;
	private PhieuXuat_DAO phieuXuat_dao;

	public FrmBanHang() {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		kh_dao = new KhachHang_DAO();
		nv_dao = new NhanVien_DAO();
		xe_DAO = new Xe_DAO();
		matHang_DAO = new MatHang_DAO();
		ch_DAO = new CuaHang_DAO();
		hd_dao = new HopDong_DAO();
		cthd_dao = new ChiTietHopDong_DAO();
		traGop_dao = new TraGop_DAO();
		traTrucTiep_dao = new TraTrucTiep_DAO();
		hdh_dao = new HoaDonHang_DAO();
		cthdHang_dao = new ChiTietHoaDonHang_DAO();
		phieuXuat_dao = new PhieuXuat_DAO();
		
		setLayout(null);
		int x = 10, y = 10, width = 400, height = 200;
		JPanel pnKhachHang = new JPanel();
		pnKhachHang.setBounds(x,y,width, height);
		pnKhachHang.setBorder(BorderFactory.createTitledBorder("Nhập thông tin khách hàng"));
		TitledBorder titleKhachHang = (TitledBorder) pnKhachHang.getBorder();
		titleKhachHang.setTitleColor(Color.blue);
		pnKhachHang.setLayout(null);
		
		pnKhachHang.add(lblTenKH = new JLabel("Loại khách hàng:"));
		lblTenKH.setBounds(30, 20, 120, 20);
		pnKhachHang.add(lblTenKH = new JLabel("Tên khách hàng:"));
		lblTenKH.setBounds(30, 45, 120, 20);
		pnKhachHang.add(lblDiaChi = new JLabel("Địa chỉ:"));
		lblDiaChi.setBounds(30, 75, 120, 20);
		pnKhachHang.add(lblSoDt = new JLabel("Số điện thoại:"));
		lblSoDt.setBounds(30, 105, 120, 20);
		pnKhachHang.add(lblGioiTinh = new JLabel("Giới tính:"));
		lblGioiTinh.setBounds(30, 135, 120, 20);

		pnKhachHang.add(radCu = new JRadioButton("Cũ"));
		radCu.setBounds(160, 20, 60, 20);
		pnKhachHang.add(radMoi = new JRadioButton("Mới"));
		radMoi.setBounds(220, 20, 60, 20);
		grbType = new ButtonGroup();
		grbType.add(radCu);
		grbType.add(radMoi);
		pnKhachHang.add(txtTenKH = new JTextField());
		txtTenKH.setBounds(160, 45, 200, 20);
		pnKhachHang.add(txtDiaChi = new JTextField());
		txtDiaChi.setBounds(160, 75, 200, 20);
		pnKhachHang.add(txtSoDt = new JTextField());
		txtSoDt.setBounds(160, 105, 200, 20);
		pnKhachHang.add(radNam = new JRadioButton("Nam"));
		radNam.setBounds(160, 135, 60, 20);
		pnKhachHang.add(radNu = new JRadioButton("Nữ"));
		radNu.setBounds(220, 135, 60, 20);
		grbSex = new ButtonGroup();
		grbSex.add(radNam);
		grbSex.add(radNu);

		
		pnKhachHang.add(btnLayTTKH = new JButton("Thêm khách hàng"));
		btnLayTTKH.setIcon(new ImageIcon("image\\add-icon.png"));
		pnKhachHang.add(btnXoaTrangKH = new JButton("Xóa trắng"));
		btnXoaTrangKH.setIcon(new ImageIcon("image\\icons8_x_24px.png"));
		btnLayTTKH.setBounds(50, 160, 180, 30);
		btnXoaTrangKH.setBounds(240, 160, 120, 30);
		add(pnKhachHang);
		
		JPanel pnXe = new JPanel();
		pnXe.setBorder(BorderFactory.createTitledBorder("Nhập thông tin xe cần mua:"));
		TitledBorder titleXe = (TitledBorder) pnXe.getBorder();
		titleXe.setTitleColor(Color.blue);
		pnXe.setLayout(null);
		x = 420; y=10; width=300; height=200;
		pnXe.setBounds(x, y, width, height);
		
		pnXe.add(lblTenXe = new JLabel("Tên xe:"));
		lblTenXe.setBounds(30, 30, 120, 20);
		pnXe.add(lblDongXe = new JLabel("Dòng xe:"));
		lblDongXe.setBounds(30, 60, 120, 20);
		pnXe.add(lblSoLuongTon = new JLabel("Số lượng tồn:"));
		lblSoLuongTon.setBounds(30, 90, 120, 20);
		pnXe.add(lblSoLuongMua = new JLabel("Số lượng mua:"));
		lblSoLuongMua.setBounds(30, 120, 120, 20);
		
		pnXe.add(cbxTenXe = new JComboBox<String>());
		cbxTenXe.setBounds(160, 30, 120, 20);
		for(Xe item : xe_DAO.getAllXe()) {
			cbxTenXe.addItem(item.getTenMH());
		}
		
		pnXe.add(cbxDongXe = new JComboBox<String>());
		cbxDongXe.setBounds(160, 60, 120, 20);
		
		pnXe.add(txtSoLuongTon = new JTextField());
		txtSoLuongTon.setBounds(160, 90, 120, 20);
		txtSoLuongTon.setEditable(false);
		pnXe.add(txtSoLuongMua = new JTextField());
		txtSoLuongMua.setBounds(160, 120, 120, 20);
		
		pnXe.add(btnThemXe = new JButton("Thêm vào hóa đơn"));
		btnThemXe.setIcon(new ImageIcon("image\\add-icon.png"));
		btnThemXe.setBounds(100, 160, 180, 30);
		add(pnXe);
		
		JPanel pnNV = new JPanel();
		pnNV.setBorder(BorderFactory.createTitledBorder("Nhân viên lập hợp đồng"));
		TitledBorder titleNhanVien = (TitledBorder) pnNV.getBorder();
		titleNhanVien.setTitleColor(Color.blue);
		pnNV.setLayout(null);
		pnNV.setBounds(730, 10, 240, 200);
		
		pnNV.add(lblTenNV = new JLabel("Tên nhân viên:"));
		lblTenNV.setBounds(10, 50, 90, 20);
		pnNV.add(lblChucVu = new JLabel("Chức vụ:"));
		lblChucVu.setBounds(10, 80, 90, 20);
		pnNV.add(lblSoDtNhanVien = new JLabel("Số điện thoại:"));
		lblSoDtNhanVien.setBounds(10, 110, 90, 20);
		
		
		pnNV.add(cbxTenNV = new JComboBox<String>());
		cbxTenNV.setBounds(105, 50, 120, 20);
//		ArrayList<NhanVien> lsTenNV = nv.getAllNhanVien();
		for (NhanVien item : nv_dao.getAllNhanVien()) {
			cbxTenNV.addItem(item.getTenNV());
		}
		pnNV.add(cbxChucVu = new JComboBox<String>());
		cbxChucVu.setBounds(105, 80, 120, 20);
		pnNV.add(cbxSoDT = new JComboBox<String>());
		cbxSoDT.setBounds(105, 110, 120, 20);
	
		
		pnNV.add(btnThemNV = new JButton("Thêm nhân viên"));
		btnThemNV.setIcon(new ImageIcon("image\\add-icon.png"));
		btnThemNV.setBounds(40, 160, 180, 30);
		add(pnNV);
		
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(null);
		pnThongTin.setBounds(5, 250, 950, 40); 
		pnThongTin.add(lblMaKH = new JLabel("Mã KH: "));
		lblMaKH.setBounds(5, 0, 50, 20);
		pnThongTin.add(txtMaKH = new JTextField());
		txtMaKH.setBounds(60, 0, 100, 20);
		txtMaKH.setEditable(false);
		pnThongTin.add(lblTenNVTT = new JLabel("Tên NV: "));
		lblTenNVTT.setBounds(170, 0, 60, 20);
		pnThongTin.add(txtTenNVTT = new JTextField());
		txtTenNVTT.setBounds(230, 0, 100, 20);
		txtTenNVTT.setEditable(false);
		
		pnThongTin.add(lblNgayLapHD = new JLabel("Ngày lập HD: "));
		lblNgayLapHD.setBounds(350, 0, 100, 20);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = new java.util.Date();
		txtNgay = new JTextField();
		txtNgay.setText(dateFormat.format(date));
		pnThongTin.add(txtNgay);
		txtNgay.setBounds(450, 0, 120, 20);
		txtNgay.setEditable(false);
		
		pnThongTin.add(lblTGBH = new JLabel("TG Bảo hành:"));
		lblTGBH.setBounds(600, 0, 90, 20);
		pnThongTin.add(txtBaoHanh = new JTextField());
		txtBaoHanh.setBounds(695, 0, 40, 20);
		
		pnThongTin.add(lblCuaHang = new JLabel("Cửa hàng"));
		lblCuaHang.setBounds(760, 0, 70, 20);
		pnThongTin.add(cbxCuaHang = new JComboBox<String>());
		cbxCuaHang.setBounds(835, 0, 90, 20);
		for (CuaHang item : ch_DAO.getAllCuaHang()) {
			cbxCuaHang.addItem(item.getTenCuaHang());
		}
		add(pnThongTin);
		
		JPanel pnTable = new JPanel();
		pnTable.setBorder(BorderFactory.createTitledBorder("Chi tiết hợp đồng"));
		TitledBorder titleChiTietHD = (TitledBorder) pnTable.getBorder();
		titleChiTietHD.setTitleColor(Color.blue);
		pnTable.setBounds(10, 290, 950, 170);
		pnTable.setLayout(null);
		
		tblModel = new DefaultTableModel(col,0);
		tblHopDong = new JTable(tblModel);
		tblHopDong.setBackground(Color.pink);
		scrollTable = new JScrollPane(tblHopDong);
		scrollTable.setBounds(10, 25, 930, 140);
		pnTable.add(scrollTable);
		add(pnTable);
		
		JPanel pnLoaiTT = new JPanel();
		pnLoaiTT.setLayout(null);
		pnLoaiTT.setBounds(10, 465, 950, 30);
		pnLoaiTT.add(lblTongTT = new JLabel("Tổng thành tiền: "));
		lblTongTT.setForeground(Color.RED);
		lblTongTT.setBounds(10, 5, 120, 20);
		pnLoaiTT.add(txtTongTT = new JTextField());
		txtTongTT.setForeground(Color.RED);
		txtTongTT.setBounds(140, 5, 200, 20);
		txtTongTT.setEditable(false);
		pnLoaiTT.add(lblHinhThucTT = new JLabel("Chọn loại thanh toán: "));
		lblHinhThucTT.setBounds(350, 5, 140, 20);
		pnLoaiTT.add(cbxHinhThucTT = new JComboBox<String>());
		cbxHinhThucTT.setBounds(500, 5, 110, 20);
		cbxHinhThucTT.addItem("Trả trực tiếp");
		cbxHinhThucTT.addItem("Trả góp");
		pnLoaiTT.add(lblGiam = new JLabel("Phần trăm giảm:"));
		lblGiam.setBounds(630, 5, 100, 20);
		pnLoaiTT.add(txtGiam = new JTextField());
		txtGiam.setBounds(730, 5, 60, 20);
		txtGiam.setEditable(false);
		pnLoaiTT.add(lblLaiSuat = new JLabel("Lãi suất:"));
		lblLaiSuat.setBounds(800, 5, 60, 20);
		pnLoaiTT.add(txtLaiSuat = new JTextField());
		txtLaiSuat.setBounds(860, 5, 60, 20);
		txtLaiSuat.setEditable(false);
		add(pnLoaiTT);

		
		JPanel pnControl = new JPanel();
		pnControl.setBounds(10, 500, 950, 40);
		pnControl.setLayout(null);
		pnControl.add(lblTienDua = new JLabel("Tiền phải đưa: "));
		lblTienDua.setForeground(Color.RED);
		lblTienDua.setBounds(10, 15, 90, 20);
		pnControl.add(txtTienDua = new JTextField());
		txtTienDua.setForeground(Color.RED);
		txtTienDua.setBounds(140, 15, 200, 20);
		txtTienDua.setEditable(false);
		pnControl.add(btnXoaDong = new JButton("XÓA SẢN PhẨM"));
		btnXoaDong.setIcon(new ImageIcon("image\\delete-icon.png"));
		btnXoaDong.setBounds(460, 10, 170, 30);
		btnXoaDong.setForeground(Color.red);
		pnControl.add(btnXoaTrang = new JButton("LÀM MỚI"));
		btnXoaTrang.setIcon(new ImageIcon("image\\icons8_x_24px.png")); 
		btnXoaTrang.setBounds(640, 10, 130, 30);
		pnControl.add(btnThanhToan = new JButton("THANH TOÁN"));
		btnThanhToan.setIcon(new ImageIcon("image\\buy.png"));
		btnThanhToan.setBounds(780, 10, 160, 30);   
		add(pnControl);     
				
		radCu.addActionListener(this);
		radMoi.addActionListener(this);
		btnLayTTKH.addActionListener(this);
		btnXoaTrangKH.addActionListener(this);
		btnThemXe.addActionListener(this);
		btnThemNV.addActionListener(this);
		btnXoaDong.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnThanhToan.addActionListener(this);
		cbxTenNV.addItemListener(this);
		cbxTenXe.addItemListener(this);
		cbxHinhThucTT.addItemListener(this);
		tblHopDong.addMouseListener(this);;
	}
	
	private void xoaTrangKH() {
		grbType.clearSelection();
		txtTenKH.setText("");
		txtDiaChi.setText("");
		txtSoDt.setText("");
		grbSex.clearSelection();
		txtMaKH.setText("");
		txtTenKH.requestFocus();
	}
	
	private void themNhanVien() {
		String tenNV = (String)cbxTenNV.getSelectedItem();
		txtTenNVTT.setText(tenNV);
		JOptionPane.showMessageDialog(this, "Thêm nhân viên lập HD thành công!!");
	}
	
	private int soLuong() {
		int SL =0;
		SL = Integer.parseInt(tblModel.getValueAt(timRow(),2).toString()) +Integer.parseInt(txtSoLuongMua.getText());
		return SL;
	}
	
	private int timRow() {
		int row = tblHopDong.getRowCount();
		for(int i=0;i<row;i++) {
			if(tblModel.getValueAt(i, 1).toString().equalsIgnoreCase(cbxTenXe.getSelectedItem().toString()))
			{
				return i;
				
			}
		}
		return -1;
	}
	
	private void themKH() {
		if(!radCu.isSelected() && !radMoi.isSelected()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn loại khách hàng!!");
		}
		else
		{
			if(radCu.isSelected())
			{
				String sdt = txtSoDt.getText();
				if(sdt.equals(""))
					JOptionPane.showMessageDialog(null, "Số ĐT không được rỗng!!");
				else
				{
					String ma = kh_dao.getMaKHTheoSDT(sdt);
					String ten = kh_dao.getTenKHTheoSDT(sdt);
					String diaChi = kh_dao.getDiaChiTheoSDT(sdt);
					String gioiTinh = kh_dao.getGioiTinhTheoSDT(sdt);
					if(ma != "" && ten != "" && diaChi != "" && gioiTinh != "")
					{
						txtTenKH.setText(ten);
						txtDiaChi.setText(diaChi);
						if(gioiTinh.equalsIgnoreCase("Nam"))
							radNam.setSelected(true);
						else
							radNu.setSelected(true);
						txtMaKH.setText(ma);
						JOptionPane.showMessageDialog(null, "Tìm thấy dữ liệu khách hàng!!");
					}
					else
						JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin, số DT không hợp lệ!!");
				}
			}
			else if(radMoi.isSelected()) {
				PhatSinhMa_DAO makh = new PhatSinhMa_DAO();
				String tenKH =txtTenKH.getText();
				String sDT = txtSoDt.getText();
				String diaChi = txtDiaChi.getText();
				String gioiTinh;
				if(radNam.isSelected())
					gioiTinh="Nam";
				else
					gioiTinh="Nữ";
				KhachHang kh = new KhachHang(makh.generateRandomKH(), tenKH, gioiTinh, diaChi, sDT);
				if(txtTenKH.getText().equals("") || txtSoDt.getText().equals("") || txtDiaChi.getText().equals("") || (!radNam.isSelected() && !radNu.isSelected()))
				{
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập đầy đủ thông tin khách hàng!!");
				}
				else
				{
					if(kh_dao.getKHTheoSDT(sDT) == null)
						if(kh_dao.createKH(kh)) {
							JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
							txtMaKH.setText(kh.getMaKH());
							
						} else
							JOptionPane.showMessageDialog(this, "Trùng mã khách hàng");
					
					else 
						JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
				}
			}	
		}	
	}
	
	
	private boolean kiemTraSoLuongNhap() {
		int soLuongMua = Integer.parseInt(txtSoLuongMua.getText());
		int soLuongTon = Integer.parseInt(txtSoLuongTon.getText());
		int soLuongCoTrongBang = 0;
		if(timRow() != -1)
			soLuongCoTrongBang = Integer.parseInt(tblModel.getValueAt(timRow(),2).toString());
		
		if(soLuongMua > soLuongTon || (soLuongMua+soLuongCoTrongBang) > soLuongTon)
			return false;
		return true;
	}
	
	private void themXeVaoHD() {
		if(txtSoLuongMua.getText().length()>0 && Integer.parseInt(txtSoLuongMua.getText().trim()) > 0)
		{	
			if(kiemTraSoLuongNhap()==true) {
				PhatSinhMa_DAO maCTHD = new PhatSinhMa_DAO();
				PhatSinhMa_DAO maHD = new PhatSinhMa_DAO();
				maHd = maHD.generateRandomHopDong();
				HopDong hd = new HopDong(maHd);
				String tenXe = (String) cbxTenXe.getSelectedItem();
				Xe x = xe_DAO.getXeTheoTen(tenXe);
				int soLuongMua = Integer.parseInt(txtSoLuongMua.getText().trim());
				ChiTietHopDong cthd = new ChiTietHopDong(hd, maCTHD.generateRandomChiTietHopDong(), x, soLuongMua);
				if(timRow() !=-1) {

					int soluong = soLuong();

					tblModel.removeRow(timRow());
					tblModel.addRow(new Object [] {cthd.getMaChiTietHD(),tenXe,df.format(soluong),df.format( x.getDonGia()),df.format(x.getDonGia()*soluong)});
				}
				else {
					tblModel.addRow(new Object [] {cthd.getMaChiTietHD(),tenXe,df.format(cthd.getSoLuong()),df.format( x.getDonGia()),df.format(x.getDonGia()*cthd.getSoLuong())});
				}
				//cập nhật lại ô tổng thành tiền
				tongTien();

				//Cập nhật lại số lượng tồn
				int soLuongCu =Integer.parseInt(txtSoLuongTon.getText());
				int soLuongUpdate = soLuongCu-soLuongMua;
				txtSoLuongTon.setText(soLuongUpdate + "");

				JOptionPane.showMessageDialog(this, "Thêm thành công!");
			}
			else
				JOptionPane.showMessageDialog(null, "Số lượng quá lớn, không đủ hàng, vui lòng nhập lại!!");
		}
		else 
			JOptionPane.showMessageDialog(this, "Không để trống và số lượng xe phải lớn hơn 0");
	}
	
	//Cập nhật lại số lượng tồn khi tạo hợp đồng
	private void capNhatSLTon() {
		int soRow = tblHopDong.getRowCount();
		for(int i=0;i<soRow;i++)
		{
			String tenMH = tblModel.getValueAt(i, 1).toString();
			matHang_DAO = new MatHang_DAO();
			MatHang mh = matHang_DAO.getMatHangTheoTen(tenMH);
			
			int slNew = mh.getSlTon() - Integer.parseInt(tblModel.getValueAt(i, 2).toString());
			matHang_DAO.updateSLTon(slNew, mh.getMaMH());
		}
	}
	
	//Thêm hợp đồng vào CSDL
	private void themhd() {
		if(txtBaoHanh.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập TG bảo hành!!");
		}
		else
		{
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			int tgBH =Integer.parseInt(txtBaoHanh.getText());
			String loaiHD = cbxHinhThucTT.getSelectedItem().toString();
			NhanVien nvl = nv_dao.getNhanVienTheoTen(cbxTenNV.getSelectedItem().toString());
			CuaHang cuaHang = ch_DAO.getCuaHangTheoTen(cbxCuaHang.getSelectedItem().toString());
			KhachHang kh = kh_dao.getKHTheoSDT(txtSoDt.getText());		
			int soDong = tblModel.getRowCount();
			if(nvl==null || cuaHang==null || kh==null || soDong==0) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập đầy đủ thông tin");
			}
			else if(tgBH <= 0) {
				JOptionPane.showMessageDialog(null, "Thời gian bảo hành không hợp lệ");
			}
			else {
				HopDong hd = new HopDong(maHd, date, tgBH, loaiHD, nvl, cuaHang, kh);
				if(hd_dao.createHD(hd))
					if(loaiHD.equalsIgnoreCase("Trả trực tiếp"))
						themHDTraTrucTiep();
					else if(loaiHD.equalsIgnoreCase("Trả góp"))
						themHDTraGop();
					
					int soRow = tblHopDong.getRowCount();
					for(int i=0;i<soRow;i++)
					{
						themCTHD(i);
					}
					
					//Thêm phiếu xuất hàng
					xuatHang();
					
					capNhatSLTon();
					JOptionPane.showMessageDialog(this, "Thanh Toán thành công, hợp đồng đã được lưu vào CSDL!!");
			}
		}
	}
	
	//thêm vào hóa đơn xuất hàng và chi tiết hóa đơn xuất hàng
	private void xuatHang() {
		//Thêm hóa đơn hàng
		PhatSinhMa_DAO maHDH = new PhatSinhMa_DAO();
		maPhieuXuat = maHDH.generateRandomHoaDonXuatHang();
		
		String tenCH = (String) cbxCuaHang.getSelectedItem();
		ch_DAO = new CuaHang_DAO();
		CuaHang ch = ch_DAO.getCuaHangTheoTen(tenCH);
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		HoaDonHang hdh = new HoaDonHang(maPhieuXuat, ch, date); 
		hdh_dao = new HoaDonHang_DAO();
		try {
			hdh_dao.addHoaDonHang(hdh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Thêm chi tiết hóa đơn hàng
		int soRow = tblHopDong.getRowCount();
		for(int i=0;i<soRow;i++)
		{
			themCTXH(i);
		}
		
		
		//Thêm phiêu xuất
		PhieuXuat px = new PhieuXuat(maPhieuXuat);
		if(!phieuXuat_dao.createPX(px))
		{
			JOptionPane.showMessageDialog(this, "Không tạo được!!");
		}
	}
	
	//	thêm vào chi tiết phiếu xuất hàng
	private void themCTXH(int vtRow) {
		HoaDonHang HDH = new HoaDonHang(maPhieuXuat);
		String tenT = tblModel.getValueAt(vtRow, 1).toString();
		int soLuong = Integer.parseInt(tblModel.getValueAt(vtRow,2).toString());
		MatHang m = matHang_DAO.getMatHangTheoTen(tenT);
		ChiTietHoaDonHang cthdh = new ChiTietHoaDonHang(HDH, m, soLuong);
		if(!cthdHang_dao.createHDH(cthdh))   
		{	
			JOptionPane.showMessageDialog(this, "Không tạo được!!");
		}
	}
	
	//Thêm vào hợp đồng trả trực tiếp
	private void themHDTraTrucTiep() {
		HopDong HD = new HopDong(maHd);
		double PhanTramMienGiam =  Double.parseDouble(txtGiam.getText());
		double soTienTra = Double.parseDouble(txtTienDua.getText());
		TraTrucTiep HDTraTrucTiep = new TraTrucTiep(HD, PhanTramMienGiam, soTienTra); 
		traTrucTiep_dao.createHDTraTrucTiep(HDTraTrucTiep);
	}
	
	//Thêm vào hợp đồng trả góp
	private void themHDTraGop() {
		HopDong HD = new HopDong(maHd);
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		double laiSuat = Double.parseDouble(txtLaiSuat.getText());
		String nguoiTra = txtTenKH.getText() + "-" + txtSoDt.getText();
		double soTienTra = Double.parseDouble(txtTienDua.getText());
		TraGop HDTraGop = new TraGop(HD, date, laiSuat, nguoiTra, soTienTra);
		traGop_dao.createHDTraGop(HDTraGop);
	}

	//	thêm vào chi tiết hợp đồng
	private void themCTHD(int vtRow) {
		HopDong HD = new HopDong(maHd);
		String maCTHD = tblModel.getValueAt(vtRow, 0).toString();
		String tenT = tblModel.getValueAt(vtRow, 1).toString();
		int soLuong = Integer.parseInt(tblModel.getValueAt(vtRow,2).toString());
		MatHang m = matHang_DAO.getMatHangTheoTen(tenT);
		ChiTietHopDong cthd = new ChiTietHopDong(HD, maCTHD, m, soLuong);
		if(!cthd_dao.createCTHD(cthd) || soLuong<=0)   
		{	
			JOptionPane.showMessageDialog(this, "Không tạo được CTHD!!");
		}
	}		

	private void xoaCTHD() {
		if (tblHopDong.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm cần xóa");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				int index = tblHopDong.getSelectedRow();
				tblModel.removeRow(index);
				tongTien();
			}
		}
	}
		
		
	private void clearTable() {
		while (tblHopDong.getRowCount() > 0) {
			tblModel.removeRow(0);
		}
	}
	
	private void xoaRong() {
		clearTable();
		
		grbType.clearSelection();
		txtTenKH.setText("");
		txtDiaChi.setText("");
		txtSoDt.setText("");
		grbSex.clearSelection();
		
		cbxTenXe.removeAllItems();
		cbxDongXe.removeAllItems();
		txtSoLuongTon.setText("");
		txtSoLuongMua.setText("");
		
		txtTenKH.requestFocus();
		cbxTenNV.removeAllItems();
		cbxChucVu.removeAllItems();
		cbxSoDT.removeAllItems();
		
		txtMaKH.setText("");
		txtTenNVTT.setText("");
		txtBaoHanh.setText("");
		cbxCuaHang.removeAllItems();
		txtTongTT.setText("");
		txtGiam.setText("");
		txtLaiSuat.setText("");
		txtTienDua.setText("");
		
		for(Xe n :xe_DAO.getAllXe())
		{
			cbxTenXe.addItem(n.getTenMH());;
		}
		
		for(NhanVien n :nv_dao.getAllNhanVien())
		{
			cbxTenNV.addItem(n.getTenNV());;
		}
		
		for(CuaHang n :ch_DAO.getAllCuaHang())
		{
			cbxCuaHang.addItem(n.getTenCuaHang());;
		}
		
	}


	private void tongTien() {
		int row = tblHopDong.getRowCount();
		double tong =0;
		for(int i =0;i<row;i++) {
			tong+= Double.parseDouble(tblHopDong.getValueAt(i, 4).toString());
		}
		txtTongTT.setText("   " + df.format(tong)+ " VNĐ");
	}
	
	private int tongSoLuong() {
		int row = tblHopDong.getRowCount();
		int tongSL =0;
		for(int i =0;i<row;i++) {
			tongSL += Integer.parseInt(tblHopDong.getValueAt(i, 2).toString());
		}
		return tongSL;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(radCu)) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại để định danh");
			txtTenKH.setEditable(false);
			txtTenKH.setText("");
			txtDiaChi.setEditable(false);
			txtDiaChi.setText("");
			radNam.setEnabled(false);
			radNu.setEnabled(false);
			txtSoDt.setText("");
			txtSoDt.requestFocus();
		}
		else if(obj.equals(radMoi)) {
			txtTenKH.setEditable(true);
			txtTenKH.setText("");
			txtDiaChi.setEditable(true);
			txtDiaChi.setText("");
			txtSoDt.setText("");
			radNam.setEnabled(true);
			radNu.setEnabled(true);
			grbSex.clearSelection();
			txtMaKH.setText("");
			txtTenKH.requestFocus();
		}
		else if(obj.equals(btnXoaTrangKH)) //Xoa trang KH
		{
			xoaTrangKH();
		}
		else if(obj.equals(btnLayTTKH))
		{
			themKH();
		}
		else if(obj.equals(btnThemXe)) {
			themXeVaoHD();
		}
		else if(obj.equals(btnThemNV)) {
			themNhanVien();
		}
		else if(obj.equals(btnXoaDong))
			xoaCTHD();
		else if(obj.equals(btnThanhToan))
		{
			themhd();
			FrmXuatHang xuatHang = new FrmXuatHang(maPhieuXuat);
			xuatHang.setVisible(true);
		}
		else if(obj.equals(btnXoaTrang))
			xoaRong();
	
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getItem() == cbxTenNV.getSelectedItem())
		{
			nv = new NhanVien_DAO();
			String s = (String) cbxTenNV.getSelectedItem();
			String chucVu = nv.getchucVuNhanVienTheoTen(s);
			String sdt = nv.getSoDienThoaiNhanVienTheoTen(s);
			cbxChucVu.removeAllItems();
			cbxSoDT.removeAllItems();

			cbxChucVu.addItem(chucVu);
			cbxSoDT.addItem(sdt);
		}
		else if(e.getItem() == cbxTenXe.getSelectedItem())
		{
			xe = new Xe_DAO();
			String s = (String) cbxTenXe.getSelectedItem();
			String dongXe = xe.getDongXeTheoTenXe(s);
			cbxDongXe.removeAllItems();
			cbxDongXe.addItem(dongXe);
			
			int sl = xe.getSoLuongTheoTenXe(s);
			txtSoLuongTon.setText(sl + "");
		}
		else if(e.getItem() == cbxHinhThucTT.getSelectedItem()) {
			String s = (String) cbxHinhThucTT.getSelectedItem();
			if(s.equalsIgnoreCase("Trả trực tiếp")) {
				if(tblHopDong.getRowCount()>0)
				{
					int row = tblHopDong.getRowCount();
					double tong =0;
					for(int i =0;i<row;i++) {
						tong += Double.parseDouble(tblHopDong.getValueAt(i, 4).toString());
					}
					
					if(tongSoLuong() > 3)  //Tổng Số lượng lớn hơn 3 chiệc được giảm 5%
					{
						txtGiam.setText(0.05 + "");
						txtLaiSuat.setText("");
						txtTienDua.setText("   " + df.format((tong-tong*0.05)));
					}
					else
					{
						txtGiam.setText(0.02 + "");
						txtLaiSuat.setText("");
						txtTienDua.setText("   " + df.format((tong-tong*0.02)));
					}
				}
			}
			else if(s.equalsIgnoreCase("Trả góp")) {
				if(tblHopDong.getRowCount()>0)
				{
					int row = tblHopDong.getRowCount();
					double tong =0;
					for(int i =0;i<row;i++) {
						tong+= Double.parseDouble(tblHopDong.getValueAt(i, 4).toString());
					}
					
					txtLaiSuat.setText(0.01 + "");
					double tienKhachDua = tong/3+ (tong/3)*0.01;  //Trả 3 đợt
					txtGiam.setText("");
					txtTienDua.setText("   " + df.format(tienKhachDua));
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblHopDong.getSelectedRow();
		txtSoLuongMua.setText(tblModel.getValueAt(row, 2).toString());
		cbxTenXe.setSelectedItem(tblModel.getValueAt(row, 1));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}