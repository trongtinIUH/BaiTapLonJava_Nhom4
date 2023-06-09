package app_QLMBX;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Xe_DAO;
import entity.Regex;
import entity.Xe;

public class Frm_Xe extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDongXe, lblsoKhung, lblmauXe, lblsoPK, lblSoSuon, lblxuatSu;
	private JTextField txtsoKhung, txtSoSuon, txtTb;
	private JButton btnLuu, btnXoaTrang, btnThoat;
	private Xe_DAO xe;
	private String maXe = "X999";
	private JComboBox<Integer> cboPK;
	private JComboBox<String> cboDongXe, cboMauXe, cboXuatXu;
	private Regex reg;
	
	public Frm_Xe() {
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JPanel pnContent = new JPanel();
		pnContent.setLayout(null);
		JLabel lblTitle = new JLabel("Thông tin xe");
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		pnContent.add(lblTitle);
		lblTitle.setBounds(180, 0, 500, 50);
		int x = 20, y = 30, width = 100, height = 30;
		pnContent.add(lblDongXe = new JLabel("Dòng xe:"));
		y+=50;
		lblDongXe.setBounds(x, y, width, height);
		pnContent.add(lblxuatSu = new JLabel("Xuất sứ:"));
		y+=50;
		lblxuatSu.setBounds(x, y, width, height);
		pnContent.add(lblsoKhung = new JLabel("Số khung:"));
		y+=50;
		lblsoKhung.setBounds(x, y, width, height);
		pnContent.add(lblmauXe = new JLabel("Màu xe:"));
		y+=50;
		lblmauXe.setBounds(x, y, width, height);
		pnContent.add(lblsoPK = new JLabel("Số pk:"));
		y+=50;
		lblsoPK.setBounds(x, y, width, height);
		pnContent.add(lblSoSuon = new JLabel("Số Sườn:"));
		y+=50;
		lblSoSuon.setBounds(x, y, width, height);
		x = 120; y = 30; width = 300; height = 30;
		pnContent.add(cboDongXe = new JComboBox<String>());
		cboDongXe.addItem("Yamaha");
		cboDongXe.addItem("Honda");
		cboDongXe.addItem("SYM");
		cboDongXe.addItem("Kawasaki");
		cboDongXe.addItem("Suzuki");
		cboDongXe.addItem("Piaggio");
		y+=50;
		cboDongXe.setBounds(x, y, width, height);
		pnContent.add(cboXuatXu = new JComboBox<String>());
		cboXuatXu.addItem("Việt Nam");
		cboXuatXu.addItem("Nhật Bản");
		cboXuatXu.addItem("Hàn Quốc");
		cboXuatXu.addItem("Đức");
		cboXuatXu.addItem("Mỹ");
		cboXuatXu.addItem("Ý");
		cboXuatXu.addItem("Trung Quốc");
		cboXuatXu.addItem("Singapore");
		y+=50;
		cboXuatXu.setBounds(x, y, width, height);
		pnContent.add(txtsoKhung = new JTextField());
		y+=50;
		txtsoKhung.setBounds(x, y, width, height);
		pnContent.add(cboMauXe = new JComboBox<String>());
		cboMauXe.addItem("đỏ");
		cboMauXe.addItem("trắng");
		cboMauXe.addItem("xanh da trời");
		cboMauXe.addItem("đen");
		cboMauXe.addItem("vàng");
		cboMauXe.addItem("xám");
		cboMauXe.addItem("kem");
		y+=50;
		cboMauXe.setBounds(x, y, width, height);
		pnContent.add(cboPK = new JComboBox<Integer>());
		cboPK.addItem(50);
		cboPK.addItem(100);
		cboPK.addItem(120);
		cboPK.addItem(150);
		cboPK.addItem(200);
		y+=50;
		cboPK.setBounds(x, y, width, height);
		pnContent.add(txtSoSuon = new JTextField());
		y+=50;
		txtSoSuon.setBounds(x, y, width, height);
		pnContent.add(txtTb = new JTextField());
		txtTb.setEditable(false);
		txtTb.setBorder(null);
		txtTb.setForeground(Color.red);
		txtTb.setFont(new Font("Arial", Font.ITALIC, 12));
		y+=50;
		txtTb.setBounds(10, y, 500, height);
		pnContent.add(btnXoaTrang = new JButton("Xóa Trắng"));
		y+=50;
		btnXoaTrang.setBounds(50, y, 100, 50);
		pnContent.add(btnLuu = new JButton("Lưu"));
		btnLuu.setBounds(200, y, 100, 50);
		pnContent.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBounds(350, y, 100, 50);
		add(pnContent);
		btnLuu.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Frm_Xe().setVisible(true);
	}
	
	public Xe revertTextToXe() {
		String dongxe = (String) cboDongXe.getSelectedItem();
		String sokhung = txtsoKhung.getText();
		String mauXe = (String) cboMauXe.getSelectedItem();
		int sopk = (Integer) cboPK.getSelectedItem();
		String sosuon = txtSoSuon.getText();
		String xuatsu = (String)cboXuatXu.getSelectedItem();
		Xe x = new Xe(maXe, dongxe, sokhung, mauXe, sopk, sosuon, xuatsu);
		return x;
	}
	
	public void xoaTrang() {
		txtsoKhung.setText("");
		txtSoSuon.setText("");
		txtsoKhung.requestFocus();
	}
	
	public void setMaXe(String ma) {
		maXe = ma;
	}
	
	private void luu() throws SQLException {
		xe = new Xe_DAO();
		Xe x = revertTextToXe();
		if(xe.addXe(x)) {
			JOptionPane.showMessageDialog(null, "Lưu thành công");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoaTrang)) {
			xoaTrang();
		}else if(obj.equals(btnLuu)) {
			if(validData()) {
				try {
					luu();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
//				txtTb.setText("Số khung hoặc số sườn đã nhập không hợp lệ!");
			}
		} else {
			System.exit(0);
		}
	}
	
	private boolean validData() {
		reg = new Regex();
		if(reg.kiemTraSoKhung(txtsoKhung.getText(), (String) cboXuatXu.getSelectedItem()) == false) {
			txtTb.setText("Số khung: AAXXXXXXXXXXXXXXX với AA là: VN, NB,... Ví dụ: VN123456789012345");
			return false;
		}
		if(reg.kiemTraSoSuon(txtSoSuon.getText()) == false) {
			txtTb.setText("Số sườn phải đúng theo định dạng XXXX-XXXXXX, Ví dụ: HVA2-020438");
			return false;
		}
		return true;
	}
}
