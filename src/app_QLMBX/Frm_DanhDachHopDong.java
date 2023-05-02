package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import dao.ChiTietHopDong_DAO;
import dao.CuaHang_DAO;
import dao.HopDong_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import entity.ChiTietHopDong;
import entity.CuaHang;
import entity.DateLabelFormatter;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVien;

public class Frm_DanhDachHopDong extends JPanel implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private String[] cols = { "STT", "Mã hợp đồng", "Ngày lập", "Thời gian", "Loại hợp đồng", "Tên nhân viên",
			"Tên cửa hàng", "Tên khách hàng" };
	private String[] cols_ct = { "Mã chi tiết hợp đồng", "Tên mặt hàng", "Đơn giá", "Số lượng",
			"Số điện thoại khách hàng" };
	private JTable table_ct;
	private DefaultTableModel model_ct;
	private JTextField txtMa;
	private Font font;
	private JTextField txtThoiGian;
	private JTextField txtmaCH;
	private JTextField txtmaNV;
	private JComboBox<String> cbTim;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnTTTraGop;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnSua;
	private SqlDateModel modelNgaylap;
	private Properties p;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private JTextField txtmaKH;
	private HopDong_DAO bh;
	private NhanVien_DAO nvdao;
	private CuaHang_DAO chdao;
	private KhachHang_DAO khdao;
	private HopDong_DAO hddao = new HopDong_DAO();
	private JComboBox<String> cbloaiHD;
	private JLabel lblTitle_ct;
	private ChiTietHopDong_DAO cthddao = new ChiTietHopDong_DAO();

	public Frm_DanhDachHopDong() {
		setLayout(null);
		JPanel panelNorth = new JPanel();
		add(panelNorth);
		panelNorth.setBounds(0, 0, 970, 50);
		JLabel lblTitle;
		panelNorth.add(lblTitle = new JLabel("Quản lý thông tin hợp đồng"));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setForeground(new Color(0, 40, 255));

		JPanel panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBounds(5, 50, 970, 290);

		// Bảng
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setBackground(Color.pink);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(table);
		panelCenter.add(pane);
		pane.setPreferredSize(new Dimension(950, 165));

		panelCenter.add(lblTitle_ct = new JLabel("Chi tiết"));
		lblTitle_ct.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle_ct.setForeground(new Color(0, 40, 255));

		model_ct = new DefaultTableModel(cols_ct, 0);
		table_ct = new JTable(model_ct);
		table_ct.setBackground(Color.pink);
		table_ct.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane_ct = new JScrollPane(table_ct);
		panelCenter.add(pane_ct);
		pane_ct.setPreferredSize(new Dimension(950, 55));

		panelCenter.add(btnTTTraGop = new JButton("Thanh toán trả góp"));

		// Thông tin khách hàng
		JPanel panelSouth = new JPanel();
		panelSouth.setBounds(7, 340, 580, 200);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Thông tin hợp đồng"));
		TitledBorder titledthongtin = (TitledBorder) panelSouth.getBorder();
		titledthongtin.setTitleColor(Color.blue);
		panelSouth.setLayout(null);

		JLabel lblMa = new JLabel("Mã hợp đồng:");
		panelSouth.add(lblMa);
		lblMa.setBounds(20, 30, 150, 20);
		add(panelSouth);
		font = new Font("Arial", Font.PLAIN, 16);
		lblMa.setFont(font);
		panelSouth.add(txtMa = new JTextField());
		txtMa.setBounds(140, 30, 110, 23);
		txtMa.setFont(font);
		txtMa.setEditable(false);
		Set<String> generatedCodes = new HashSet<>();
		String code;
		do {
			code = generateRandomCode();
		} while (generatedCodes.contains(code));
		generatedCodes.add(code);

		// Đặt giá trị cho JTextField
		txtMa.setText(code);

		JLabel lblTen = new JLabel("Ngày lập:");
		panelSouth.add(lblTen);
		lblTen.setBounds(270, 30, 100, 20);
		lblTen.setFont(font);
		modelNgaylap = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelNgaylap, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(370, 30, 190, 30);
		datePicker.setBackground(new Color(248, 248, 248));
		datePicker.setToolTipText("Chọn ngày lập");
		modelNgaylap.setDate(1990, 0, 1);
		modelNgaylap.setSelected(true);
		panelSouth.add(datePicker);

		JLabel lblThoiGian = new JLabel("Thời gian (Tháng):");
		panelSouth.add(lblThoiGian);
		lblThoiGian.setBounds(20, 75, 130, 20);
		lblThoiGian.setFont(font);
		panelSouth.add(txtThoiGian = new JTextField());
		txtThoiGian.setBounds(160, 75, 100, 23);
		txtThoiGian.setFont(font);

		JLabel lblloaiHD = new JLabel("Loại hợp đồng:");
		panelSouth.add(lblloaiHD);
		lblloaiHD.setBounds(280, 75, 150, 20);
		lblloaiHD.setFont(font);
		cbloaiHD = new JComboBox<String>();
		cbloaiHD.addItem("Trả trực tiếp");
		cbloaiHD.addItem("Trả góp");
		panelSouth.add(cbloaiHD);
		cbloaiHD.setFont(font);
		cbloaiHD.setBounds(400, 75, 160, 23);

		JLabel lblmaNV = new JLabel("Mã nhân viên:");
		panelSouth.add(lblmaNV);
		lblmaNV.setBounds(20, 120, 150, 20);
		lblmaNV.setFont(font);
		panelSouth.add(txtmaNV = new JTextField());
		txtmaNV.setFont(font);
		txtmaNV.setBounds(130, 120, 150, 23);

		JLabel lblmaCH = new JLabel("Mã cửa hàng:");
		panelSouth.add(lblmaCH);
		lblmaCH.setBounds(300, 120, 130, 20);
		lblmaCH.setFont(font);
		panelSouth.add(txtmaCH = new JTextField());
		txtmaCH.setFont(font);
		txtmaCH.setBounds(420, 120, 140, 23);

		JLabel lblmaKH = new JLabel("Mã khách hàng:");
		panelSouth.add(lblmaKH);
		lblmaKH.setBounds(20, 165, 130, 20);
		lblmaKH.setFont(font);
		panelSouth.add(txtmaKH = new JTextField());
		txtmaKH.setFont(font);
		txtmaKH.setBounds(145, 165, 140, 23);

		// chức năng
		JPanel panelChucNang = new JPanel();
		panelChucNang.setLayout(null);
		panelChucNang.setBounds(595, 340, 375, 200);
		panelChucNang.setBorder(BorderFactory.createTitledBorder("Các chức năng"));
		TitledBorder titledchucnang = (TitledBorder) panelChucNang.getBorder();
		titledchucnang.setTitleColor(Color.blue);
		add(panelChucNang);

		JLabel lblTim = new JLabel("Chọn loại muốn tìm:");
		panelChucNang.add(lblTim);
		lblTim.setBounds(20, 30, 150, 20);
		lblTim.setFont(font);
		cbTim = new JComboBox<String>();
		cbTim.addItem("Tìm theo mã");
		cbTim.addItem("Tìm theo số điện thoại");
		cbTim.addItem("Tìm theo mã khách hàng");
		panelChucNang.add(cbTim);
		cbTim.setBounds(175, 30, 180, 23);
		cbTim.setFont(new Font("Arial", Font.PLAIN, 15));

		JLabel lblNhapTT = new JLabel("Nhập thông tin:");
		panelChucNang.add(lblNhapTT);
		lblNhapTT.setBounds(20, 70, 150, 20);
		lblNhapTT.setFont(font);
		panelChucNang.add(txtTim = new JTextField());
		txtTim.setFont(font);
		txtTim.setBounds(140, 70, 220, 23);

		panelChucNang.add(btnTim = new JButton("Tìm kiếm"));
		btnTim.setIcon(new ImageIcon("image\\tim.png"));
		btnTim.setFont(font);
		btnTim.setBounds(112, 110, 140, 25);

		panelChucNang.add(btnXoa = new JButton("Xóa"));
		btnXoa.setIcon(new ImageIcon("image\\delete-icon.png"));
		btnXoa.setFont(font);
		btnXoa.setForeground(Color.red);
		btnXoa.setBounds(10, 160, 90, 25);

		panelChucNang.add(btnXoaTrang = new JButton("Xóa trắng"));
		btnXoaTrang.setIcon(new ImageIcon("image\\icons8_x_24px.png"));
		btnXoaTrang.setFont(font);
		btnXoaTrang.setBounds(115, 160, 140, 25);

		panelChucNang.add(btnSua = new JButton("Sửa"));
		btnSua.setIcon(new ImageIcon("image\\sua.png"));
		btnSua.setFont(font);
		btnSua.setBounds(265, 160, 100, 25);
		loadData();
		
		btnTTTraGop.setEnabled(false);

		table.addMouseListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTTTraGop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		} else if (o.equals(btnXoa)) {
			xoa();
		} else if (o.equals(btnTim)) {
			tim();
		} else if (o.equals(btnSua)) {
			sua();
		} else if (o.equals(btnTTTraGop)) {
			frmThanhToanTraGop TTTraGop = new frmThanhToanTraGop(txtMa.getText());
			TTTraGop.setVisible(true);
		}
	}

	private void xoa() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn hợp đồng cần xóa");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa hợp đồng này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				int index = table.getSelectedRow();
				try {
					hddao.xoaHD(model.getValueAt(table.getSelectedRow(), 1).toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				model.removeRow(index);
				JOptionPane.showMessageDialog(this, "Xóa thành công");
			}
		}
	}

	private void sua() {
		int row = table.getSelectedRow();
		if(row >= 0) {
			String maHD = txtMa.getText();
			int thoiGian = -1;
			try {
				thoiGian = Integer.parseInt(txtThoiGian.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
			}
			String loaiHD = (String) cbloaiHD.getSelectedItem();
			String maNV = txtmaNV.getText();
			String maKH = txtmaKH.getText();
			String maCH = txtmaCH.getText();
			Date ngaylap = (Date) datePicker.getModel().getValue();
			
			KhachHang kh = new KhachHang(maKH);
			NhanVien nv = new NhanVien(maNV);
			CuaHang ch = new CuaHang(maCH);
			HopDong hd = new HopDong(maHD, ngaylap, thoiGian, loaiHD, nv, ch, kh);
			
			if(thoiGian == -1) {
				
			}
			else if(thoiGian > 0) {
				if (hddao.update(hd)) {
					clearTable();
					loadData();
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				} else {
					if (nvdao.getNVTheoMa(maNV) == null)
						JOptionPane.showMessageDialog(this, "Sửa không thành công mã nhân viên không tồn tại!");
					else if (chdao.getCHTheoMa(maCH) == null)
						JOptionPane.showMessageDialog(this, "Sửa không thành công mã cửa hàng không tồn tại");
					else if (khdao.getKHTheoMa(maKH) == null)
						JOptionPane.showMessageDialog(this, "Sửa không thành công mã khách hàng không tồn tại");
				}
			} else
				JOptionPane.showMessageDialog(this, "Thời gian bảo hành phải lớn hơn 0");
		} else 
			JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
	}

//	private void them() {
//		Set<String> generatedCodes = new HashSet<>();
//		String code;
//		do {
//			code = generateRandomCode();
//		} while (generatedCodes.contains(code));
//		generatedCodes.add(code);
//
//		// Đặt giá trị cho JTextField
//		txtMa.setText(code);
//
//		String maHD = txtMa.getText();
//		int thoiGian = Integer.parseInt(txtThoiGian.getText());
//		String loaiHD = (String) cbloaiHD.getSelectedItem();
//		String maNV = txtmaNV.getText();
//		String maKH = txtmaKH.getText();
//		String maCH = txtmaCH.getText();
//		Date ngaylap = (Date) datePicker.getModel().getValue();
//
//		KhachHang kh = new KhachHang(maKH);
//		NhanVien nv = new NhanVien(maNV);
//		CuaHang ch = new CuaHang(maCH);
//		HopDong hd = new HopDong(maHD, ngaylap, thoiGian, loaiHD, nv, ch, kh);
//
//		if (hddao.createHD(hd)) {
//			model.addRow(new Object[] { model.getRowCount() + 1, maHD, ngaylap, thoiGian, loaiHD,
//					nvdao.getNVTheoMa(maNV).getTenNV(), chdao.getCHTheoMa(maCH).getTenCuaHang(),
//					khdao.getKHTheoMa(maKH).getTenKH() });
//			JOptionPane.showMessageDialog(this, "Thêm thành công");
//		} else {
//			if (nvdao.getNVTheoMa(maNV) == null)
//				JOptionPane.showMessageDialog(this, "Thêm không thành công mã nhân viên không tồn tại!");
//			else if (chdao.getCHTheoMa(maCH) == null)
//				JOptionPane.showMessageDialog(this, "Thêm không thành công mã cửa hàng không tồn tại");
//			else if (khdao.getKHTheoMa(maKH) == null)
//				JOptionPane.showMessageDialog(this, "Thêm không thành công mã khách hàng không tồn tại");
//		}
//
//	}

	private void xoaTrang() {
		txtMa.setText("");
		txtmaCH.setText("");
		txtmaKH.setText("");
		txtmaNV.setText("");
		txtThoiGian.setText("");
		txtTim.setText("");
	}

	private void tim() {
		int selectedIndex = cbTim.getSelectedIndex();
		int i = 0;
		if (btnTim.getText().equals("Tìm kiếm")) {
			if (selectedIndex == 0) {
				HopDong hd = null;
				try {
					hd = hddao.getHopDongTheoMa(txtTim.getText());
				} catch (Exception e) {
					// TODO: handle exception
				}

				if (hd != null) {
					btnTim.setText("Hủy tìm");
					clearTable();
					NhanVien nv = nvdao.getNVTheoMa(hd.getNvLapHD().getMaNV());
					CuaHang ch = chdao.getCHTheoMa(hd.getCuaHang().getMaCH());
					KhachHang kh = khdao.getKHTheoMa(hd.getKhachHang().getMaKH());
					Object[] row = { ++i, hd.getMaHD(), hd.getNgaylapHD(), hd.getThoiGianBH(), hd.getLoaiHD(),
							nv.getTenNV(), ch.getTenCuaHang(), kh.getTenKH() };
					model.addRow(row);
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy");
				}
			} else if (selectedIndex == 1) {
				KhachHang kh = null;
				try {
					kh = khdao.getKHTheoSDT(txtTim.getText());
				} catch (Exception e) {
					// TODO: handle exception
				}

				if (kh != null) {
					ArrayList<HopDong> dshd = hddao.getHDTheoMaKH(kh.getMaKH());
					if (dshd != null) {
						btnTim.setText("Hủy tìm");
						clearTable();
						for (HopDong hd : dshd) {
							NhanVien nv = nvdao.getNVTheoMa(hd.getNvLapHD().getMaNV());
							CuaHang ch = chdao.getCHTheoMa(hd.getCuaHang().getMaCH());
							Object[] row = { ++i, hd.getMaHD(), hd.getNgaylapHD(), hd.getThoiGianBH(), hd.getLoaiHD(),
									nv.getTenNV(), ch.getTenCuaHang(), kh.getTenKH() };
							model.addRow(row);
						}
					} else {
						JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin hợp đồng");
					}

				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
				}
			} else if (selectedIndex == 2) {
				ArrayList<HopDong> dshd = hddao.getHDTheoMaKH(txtTim.getText());
				if (dshd != null) {
					btnTim.setText("Hủy tìm");
					clearTable();
					for (HopDong hd : dshd) {
						NhanVien nv = nvdao.getNVTheoMa(hd.getNvLapHD().getMaNV());
						CuaHang ch = chdao.getCHTheoMa(hd.getCuaHang().getMaCH());
						KhachHang kh = khdao.getKHTheoMa(hd.getKhachHang().getMaKH());
						Object[] row = { ++i, hd.getMaHD(), hd.getNgaylapHD(), hd.getThoiGianBH(), hd.getLoaiHD(),
								nv.getTenNV(), ch.getTenCuaHang(), kh.getTenKH() };
						model.addRow(row);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin hợp đồng");
				}

			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
			}
		} else {
			clearTable();
			loadData();
			btnTim.setText("Tìm kiếm");
		}
	}

	public void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	private void clearTable_CT() {
		while (table_ct.getRowCount() > 0) {
			model_ct.removeRow(0);
		}
	}

	public void loadData() {
		int i = 0;
		bh = new HopDong_DAO();
		nvdao = new NhanVien_DAO();
		NhanVien nv;
		chdao = new CuaHang_DAO();
		CuaHang ch;
		khdao = new KhachHang_DAO();
		KhachHang kh;
		for (HopDong x : bh.getAllHopDong()) {
			i++;
			nv = nvdao.getNVTheoMa(x.getNvLapHD().getMaNV());
			ch = chdao.getCHTheoMa(x.getCuaHang().getMaCH());
			kh = khdao.getKHTheoMa(x.getKhachHang().getMaKH());
			Object[] row = { i, x.getMaHD(), x.getNgaylapHD(), x.getThoiGianBH(), x.getLoaiHD(), nv.getTenNV(),
					ch.getTenCuaHang(), kh.getTenKH() };
			model.addRow(row);
		}
	}

	private String generateRandomCode() {
		String prefix = "HD";
		int maxNumber = 999999;
		int randomNum = new Random().nextInt(maxNumber);
		String suffix = String.format("%06d", randomNum);
		return prefix + suffix;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		HopDong hd = hddao.getHopDongTheoMa(model.getValueAt(row, 1).toString());

		txtMa.setText(model.getValueAt(row, 1).toString());
		modelNgaylap.setValue((java.sql.Date) model.getValueAt(row, 2));
		txtThoiGian.setText(model.getValueAt(row, 3).toString());
		if (model.getValueAt(row, 4).toString().equals("Trả trực tiếp")) {
			cbloaiHD.setSelectedIndex(0);
		} else {
			cbloaiHD.setSelectedIndex(1);
		}
		txtmaKH.setText(hd.getKhachHang().getMaKH());
		txtmaCH.setText(hd.getCuaHang().getMaCH());
		txtmaNV.setText(hd.getNvLapHD().getMaNV());

		// chi tiết
		ArrayList<ChiTietHopDong> dscthd = cthddao.getCTHDTheoMaHD(txtMa.getText());
		KhachHang kh = khdao.getKHTheoMa(txtmaKH.getText());
		DecimalFormat df = new DecimalFormat("#.##");
		clearTable_CT();
		for (ChiTietHopDong cthd : dscthd) {
			String donGia = df.format(cthd.getMatHang().getDonGia());
			Object[] obj = { cthd.getMaChiTietHD(), cthd.getMatHang().getTenMH(), donGia, cthd.getSoLuong(), kh.getSdt() };
			model_ct.addRow(obj);
		}
		
		if(cbloaiHD.getSelectedItem().equals("Trả góp")) {
			btnTTTraGop.setEnabled(true);
		}else {
			btnTTTraGop.setEnabled(false);
		}
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
