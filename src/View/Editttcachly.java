package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Object.ttcachly;
import data.ttkhaibao_mt;

public class Editttcachly extends JFrame {

	private JPanel contentPane;
	private JTextField txtcmnd;
	private JTextField txthoten;
	private JTextField txtid;
	private JTextField txtnoicl;
	private JTextField txtmucdo;
	private JTextField txtmacl;
	private JTextField txtbatdau;
	private JTextField txtketthuc;
	private JRadioButton no;
	private JRadioButton yes;
	private static ttcachly ex=new ttcachly();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Editttcachly frame = new Editttcachly();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Editttcachly() {
		setTitle("Edit thông tin cách ly");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 913, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel hoten = new JLabel("Họ tên");
		hoten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hoten.setBounds(162, 87, 76, 27);
		contentPane.add(hoten);
		
		JLabel cmnd = new JLabel("Số CMND");
		cmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cmnd.setBounds(162, 135, 76, 27);
		contentPane.add(cmnd);
		
		JLabel id_nk = new JLabel("ID nhân khẩu");
		id_nk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		id_nk.setBounds(162, 50, 96, 27);
		contentPane.add(id_nk);
		
		JLabel macl = new JLabel("Mã cách ly");
		macl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		macl.setBounds(162, 181, 76, 27);
		contentPane.add(macl);
		
		JLabel noicl = new JLabel("Nơi cách ly");
		noicl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		noicl.setBounds(162, 231, 112, 27);
		contentPane.add(noicl);
		
		JLabel mucdo = new JLabel("Mức độ cách ly");
		mucdo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mucdo.setBounds(162, 282, 121, 27);
		contentPane.add(mucdo);
		
		JLabel batdau = new JLabel("Ngày bắt đầu");
		batdau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		batdau.setBounds(162, 386, 112, 27);
		contentPane.add(batdau);
		
		JLabel ketthuc = new JLabel("Ngày kết thúc");
		ketthuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ketthuc.setBounds(162, 439, 112, 27);
		contentPane.add(ketthuc);
		
		JLabel test = new JLabel("Test");
		test.setFont(new Font("Tahoma", Font.PLAIN, 16));
		test.setBounds(162, 334, 76, 27);
		contentPane.add(test);
		
		txtcmnd = new JTextField();
		txtcmnd.setEditable(false);
		txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcmnd.setBounds(301, 130, 355, 36);
		contentPane.add(txtcmnd);
		txtcmnd.setColumns(10);
		
		txthoten = new JTextField();
		txthoten.setEditable(false);
		txthoten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txthoten.setColumns(10);
		txthoten.setBounds(301, 84, 355, 36);
		contentPane.add(txthoten);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtid.setColumns(10);
		txtid.setBounds(301, 39, 355, 36);
		contentPane.add(txtid);
		
		txtnoicl = new JTextField();
		txtnoicl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtnoicl.setColumns(10);
		txtnoicl.setBounds(301, 226, 355, 36);
		contentPane.add(txtnoicl);
		
		txtmucdo = new JTextField();
		txtmucdo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmucdo.setColumns(10);
		txtmucdo.setBounds(301, 282, 355, 36);
		contentPane.add(txtmucdo);
		
		txtmacl = new JTextField();
		txtmacl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmacl.setColumns(10);
		txtmacl.setBounds(301, 176, 355, 36);
		contentPane.add(txtmacl);
		
		txtbatdau = new JTextField();
		txtbatdau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtbatdau.setColumns(10);
		txtbatdau.setBounds(301, 381, 355, 36);
		contentPane.add(txtbatdau);
		
		txtketthuc = new JTextField();
		txtketthuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtketthuc.setColumns(10);
		txtketthuc.setBounds(301, 434, 355, 36);
		contentPane.add(txtketthuc);
		
		JButton btnSave = new JButton("Save");
		
		btnSave.setBackground(Color.CYAN);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.setBounds(744, 561, 101, 36);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(576, 561, 101, 36);
		contentPane.add(btnCancel);
		
		yes = new JRadioButton("Đã Test");
		yes.setFont(new Font("Tahoma", Font.BOLD, 16));
		yes.setBounds(301, 334, 96, 37);
		contentPane.add(yes);
		
		no = new JRadioButton("Chưa Test");
		no.setFont(new Font("Tahoma", Font.BOLD, 16));
		no.setBounds(412, 334, 112, 37);
		contentPane.add(no);
		ButtonGroup group= new ButtonGroup();
		group.add(no);
		group.add(yes);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ex.setId_nk(Integer.parseInt(txtid.getText().toString().trim()));
				ex.setBatdau(java.sql.Date.valueOf(txtbatdau.getText().toString().trim()));
				if(txtketthuc.getText().trim().equals("")) ex.setKetthuc(null);
				else ex.setKetthuc(java.sql.Date.valueOf(txtketthuc.getText().toString().trim()));
				ex.setNoicachly(txtnoicl.getText().toString().trim());
				ex.setHoten(txthoten.getText().trim());
				ex.setMa_cachly(txtmacl.getText().trim());
				ex.setMucdocachly(txtmucdo.getText().trim());
				if(no.isSelected()) ex.setDatest(false); 
				if(yes.isSelected()) ex.setDatest(true);
//				ex2.setHo_ten(txthoten.getText().trim());
//				ex2.setSo_cmnd(new BigDecimal(txtcmnd.getText().trim()));
//				ex2.setId_nkhau(Integer.parseInt(txtid.getText()));
				int j=ttkhaibao_mt.InsertorUpdatecachly(ex);
				if(j==1) {
					JOptionPane.showMessageDialog(null, "Thêm/sửa dữ liệu cách ly thành công");
					Thongtincachly.updatetable();
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Thêm/sửa dữ liệu thất bại","Error",JOptionPane.WARNING_MESSAGE);

			}
		});
	}
	public void hienthinoidung(String a,String b,String c,String d,String e,String f,String g,String k,String l) {
		txtid.setText(a);
		txthoten.setText(b);
		txtcmnd.setText(c);
		txtmacl.setText(d);
		txtnoicl.setText(e);
		txtmucdo.setText(f);
		if(g.equals("yes")) yes.setSelected(true); else no.setSelected(true);
		txtbatdau.setText(k);
		if(l != null) txtketthuc.setText(l);
	}

}
