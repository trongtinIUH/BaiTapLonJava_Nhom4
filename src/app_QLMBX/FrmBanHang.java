package app_QLMBX;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import connectDB.ConnectDB;
import dao.ChiTietHopDong_DAO;
import dao.CuaHang_DAO;
import dao.HopDong_DAO;
import dao.KhachHang_DAO;
import dao.MatHang_DAO;
import dao.NhanVien_DAO;
import dao.PhatSinhMa_DAO;
import dao.Xe_DAO;
import entity.ChiTietHopDong;
import entity.CuaHang;
import entity.DateLabelFormatter;
import entity.HopDong;
import entity.KhachHang;
import entity.MatHang;
import entity.NhanVien;
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
	private JTextField txtSoLuong;
	private JButton btnThemXe;
	private String col[] = {"Mã chi tiết hợp đồng", "Tên mặt hàng", "Số lượng", "Đơn gia", "Thành tiền"};
	private JScrollPane scrollTable;
	private DefaultTableModel tblModel;
	private JTable tblHopDong;
	private JLabel lblMaKH;
	private JLabel lblNgayLapHD;
	private ButtonGroup grbSex;
	private JLabel lblTenNV;
	private JComboBox cbxTenNV;
	private JLabel lblTongTT;
	private JTextField txtTongTT;
	private JButton btnThemNV;
	private JComboBox cbxTenXe;
	private JTextField txtMaKH;
	private JLabel lblHinhThucTT;
	private JComboBox cbxHinhThucTT;
	private JLabel lblCuaHang;
	private JComboBox cbxCuaHang;
	private JButton btnThemKH;
	private JTextField txtTenNVTT;
	private JLabel lblChucVu;
	private JComboBox<String> cbxChucVu;
	private JComboBox<String> cbxSoDT;
	private SqlDateModel modelNgayKH;
	private Properties p;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private JLabel lblSoDtNhanVien;
	private JComboBox cbxDongXe;
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
	private int flag;

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

		
		pnKhachHang.add(btnThemKH = new JButton("Thêm khách hàng"));
		pnKhachHang.add(btnXoaTrangKH = new JButton("Xóa trắng"));
		btnThemKH.setBounds(110, 160, 150, 30);
		btnXoaTrangKH.setBounds(270, 160, 100, 30);
		add(pnKhachHang);
		
		JPanel pnXe = new JPanel();
		pnXe.setBorder(BorderFactory.createTitledBorder("Nhập thông tin xe cần mua:"));
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
		btnThemXe.setBounds(100, 160, 150, 30);
		add(pnXe);
		
		JPanel pnNV = new JPanel();
		pnNV.setBorder(BorderFactory.createTitledBorder("Nhân viên lập hóa đơn"));
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
		btnThemNV.setBounds(40, 160, 150, 30);
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
		modelNgayKH = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelNgayKH, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(450, 0, 120, 30);
		datePicker.setBackground(new Color(248,248,248));
		modelNgayKH.setDate(2020,12,12);
		modelNgayKH.setSelected(true);
		pnThongTin.add(datePicker);
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
		pnTable.setBounds(10, 290, 950, 170);
		pnTable.setLayout(null);
		
		tblModel = new DefaultTableModel(col,0);
		tblHopDong = new JTable(tblModel);
		tblHopDong.setBackground(Color.pink);
		scrollTable = new JScrollPane(tblHopDong);
		scrollTable.setBounds(10, 25, 930, 140);
		pnTable.add(scrollTable);
		add(pnTable);
		
		JPanel pnControl = new JPanel();
		pnControl.setBounds(10, 470, 950, 40);
		pnControl.setLayout(null);
		pnControl.add(lblTongTT = new JLabel("Tổng thành tiền: "));
		lblTongTT.setBounds(10, 5, 120, 20);
		pnControl.add(txtTongTT = new JTextField());
		txtTongTT.setBounds(140, 5, 200, 20);
		txtTongTT.setEditable(false);
		pnControl.add(btnXoaDong = new JButton("Xóa sản phẩm"));
		btnXoaDong.setBounds(400, 5, 150, 30);
		btnXoaDong.setForeground(Color.red);
		pnControl.add(btnXoaTrang = new JButton("LÀM MỚI"));
		btnXoaTrang.setBounds(560, 5, 100, 30);
		pnControl.add(btnThanhToan = new JButton("THANH TOÁN"));
		btnThanhToan.setBounds(670, 5, 120, 30);   
		add(pnControl);     
		
		JPanel pnLoaiTT = new JPanel();
		pnLoaiTT.setLayout(null);
		pnLoaiTT.setBounds(10, 510, 950, 40);
		pnLoaiTT.add(lblHinhThucTT = new JLabel("Chọn hình thức thanh toán: "));
		lblHinhThucTT.setBounds(10, 5, 170, 20);
		pnLoaiTT.add(cbxHinhThucTT = new JComboBox());
		cbxHinhThucTT.setBounds(190, 5, 120, 20);
		cbxHinhThucTT.addItem("Trả trực tiếp");
		cbxHinhThucTT.addItem("Trả góp");
		pnLoaiTT.add(lblGiam = new JLabel("Tiền giảm"));
		lblGiam.setBounds(320, 5, 60, 20);
		pnLoaiTT.add(txtGiam = new JTextField());
		txtGiam.setBounds(390, 5, 60, 20);
		txtGiam.setEditable(false);
		pnLoaiTT.add(lblLaiSuat = new JLabel("Lãi suất"));
		lblLaiSuat.setBounds(470, 5, 60, 20);
		pnLoaiTT.add(txtLaiSuat = new JTextField());
		txtLaiSuat.setBounds(540, 5, 60, 20);
		txtLaiSuat.setEditable(false);
		pnLoaiTT.add(lblTienDua = new JLabel("Tiền phải đưa"));
		lblTienDua.setBounds(620, 5, 90, 20);
		pnLoaiTT.add(txtTienDua = new JTextField());
		txtTienDua.setBounds(730, 5, 200, 20);
		txtTienDua.setEditable(false);
		add(pnLoaiTT);
		
		
		btnThemKH.addActionListener(this);
		btnXoaTrangKH.addActionListener(this);
		btnThemXe.addActionListener(this);
		btnThemNV.addActionListener(this);
		btnXoaDong.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnThanhToan.addActionListener(this);
		cbxTenNV.addItemListener(this);
		cbxTenXe.addItemListener(this);
		tblHopDong.addMouseListener(this);
	}
	
	private void xoaTrangKH() {
		txtTenKH.setText("");
		txtDiaChi.setText("");
		txtSoDt.setText("");
		grbSex.clearSelection();
		txtTenKH.requestFocus();
	}
	

