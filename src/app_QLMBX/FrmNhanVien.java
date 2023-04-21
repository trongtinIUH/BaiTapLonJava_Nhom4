package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import dao.NhanVien_DAO;
import entity.DateLabelFormatter;
import entity.NhanVien;

public class FrmNhanVien extends JPanel implements Serializable,ActionListener,MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String col[]= {"Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Địa Chỉ", "SDT", "Email","Ngày Vào Làm","Chức Vụ","Lương","Mã Cửa Hàng"};
	private JLabel lblmaNV,lbltenNV,lblGioiTinh,lbldiaChi,lblsdt,lblemail,lblngayvaolam,lblchucVu,lblluongcoBan,lblmaCH,lblUser;
	private JTextField txtmaNV,txttenNV,txtdiaChi,txtsdt,txtemail,txtLuong,txtmaCH,txtNgayvaolam;
	private JButton btnThem,btnXoa,btnXoaTrang,btnLuu,btnTimKiem;
	private JTable tblNhanVien;
	private DefaultTableModel model;
	
	private JComboBox<String> jComboBox_gioitinh;
	private String[] GioiTinh=  new String[] {"Nam","Nữ"};
	private JComboBox<String> jComboBox_mach;
	private String[] cuahang=  new String[] {"CH001","CH003","CH003"};
	private JComboBox<String> jComboBox_chucvu;
	private String[] chucVu=  new String[] {"Nhân viên hành chính","Nhân viên kỹ thuật","Nhân viên bán hàng","Nhân viên tư vấn/Bảo hành","Quản lý kho hàng","Kế "};

	private JLabel lblTimKiem;
	private JTextField txtTimkiem;
	private NhanVien_DAO nv;
	private Component panelSouth;
	private SqlDateModel modelNgaylap;
	private Properties p;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	
	

	public FrmNhanVien() {
		setSize(990, 600);

		
		
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
	//y+=30;
		pnContent.add(lbltenNV = new JLabel("Tên Nhân Viên :"));
		lbltenNV.setBounds(520, y, width, height);
		//y+=30;
		
		y+=30;
		pnContent.add(lblGioiTinh = new JLabel("Giới Tính:"));
		lblGioiTinh.setBounds(x, y, width, height);
//	y+=30;
		
		pnContent.add(lbldiaChi = new JLabel("Địa Chỉ:"));
		lbldiaChi.setBounds(520, y, width, height);

		y+=30;
		pnContent.add(lblsdt = new JLabel("SDT:"));
		lblsdt.setBounds(x, y, width, height);
		
		
		pnContent.add(lblemail = new JLabel("Email:"));
		lblemail.setBounds(520, y, width, height);
		
		y+=30;
		pnContent.add(lblngayvaolam = new JLabel("Ngày Vào Làm:"));
		lblngayvaolam.setBounds(x, y, width, height);
		
		
		pnContent.add(lblchucVu = new JLabel("Chức Vụ:"));
		lblchucVu.setBounds(520, y, width, height);
		
		y+=30;
		pnContent.add(lblluongcoBan = new JLabel("Lương:"));
		lblluongcoBan.setBounds(x, y, width, height);
		
		pnContent.add(lblmaCH = new JLabel("Mã Cửa Hàng:"));
		lblmaCH.setBounds(520, y, width, height);
		
		y+=30;
		pnContent.add(lblTimKiem = new JLabel("Tìm Mã NV:"));
		lblTimKiem.setBounds(x, y, width, height);
		
		
		
		
		
		x+=100;y = 56;width = 300;height = 20;
		pnContent.add(txtmaNV = new JTextField(20));
		txtmaNV.setBounds(x, y, width, height);
		
		pnContent.add(txttenNV = new JTextField(20));
	//y += 30;
		txttenNV.setBounds(620, y, width, height);
		
		
		y+=30;
		jComboBox_gioitinh= new JComboBox<String>(GioiTinh);
		pnContent.add(jComboBox_gioitinh);
		jComboBox_gioitinh.setBounds(x, y, width, height);
		//y+=30;
		pnContent.add(txtdiaChi = new JTextField(20));
		txtdiaChi.setBounds(620, y, width, height);
		y+=30;
		pnContent.add(txtsdt = new JTextField(20));
		txtsdt.setBounds(x, y, width, height);
		
		
		pnContent.add(txtemail = new JTextField(20));
		txtemail.setBounds(620, y, width, height);
		y+=30;
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
		datePicker.setBackground(new Color(248,248,248));
		datePicker.setToolTipText("Chọn ngày sinh");
		modelNgaylap.setDate(1990, 0, 1);
		modelNgaylap.setSelected(true);
		pnContent.add(datePicker);
	
		
	
		
		
		jComboBox_chucvu= new JComboBox<String>(chucVu);
		pnContent.add(jComboBox_chucvu);
		jComboBox_chucvu.setBounds(620, y, width, height);
		
		y+=30;
		pnContent.add(txtLuong = new JTextField(20));
		txtLuong.setBounds(x, y, width, height);	
		
		jComboBox_mach= new JComboBox<String>(cuahang);
		pnContent.add(jComboBox_mach);
		jComboBox_mach.setBounds(620, y, width, height);
		
		pnContent.add(txtTimkiem = new JTextField(20));
		y += 30;
		txtTimkiem.setBounds(x, y, width, height);
		
		pnContent.add(btnThem = new JButton("Thêm"));
		width = 100; height = 30; x = 150;
		y+=30; 
		btnThem.setBounds(x, y, width, height);
		pnContent.add(btnXoa = new JButton("Xóa"));
		x+=120; 
		btnXoa.setBounds(x, y, width, height);
		pnContent.add(btnLuu = new JButton("Lưu"));
		x+=120;
		btnLuu.setBounds(x, y, width, height);
		pnContent.add(btnTimKiem = new JButton("Tìm"));
		x+=120;
		btnTimKiem.setBounds(x, y, width, height);
		pnContent.add(btnXoaTrang = new JButton("Xóa Trắng"));
		x+=120;
		btnXoaTrang.setBounds(x, y, 200, height);
		
		
	
		
		model = new DefaultTableModel(col, 0);
		tblNhanVien = new JTable(model);
		tblNhanVien.setBackground(Color.pink);
		JScrollPane sp = new JScrollPane(tblNhanVien);
		width = 990; height = 400;
		y+=50;
		sp.setBounds(0, y, width, height);
		pnContent.add(sp);
		pnContent.setPreferredSize(new Dimension(990, 600));
		pnControl.add(pnContent, BorderLayout.CENTER);
		this.add(pnControl);
			
		loadData();
		//phần sự kiện
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
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
				//lấy dữ liệu từ bảng của jcombobox về input
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
		for(NhanVien x : nv.getAllNhanVien()) {
			Object[] row = {x.getMaNV(), x.getTenNV(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.geteMail(), x.getNgayVaoLam(), x.getChucVu(), x.getLuongCoBan(), x.getMaCH() };
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
				Object o= e.getSource();
				if(o.equals(btnXoaTrang)) {
					xoatrang();
				}
				if(o.equals(btnTimKiem)) {
				tim();
				}
				if(o.equals(btnThem)) {
					try {
						them();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(o.equals(btnXoa)) {
					try {
						xoa();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		
	}
	private void xoa() throws SQLException {
		// TODO Auto-generated method stub
		int row =tblNhanVien.getSelectedRow();
		if(row!=-1) {
			int tb= JOptionPane.showConfirmDialog(null, "what the fuck man?","Delete",JOptionPane.YES_NO_OPTION);
			if(tb==JOptionPane.YES_OPTION) {
				model.removeRow(row);
				String manv = txtmaNV.getText();
				nv.DeleteNV(manv);
				JOptionPane.showMessageDialog(this, "Xoá thành công");
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"chưa chọn dòng xóa!");
		}
		
	}
	// hàm tìm
	private void tim() {
		int vt= nv.timkiem(txtTimkiem.getText());
		if(vt==-1) {
			JOptionPane.showMessageDialog(null,"Không tồn tại nv!");
		}
		else {
			tblNhanVien.setRowSelectionInterval(vt, vt);
		}
		
	}
	
	private void them() throws NumberFormatException, Exception {
		String ma=txtmaNV.getText();
		String ten=txttenNV.getText();
		String  gioitinh= (String) jComboBox_gioitinh.getSelectedItem();
		String dc=txtdiaChi.getText();
		String sdt=txtsdt.getText();
		String email=txtemail.getText();
		Date ngaylap =(Date) datePicker.getModel().getValue();
		String chucvu=(String) jComboBox_chucvu.getSelectedItem();
		String luong=txtLuong.getText();
		String mach=(String) jComboBox_mach.getSelectedItem();
	
		
		if(ma.equals("")||ten.equals("")) {
			JOptionPane.showMessageDialog(this, "Ban chua nhap day du thong tin");
		}
		
		
		//thêm ngày *****************
	
		
		NhanVien nhanvien = new NhanVien(ma,ten, gioitinh, dc, sdt, email, (java.sql.Date) ngaylap, chucvu, Float.parseFloat(luong), mach);
		String [] row = {ma,ten,gioitinh,dc,sdt,email,String.valueOf(ngaylap),chucvu,luong,mach};
		try {
			model.addRow(row);
			nv.addNhanVien(nhanvien);
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			
	} catch (Exception e) {
		JOptionPane.showMessageDialog(this, "Trùng mã lớp");
		txtmaNV.setText("");
			txtmaNV.requestFocus();
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
}
