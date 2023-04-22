package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.AbstractDateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import entity.DateLabelFormatter;

public class FrmKhuyenMai extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private String[] cols = {"STT", "Mã hợp đồng", "Ngày lập", "Thời gian", "Tên nhân viên", "Tên cửa hàng", "Tên khách hàng"};
	private JTextField txtMa;
	private Font font;
	private JTextField txtPhai;
	private JTextField txtDiaChi;
	private JTextField txtSdt;
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

	
	public FrmKhuyenMai() {
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

		// Thông tin khách hàng
		JPanel panelSouth = new JPanel();
		panelSouth.setBounds(7, 340, 580, 200);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Thông tin bảo hành"));
		TitledBorder titledthongtin = (TitledBorder) panelSouth.getBorder();
		titledthongtin.setTitleColor(Color.blue);
		panelSouth.setLayout(null);

		JLabel lblMa = new JLabel("Mã bảo hành:");
		panelSouth.add(lblMa);
		lblMa.setBounds(20, 50, 150, 20);
		add(panelSouth);
		font = new Font("Arial", Font.PLAIN, 16);
		lblMa.setFont(font);
		panelSouth.add(txtMa = new JTextField());
		txtMa.setBounds(140, 50, 110, 23);
		txtMa.setFont(font);
		txtMa.setEditable(false);
		Set<String> generatedCodes = new HashSet<>();
		String code;
		do {
		    code = generateRandomCode(8);
		} while (generatedCodes.contains(code));
		generatedCodes.add(code);

		// Đặt giá trị cho JTextField
		txtMa.setText(code);

		JLabel lblTen = new JLabel("Ngày lập:");
		panelSouth.add(lblTen);
		lblTen.setBounds(270, 50, 100, 20);
		lblTen.setFont(font);
		modelNgaylap = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelNgaylap, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(370, 45, 190, 30);
		datePicker.setBackground(new Color(248,248,248));
		datePicker.setToolTipText("Chọn ngày lập");
		modelNgaylap.setDate(1990, 0, 1);
		modelNgaylap.setSelected(true);
		panelSouth.add(datePicker);

		JLabel lblPhai = new JLabel("Thời gian (Tháng):");
		panelSouth.add(lblPhai);
		lblPhai.setBounds(20, 100, 130, 20);
		lblPhai.setFont(font);
		panelSouth.add(txtPhai = new JTextField());
		txtPhai.setBounds(160, 100, 150, 23);
		txtPhai.setFont(font);

		JLabel lblSdt = new JLabel("Mã nhân viên:");
		panelSouth.add(lblSdt);
		lblSdt.setBounds(320, 100, 100, 20);
		lblSdt.setFont(font);
		panelSouth.add(txtSdt = new JTextField());
		txtSdt.setFont(font);
		txtSdt.setBounds(430, 100, 130, 23);

		JLabel lblDiaChi = new JLabel("Mã cửa hàng:");
		panelSouth.add(lblDiaChi);
		lblDiaChi.setBounds(20, 150, 150, 20);
		lblDiaChi.setFont(font);
		panelSouth.add(txtDiaChi = new JTextField());
		txtDiaChi.setFont(font);
		txtDiaChi.setBounds(130, 150, 150, 23);
		
		JLabel lblmaKH = new JLabel("Mã khách hàng:");
		panelSouth.add(lblmaKH);
		lblmaKH.setBounds(300, 150, 130, 20);
		lblmaKH.setFont(font);
		panelSouth.add(txtmaKH = new JTextField());
		txtmaKH.setFont(font);
		txtmaKH.setBounds(420, 150, 140, 23);
		
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
		btnTim.setFont(font);
		btnTim.setBounds(137, 110, 100, 25);

		panelChucNang.add(btnThem = new JButton("Thêm"));
		btnThem.setFont(font);
		btnThem.setBounds(20, 160, 80, 25);

		panelChucNang.add(btnXoa = new JButton("Xóa"));
		btnXoa.setFont(font);
		btnXoa.setForeground(Color.red);
		btnXoa.setBounds(105, 160, 70, 25);

		panelChucNang.add(btnXoaTrang = new JButton("Xóa trắng"));
		btnXoaTrang.setFont(font);
		btnXoaTrang.setBounds(180, 160, 105, 25);

		panelChucNang.add(btnSua = new JButton("Sửa"));
		btnSua.setFont(font);
		btnSua.setBounds(290, 160, 70, 25);
	}
	
	private String generateRandomCode(int length) {
	    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    StringBuilder sb = new StringBuilder(length);
	    Random rnd = new Random();
	    for (int i = 0; i < length; i++) {
	        sb.append(chars.charAt(rnd.nextInt(chars.length())));
	    }
	    return sb.toString();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {

		} else if (o.equals(btnXoaTrang)) {

		} else if (o.equals(btnXoa)) {

		} else if (o.equals(btnTim)) {

		} else if (o.equals(btnSua)) {

		}
	}
}
