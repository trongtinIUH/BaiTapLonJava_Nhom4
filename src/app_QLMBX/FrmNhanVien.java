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

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmNhanVien extends JPanel implements Serializable,ActionListener,MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblmaNV,lbltenNV,lblGioiTinh,lbldiaChi,lblsdt,lblemail,lblngayvaolam,lblchucVu,lblluongcoBan,lblmaCH,lblUser;
	private JTextField txtmaNV,txttenNV,txtdiaChi,txtsdt,txtemail,txtLuong,txtmaCH,txtNgayvaolam;
	private JButton btnThem,btnXoa,btnXoaTrang,btnLuu,btnTimKiem;
	private JTable tblNhanVien;
	private DefaultTableModel model;
	
	private JComboBox<String> jComboBox_gioitinh;
	private String[] GioiTinh=  new String[] {"Nam","Nữ"};
	private JComboBox<String> jComboBox_mach;
	private String[] cuahang=  new String[] {"Gò Vấp 1","Gò Vấp 2","Gò Vấp 3"};
	private JComboBox<String> jComboBox_chucvu;
	private String[] chucVu=  new String[] {"Nhân viên hành chính","Nhân viên kỹ thuật"};

	private JLabel lblTimKiem;
	private JTextField txtTimkiem;
	
	
	
	
	public FrmNhanVien() {
		setSize(700,600);
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		
		
		Box b= Box.createVerticalBox();
		Box b1= Box.createHorizontalBox();
		Box b2= Box.createHorizontalBox();
		Box b3= Box.createHorizontalBox();
		Box b4= Box.createHorizontalBox();
		Box b5= Box.createHorizontalBox();
		Box b6= Box.createHorizontalBox();
		Box b7= Box.createHorizontalBox();
		Box b8= Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		b.add(b5);
		b.add(Box.createVerticalStrut(5));
		b.add(b6);
		b.add(Box.createVerticalStrut(5));
		b.add(b7);
		b.add(Box.createVerticalStrut(5));
		b.add(b8);
		b.add(Box.createVerticalStrut(5));
		add(b,BorderLayout.NORTH);
		
		
		//phần input
		b1.add(lblUser = new JLabel("THÔNG TIN NHÂN VIÊN"));
		b1.add(Box.createRigidArea(new Dimension(50,50)));
		lblUser.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
		lblUser.setForeground(Color.blue);
		
		
		lblmaNV = new JLabel("Mã Nhân Viên:   ");
		b2.add(lblmaNV);
		b2.add(txtmaNV = new JTextField(20));
		
		b2.add(lbltenNV =new JLabel("Tên NV: "));
		b2.add(txttenNV= new JTextField(10));
		b2.add(lblGioiTinh= new JLabel("Giới Tính: "));
		jComboBox_gioitinh= new JComboBox<String>(GioiTinh);
		b2.add(jComboBox_gioitinh);
		
		b3.add(lbldiaChi =new JLabel("Địa Chỉ: "));
		b3.add(txtdiaChi= new JTextField(20));
		b3.add(lblsdt =new JLabel("SDT: "));
		b3.add(txtsdt= new JTextField(10));
		lbldiaChi.setPreferredSize(lblmaNV.getPreferredSize());
		
		
		b4.add(lblemail =new JLabel("Email: "));
		b4.add(txtemail= new JTextField(20));
		b4.add(lblngayvaolam =new JLabel("Ngày Vào Làm: "));
		b4.add(txtNgayvaolam= new JTextField(10));
		lblemail.setPreferredSize(lblmaNV.getPreferredSize());
		
		b5.add(lblchucVu= new JLabel("Chức Vụ: "));
		jComboBox_chucvu= new JComboBox<String>(chucVu);
		b5.add(jComboBox_chucvu);
		b5.add(lblluongcoBan =new JLabel("Lương: "));
		b5.add(txtLuong= new JTextField(10));
		lblchucVu.setPreferredSize(lblmaNV.getPreferredSize());
		
		b6.add(lblmaCH= new JLabel("Mã Cửa Hàng:"));
		jComboBox_mach= new JComboBox<String>(cuahang);
		b6.add(jComboBox_mach);
		lblmaCH.setPreferredSize(lblmaNV.getPreferredSize());
		
		//phần dưới
		JSplitPane jSplitPane;
		add(jSplitPane= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT),BorderLayout.SOUTH);
		jSplitPane.setResizeWeight(0.5);
		b7.add(jSplitPane);
		
		//tạo ô tìm kiếm
		JPanel pnTim= new JPanel();
		pnTim.add(lblTimKiem= new JLabel("Tìm NV: "));
		pnTim.add(txtTimkiem= new JTextField(10));
		pnTim.add(btnTimKiem= new JButton("Tìm"));
		jSplitPane.add(pnTim);
		
		//tạo ô chức năng
		JPanel pnchucnang= new JPanel();
		pnchucnang.add(btnThem= new JButton("Thêm"));
		pnchucnang.add(btnXoa= new JButton("Xóa"));
		pnchucnang.add(btnXoaTrang= new JButton("Xóa Trắng"));
		pnchucnang.add(btnLuu= new JButton("Lưu"));
		jSplitPane.add(pnchucnang);
		
		
		TaoTable();
			
		
		//phần sự kiện
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTimKiem.addActionListener(this);
		
		
	}
	private void TaoTable() {
			String col[]= {"Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Địa Chỉ", "SDT", "Email","Ngày Vào Làm","Chức Vụ","Lương","Mã Cửa Hàng"};
			model= new DefaultTableModel(col,0);
			tblNhanVien = new JTable(model);
			JScrollPane pane = new JScrollPane(tblNhanVien);
			pane.setPreferredSize(new Dimension(950, 350));
			
			JComboBox jComboBox1= new JComboBox();
			jComboBox1.addItem("Nam");
			jComboBox1.addItem("Nữ");
			JComboBox jComboBox2= new JComboBox();
			jComboBox2.addItem("Nhân viên hành chính");
			jComboBox2.addItem("Nhân viên kỹ thuật");
			DefaultCellEditor de1 = new DefaultCellEditor(jComboBox1);
			DefaultCellEditor de2 = new DefaultCellEditor(jComboBox2);
			tblNhanVien.getColumnModel().getColumn(2).setCellEditor(de1);
			tblNhanVien.getColumnModel().getColumn(7).setCellEditor(de2);
			
			add(pane,BorderLayout.CENTER);
			
		}
//	public static void main(String[] args) {
//		new FrmNhanVien().setVisible(true);
//	}




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
		
	}
	private void xoatrang() {
		txtmaNV.setText("");
		txtmaNV.requestFocus();
		txtdiaChi.setText("");
		txtemail.setText("");
		txtLuong.setText("");
		txtmaCH.setText("");
		txtNgayvaolam.setText("");
		txtsdt.setText("");
		txttenNV.setText("");
	}
}
