package app_QLMBX;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.SanPham_DAO;
import entity.Xe;

public class Frm_Xe extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDongXe, lblsoKhung, lblmauXe, lblsoPK, lblSoSuon, lblxuatSu;
	private JTextField txtDongXe, txtsoKhung, txtmauXe, txtsoPK, txtSoSuon, txtxuatSu;
	private JButton btnLuu, btnXoaTrang, btnThoat;
	private SanPham_DAO sp;
	public String maXe = "";
	
	public Frm_Xe() {
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JPanel pnContent = new JPanel();
		pnContent.setLayout(null);
		int x = 20, y = 30, width = 100, height = 30;
		pnContent.add(lblDongXe = new JLabel("Dòng xe:"));
		y+=50;
		lblDongXe.setBounds(x, y, width, height);
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
		pnContent.add(lblxuatSu = new JLabel("Xuất sứ:"));
		y+=50;
		lblxuatSu.setBounds(x, y, width, height);
		x = 120; y = 30; width = 300; height = 30;
		pnContent.add(txtDongXe = new JTextField());
		y+=50;
		txtDongXe.setBounds(x, y, width, height);
		pnContent.add(txtsoKhung = new JTextField());
		y+=50;
		txtsoKhung.setBounds(x, y, width, height);
		pnContent.add(txtmauXe = new JTextField());
		y+=50;
		txtmauXe.setBounds(x, y, width, height);
		pnContent.add(txtsoPK = new JTextField());
		y+=50;
		txtsoPK.setBounds(x, y, width, height);
		pnContent.add(txtSoSuon = new JTextField());
		y+=50;
		txtSoSuon.setBounds(x, y, width, height);
		pnContent.add(txtxuatSu = new JTextField());
		y+=50;
		txtxuatSu.setBounds(x, y, width, height);
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
		String dongxe = txtDongXe.getText();
		String sokhung = txtsoKhung.getText();
		String mauXe = txtmauXe.getText();
		String sopk = txtsoPK.getText();
		String sosuon = txtSoSuon.getText();
		String xuatsu = txtxuatSu.getText();
		Xe x = new Xe(maXe, dongxe, sokhung, mauXe, Integer.parseInt(sopk), sosuon, xuatsu);
		return x;
	}
	
	public void xoaTrang() {
		txtDongXe.setText("");
		txtsoKhung.setText("");
		txtmauXe.setText("");
		txtsoPK.setText("");
		txtSoSuon.setText("");
		txtxuatSu.setText("");
		txtDongXe.requestFocus();
	}
	
	private void luu() throws SQLException {
		sp = new SanPham_DAO();
		Xe x = revertTextToXe();
		if(sp.addXe(x)) {
			JOptionPane.showMessageDialog(null, "Lưu thành công");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoaTrang)) {
			xoaTrang();
		}else if(obj.equals(btnLuu)) {
			try {
				luu();
				dispose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			System.exit(0);
		}
	}
}
