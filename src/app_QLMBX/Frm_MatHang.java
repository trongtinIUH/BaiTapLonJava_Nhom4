package app_QLMBX;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import dao.CuaHang_DAO;
import dao.HoaDonHang_DAO;
import dao.MatHang_DAO;
import dao.NhapHang_DAO;
import entity.CuaHang;
import entity.DateLabelFormatter;
import entity.HoaDonHang;
import entity.MatHang;
import entity.PhieuNhap;

public class Frm_MatHang extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDVT, lblMota, lblLoaiMH, lblNgayGD, lblCuaHang;
	private JTextField txtDVT, txtMota;
	private JComboBox<String> cboLoaiMH, cboCuaHang;
	private JButton btnLuu;
	public String maHDH = "";
	public String maSP = "";
	public String tenSP = "";
	public String tenNhaCC = "";
	public int soLuong;
	public double donGia;
	private MatHang_DAO sp;
	private CuaHang_DAO ch_dao;
	private Frm_Xe xe;
	private Frm_LinhKien lk;
	private HoaDonHang_DAO hdh;
	private SqlDateModel modelNgaylap;
	private Properties p;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private NhapHang_DAO nh;
	public Frm_MatHang() {
		setSize(500, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JPanel pnContent = new JPanel();
		pnContent.setLayout(null);
		JLabel lblTitle = new JLabel("Thông tin mặt hàng");
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		pnContent.add(lblTitle);
		lblTitle.setBounds(80, 0, 500, 50);
		int x = 20, y = 30, width = 100, height = 30;
		pnContent.add(lblLoaiMH = new JLabel("Loại mặt hàng"));
		y+=50;
		lblLoaiMH.setBounds(x, y, width, height);
		pnContent.add(lblDVT = new JLabel("Đơn vị tính:"));
		y+=50;
		lblDVT.setBounds(x, y, width, height);
		pnContent.add(lblNgayGD = new JLabel("Ngày giao dịch:"));
		y+=50;
		lblNgayGD.setBounds(x, y, width, height);
		pnContent.add(lblCuaHang = new JLabel("Cửa hàng:"));
		y+=50;
		lblCuaHang.setBounds(x, y, width, height);
		pnContent.add(lblMota = new JLabel("Mô tả:"));
		y+=50;
		lblMota.setBounds(x, y, width, height);
		x = 120; y = 30; width = 300; height = 30;
		pnContent.add(cboLoaiMH = new JComboBox<String>());
		cboLoaiMH.addItem("Linh Kiện");
		cboLoaiMH.addItem("Xe");
		cboLoaiMH.setEnabled(false);
		y+=50;
		cboLoaiMH.setBounds(x, y, width, height);
		pnContent.add(txtDVT = new JTextField());
		y+=50;
		txtDVT.setText("VNĐ");
		txtDVT.setEditable(false);
		txtDVT.setBounds(x, y, width, height);
		modelNgaylap = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelNgaylap, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBackground(new Color(248,248,248));
		datePicker.setToolTipText("Chọn ngày sinh");
		modelNgaylap.setDate(2023, 03, 28);
		modelNgaylap.setSelected(true);
		pnContent.add(datePicker);
		y+=50;
		datePicker.setBounds(x, y, width, height);
		pnContent.add(cboCuaHang = new JComboBox<String>());
		cboCuaHang.addItem("CH001");
		cboCuaHang.addItem("CH002");
		cboCuaHang.addItem("CH003");
		y+=50;
		cboCuaHang.setBounds(x, y, width, height);
		pnContent.add(txtMota = new JTextField());
		y+=50;
		txtMota.setBounds(x, y, width, height);
		y+=50;
		pnContent.add(btnLuu = new JButton("Lưu"));
		btnLuu.setBounds(200, y, 100, 50);
		btnLuu.addActionListener(this);
		add(pnContent);
	}
	public static void main(String[] args) {
		new Frm_MatHang().setVisible(true);
	}
	
	private MatHang revertTextToMatHang() {
		String loaiMH = (String) cboLoaiMH.getSelectedItem();
		String dvt = txtDVT.getText();
		String mota = txtMota.getText();
		MatHang x = new MatHang(maSP, tenSP, dvt, mota, donGia, soLuong, loaiMH);
		return x;
	}
	
	private HoaDonHang revertTextToHoaDonHang() {
		MatHang mh = revertTextToMatHang();
		ch_dao = new CuaHang_DAO();
		String maCH = (String) cboCuaHang.getSelectedItem();
		CuaHang ch = ch_dao.getCHTheoMa(maCH);
		Date date = (Date) datePicker.getModel().getValue();
		return new HoaDonHang(maHDH, ch, mh, date);
	}
	
	public void setComboBox(String ten) {
		if(tenNhaCC.equals("Công ty cung ứng xe Bảo Long")) {
			cboLoaiMH.setSelectedItem("Xe");
		}
		if(tenNhaCC.equals("Công ty phụ tùng xe Phước Đại")) {
			cboLoaiMH.setSelectedItem("Linh Kiện");
		}
	}
	
	private void luu() throws HeadlessException, SQLException {
		nh = new NhapHang_DAO();
		hdh = new HoaDonHang_DAO();
		sp = new MatHang_DAO();
		HoaDonHang hd = revertTextToHoaDonHang();
		MatHang mh = revertTextToMatHang();
		PhieuNhap p = new PhieuNhap(maHDH, mh, tenNhaCC, maHDH);
		if(hdh.addHoaDonHang(hd)) {
			if(nh.addPhieuNhap(p)) {
				if(sp.addSanPham(mh)) {
					if(nh.addCTHD(maHDH, maSP, soLuong)) {
						if(mh.getLoaiMH().equals("Xe")) {
							JOptionPane.showMessageDialog(null, "Bạn đang thêm một xe mới vui lòng nhập thêm thông tin cho xe!");
							xe = new Frm_Xe();
							xe.setMaXe(maSP);
							xe.setVisible(true);
						}
						if(mh.getLoaiMH().equals("Linh Kiện")) {
							JOptionPane.showMessageDialog(null, "Bạn đang thêm một linh kiện mới vui lòng nhập thêm thông tin cho xe!");
							lk = new Frm_LinhKien();
							lk.setMaLK(maSP);
							lk.setVisible(true);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Trùng mã mặt hàng!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Trùng mã phiếu nhập!");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Trùng mã hóa đơn hàng!");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnLuu)) {
			try {
				luu();
				dispose();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
