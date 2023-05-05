package app_QLMBX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle, lblUsername, lblPassword;
    private JTextField txtUsername, txtPassword;
    private JButton btnLogin, btnExit;
    private String user="123";
	private String pass= "123";

	public LoginForm() {
		setTitle("Login Form");
		setSize(640, 300);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 240, 240));
		


		lblTitle = new JLabel("User Login");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 35));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(300, 20, 200, 45);
		lblTitle.setForeground(Color.red);
		panel.add(lblTitle);

		lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.white);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 18));
		lblUsername.setBounds(270, 95, 150, 25);
		panel.add(lblUsername);

		txtUsername = new JTextField(20);
		txtUsername.setBounds(380, 95, 200, 25);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 18));
		txtUsername.setText("123");
		panel.add(txtUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.white);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 18));
		lblPassword.setBounds(270, 135, 150, 25);
		panel.add(lblPassword);

		txtPassword = new JPasswordField(20);
		txtPassword.setBounds(380, 135, 200, 25);
		txtPassword.setText("123");
		panel.add(txtPassword);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(310, 200, 90, 25);
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(btnLogin);

		btnExit = new JButton("Exit");
		btnExit.setBounds(460, 200, 90, 25);
		btnExit.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(btnExit);

		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image\\login1.jpg"));
		label.setBounds(0, 0, 640, 300);
		panel.add(label);
		add(panel);

		setVisible(true);
		btnExit.addActionListener(this);
		btnLogin.addActionListener(this);
	}

	public static void main(String[] args) {
		new LoginForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLogin)) {
			String username = txtUsername.getText();
			char[] mk = ((JPasswordField) txtPassword).getPassword();
			String mkstr=new String(mk);
			if(username.equals(user)&& mkstr.equals(pass)) {
				TrangChu trangchu= new TrangChu();
				trangchu.setVisible(true);	
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "Sai tài khoản | mật khẩu");
			}

		}

		else if (o.equals(btnExit)) {
			int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Thoát Không?", "Thoát",
					JOptionPane.YES_NO_OPTION);
			if (chon == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
}
