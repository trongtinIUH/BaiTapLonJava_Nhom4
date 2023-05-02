package app_QLMBX;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.ChiTietHoaDonHang_DAO;
import dao.HoaDonHang_DAO;
import dao.TraGop_DAO;
import entity.ChiTietHoaDonHang;
import entity.CuaHang;
import entity.HoaDonHang;
import entity.HopDong;
import entity.PhieuXuat;
import entity.TraGop;

public class FrmXuatHang extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] cols = { "STT", "Mã chi tiết hóa đơn hàng", "Tên mặt hàng", "Số lượng" };
	private DefaultTableModel model;
	private JTable table;
	private HoaDonHang_DAO hdh_dao = new HoaDonHang_DAO();
	private ChiTietHoaDonHang_DAO ctHDH_dao = new ChiTietHoaDonHang_DAO();
	private JTextField txtNgay;
	private JTextField txtma;
	private JTextField txtNguoiTra;
	private JTextField txtLaiSuat;
	private JTextField txtTinhTrang;
	private JTextField txtThanhToan;
	private double tien;
	private JTextField txtmaHDH;
	private JTextField txtTenCH;
	private JTextField txtTenNV;
	private JButton btnXacNhan;

	public FrmXuatHang(String maHDH) {
		// TODO Auto-generated constructor stub
		setTitle("Thông tin phiếu xuất hàng");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		JPanel panelNorth = new JPanel();
		panelNorth.setBounds(92, 0, 500, 40);
		JLabel lblTitle;
		panelNorth.add(lblTitle = new JLabel("Thông tin chi tiết phiếu xuất hàng"));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setForeground(new Color(0, 40, 255));
		add(panelNorth);

		JPanel panelCenter = new JPanel();
		panelCenter.setBounds(5, 50, 680, 90);
		add(panelCenter);
		// Bảng
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setBackground(Color.pink);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(table);
		panelCenter.add(pane);
		pane.setPreferredSize(new Dimension(660, 80));

		JPanel panelChucNang = new JPanel();
		panelChucNang.setLayout(null);
		panelChucNang.setBounds(10, 150, 665, 130);
		panelChucNang.setBorder(BorderFactory.createTitledBorder("Thông tin"));
		TitledBorder titledchucnang = (TitledBorder) panelChucNang.getBorder();
		titledchucnang.setTitleColor(Color.blue);
		add(panelChucNang);

		JLabel lblMaHDH = new JLabel("Mã hóa đơn hàng:");
		panelChucNang.add(lblMaHDH);
		lblMaHDH.setBounds(20, 25, 120, 20);
		txtmaHDH = new JTextField();
		panelChucNang.add(txtmaHDH);
		txtmaHDH.setBounds(140, 25, 270, 20);
		txtmaHDH.setText(maHDH);
		txtmaHDH.setEditable(false);

		JLabel lblTenCH = new JLabel("Tên cửa hàng:");
		panelChucNang.add(lblTenCH);
		lblTenCH.setBounds(20, 60, 100, 20);

		txtTenCH = new JTextField();
		panelChucNang.add(txtTenCH);
		txtTenCH.setBounds(140, 60, 270, 20);
		txtTenCH.setEditable(false);



		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		txtNgay = new JTextField();
		txtNgay.setText(dateFormat.format(date));
		panelChucNang.add(txtNgay);
		txtNgay.setBounds(580, 95, 100, 20);
		txtNgay.setEditable(false);
		txtNgay.setBorder(null);

		JPanel panelThanhToan = new JPanel();
		panelThanhToan.setLayout(null);
		add(panelThanhToan);
		panelThanhToan.setBounds(20, 290, 650, 200);


		btnXacNhan = new JButton("Xác nhận");
		panelThanhToan.add(btnXacNhan);
		btnXacNhan.setBounds(240, 100, 150, 30);
		btnXacNhan.setFont(new Font("Arial", Font.BOLD, 20));
		btnXacNhan.setForeground(Color.blue);
		
		loadData(maHDH);
		
		btnXacNhan.addActionListener(this);
		
	}

	private void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	private void loadData(String id) {
		int i = 0;
		for (ChiTietHoaDonHang x : ctHDH_dao.getChiTietHoaDonHangTheoMa(id)) {
			i++;
			Object[] row = { i, x.getHdh().getMaHDH(), x.getMh().getMaMH(), x.getSoLuong()};
			model.addRow(row);
		}
		CuaHang x = hdh_dao.getCuaHangTheoMaHoaDonHang(id);
		txtTenCH.setText(x.getTenCuaHang());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnXacNhan)) {
			FrmXuatHang xuatHang = new FrmXuatHang(null);
			xuatHang.setVisible(false);
		}

	}

	public static void main(String[] args) {
		new FrmXuatHang(null).setVisible(true);
	}

}
