package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
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

import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import entity.KhachHang;
import entity.NhanVien;

public class FrmKhachHang extends JPanel implements ActionListener {

	/**
	 * 
	 */

	private JTable table;
	private DefaultTableModel model;
	private String[] cols = { "STT", "Mã khách hàng", "Tên", "Giới tính", "Địa chỉ", "Số điện thoại" };
	private JTextField txtTen;
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
	private KhachHang_DAO kh;

	private static final long serialVersionUID = 1L;

	public FrmKhachHang() {
		setLayout(null);
		JPanel panelNorth = new JPanel();
		add(panelNorth);
		panelNorth.setBounds(0, 0, 970, 50);
		JLabel lblTitle;
		panelNorth.add(lblTitle = new JLabel("Quản lý thông tin khách hàng"));
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
		panelSouth.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		TitledBorder titledthongtin = (TitledBorder) panelSouth.getBorder();
		titledthongtin.setTitleColor(Color.blue);
		panelSouth.setLayout(null);

		JLabel lblMa = new JLabel("Mã khách hàng:");
		panelSouth.add(lblMa);
		lblMa.setBounds(20, 50, 150, 20);
		add(panelSouth);
		font = new Font("Arial", Font.PLAIN, 16);
		lblMa.setFont(font);
		panelSouth.add(txtMa = new JTextField());
		txtMa.setBounds(150, 50, 150, 23);
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

		JLabel lblTen = new JLabel("Tên:");
		panelSouth.add(lblTen);
		lblTen.setBounds(320, 50, 50, 20);
		lblTen.setFont(font);
		panelSouth.add(txtTen = new JTextField());
		txtTen.setBounds(370, 50, 190, 23);
		txtTen.setFont(font);

		JLabel lblPhai = new JLabel("Giới tính:");
		panelSouth.add(lblPhai);
		lblPhai.setBounds(20, 100, 150, 20);
		lblPhai.setFont(font);
		panelSouth.add(txtPhai = new JTextField());
		txtPhai.setBounds(110, 100, 190, 23);
		txtPhai.setFont(font);

		JLabel lblSdt = new JLabel("Số điện thoại:");
		panelSouth.add(lblSdt);
		lblSdt.setBounds(320, 100, 100, 20);
		lblSdt.setFont(font);
		panelSouth.add(txtSdt = new JTextField());
		txtSdt.setFont(font);
		txtSdt.setBounds(430, 100, 130, 23);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		panelSouth.add(lblDiaChi);
		lblDiaChi.setBounds(20, 150, 150, 20);
		lblDiaChi.setFont(font);
		panelSouth.add(txtDiaChi = new JTextField());
		txtDiaChi.setFont(font);
		txtDiaChi.setBounds(90, 150, 470, 23);

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
		cbTim.addItem("Tìm theo tên");
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
		loadData();
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
	
	public void loadData() {
		int i = 0;
		kh = new KhachHang_DAO();
		for(KhachHang x : kh.getAllKhachHang()) {
			i++;
			Object[] row = {i, x.getMaKH(), x.getTenKH(), x.getGioiTinh(), x.getDiaChi(), x.getSdt()};
			model.addRow(row);
		}
	}

	private String generateRandomCode() {
	    String prefix = "KH";
	    int maxNumber = 999999;
	    int randomNum = new Random().nextInt(maxNumber);
	    String suffix = String.format("%06d", randomNum);
	    return prefix + suffix;
	}

}
