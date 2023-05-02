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

import dao.BaoHanh_DAO;
import dao.HopDong_DAO;
import dao.KhachHang_DAO;
import dao.LinhKien_DAO;
import dao.NhanVien_DAO;
import entity.DateLabelFormatter;
import entity.HopDong;
import entity.KhachHang;
import entity.LinhKienPhuTung;
import entity.NhanVien;
import entity.PhieuBaoHanh;

public class FrmBaoHanh extends JPanel implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private String[] cols = { "STT", "Mã phiếu bảo hành","Mã hợp đồng","Mã linh kiện", "Ngày lập","Lí do", "Lỗi của ai", "Giá tiền sửa", "Nhân viên lập","Tên khách hàng"};
	private Font font;
	private JTextField txtmaNV;
	private JComboBox<String> cbTim;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnSua;
	private SqlDateModel modelNgaylap;
	private Properties p;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private JTextField txtmaKH;
	private HopDong_DAO hd_dao;
	private NhanVien_DAO nvdao;
	private KhachHang_DAO khdao;
	private BaoHanh_DAO bh_dao;
	private LinhKien_DAO lk_dao;
	private JTextField txtMaPhieu;
	private JTextField txtLinhKien;
	private JTextField txtLiDo;
	private JTextField txtHopDong;
	private JTextField txtLoi;
	private JTextField txtTienSua;
	private BaoHanh_DAO bh;
	private DecimalFormat df = new DecimalFormat("#");

	public FrmBaoHanh() {
		setLayout(null);
		JPanel panelNorth = new JPanel();
		add(panelNorth);
		panelNorth.setBounds(0, 0, 970, 50);
		JLabel lblTitle;
		panelNorth.add(lblTitle = new JLabel("Quản lý thông tin bảo hành"));
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
		pane.setPreferredSize(new Dimension(950, 270));

		JPanel panelSouth = new JPanel();
		panelSouth.setBounds(7, 340, 560, 200);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Thông tin bảo hành"));
		TitledBorder titledthongtin = (TitledBorder) panelSouth.getBorder();
		titledthongtin.setTitleColor(Color.blue);
		panelSouth.setLayout(null);
		add(panelSouth);

		JLabel lblMaPhieu = new JLabel("Mã Phiếu BH:");
		panelSouth.add(lblMaPhieu);
		lblMaPhieu.setBounds(20, 30, 150, 20);
		font = new Font("Arial", Font.PLAIN, 16);
		lblMaPhieu.setFont(font);
		panelSouth.add(txtMaPhieu = new JTextField());
		txtMaPhieu.setBounds(140, 30, 110, 23);
		txtMaPhieu.setFont(font);
		txtMaPhieu.setEditable(false);
		Set<String> generatedCodes = new HashSet<>();
		String code;
		do {
			code = generateRandomCode();
		} while (generatedCodes.contains(code));
		generatedCodes.add(code);

		// Đặt giá trị cho JTextField
		txtMaPhieu.setText(code);

		JLabel lblTen = new JLabel("Ngày lập BH:");
		panelSouth.add(lblTen);
		lblTen.setBounds(290, 30, 100, 20);
		lblTen.setFont(font);
		modelNgaylap = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelNgaylap, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(410, 30, 140, 30);
		datePicker.setBackground(new Color(248, 248, 248));
		datePicker.setToolTipText("Chọn ngày lập");
		modelNgaylap.setDate(2023, 4, 5);
		modelNgaylap.setSelected(true);
		panelSouth.add(datePicker);
		
		JLabel lblHopDong = new JLabel("Mã hợp đồng:");
		panelSouth.add(lblHopDong);
		lblHopDong.setBounds(20, 60, 150, 20);
		lblHopDong.setFont(font);
		panelSouth.add(txtHopDong = new JTextField());
		txtHopDong.setBounds(140, 60, 110, 23);
		txtHopDong.setFont(font);
//		txtHopDong.setEditable(false);


		JLabel lblLiDo = new JLabel("Lí do:");
		panelSouth.add(lblLiDo);
		lblLiDo.setBounds(290, 60, 150, 20);
		lblLiDo.setFont(font);
		panelSouth.add(txtLiDo = new JTextField());
		txtLiDo.setBounds(410, 60, 140, 23);
		txtLiDo.setFont(font);
		
		JLabel lblLinhKien = new JLabel("Mã Linh kiện:");
		panelSouth.add(lblLinhKien);
		lblLinhKien.setBounds(20, 90, 150, 20);
		lblLinhKien.setFont(font);
		panelSouth.add(txtLinhKien = new JTextField());
		txtLinhKien.setBounds(140, 90, 110, 23);
		txtLinhKien.setFont(font);
//		txtLinhKien.setEditable(false);

		JLabel lblLoi = new JLabel("Lỗi của ai:");
		panelSouth.add(lblLoi);
		lblLoi.setBounds(290, 90, 130, 20);
		lblLoi.setFont(font);
		panelSouth.add(txtLoi = new JTextField());
		txtLoi.setFont(font);
		txtLoi.setBounds(410, 90, 140, 23);
		
		JLabel lblmaNV = new JLabel("Mã nhân viên:");
		panelSouth.add(lblmaNV);
		lblmaNV.setBounds(20, 120, 130, 20);
		lblmaNV.setFont(font);
		panelSouth.add(txtmaNV = new JTextField());
		txtmaNV.setFont(font);
		txtmaNV.setBounds(140, 120, 110, 23);
		
		JLabel lblTienSua = new JLabel("Giá tiền sửa:");
		panelSouth.add(lblTienSua);
		lblTienSua.setBounds(290, 120, 130, 20);
		lblTienSua.setFont(font);
		panelSouth.add(txtTienSua = new JTextField());
		txtTienSua.setFont(font);
		txtTienSua.setBounds(410, 120, 140, 23);
		
		JLabel lblmaKh = new JLabel("Mã khách hàng:");
		panelSouth.add(lblmaKh);
		lblmaKh.setBounds(20, 150, 130, 20);
		lblmaKh.setFont(font);
		panelSouth.add(txtmaKH = new JTextField());
		txtmaKH.setFont(font);
		txtmaKH.setBounds(140, 150, 110, 23);
		txtmaKH.setEditable(false);


		// chức năng
		JPanel panelChucNang = new JPanel();
		panelChucNang.setLayout(null);
		panelChucNang.setBounds(575, 340, 375, 200);
		panelChucNang.setBorder(BorderFactory.createTitledBorder("Các chức năng"));
		TitledBorder titledchucnang = (TitledBorder) panelChucNang.getBorder();
		titledchucnang.setTitleColor(Color.blue);
		add(panelChucNang);

		JLabel lblTim = new JLabel("Chọn loại muốn tìm:");
		panelChucNang.add(lblTim);
		lblTim.setBounds(20, 30, 150, 20);
		lblTim.setFont(font);
		cbTim = new JComboBox<String>();
		cbTim.addItem("Tìm theo mã phiếu");
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
		btnTim.setBounds(117, 100, 145, 25);

		panelChucNang.add(btnThem = new JButton("Thêm"));
		btnThem.setIcon(new ImageIcon("image\\add-icon.png"));
		btnThem.setFont(font);
		btnThem.setBounds(50, 140, 140, 25);

		panelChucNang.add(btnXoa = new JButton("Xóa"));
		btnXoa.setIcon(new ImageIcon("image\\delete-icon.png"));
		btnXoa.setFont(font);
		btnXoa.setForeground(Color.red);
		btnXoa.setBounds(195, 140, 140, 25);

		panelChucNang.add(btnXoaTrang = new JButton("Xóa trắng"));
		btnXoaTrang.setIcon(new ImageIcon("image\\icons8_x_24px.png"));
		btnXoaTrang.setFont(font);
		btnXoaTrang.setBounds(50, 170, 140, 25);

		panelChucNang.add(btnSua = new JButton("Sửa"));
		btnSua.setIcon(new ImageIcon("image\\sua.png"));
		btnSua.setFont(font);
		btnSua.setBounds(195, 170, 140, 25);
		loadData();

		table.addMouseListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoaTrang.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			them();
		} else if (o.equals(btnXoaTrang)) {
			xoaTrang();
		} else if (o.equals(btnXoa)) {
			xoa();
		} 
		else if (o.equals(btnTim)) {
			tim();	
		} 
		else if (o.equals(btnSua)) {
			sua();
		}
	}
	
	private void xoa() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn Phiếu bảo hành cần xóa");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa phiếu bảo hành này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				int index = table.getSelectedRow();
				try {
					bh_dao.xoaHD(model.getValueAt(table.getSelectedRow(), 1).toString());
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
//		if (kiemTra()) {
		String maPhieu = txtMaPhieu.getText();
		String MaHD = txtHopDong.getText();
		String maLK = txtLinhKien.getText();
		String maNV = txtmaNV.getText();
		String maKH = txtmaKH.getText();
		String liDo = txtLiDo.getText();
		String loiCuaAi = txtLoi.getText();
		double tienSua = Double.parseDouble(txtTienSua.getText());
		Date ngaylap = (Date) datePicker.getModel().getValue();
		
		HopDong hd = new HopDong(MaHD);
		LinhKienPhuTung lk = new LinhKienPhuTung(maLK);
		NhanVien nv = new NhanVien(maNV);
		KhachHang kh = new KhachHang(maKH);

		PhieuBaoHanh bh = new PhieuBaoHanh(maPhieu, hd, lk, ngaylap, liDo, loiCuaAi, tienSua, nv, kh);
		
		if (bh_dao.update(bh)) {
			clearTable();
			loadData();
			JOptionPane.showMessageDialog(this, "Sửa thành công");
		} else {
			if(nvdao.getNVTheoMa(txtmaNV.getText()) == null)
				JOptionPane.showMessageDialog(this, "Sửa không thành công mã nhân viên không tồn tại!");
			else if(hd_dao.getHopDongTheoMa(txtHopDong.getText()) == null)
				JOptionPane.showMessageDialog(this, "Sửa không thành công Hợp đồng không tồn tại");
			else if(lk_dao.getLinhKienTheoMa(txtLinhKien.getText()) == null)
				JOptionPane.showMessageDialog(this, "Sửa không thành công Mã linh kiện không tồn tại");
		}		
	}
	
	private boolean kiemTraThoiHanBaoHanh() {
		String maHD = txtHopDong.getText();

		Date ngaylapBaoHanh = (Date) datePicker.getModel().getValue();
		
		@SuppressWarnings("deprecation")
		int thangLapBaoHanh = ngaylapBaoHanh.getMonth()+1;
		@SuppressWarnings("deprecation")
		int namLapBaoHanh = ngaylapBaoHanh.getYear();
		
		hd_dao = new HopDong_DAO();	
		int thoiGianBh = hd_dao.getThoiGianBHTheoMaHD(maHD);
		Date ngayLapHD = hd_dao.getNgayLapTheoMaHD(maHD);
		@SuppressWarnings("deprecation")
		int thangLapHD = ngayLapHD.getMonth()+1;
		@SuppressWarnings("deprecation")
		int namLapHD = ngayLapHD.getYear();

		int doiThang = (namLapBaoHanh - namLapHD) * 12;
		if((thangLapBaoHanh - thangLapHD) >= 0) {
			if((doiThang + (thangLapBaoHanh - thangLapHD)) <= thoiGianBh)
				return true;
			else
				return false;
		}
		else
		{
			if((doiThang - (thangLapHD - thangLapBaoHanh)) <= thoiGianBh && namLapBaoHanh-namLapHD > 0)
				return true;
			else
				return false;
		}
	}

	private void them() {
		if(txtHopDong.getText().equals("") || txtLinhKien.getText().equals("") || txtmaNV.getText().equals("") 
				|| txtLiDo.getText().equals("") || txtLoi.getText().equals("") || txtTienSua.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập đầy đủ thông tin!!");
		}else if(kiemTraThoiHanBaoHanh() == false) {
			JOptionPane.showMessageDialog(null, "Hợp đồng đã quá hạn bảo hành");
		}else {
			Set<String> generatedCodes = new HashSet<>();
			String code;
			do {
				code = generateRandomCode();
			} while (generatedCodes.contains(code));
			generatedCodes.add(code);

			// Đặt giá trị cho JTextField
			txtMaPhieu.setText(code);

			String maPhieu = txtMaPhieu.getText();
			String MaHD = txtHopDong.getText();
			String TenLK = txtLinhKien.getText();
			String maNV = txtmaNV.getText();
			hd_dao = new HopDong_DAO();
			txtmaKH.setText(hd_dao.getMaKHTheoMaHD(txtHopDong.getText()));
			String maKH = txtmaKH.getText();
			String liDo = txtLiDo.getText();
			String loiCuaAi = txtLoi.getText();
			double tienSua = Double.parseDouble(txtTienSua.getText());
			Date ngaylap = (Date) datePicker.getModel().getValue();
			
			HopDong hd = new HopDong(MaHD);
			LinhKienPhuTung lk = new LinhKienPhuTung(TenLK);
			NhanVien nv = new NhanVien(maNV);
			KhachHang kh = new KhachHang(maKH);

			PhieuBaoHanh bh = new PhieuBaoHanh(maPhieu, hd, lk, ngaylap, liDo, loiCuaAi, tienSua, nv, kh);
			bh_dao = new BaoHanh_DAO();
			if (bh_dao.createBH(bh)) {
				model.addRow(new Object[] { model.getRowCount() + 1, maPhieu, hd_dao.getHopDongTheoMa(MaHD).getMaHD(),
						lk_dao.getLinhKienTheoMa(TenLK).getMaLinhKien(), ngaylap, liDo, loiCuaAi, tienSua, nvdao.getNVTheoMa(maNV).getTenNV(), khdao.getKHTheoMa(maKH).getTenKH()});
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			} else {
				if(nvdao.getNVTheoMa(maNV) == null)
					JOptionPane.showMessageDialog(this, "Thêm không thành công mã nhân viên không tồn tại!");
				else if( hd_dao.getHopDongTheoMa(MaHD) == null)
					JOptionPane.showMessageDialog(this, "Thêm không thành công Hợp đồng không tồn tại");
				else if(lk_dao.getLinhKienTheoMa(TenLK) == null)
					JOptionPane.showMessageDialog(this, "Thêm không thành công mã linh kiện không tồn tại");
			}

		}
	}

	private void xoaTrang() {
		txtMaPhieu.setText("");
		txtHopDong.setText("");
		txtLinhKien.setText("");
		txtmaNV.setText("");
		txtLoi.setText("");
		txtTienSua.setText("");
		txtLiDo.setText("");
		txtmaKH.setText("");
	}

	private void tim() {
		int selectedIndex = cbTim.getSelectedIndex();
		int i = 0;
		if (btnTim.getText().equals("Tìm kiếm")) {
			if (selectedIndex == 0) {
				PhieuBaoHanh bh = null;
				try {
					bh_dao = new BaoHanh_DAO();
					bh = bh_dao.getPhieuBaoHanhTheoMa(txtTim.getText());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				if (bh != null) {
					btnTim.setText("Hủy tìm");
					clearTable();
					HopDong hd = hd_dao.getHopDongTheoMa(bh.getHd().getMaHD());
					LinhKienPhuTung lk = lk_dao.getLinhKienTheoMa(bh.getLkpt().getMaLinhKien());
					NhanVien nv = nvdao.getNVTheoMa(bh.getNhanVien().getMaNV());
					KhachHang kh = khdao.getKHTheoMa(bh.getKh().getMaKH());
					Object[] row = { ++i, bh.getMaPhieuBH(), hd.getMaHD(), lk.getMaLinhKien(), bh.getNgayBH(), bh.getLiDo(), bh.getLoiCuaAi(),
							bh.getGiaTienSua(),nv.getTenNV(), kh.getTenKH()};
					model.addRow(row);
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin Phiếu bảo hành");
				}
			} 
			else if (selectedIndex == 1) {
				bh_dao = new BaoHanh_DAO();
				ArrayList<PhieuBaoHanh> dsbh = bh_dao.getPhieuBaoHanhTheoMaKH(txtTim.getText());
				if (dsbh != null) {
					btnTim.setText("Hủy tìm");
					clearTable();
					for (PhieuBaoHanh bh : dsbh) {
						HopDong hd = hd_dao.getHopDongTheoMa(bh.getHd().getMaHD());
						LinhKienPhuTung lk = lk_dao.getLinhKienTheoMa(bh.getLkpt().getMaLinhKien());
						NhanVien nv = nvdao.getNVTheoMa(bh.getNhanVien().getMaNV());
						KhachHang kh = khdao.getKHTheoMa(bh.getKh().getMaKH());
						Object[] row = { ++i, bh.getMaPhieuBH(), hd.getMaHD(), lk.getMaLinhKien(), bh.getNgayBH(), bh.getLiDo(), bh.getLoiCuaAi(),
								bh.getGiaTienSua(),nv.getTenNV(), kh.getTenKH()};
						model.addRow(row);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin Phiếu bảo hành");
				}

			}
			else {
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

	public void loadData() {
		int i = 0;
		bh = new BaoHanh_DAO();
		nvdao = new NhanVien_DAO();
		NhanVien nv;
		hd_dao = new HopDong_DAO();
		HopDong hd;
		lk_dao = new LinhKien_DAO();
		LinhKienPhuTung lk;
		khdao = new KhachHang_DAO();
		KhachHang kh;
		for (PhieuBaoHanh x : bh.getAllPhieuBaoHanh()) {
			i++;
			nv = nvdao.getNVTheoMa(x.getNhanVien().getMaNV());
			hd = hd_dao.getHopDongTheoMa(x.getHd().getMaHD());
			lk = lk_dao.getLinhKienTheoMa(x.getLkpt().getMaLinhKien());
			kh = khdao.getKHTheoMa(x.getKh().getMaKH());
			Object[] row = { i, x.getMaPhieuBH(), hd.getMaHD(), lk.getMaLinhKien(), x.getNgayBH(), x.getLiDo(),
					x.getLoiCuaAi(), df.format(x.getGiaTienSua()), nv.getTenNV(), kh.getTenKH()};
			model.addRow(row);
		}
	}

	private String generateRandomCode() {
		String prefix = "BH";
		int maxNumber = 999999;
		int randomNum = new Random().nextInt(maxNumber);
		String suffix = String.format("%06d", randomNum);
		return prefix + suffix;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		bh_dao = new BaoHanh_DAO();
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		PhieuBaoHanh bh = bh_dao.getPhieuBaoHanhTheoMa(model.getValueAt(row, 1).toString());
		txtMaPhieu.setText(model.getValueAt(row, 1).toString());
		
		modelNgaylap.setValue((java.sql.Date) model.getValueAt(row, 4));
		txtLiDo.setText(model.getValueAt(row, 5).toString());
		txtLoi.setText(model.getValueAt(row, 6).toString());
		txtTienSua.setText(model.getValueAt(row, 7).toString());
		
		txtHopDong.setText(bh.getHd().getMaHD());
		txtLinhKien.setText(bh.getLkpt().getMaLinhKien());
		txtmaNV.setText(bh.getNhanVien().getMaNV());
		txtmaKH.setText(bh.getKh().getMaKH());
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
	