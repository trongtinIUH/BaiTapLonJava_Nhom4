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

import dao.LinhKien_DAO;
import entity.LinhKienPhuTung;

public class Frm_LinhKien extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblHangSX;
	private JTextField txtHangSX;
	private JButton btnLuu, btnThoat;
	public String maLK = "";
	private LinhKien_DAO lk;
	public Frm_LinhKien() {
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JPanel pnContent = new JPanel();
		pnContent.setLayout(null);
		int x = 20, y = 10, width = 100, height = 30;
		pnContent.add(lblHangSX = new JLabel("Hãng SX: "));
		lblHangSX.setBounds(x, y, width, height);
		pnContent.add(txtHangSX = new JTextField());
		txtHangSX.setBounds(80, y, 200, height);
		pnContent.add(btnLuu = new JButton("Lưu"));
		btnLuu.setBounds(30, 80, width, height);
		pnContent.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBounds(150, 80, width, height);
		add(pnContent);
		btnLuu.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	public static void main(String[] args) {
		new Frm_LinhKien().setVisible(true);
	}
	
	private LinhKienPhuTung revertTextToLK() {
		String hangsx = txtHangSX.getText();
		LinhKienPhuTung lk = new LinhKienPhuTung(maLK, hangsx);
		return lk;
	}
	
	private void luu() throws SQLException {
		lk = new LinhKien_DAO();
		LinhKienPhuTung x = revertTextToLK();
		if(lk.addLinhKien(x)) {
			JOptionPane.showMessageDialog(null, "Lưu thành công");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThoat)) {
			System.exit(0);
		}
		if(obj.equals(btnLuu)){
			try {
				luu();
				dispose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
