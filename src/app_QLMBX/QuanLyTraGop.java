package app_QLMBX;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuanLyTraGop extends JFrame implements ActionListener, MouseListener {

	private JPanel panelTim;
	private JComboBox<String> cbTim;

	public QuanLyTraGop() {
		setTitle("Quản lý thông tin trả góp");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panelTim = new JPanel();
		panelTim.setBorder(crea);
		panelTim.setBounds(1,1,1,1);
		add(panelTim);
		JLabel lblTim = new JLabel("Chọn loại muốn tìm:");
		panelTim.add(lblTim);
		lblTim.setBounds(20, 30, 150, 20);
		cbTim = new JComboBox<String>();
		cbTim.addItem("Tìm theo mã hợp đồng");
		cbTim.addItem("Tìm theo số điện thoại");
		cbTim.addItem("Tìm theo mã khách hàng");
		panelTim.add(cbTim);
		cbTim.setBounds(175, 30, 180, 23);
	}

	public static void main(String[] args) {
		new QuanLyTraGop().setVisible(true);;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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

}