//	
//	private String themXe() {
//		String tenXe = (String)cbxTenXe.getSelectedItem();
//		return tenXe;
//	}
//	
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
		//if(kiemTraKH()) {
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
			kh_dao = new KhachHang_DAO();
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
				
		//}
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
		//if(kiemTraMatHang()&&kiemTraKH())
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
	
	
	//Thêm vào hợp đồng
	private void themhd() {

		if(txtBaoHanh.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập TG bảo hành!!");
		}
		else
		{
			Date ngaylap =(Date) datePicker.getModel().getValue();
			int tgBH =Integer.parseInt(txtBaoHanh.getText());
			String loaiHD = cbxHinhThucTT.getSelectedItem().toString();
			NhanVien nvl = nv_dao.getNhanVienTheoTen(cbxTenNV.getSelectedItem().toString());
			CuaHang cuaHang = ch_DAO.getCuaHangTheoTen(cbxCuaHang.getSelectedItem().toString());
			KhachHang kh = kh_dao.getKHTheoSDT(txtSoDt.getText());
			//		ChiTietHopDong cthd = cthd_dao.getCTHDTheoMa(maCTHD);
			int soDong = tblModel.getRowCount();
			if(nvl==null || cuaHang==null || kh==null || soDong==0) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập đầy đủ thông tin");
			}
			else if(tgBH <= 0) {
				JOptionPane.showMessageDialog(null, "Thời gian bảo hành không hợp lệ");
			}
			else {
				//maHd = ma.generateRandomHopDong();
				HopDong hd = new HopDong(maHd, ngaylap, tgBH, loaiHD, nvl, cuaHang, kh);
				if(hd_dao.createHD(hd))
					JOptionPane.showMessageDialog(this, "Thanh Toán thành công, hợp đồng đã được lưu vào CSDL!!");
			}
		}
	}
	
	//Thêm vào hợp đồng trả trực tiếp(Chưa làm)
	
	
	//Thêm vào hợp đồng trả góp(chưa làm)

	//	thêm vào chi tiết 
	private void themCTHD(int vtRow) {
		//if(kiemTraThuoc()&&kiemTraKH())
		//{
		HopDong HD = new HopDong(maHd);
		String maCTHD = tblModel.getValueAt(vtRow, 0).toString();
		String tenT = tblModel.getValueAt(vtRow, 1).toString();
		int soLuong = Integer.parseInt(tblModel.getValueAt(vtRow,2).toString());
		MatHang m = matHang_DAO.getMatHangTheoTen(tenT);
		ChiTietHopDong cthd = new ChiTietHopDong(HD, maCTHD, m, soLuong);
		if(!cthd_dao.createCTHD(cthd) || soLuong<=0)   
		{	
			JOptionPane.showMessageDialog(this, "Không tạo được!!");
		}
		//}

	}
	
	// Thanh toán và lưu thông tin hợp đồng
	private void thanhToan() {
		themhd();
		int soRow = tblHopDong.getRowCount();
		for(int i=0;i<soRow;i++)
		{
			themCTHD(i);
		}
	}

		
