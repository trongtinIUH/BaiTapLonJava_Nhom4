package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import dao.NhanVien_DAO;
import entity.DateLabelFormatter;
import entity.NhanVien;
import entity.Regex;

public class FrmNhanVien extends JPanel implements Serializable, ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String col[] = { "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Địa Chỉ", "SDT", "Email", "Ngày Vào Làm",
			"Chức Vụ", "Lương", "Mã Cửa Hàng" };
	private JLabel lblmaNV, lbltenNV, lblGioiTinh, lbldiaChi, lblsdt, lblemail, lblngayvaolam, lblchucVu, lblluongcoBan,
			lblmaCH;
	private JTextField txtmaNV, txttenNV, txtdiaChi, txtsdt, txtemail, txtLuong;
	private JButton btnThem, btnXoa, btnXoaTrang, btnTimKiem;
	private JTable tblNhanVien;
	private DefaultTableModel model;

	private JComboBox<String> jComboBox_gioitinh;
	private String[] GioiTinh = new String[] { "Nam", "Nữ" };
	private JComboBox<String> jComboBox_mach;
	private String[] cuahang = new String[] { "CH001", "CH002", "CH003" };
	private JComboBox<String> jComboBox_chucvu;
	private String[] chucVu = new String[] { "Nhân viên hành chính", "Nhân viên kỹ thuật" };

	private JLabel lblTimKiem;
	private JTextField txtTimkiem;
	private NhanVien_DAO nv;
	private SqlDateModel modelNgaylap;
	private Properties p;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private Frm_NhapThongTinNhanVien mo;
	private Regex reg;
	private Set<String> generatedCodes = new HashSet<>();

	public String manv_nv = "";

	public FrmNhanVien() {
		setSize(1000, 600);
		mo = new Frm_NhapThongTinNhanVien();

		// hi
		JPanel pnControl = new JPanel();
		pnControl.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JLabel lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		pnNorth.add(lblTitle);
		pnControl.add(pnNorth, BorderLayout.NORTH);
		JPanel pnContent = new JPanel();
		pnContent.setLayout(null);

		int x = 100, y = 50, width = 100, height = 30;
		pnContent.add(lblmaNV = new JLabel("Mã Nhân Viên:"));
		lblmaNV.setBounds(x, y, width, height);
		// y+=30;
		pnContent.add(lbltenNV = new JLabel("Tên Nhân Viên :"));
		lbltenNV.setBounds(520, y, width, height);
		// y+=30;

		y += 30;
		pnContent.add(lblGioiTinh = new JLabel("Giới Tính:"));
		lblGioiTinh.setBounds(x, y, width, height);
//	y+=30;

		pnContent.add(lbldiaChi = new JLabel("Địa Chỉ:"));
		lbldiaChi.setBounds(520, y, width, height);

		y += 30;
		pnContent.add(lblsdt = new JLabel("SDT:"));
		lblsdt.setBounds(x, y, width, height);

		pnContent.add(lblemail = new JLabel("Email:"));
		lblemail.setBounds(520, y, width, height);

		y += 30;
		pnContent.add(lblngayvaolam = new JLabel("Ngày Vào Làm:"));
		lblngayvaolam.setBounds(x, y, width, height);

		pnContent.add(lblchucVu = new JLabel("Chức Vụ:"));
		lblchucVu.setBounds(520, y, width, height);

		y += 30;
		pnContent.add(lblluongcoBan = new JLabel("Lương:"));
		lblluongcoBan.setBounds(x, y, width, height);

		pnContent.add(lblmaCH = new JLabel("Mã Cửa Hàng:"));
		lblmaCH.setBounds(520, y, width, height);

		y += 30;
		pnContent.add(lblTimKiem = new JLabel("Tìm Mã NV:"));
		lblTimKiem.setBounds(x, y, width, height);

		x += 100;
		y = 56;
		width = 300;
		height = 20;
		pnContent.add(txtmaNV = new JTextField(20));
		loadMa();
		txtmaNV.setBounds(x, y, width, height);
		txtmaNV.setEditable(false);

		pnContent.add(txttenNV = new JTextField(20));
		// y += 30;
		txttenNV.setBounds(620, y, width, height);

		y += 30;
		jComboBox_gioitinh = new JComboBox<String>(GioiTinh);
		pnContent.add(jComboBox_gioitinh);
		jComboBox_gioitinh.setBounds(x, y, width, height);
		// y+=30;
		pnContent.add(txtdiaChi = new JTextField(20));
		txtdiaChi.setBounds(620, y, width, height);
		y += 30;
		pnContent.add(txtsdt = new JTextField(20));
		txtsdt.setBounds(x, y, width, height);

		pnContent.add(txtemail = new JTextField(20));
		txtemail.setBounds(620, y, width, height);
		y += 30;
//		pnContent.add(txtNgayvaolam = new JTextField(20));
//		txtNgayvaolam.setBounds(x, y, width, height);	
//		
		modelNgaylap = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelNgaylap, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(x, y, width, height);
		datePicker.setBackground(new Color(248, 248, 248));
		datePicker.setToolTipText("Chọn ngày sinh");
		modelNgaylap.setDate(2023, 4, 5);
		modelNgaylap.setSelected(true);
		pnContent.add(datePicker);

		jComboBox_chucvu = new JComboBox<String>(chucVu);
		pnContent.add(jComboBox_chucvu);
		jComboBox_chucvu.setBounds(620, y, width, height);

		y += 30;
		pnContent.add(txtLuong = new JTextField(20));
		txtLuong.setBounds(x, y, width, height);

		jComboBox_mach = new JComboBox<String>(cuahang);
		pnContent.add(jComboBox_mach);
		jComboBox_mach.setBounds(620, y, width, height);

		pnContent.add(txtTimkiem = new JTextField(20));
		y += 30;
		txtTimkiem.setBounds(x, y, width, height);

		pnContent.add(btnThem = new JButton("Thêm"));
		btnThem.setIcon(new ImageIcon("image\\add-icon.png"));
		// btnThem.setForeground(Color.BLACK);
		// btnThem.setBackground(Color.green);
		width = 110;
		height = 30;
		x = 150;
		y += 30;
		btnThem.setBounds(x, y, width, height);

		pnContent.add(btnXoa = new JButton("Xóa"));
		btnXoa.setIcon(new ImageIcon("image\\delete-icon.png"));
		// btnXoa.setForeground(Color.BLACK);
		// btnXoa.setBackground(Color.red);
		x += 120;
		btnXoa.setBounds(x, y, width, height);

		pnContent.add(btnTimKiem = new JButton("Tìm"));
		btnTimKiem.setIcon(new ImageIcon("image\\tim.png"));
		x += 120;
		btnTimKiem.setBounds(x, y, width, height);
		pnContent.add(btnXoaTrang = new JButton("Xóa Trắng"));
		btnXoaTrang.setBackground(Color.yellow);
		x += 120;
		btnXoaTrang.setBounds(x, y, 200, height);

// phần bảng
		model = new DefaultTableModel(col, 0);
		tblNhanVien = new JTable(model);
		tblNhanVien.setBackground(Color.pink);
		JScrollPane sp = new JScrollPane(tblNhanVien);
		width = 950;
		height = 200;
		y += 50;
		sp.setBounds(30, y, width, height);
		pnContent.add(sp);
		pnContent.setPreferredSize(new Dimension(1000, 500));
		pnControl.add(pnContent, BorderLayout.SOUTH);
		this.add(pnControl);

		loadData();
		// phần sự kiện
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTimKiem.addActionListener(this);
		tblNhanVien.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblNhanVien.getSelectedRow();
				txtmaNV.setText(model.getValueAt(row, 0).toString());
				txttenNV.setText(model.getValueAt(row, 1).toString());
				// lấy dữ liệu từ bảng của jcombobox về input
				jComboBox_gioitinh.setSelectedItem(model.getValueAt(row, 2));
				txtdiaChi.setText(model.getValueAt(row, 3).toString());
				txtsdt.setText(model.getValueAt(row, 4).toString());
				txtemail.setText(model.getValueAt(row, 5).toString());
				modelNgaylap.setValue((java.sql.Date) model.getValueAt(row, 6));
				jComboBox_chucvu.setSelectedItem(model.getValueAt(row, 7));
				txtLuong.setText(model.getValueAt(row, 8).toString());
				jComboBox_mach.setSelectedItem(model.getValueAt(row, 9));

			}
		});

	}

	// lỗi chưa load dữ liệu ************************************************#
	public void loadData() {
		nv = new NhanVien_DAO();
		for (NhanVien x : nv.getAllNhanVien()) {
			Object[] row = { x.getMaNV(), x.getTenNV(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.geteMail(),
					x.getNgayVaoLam(), x.getChucVu(), x.getLuongCoBan(), x.getMaCH() };
			model.addRow(row);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaTrang)) {
			xoatrang();
		} else if (o.equals(btnTimKiem)) {
			tim();
		} else if (o.equals(btnThem)) {
			if (validData()) {
				them();
			}
		}

		else if (o.equals(btnXoa)) {
			try {
				xoa();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void clearTable() {
		while (tblNhanVien.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	private void xoa() throws SQLException {
		// TODO Auto-generated method stub
		int row = tblNhanVien.getSelectedRow();
		if (row != -1) {
			int tb = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?", "Delete", JOptionPane.YES_NO_OPTION);
			if (tb == JOptionPane.YES_OPTION) {
				String manv = txtmaNV.getText();
				model.removeRow(row);
				nv.DeleteNV(manv);
				JOptionPane.showMessageDialog(this, "Xoá thành công");
			}
		} else {
			JOptionPane.showMessageDialog(null, "chưa chọn dòng xóa!");
		}

	}

	// hàm tìm
	public void clearTableFrmSanPham() {
		while (tblNhanVien.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	// tìm
	private void tim() {
		if (btnTimKiem.getText().equals("Tìm")) {
			ArrayList<NhanVien> nv1 = nv.Timkiem(txtTimkiem.getText());
			if (nv1 != null) {
				btnTimKiem.setText("Hủy Tìm");
				clearTableFrmSanPham();
				for (NhanVien mh : nv1) {
					if (nv1 != null) {
						model.addRow(new String[] { mh.getMaNV(), mh.getTenNV(), mh.getGioiTinh(), mh.getDiaChi(),
								mh.getSdt() + "", mh.geteMail() + "", mh.getNgayVaoLam() + "", mh.getChucVu(),
								mh.getLuongCoBan() + "", mh.getMaCH() });
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy");

			}

		} else {
			clearTableFrmSanPham();
			loadData();
			btnTimKiem.setText("Tìm");
		}
	}
	
	private void loadMa() {
		String code;
		do {
			code = generateRandomCode();
		} while (generatedCodes.contains(code));
		generatedCodes.add(code);
		txtmaNV.setText(code);
	}
	
	private String generateRandomCode() {
		String prefix = "NV";
		int maxNumber = 999999;
		int randomNum = new Random().nextInt(maxNumber);
		String suffix = String.format("%06d", randomNum);
		return prefix + suffix;
	}

	public String getTextFieldValue() {
		return txtmaNV.getText();
	}

	private void them(){
		loadMa();
		String ma = txtmaNV.getText();
		String ten = txttenNV.getText();
		String gioitinh = (String) jComboBox_gioitinh.getSelectedItem();
		String dc = txtdiaChi.getText();
		String sdt = txtsdt.getText();
		String email = txtemail.getText();
		Date ngaylap = (Date) datePicker.getModel().getValue();
		String chucvu = (String) jComboBox_chucvu.getSelectedItem();
		String luong = txtLuong.getText();
		double salary = Double.valueOf(luong);
		String mach = (String) jComboBox_mach.getSelectedItem();

		if (ma.length() > 0 || ten.length() > 0 || salary > 0) {
			NhanVien nhanvien = new NhanVien(ma, ten, gioitinh, dc, sdt, email, (java.sql.Date) ngaylap, chucvu,
					Float.parseFloat(luong), mach);
			String[] row = { ma, ten, gioitinh, dc, sdt, email, String.valueOf(ngaylap), chucvu, luong, mach };
			// mo.maNV= nhanvien.getMaNV();
			try {
				model.addRow(row);
				nv.addNhanVien(nhanvien);
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				mo.settxtmanv(ma);
				mo.setchucvu(chucvu);
				mo.setVisible(true);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Trùng mã lớp");
				txtmaNV.setText("");
				txtmaNV.requestFocus();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu");
		}
	}

	private void xoatrang() {
		txtmaNV.setText("");
		txtmaNV.requestFocus();
		txttenNV.setText("");
		txtsdt.setText("");
		txtdiaChi.setText("");
		txtemail.setText("");
		txtLuong.setText("");
	}

	// hàm kiểm tra nhập
	private boolean validData() {
		reg = new Regex();
		if (txtmaNV.getText().equals("") || txttenNV.getText().equals("") || txtLuong.getText().equals("")
				|| txtsdt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Các textField không được rỗng");
			return false;
		}
		if (reg.kiemTraTenNV(txttenNV.getText()) == false) {
			JOptionPane.showMessageDialog(null, "VD: Lê Thị Tơ");
			return false;
		}
		if (reg.kiemTraSDT(txtsdt.getText()) == false) {
			JOptionPane.showMessageDialog(null, "VD: 0947672098  *SDT 10 số*");
			return false;
		}
//		if(reg.kiemTraSoDouble(txtLuong) == false) {
//			return false;
//		}
		return true;
	}
}
