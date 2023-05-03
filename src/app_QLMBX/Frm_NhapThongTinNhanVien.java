package app_QLMBX;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dao.NhanVien_DAO;




public class Frm_NhapThongTinNhanVien extends JFrame implements Serializable,ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField txtsoNamKN;
	private JLabel lbltenPB,lblhocVan,lblbacTho,lblsoNamKN,lblchucvu;
	private JComboBox<String> jComboBox_tenpb;
	private String[] phongban=  new String[] {"PB 1","PB 2","PB 3","PB 4","PB 5","PB 6"};
	
	private JComboBox<String> jComboBox_hocvan;
	private String[] hocvan=  new String[] {"Đại Học","Cao Đẳng","Trung Cấp","THPT"};
	
	private JComboBox<String> jComboBox_bactho;
	private String[] bactho=  new String[] {"Bậc 1","Bậc 2","Bậc 3","Bậc 4","Bậc 5","Bậc 6"};
	
	private JComboBox<String> jComboBox_chucvu;
	private String[] chucVu=  new String[] {"Nhân viên hành chính","Nhân viên kỹ thuật"};
	
	private Frm_NhapThongTinNhanVien tt=this;
	

	private JButton btnLuu;

	
	private NhanVien_DAO nv;
	private JLabel lblmaNV;
	private JTextField txtmaNV;
	private JButton btnxacnhan;
	public String maNV="";


	

	public Frm_NhapThongTinNhanVien() {

		
		setSize(500, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JPanel pnContent = new JPanel();
		pnContent.setLayout(null);
		JLabel lblTitle = new JLabel("Thông tin nhân viên");
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 26));
		pnContent.add(lblTitle);
		lblTitle.setBounds(120, 0, 500, 50);
		int x = 20, y = 40, width = 100, height = 30;
		pnContent.add(lblchucvu = new JLabel("Chức Vụ: "));
		y+=40;
		lblchucvu.setBounds(x, y, width, height);
		
		pnContent.add(lblmaNV = new JLabel("Mã NV: "));
		y+=40;
		lblmaNV.setBounds(x, y, width, height);
		
		pnContent.add(lbltenPB = new JLabel("Phòng Ban: "));
		y+=40;
		lbltenPB.setBounds(x, y, width, height);
		pnContent.add(lblhocVan = new JLabel("Học Vấn: "));
		y+=40;
		lblhocVan.setBounds(x, y, width, height);
		pnContent.add(lblbacTho = new JLabel("Bậc Thợ :"));
		y+=40;
		lblbacTho.setBounds(x, y, width, height);
		pnContent.add(lblsoNamKN = new JLabel("Số Năm K/N:"));
		y+=40;
		lblsoNamKN.setBounds(x, y, width, height);
				
		
		x = 120; y = 80; width = 300; height = 30;
	//	jComboBox_chucvu.setSelectedItem(chucvu);
		jComboBox_chucvu= new JComboBox<String>(chucVu);
		jComboBox_chucvu.setEnabled(false);
		pnContent.add(jComboBox_chucvu);
		jComboBox_chucvu.setBounds(x, y, 200, height);
	
		pnContent.add(btnxacnhan = new JButton("Xác Nhận"));
		btnxacnhan.setIcon(new ImageIcon("image\\check-icon.png"));
		btnxacnhan.setBounds(330,80, 130, 30);
		btnxacnhan.addActionListener(this);
		y+=40;
		
// nhập mã nv ở day

		pnContent.add(txtmaNV = new JTextField(10));
		txtmaNV.setText(maNV);
		txtmaNV.setEditable(false);
		txtmaNV.setBounds(x, y, 340, height);
		y+=40;
		
		
		jComboBox_tenpb= new JComboBox<String>(phongban);
		pnContent.add(jComboBox_tenpb);
		jComboBox_tenpb.setBounds(x, y, 340, height);
		y+=40;
		
		jComboBox_hocvan= new JComboBox<String>(hocvan);
		pnContent.add(jComboBox_hocvan);
		jComboBox_hocvan.setBounds(x, y, 340, height);
		y+=40;
		jComboBox_bactho= new JComboBox<String>(bactho);
		pnContent.add(jComboBox_bactho);
		jComboBox_bactho.setBounds(x, y, 340, height);
		y+=40;
		pnContent.add(txtsoNamKN = new JTextField());
		txtsoNamKN.setBounds(x, y, 340, height);
		y+=40;
		
		pnContent.add(btnLuu = new JButton("Lưu"));
		btnLuu.setBounds(200, y, 100, 40);

		btnLuu.addActionListener(this);
		add(pnContent);
		
		
		
		tt.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        int option = JOptionPane.showConfirmDialog(tt, "Bạn có muốn đóng cửa sổ này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
		        if (option == JOptionPane.YES_OPTION) {
		        	tt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        } else {
		        	tt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		        }
		    }
		});
	
		
	}
	public void settxtmanv(String ma) {
		
		txtmaNV.setText(ma);
	}
	public void setchucvu(String cv) {
		
		jComboBox_chucvu.setSelectedItem(cv);
	}
	public static void main(String[] args) {
		new Frm_NhapThongTinNhanVien().setVisible(true);
	}
	

	

	private void luu_kt() throws HeadlessException, SQLException {
		nv = new NhanVien_DAO();
	
		String bactho = (String) jComboBox_bactho.getSelectedItem();
		String namkn = txtsoNamKN.getText();
		String ma_nv_kt= txtmaNV.getText();
	try {
			nv.addNhanVien_kythuat(ma_nv_kt,bactho,Integer.parseInt(namkn));
			JOptionPane.showMessageDialog(null, "Lưu thành  công");			
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lưu không Thành Công do trùng mã !");
		}	
	}
	private void luu_hc() throws HeadlessException, SQLException {
		nv = new NhanVien_DAO();
		String pb = (String) jComboBox_tenpb.getSelectedItem();
		String hocvan = (String) jComboBox_hocvan.getSelectedItem();
		String ma_nv_kt= txtmaNV.getText();
	try {
			nv.addNhanVien_hanhchinh(ma_nv_kt,pb,hocvan);
			JOptionPane.showMessageDialog(null, "Lưu thành  công");
			
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lưu không Thành Công do trùng mã !");
		}
	
	
	
	}
	
	
	private boolean isConfirmed = false;
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnxacnhan)) {
			XacNhan();
			  isConfirmed = true;
		}
		if (o.equals(btnLuu)) {
	        if (!isConfirmed) {
	            JOptionPane.showMessageDialog(null, "Vui lòng Chọn chức vụ xác nhận");
	        } else {
	            if (jComboBox_chucvu.getSelectedItem().equals("Nhân viên hành chính")) {
	                try {
	                    luu_hc();
	                    dispose();
	                } catch (HeadlessException | SQLException e1) {
	                    e1.printStackTrace();
	                }
	            } else {
	                try {
	                    luu_kt();
	                    dispose();
	                } catch (HeadlessException | SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
	    }
		
	}
	
	public void XacNhan() {
		if(btnxacnhan.getText().equals("Xác Nhận")) {
			if(jComboBox_chucvu.getSelectedItem().equals("Nhân viên hành chính")) {
				jComboBox_bactho.setEnabled(false);
				txtsoNamKN.setEnabled(false);
				jComboBox_tenpb.setEnabled(true);
				jComboBox_hocvan.setEnabled(true);
			}
			else {
				jComboBox_tenpb.setEnabled(false);
				jComboBox_hocvan.setEnabled(false);
				jComboBox_bactho.setEnabled(true);
				txtsoNamKN.setEnabled(true);
			}
			
		}
	}
}
