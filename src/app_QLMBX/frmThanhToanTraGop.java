package app_QLMBX;

import java.awt.Color;
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

import dao.TraGop_DAO;
import entity.HopDong;
import entity.TraGop;

public class frmThanhToanTraGop extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] cols = { "STT", "Mã hợp đồng", "Ngày trả", "Lãi suất", "Người trả", "Số tiền trả" };
	private DefaultTableModel model;
	private JTable table;
	private TraGop_DAO tragopdao = new TraGop_DAO();
	private JTextField txtNgay;
	private JTextField txtma;
	private JTextField txtNguoiTra;
	private JTextField txtLaiSuat;
	private JTextField txtTinhTrang;
	private JTextField txtThanhToan;
	private JButton btnThanhToan;
	private double tien;

	public frmThanhToanTraGop(String maHD) {
		// TODO Auto-generated constructor stub
		setTitle("Thanh toán trả góp");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		JPanel panelNorth = new JPanel();
		panelNorth.setBounds(92, 0, 500, 40);
		JLabel lblTitle;
		panelNorth.add(lblTitle = new JLabel("Thông tin trả góp"));
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

		JLabel lblMa = new JLabel("Mã hợp đồng: ");
		panelChucNang.add(lblMa);
		lblMa.setBounds(20, 25, 100, 20);
		txtma = new JTextField();
		panelChucNang.add(txtma);
		txtma.setBounds(110, 25, 150, 20);
		txtma.setText(maHD);
		txtma.setEditable(false);

		JLabel lblNguoiTra = new JLabel("Người trả:");
		panelChucNang.add(lblNguoiTra);
		lblNguoiTra.setBounds(300, 25, 100, 20);

		txtNguoiTra = new JTextField();
		panelChucNang.add(txtNguoiTra);
		txtNguoiTra.setBounds(370, 25, 270, 20);

		JLabel lblLaiSuat = new JLabel("Lãi suất: ");
		panelChucNang.add(lblLaiSuat);
		lblLaiSuat.setBounds(20, 65, 100, 20);

		txtLaiSuat = new JTextField();
		panelChucNang.add(txtLaiSuat);
		txtLaiSuat.setBounds(80, 65, 100, 20);
		txtLaiSuat.setEditable(false);

		JLabel lblTinhTrang = new JLabel("Tình trạng: ");
		panelChucNang.add(lblTinhTrang);
		lblTinhTrang.setBounds(230, 65, 100, 20);

		txtTinhTrang = new JTextField();
		panelChucNang.add(txtTinhTrang);
		txtTinhTrang.setBounds(310, 65, 150, 20);
		txtTinhTrang.setEditable(false);

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

		JLabel lblThanhToan = new JLabel("Số tiền cần thanh toán: ");
		lblThanhToan.setFont(new Font("Arial", Font.BOLD, 20));
		panelThanhToan.add(lblThanhToan);
		lblThanhToan.setBounds(70, 30, 400, 30);
		lblThanhToan.setForeground(Color.red);

		txtThanhToan = new JTextField();
		txtThanhToan.setFont(new Font("Arial", Font.BOLD, 20));
		panelThanhToan.add(txtThanhToan);
		txtThanhToan.setBounds(320, 30, 230, 30);
		txtThanhToan.setEditable(false);
		txtThanhToan.setForeground(Color.red);
		txtThanhToan.setHorizontalAlignment(JTextField.RIGHT);
		loadData(maHD);


		btnThanhToan = new JButton("Thanh toán");
		panelThanhToan.add(btnThanhToan);
		btnThanhToan.setBounds(240, 100, 150, 30);
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 20));
		btnThanhToan.setForeground(Color.blue);
		if (txtTinhTrang.getText().equals("Đã trả đủ")) {
			btnThanhToan.setEnabled(false);
		}
		
		btnThanhToan.addActionListener(this);
	}

	private void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	
	private void loadData(String id) {
		int i = 0;
		for (TraGop x : tragopdao.getTraGopTheoMa(id)) {
			i++;
			tien = x.getSoTienTra();
			DecimalFormat df = new DecimalFormat("#,###.##");
			String donGia = df.format(x.getSoTienTra());
			Object[] row = { i, x.getHd().getMaHD(), x.getNgayTra(), x.getLaiSuat(), x.getNguoiTra(), donGia };
			model.addRow(row);
		}
		
		
		if (model.getRowCount() == 1)
			txtTinhTrang.setText("Còn 2 lần trả");
		else if (model.getRowCount() == 2)
			txtTinhTrang.setText("Còn 1 lần trả");
		else
			txtTinhTrang.setText("Đã trả đủ");
		if(!txtTinhTrang.getText().equals("Đã trả đủ"))
			txtThanhToan.setText(model.getValueAt(0, 5).toString() + " " + "VNĐ");
		else
			txtThanhToan.setText("0 VNĐ");
		
		txtLaiSuat.setText(model.getValueAt(0, 3).toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThanhToan)) {
			HopDong hd = new HopDong(txtma.getText());
			Double lai = Double.parseDouble(txtLaiSuat.getText());
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			TraGop tg = new TraGop(hd, date, lai, txtNguoiTra.getText(), tien);
			if(tragopdao.createHDTraGop(tg)) {				
				JOptionPane.showMessageDialog(this, "Thanh toán thành công");
				clearTable();
				loadData(hd.getMaHD());
			} else {
				JOptionPane.showMessageDialog(this, "Cùng một hợp đồng không thể trả góp 2 lần trong một ngày");
			}
			
		}

	}

	public static void main(String[] args) {
		new frmThanhToanTraGop(null).setVisible(true);
	}

}
