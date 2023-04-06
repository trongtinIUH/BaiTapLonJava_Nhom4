package du_an;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class Gui extends JFrame implements ActionListener,MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnTimkiem,btnThem,btnXoaTrang,btnSua,btnXoa,btnLuu;
	private JTextField txtmanv,txtho,txttennv,txttuoi,txttienluong,txttimkiem;
	private JLabel lblmanv,lblho,lbltennv,lbltuoi,lblphai,lbltienluong;
	private DefaultTableModel defaultTableModel;
	private JTable tblNhanVien;
	private JLabel lblUser;
	private JRadioButton radNam,radNu;
	private ButtonGroup grpsex;
	private JPanel pnCenter,pnContent,pnSouth;
	

	
	
	public Gui() {
		setTitle("Thông Tin Nhân Viên");
		setSize(900,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addControl();
		try {
			//loadData();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
	 
	public void addControl() {
		pnContent =new JPanel();
		add(pnContent,BorderLayout.NORTH);
		
		pnContent.add(lblUser = new JLabel("THÔNG TIN NHÂN VIÊN"),BorderLayout.NORTH);
		lblUser.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
		lblUser.setForeground(Color.blue);
		
		pnCenter = new JPanel();
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2= Box.createHorizontalBox();
		Box b3= Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		pnCenter.add(b);
		pnCenter.add(Box.createVerticalStrut(10));
		
		//phần input
		lblmanv = new JLabel("Mã nhân viên:");
		b1.add(lblmanv);
		b1.add(txtmanv= new JTextField(20));
		
		lblho =new JLabel("Họ");
		lblho.setPreferredSize(lblmanv.getPreferredSize());
		b2.add(lblho);
		b2.add(txtho = new JTextField(20));
		b2.add(lbltennv = new JLabel("Tên nhân viên:"));
		b2.add(txttennv = new JTextField(40));
		
		lbltuoi = new JLabel("Tuổi");
		lbltuoi.setPreferredSize(lblmanv.getPreferredSize());
		b3.add(lbltuoi);
		b3.add(txttuoi = new JTextField(20));
		b3.add(lblphai = new JLabel("Phái"));
		radNam = new JRadioButton("Nam",true);
		radNu = new JRadioButton("Nữ");
		ButtonGroup grpsex = new ButtonGroup();
		grpsex.add(radNam);
		grpsex.add(radNu);
		b3.add(radNam);
		b3.add(radNu);
		
		lbltienluong = new JLabel("Tiền Lương");
		lbltienluong.setPreferredSize(lblmanv.getPreferredSize());
		b4.add(lbltienluong);
		b4.add(txttienluong = new JTextField(20));
		
		createTable();

		add(pnCenter,BorderLayout.CENTER);
		
		
		
		//phần dưới cùng
		JSplitPane jSplitPane; //tạo ngăn chia mới theo chiều ngang
		add(jSplitPane= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT),BorderLayout.SOUTH);
		jSplitPane.setResizeWeight(0.5);
		
		//tạo ô tìm kiếm
		JPanel pnSearch = new JPanel();
		pnSearch.add(new JLabel("Nhập mã số cần tìm:"));
		pnSearch.add(txttimkiem = new JTextField(10));
		pnSearch.add(btnTimkiem= new JButton("Tìm"));
		jSplitPane.add(pnSearch);
		
		//ô chức năng
		JPanel pnChucnang=  new JPanel();
		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		btnXoaTrang = new JButton("Xóa Trắng");
		btnLuu = new JButton("Lưu");
		pnChucnang.add(btnThem);
		pnChucnang.add(btnXoa);
		pnChucnang.add(btnSua);
		pnChucnang.add(btnXoaTrang);
		pnChucnang.add(btnLuu);
		//thêm chức năng vào năng bên phải jsplit
		jSplitPane.add(pnChucnang);
		
		//thêm sự kiện
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		
	}
	
	
	public void createTable() {
		JPanel pnTable = new JPanel();
		defaultTableModel = new DefaultTableModel();
		tblNhanVien = new JTable(defaultTableModel);
		defaultTableModel.addColumn("Mã NV");
		defaultTableModel.addColumn("Họ");
		defaultTableModel.addColumn("Tên");
		defaultTableModel.addColumn("Phái");
		defaultTableModel.addColumn("Tuổi");
		defaultTableModel.addColumn("Tiền lương");
		TableColumn sexCol = tblNhanVien.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		sexCol.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn col = new TableColumn();
		col.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		tblNhanVien.getColumnModel().getColumn(0).setCellRenderer(center);
		tblNhanVien.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		tblNhanVien.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tblNhanVien.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		JScrollPane sp = new JScrollPane(tblNhanVien, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(650, 250));
		pnCenter.add(sp);
		pnCenter.add(pnTable);
	}

	public static void main(String[] args) {
		new Gui().setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnThem)) {
			if(btnThem.getText().equals("Thêm")) { 
				xoatrang();
			this.txtmanv.requestFocus();
			btnXoa.setEnabled(false);
			btnSua.setEnabled(false);
			btnThem.setText("Hủy");
			}
		
			else {
				btnXoa.setEnabled(true);
				btnSua.setEnabled(false);
				btnThem.setText("Thêm");
			}
		}
		else if(o.equals(btnLuu)) {
			if(txtmanv.getText().equals("")||txtho.getText().equals("")||txttennv.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ thông tin!");
			}
			else {
				try {
					luu();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
		}	
		else if(o.equals(btnTimkiem)) {
			tim();
		}
		else if(o.equals(btnXoa)) {
			try {
				xoa();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(o.equals(btnXoaTrang)) {
			txtmanv.setText("");
			txtho.setText("");
			txttennv.setText("");
			txttuoi.setText("");
			txttienluong.setText("");
			radNam.setSelected(false);
			radNu.setSelected(false);
			txtmanv.requestFocus();
		}
		
		
	}
	private void xoa() throws Exception {}



	private void tim() {}
	private void xoatrang()
	{
		txtmanv.setText("");
		txtho.setText("");
		txttennv.setText("");
		txttuoi.setText("");
		txttienluong.setText("");
		radNam.setSelected(false);
		radNu.setSelected(false);
		txtmanv.requestFocus();
	}


	private void luu() throws Exception{
		// TODO Auto-generated method stub
		if(validData()) {
			String phai="";
			String maNV= txtmanv.getText();
			String ho= txtho.getText();
			String ten= txttennv.getText();
			String tuoi= txttuoi.getText();
			String luong= txttienluong.getText();
			if(radNam.isSelected())
				phai=radNam.getText();
			if(radNu.isSelected())
				phai=radNu.getText();
//			if(maNV.equals("")||ho.equals("")||ten.equals("")||tuoi.equals("")||luong.equals("")) {
//				
//			}
			
			
				}
				else {
					JOptionPane.showMessageDialog(this, "ID nay da ton tai");
				txtmanv.setText("");
					txtmanv.requestFocus();
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
		int row = tblNhanVien.getSelectedRow();
		txtmanv.setText(defaultTableModel.getValueAt(row, 0).toString());
		txtho.setText(defaultTableModel.getValueAt(row, 1).toString());
		txttennv.setText(defaultTableModel.getValueAt(row, 2).toString());
		txttuoi.setText(defaultTableModel.getValueAt(row, 3).toString());
		if (defaultTableModel.getValueAt(row, 4).toString().equals("Nam")) {
			radNam.setSelected(true);
			radNu.setSelected(false);
		}
		else {
			radNam.setSelected(false);
			radNu.setSelected(true);
		}
		txttienluong.setText(defaultTableModel.getValueAt(row, 5).toString());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public boolean validData() {
		String manv= txtmanv.getText().trim();
		String tennv= txttennv.getText().trim();
		String ho= txtho.getText().trim();
		String tuoinv = txttuoi.getText().trim();
		int tuoi =Integer.parseInt(tuoinv);
		
		if(!(manv.length()>0 &&manv.matches("(NV)\\d{3}"))) {
			JOptionPane.showMessageDialog(null,"ERROR: Phải theo mã NV+3 số");
		return false;
		
		}
		
		if(!(tennv.length()>0 &&tennv.matches("[A-Za-z]+"))) {
			JOptionPane.showMessageDialog(null,"ERROR: tên phải nhập là kí tự chữ");
		return false;
		}
		
		
		if(!(ho.length()>0 &&ho.matches("[A-Za-z]+"))) {
			JOptionPane.showMessageDialog(null,"ERROR: họ phải nhập là kí tự chữ");
		return false;
		}
		
		if (tuoi <= 18 || tuoi >= 60) {
			try {
				if (tuoi <= 0) {
					JOptionPane.showMessageDialog(null,"ERROR: phải nhập là số dương");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"ERROR: phải nhập là số dương");
				return false;
			}
		}

		return true;
		
		
	}
	
	
	}





