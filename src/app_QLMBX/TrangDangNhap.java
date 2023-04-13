package app_QLMBX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TrangDangNhap extends JFrame implements Serializable,ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnLogin,btnExit;
	private JTextField textFN;
	private JPasswordField textLN;
	private JLabel lblUser;
	private JLabel lblmk;
	private JLabel lblma;
	
	//pass user phải tạo trong sql ***
	private String user="21054421";
	private String pass= "tin";
	
	

	public TrangDangNhap() {
		super("Đăng Nhập");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,200);
		setLocationRelativeTo(null);
		setResizable(false);
		
		taoGui();
}
	private void taoGui() {
		Box b=Box.createVerticalBox();
		Box p1= Box.createHorizontalBox();
		Box pTieuDe= Box.createHorizontalBox();
		Box p2= Box.createHorizontalBox();
		Box p3= Box.createHorizontalBox();
		b.add(pTieuDe);
		b.add(Box.createVerticalStrut(20));
		b.add(p1);
		b.add(Box.createVerticalStrut(5));
		b.add(p2);
		b.add(Box.createVerticalStrut(5));
		b.add(p3);
		b.add(Box.createVerticalStrut(10));
		
		lblUser = new JLabel("TRANG ĐĂNG NHẬP");
		pTieuDe.add(Box.createRigidArea(new Dimension(30, 10)));
		pTieuDe.add(lblUser);
		lblUser.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
		lblUser.setForeground(Color.blue);
		
		p1.add(lblma =new JLabel("Mã Nhân Viên:"));
		p1.add(textFN=new JTextField(10));
		
		p2.add(lblmk= new JLabel("Mật Khẩu:"));
		p2.add(textLN=new JPasswordField(20));
		lblmk.setPreferredSize(lblma.getPreferredSize());
		
		//phần nút đăng nhập và sự kiện
		p3.add(btnLogin= new JButton("Login"));
		p3.add(btnExit= new JButton("Exit"));
		this.add(b,BorderLayout.NORTH);
		
		
		//sự kiện ở đây
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
	}
	public static void main(String[] args) {
		 new TrangDangNhap().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if(o.equals(btnLogin)) {
		String username= textFN.getText();
		char[] mk = textLN.getPassword();
		String mkstr=new String(mk);
		if(username.equals(user)&& mkstr.equals(pass)) {
			TrangChu trangchu= new TrangChu();
		trangchu.setVisible(true);
		dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "Sai tài khoản | mật khẩu");
		}
		
		
		//thì chuyển qua trang chủ
	}
	
	else if(o.equals(btnExit)) {
		int chon=JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Thoát Không?","Thoát", JOptionPane.YES_NO_OPTION);
		if(chon==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

		
	}

}