//	private void timSDTKH()
//	{
//
//
//		String sdt = txtTimSo.getText().trim();
//		KhachHang kh = kh_dao.getKhachHangTheoSDT(sdt);
//		if(kh!=null)
//		{
//
//			lbXuatTenKH.setText(kh.getMaKH());
//			txtTenKH.setText(kh.getHoTen());
//			txtSDT.setText(kh.getSDT());
//			modelNgayKH.setValue(kh.getNgaySinh());
//			txtDiaChi.setText(kh.getDiaChi());
//
//			if (kh.isGioiTinh()) {
//				radNam.setSelected(true);
//				radNu.setSelected(false);
//			} else {
//				radNam.setSelected(false);
//				radNu.setSelected(true);
//			}
//		}
//		else JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại");
//	}

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
		
		
		//sửa Khách hàng 
//	private void suaKH() {
//
//		if(kiemTraKH()) {
//
//		String tenkh = txtTenKH.getText().trim();
//		String sdt = txtSoDt.getText().trim();
//		String diachi = txtDiaChi.getText().trim();
//		boolean gioitinh = radNam.isSelected();
//		KhachHang ktkh = kh_dao.getKhachHangTheoSDT(txtSDT.getText());
//		KhachHang skh = new KhachHang(lbXuatTenKH.getText(), tenkh, gioitinh, diachi, sdt);
//		if(ktkh!=null&&!ktkh.getMaKH().equalsIgnoreCase(lbXuatTenKH.getText()))
//		{
//			JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại ở khách hàng khác");
//		}
//		else if(kh_dao.update(skh))
//		{
//			JOptionPane.showMessageDialog(this,"Cập nhật thành công thông tin khách hàng");
//			txtTimSDT.setText(skh.getSDT());
//		}
//
//		}
//
//
//	}
		
	private void clearTable() {
		while (tblHopDong.getRowCount() > 0) {
			tblModel.removeRow(0);
		}
	}
	
	private void xoaRong() {
		clearTable();
		
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
		
		for(Xe n :xe_DAO.getAllXe())
		{
			cbxTenNV.addItem(n.getTenMH());;
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
		txtTongTT.setText(" "+tong+ " VNĐ");
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnXoaTrangKH)) //Xoa trang KH
		{
			xoaTrangKH();
		}
		else if(obj.equals(btnThemKH))
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
			thanhToan();
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblHopDong.getSelectedRow();
		txtSoLuong.setText(tblModel.getValueAt(row, 2).toString());
//		cbxTenNV.setSelectedItem(tblModel.getValueAt(row, 1));
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