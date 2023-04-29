package app_QLMBX;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.MatHang_DAO;
import dao.NhapHang_DAO;
import entity.PhieuNhap;
import entity.Regex;

import javax.swing.border.TitledBorder;

public class FrmNhapHang extends JPanel implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtMaSp;
	private JTextField txtTenSp;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JComboBox<String> cboNCC;
	private JTextField txtMaPhieu;
	private JTable table;
	private JTextField txtTim;
	private JButton btnXoa, btnXacNhan, btnNhap, btnTim;
	private Frame frame;
	private DefaultTableModel model;
	private NhapHang_DAO nh;
	private MatHang_DAO mhDao;
	private Frm_MatHang mh;
	private Regex reg;
	public FrmNhapHang() {
		frame = new JFrame();
		setBounds(100, 100, 990, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		((JFrame) frame).setContentPane(contentPane);
		add(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		nh = new NhapHang_DAO();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("NHẬP HÀNG");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel pnTable = new JPanel();
		String[] cols = {"Mã phiếu nhập", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Nhà cung cấp"};
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setBackground(Color.pink);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(210);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(450);
		loadData();
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(575, 350));
		pnTable.add(sp, BorderLayout.CENTER);
		
		JLabel lblNewLabel_6 = new JLabel("Kho Hàng");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_7 = new JLabel("Tìm kiếm:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtTim = new JTextField();
		txtTim.setColumns(10);
		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon("image\\Search-icon.png"));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(3))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 384, Short.MAX_VALUE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(144)
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnTim))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(pnTable, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
								.addContainerGap()))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(175)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_6)
							.addGap(29)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_7)
									.addComponent(btnTim))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(pnTable, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin phiếu nhập");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("Nhà cung cấp");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		cboNCC = new JComboBox<String>();
		cboNCC.addItem("Công ty cung ứng xe Bảo Long");
		cboNCC.addItem("Công ty phụ tùng xe Phước Đại");
//		cboNCC.set(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mã phiếu nhập");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtMaPhieu = new JTextField();
		txtMaPhieu.setColumns(10);
		

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("D:\\BaiTapLonJava_Nhom4\\image\\delete-icon.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setIcon(new ImageIcon("D:\\BaiTapLonJava_Nhom4\\image\\check-icon.png"));
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
							.addGap(31)
							.addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(51))
						.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMaPhieu, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cboNCC, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel_1_1)
							.addGap(95))))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMaPhieu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboNCC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Mã sản phẩm:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin sản phẩm");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtMaSp = new JTextField();
		txtMaSp.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tên sản phẩm:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtTenSp = new JTextField();
		txtTenSp.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Số lượng nhập:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		
		JLabel lblNewLabel_4_1 = new JLabel("Đơn giá nhập:");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		
		btnNhap = new JButton("Chọn nhập");
		btnNhap.setIcon(new ImageIcon("D:\\BaiTapLonJava_Nhom4\\image\\check-icon.png"));
		btnNhap.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(99))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTenSp, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(16)
									.addComponent(txtMaSp, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
											.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtDonGia, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
										.addComponent(txtSoLuong, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
										.addComponent(btnNhap))))
							.addContainerGap())))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(txtMaSp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(txtTenSp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(lblNewLabel_5)
								.addGap(14))
							.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(26)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDonGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(btnNhap, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		btnNhap.addActionListener(this);
		btnTim.addActionListener(this);
		btnXacNhan.addActionListener(this);
		btnXoa.addActionListener(this);
		table.addMouseListener(this);
	}
	
	public void loadData() {
		DecimalFormat df = new DecimalFormat("#.##");
		for(PhieuNhap x : nh.getAllNhapHang()) {
			Object[] row = {x.getSoPhieu(), x.getMh().getMaMH(), x.getMh().getTenMH(), x.getMh().getSlTon(), df.format(x.getMh().getDonGia()), x.getTenNCC()};
			model.addRow(row);
		}
	}
	
	private void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	
	private void tim() {
		if(btnTim.getText().equals("Tìm")) {
			ArrayList<PhieuNhap> dspn = nh.getPhieuTheoTen(txtTim.getText());
			if(dspn != null) {
				btnTim.setText("Hủy tìm");
				clearTable();
				for(PhieuNhap p : dspn) {				
					if(dspn != null) {
						model.addRow(new String[] {p.getSoPhieu(), p.getMh().getMaMH(), p.getMh().getTenMH(), p.getMh().getSlTon() + "", p.getMh().getDonGia() + "", p.getTenNCC()});
					} 
				}
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
			}
		}else {
			clearTable();
			loadData();
			btnTim.setText("Tìm");
		}
	}
	

	private boolean validData() {
		reg = new Regex();
		if(txtMaPhieu.getText().equals("") || txtMaSp.getText().equals("") || txtTenSp.getText().equals("") || txtSoLuong.getText().equals("") || txtDonGia.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Các textField không được rỗng");
			return false;
		}
		if(!(txtMaSp.getText().matches("(LK||X)\\d{1,}"))) {
			JOptionPane.showMessageDialog(null, "Mã sản phẩm phải theo định dạng LKXXX hay AXXX");
			return false;
		}
		if(reg.kiemTraMaNhapHang(txtMaPhieu.getText()) == false) {
			JOptionPane.showMessageDialog(null, "Mã phiếu phải theo định dạng HDH_NXXX");
			return false;
		}
		return true;
	}
	
	private void unEnabled() {
		if(btnNhap.getText().equals("Chọn nhập")) {
			txtMaSp.setEditable(false);
			txtTenSp.setEditable(false);
			txtSoLuong.setEditable(false);
			txtDonGia.setEditable(false);
			btnNhap.setText("Hủy nhập");
		} else {
			txtMaSp.setEditable(true);
			txtTenSp.setEditable(true);
			txtSoLuong.setEditable(true);
			txtDonGia.setEditable(true);
			btnNhap.setText("Chọn nhập");
		}
	}
	
	private void themVaoBang() {
		String maPhieu = txtMaPhieu.getText();
		String maSP = txtMaSp.getText();
		String tenSP = txtTenSp.getText();
		String sl = txtSoLuong.getText();
		String donGia = txtDonGia.getText();
		String ncc = (String)cboNCC.getSelectedItem();
		String[] row = {maPhieu, maSP, tenSP, sl, donGia, ncc};
		model.addRow(row);
	}
	
	private void luu() throws SQLException {
		mh = new Frm_MatHang();
		mh.maHDH = txtMaPhieu.getText();
		mh.maSP = txtMaSp.getText();
		mh.tenSP = txtTenSp.getText();
		if(txtSoLuong.getText().matches("^[0-9]+$") && txtDonGia.getText().matches("^[0-9]+(\\.[0-9]{1,2})?$")) {
			mh.soLuong = Integer.parseInt(txtSoLuong.getText());
			mh.donGia = Double.valueOf(txtDonGia.getText());
			mh.tenNhaCC = (String)cboNCC.getSelectedItem();
			mh.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Số lượng và đơn giá phải là số và không nhỏ hơn 0");
		}
	}
	

	private void xoa() throws SQLException {
		mhDao = new MatHang_DAO();
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row!=-1) {
			int tb= JOptionPane.showConfirmDialog(null, "Bạn có chắc chắc muốn xóa?", "Delete",JOptionPane.YES_NO_OPTION);
			if(tb==JOptionPane.YES_OPTION) {
				model.removeRow(row);
				String maHDH = txtMaPhieu.getText();
				nh.Delete(maHDH);
				String maSP = txtMaSp.getText();
				mhDao.Delete(maSP);
				JOptionPane.showMessageDialog(this, "Xoá thành công");
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"chưa chọn dòng xóa!");
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnTim)) {
			tim();
		} else if(obj.equals(btnNhap)) {
			unEnabled();
		} else if(obj.equals(btnXacNhan)) {
			if(validData()) {
				try {
					luu();
					themVaoBang();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if(obj.equals(btnXoa)) {
			try {
				xoa();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		if(row != -1) {
			txtMaPhieu.setText(model.getValueAt(row, 0).toString());
			txtMaSp.setText(model.getValueAt(row, 1).toString());
			txtTenSp.setText(model.getValueAt(row, 2).toString());
			txtSoLuong.setText(model.getValueAt(row, 3).toString());
			txtDonGia.setText(model.getValueAt(row, 4).toString());
			if(model.getValueAt(row, 5).toString().equalsIgnoreCase("Công ty cung ứng xe Bảo Long")) {
				cboNCC.setSelectedIndex(0);
			}
			if(model.getValueAt(row, 5).toString().equalsIgnoreCase("Công ty phụ tùng xe Phước Đại")) {
				cboNCC.setSelectedIndex(1);
			}
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
