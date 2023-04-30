package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

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

import dao.MatHang_DAO;
import entity.MatHang;

public class FrmSanPham extends JPanel implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMaSP, lblTenSP, lblLoaiSP, lblsoLuong, lblDonViTinh, lblDonGia, lblTim, lblMoTa;
	private JTextField  txtMaSP, txtTenSP, txtsoLuong, txtDonViTinh, txtDonGia, txtTim, txtMoTa;
	private JTable tblSanPham;
	private DefaultTableModel model;
	private String[] cols = {"Mã SP", "Loại SP", "Tên SP", "Số lượng", "Đơn Vị Tính", "Đơn Giá", "Mô tả"};
	private JButton btnThem, btnXoa, btnTim, btnSua, btnRefresh;
	private JComboBox<String> cboLoaiSP;
	private MatHang_DAO sp;
	private Frm_Xe xe;
	private Frm_LinhKien lk;
	public FrmSanPham() {
		setSize(990, 600);
		JPanel pnControl = new JPanel();
		pnControl.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JLabel lblTitle = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		pnNorth.add(lblTitle);
		pnControl.add(pnNorth, BorderLayout.NORTH);
		JPanel pnContent = new JPanel();
		pnContent.setLayout(null);
		int x = 100, y = 50, width = 100, height = 30;
		pnContent.add(lblMaSP = new JLabel("Mã SP:"));
		lblMaSP.setBounds(x, y, width, height);
		pnContent.add(lblLoaiSP = new JLabel("Loại SP:"));
		lblLoaiSP.setBounds(520, y, width, height);
		pnContent.add(lblTenSP = new JLabel("Tên SP:"));
		y+=30;
		lblTenSP.setBounds(x, y, width, height);
		pnContent.add(lblsoLuong = new JLabel("Số lượng:"));
		lblsoLuong.setBounds(520, y, width, height);
		pnContent.add(lblDonViTinh = new JLabel("Đơn vị tính:"));
		y+=30;
		lblDonViTinh.setBounds(x, y, width, height);
		pnContent.add(lblDonGia = new JLabel("Đơn Giá:"));
		lblDonGia.setBounds(520, y, width, height);
		pnContent.add(lblTim = new JLabel("Tìm theo tên SP:"));
		y+=30;
		lblTim.setBounds(x, y, width, height);
		pnContent.add(lblMoTa = new JLabel("Mô tả:"));
		lblMoTa.setBounds(520, y, width, height);
		
		
		x+=100;y = 56;width = 300;height = 20;
		pnContent.add(txtMaSP = new JTextField(20));
		txtMaSP.setBounds(x, y, width, height);
		txtMaSP.setEditable(false);
		pnContent.add(cboLoaiSP = new JComboBox<String>());
		cboLoaiSP.addItem("Linh Kiện");
		cboLoaiSP.addItem("Xe");
		cboLoaiSP.setBounds(620, y, width, height);
		txtMaSP.setText(generateRandomCode((String) cboLoaiSP.getSelectedItem()));
		pnContent.add(txtTenSP = new JTextField(20));
		y += 30;
		txtTenSP.setBounds(x, y, width, height);
		pnContent.add(txtsoLuong = new JTextField(20));
		txtsoLuong.setBounds(620, y, width, height);
		pnContent.add(txtDonViTinh = new JTextField(20));
		txtDonViTinh.setText("VNĐ");
		txtDonViTinh.setEditable(false);
		y += 30;
		txtDonViTinh.setBounds(x, y, width, height);
		pnContent.add(txtDonGia = new JTextField(20));
		txtDonGia.setBounds(620, y, width, height);
		pnContent.add(txtTim = new JTextField(20));
		y += 30;
		txtTim.setBounds(x, y, width, height);
		pnContent.add(txtMoTa = new JTextField(20));
		txtMoTa.setBounds(620, y, width, height);
		
		pnContent.add(btnThem = new JButton("Thêm"));
		btnThem.setIcon(new ImageIcon("image\\add-icon.png"));
		width = 100; height = 30; x = 150;
		y+=30; 
		btnThem.setBounds(130, y, 120, height);
		pnContent.add(btnXoa = new JButton("Xóa"));
		btnXoa.setIcon(new ImageIcon("image\\delete-icon.png"));
		x+=120; 
		btnXoa.setBounds(x, y, width, height);
		pnContent.add(btnTim = new JButton("Tìm"));
		btnTim.setIcon(new ImageIcon("image\\Search-icon.png"));
		x+=120;
		btnTim.setBounds(x, y, width, height);
		pnContent.add(btnSua = new JButton("Sửa(chỉ sửa số lượng và đơn giá)"));
		btnSua.setIcon(new ImageIcon("image\\Pencil-icon.png"));
		x+=120;
		btnSua.setBounds(x, y, 280, height);
		pnContent.add(btnRefresh = new JButton("Làm mới"));
		btnRefresh.setIcon(new ImageIcon("image\\Refresh-icon.png"));
		x+=300;
		btnRefresh.setBounds(x, y, 130, height);
		
		model = new DefaultTableModel(cols, 0);
		tblSanPham = new JTable(model);
		tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(290);
		tblSanPham.getColumnModel().getColumn(5).setPreferredWidth(100);
		tblSanPham.getColumnModel().getColumn(6).setPreferredWidth(400);
		tblSanPham.setBackground(Color.pink);
		loadDataFrmSanPham();
		JScrollPane sp = new JScrollPane(tblSanPham);
		width = 980; height = 250;
		y+=50;
		sp.setBounds(10, y, width, height);
		pnContent.add(sp);
		pnContent.setPreferredSize(new Dimension(990, 600));
		pnControl.add(pnContent, BorderLayout.CENTER);
		this.add(pnControl);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		btnSua.addActionListener(this);
		tblSanPham.addMouseListener(this);
		cboLoaiSP.addActionListener(this);
		btnRefresh.addActionListener(this);
	}
	
	public void loadDataFrmSanPham() {
		DecimalFormat df = new DecimalFormat("#.##");
		sp = new MatHang_DAO();
		for(MatHang x : sp.getAllMatHang()) {
			Object[] row = {x.getMaMH(), x.getLoaiMH(), x.getTenMH(), x.getSlTon(), x.getDvt(), df.format(x.getDonGia()), x.getMoTa()};
			model.addRow(row);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tblSanPham.getSelectedRow();
		if(row != -1) {
			txtMaSP.setText(model.getValueAt(row, 0).toString());
			if(model.getValueAt(row, 1).toString().equalsIgnoreCase("Linh Kiện")) {
				cboLoaiSP.setSelectedIndex(0);
			}
			if(model.getValueAt(row, 1).toString().equalsIgnoreCase("Xe")) {
				cboLoaiSP.setSelectedIndex(1);
			}
			txtTenSP.setText(model.getValueAt(row, 2).toString());
			txtsoLuong.setText(model.getValueAt(row, 3).toString());
			txtDonViTinh.setText(model.getValueAt(row, 4).toString());
			txtDonGia.setText(model.getValueAt(row, 5).toString());
			txtMoTa.setText(model.getValueAt(row, 6).toString());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		 if (!tblSanPham.isFocusOwner()) { // Nếu bảng không có focus
			 tblSanPham.clearSelection(); // Xóa các dòng đã chọn
	     }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThem)) {
			if(validData()) {
				try {
					luu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(obj.equals(btnXoa)) {
			try {
				xoa();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(obj.equals(btnTim)) {
			tim();
		}
		if(obj.equals(btnSua)) {
			if(validData()) {
				sua();
			}
		}
		if(obj.equals(btnRefresh)) {
			clearTableFrmSanPham();
			loadDataFrmSanPham();
		}
		if(obj.equals(cboLoaiSP)) {
			String selectedValue = (String) cboLoaiSP.getSelectedItem();
			String randomCode = txtMaSP.getText(); // Lấy mã sản phẩm đã có trên textfield txtMaSP
			if (tblSanPham.getSelectedRow() == -1) { // Nếu không có hàng nào được chọn trong bảng
				randomCode = generateRandomCode(selectedValue); // Phát sinh mã ngẫu nhiên mới
			}
			txtMaSP.setText(randomCode); // Hiển thị mã sản phẩm lên trên textfield txtMaSP
		}
	}
	
	private boolean validData() {
		String ten = txtTenSP.getText();
		String mta = txtMoTa.getText();
		if(ten.equals("") || txtsoLuong.getText().equals("") || txtDonGia.getText().equals("") || mta.equals("")) {
			JOptionPane.showMessageDialog(null, "Các trường không được rỗng");
			return false;
		}
		return true;
	}

	private void luu() throws SQLException {
		MatHang mh = revertTextToMatHang();
		if(mh != null) {
			String ma = txtMaSP.getText();
			if(sp.addSanPham(mh)) {
				if(mh.getLoaiMH().equals("Xe")) {
					JOptionPane.showMessageDialog(null, "Bạn đang thêm một xe mới vui lòng nhập thêm thông tin cho xe!");
					xe = new Frm_Xe();
					xe.maXe = ma;
					xe.setVisible(true);
					themVaoBang();
				}
				if(mh.getLoaiMH().equals("Linh Kiện")) {
					JOptionPane.showMessageDialog(null, "Bạn đang thêm một linh kiện mới vui lòng nhập thêm thông tin cho xe!");
					lk = new Frm_LinhKien();
					lk.maLK = ma;
					lk.setVisible(true);
					themVaoBang();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Trùng mã mặt hàng!");
			}
		}
	}
	
	private void xoa() throws SQLException {
		// TODO Auto-generated method stub
		int row = tblSanPham.getSelectedRow();
		if(row!=-1) {
			int tb= JOptionPane.showConfirmDialog(null, "Bạn có chắc chắc muốn xóa?", "Delete",JOptionPane.YES_NO_OPTION);
			if(tb==JOptionPane.YES_OPTION) {
				model.removeRow(row);
				String maSP = txtMaSP.getText();
				sp.Delete(maSP);
				JOptionPane.showMessageDialog(this, "Xoá thành công");
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"chưa chọn dòng xóa!");
		}
		
	}
	
	private MatHang revertTextToMatHang() {
		MatHang mh = null;
		if(txtsoLuong.getText().matches("^[0-9]+$") && txtDonGia.getText().matches("^[0-9]+(\\.[0-9]{1,2})?$")) {
			String ma = txtMaSP.getText();
			String loaiMH =(String) cboLoaiSP.getSelectedItem();
			String ten = txtTenSP.getText();
			int sl = Integer.parseInt(txtsoLuong.getText());
			double donGia = Double.parseDouble(txtDonGia.getText());
			String dvt = txtDonViTinh.getText();
			String mota = txtMoTa.getText();
			mh = new MatHang(ma, ten, dvt, mota, donGia, sl, loaiMH);
		} else {
			JOptionPane.showMessageDialog(null, "Số lượng và đơn giá phải là số và không nhỏ hơn 0");
		}
		return mh;
	}

	private void themVaoBang() {
		String ma = txtMaSP.getText();
		String loaiMH =(String) cboLoaiSP.getSelectedItem();
		String ten = txtTenSP.getText();
		String sl = txtsoLuong.getText();
		String dvt = txtDonViTinh.getText();
		String donGia = txtDonGia.getText();
		String mota = txtMoTa.getText();
		String[] row = {ma, loaiMH, ten, sl, dvt, donGia, mota};
		model.addRow(row);
	}
	public void clearTableFrmSanPham() {
		while (tblSanPham.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	private void tim() {
		if(btnTim.getText().equals("Tìm")) {
			ArrayList<MatHang> dsmh = sp.getSPTheoTen(txtTim.getText());
			if(dsmh != null) {
				btnTim.setText("Hủy tìm");
				clearTableFrmSanPham();
				for(MatHang mh : dsmh) {				
					if(dsmh != null) {
						model.addRow(new String[] {mh.getMaMH(), mh.getTenMH(), mh.getDvt(),
								mh.getMoTa(), mh.getDonGia() + "", mh.getSlTon() + "", mh.getLoaiMH()});
					} 
				}
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
			}
		}else {
			clearTableFrmSanPham();
			loadDataFrmSanPham();
			btnTim.setText("Tìm");
		}
	}
	private void sua() {
		String ma = txtMaSP.getText();
		int sl = Integer.parseInt(txtsoLuong.getText());
		BigDecimal dg = new BigDecimal(txtDonGia.getText());
		if(sp.update(sl, dg, ma)) {
			clearTableFrmSanPham();
			loadDataFrmSanPham();
			JOptionPane.showMessageDialog(null, "Sửa thành công!");
		}else {
			JOptionPane.showMessageDialog(null, "Mã SP không tồn tại!");
		}
	}
	private String generateRandomCode(String loaiMH) {
		String prefix = "";
		String suffix = "";
		if(loaiMH.equals("Linh Kiện")) {
			prefix = "LK";
			int maxNumber = 999999;
			int randomNum = new Random().nextInt(maxNumber);
			suffix = String.format("%06d", randomNum);
		}
		if(loaiMH.equals("Xe")) {
			prefix = "X";
			int maxNumber = 999999;
			int randomNum = new Random().nextInt(maxNumber);
			suffix = String.format("%06d", randomNum);
		}
		return prefix + suffix;
	}
}
