package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Object.nhan_khau;
import Object.ttcachly;
import data.ttkhaibao_mt;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

public class Themmoicachly extends JFrame {

	private JPanel contentPane;
	private JTextField txthoten;
	private JTextField txtcmnd;
	private JTextField txtid;
	private JTextField txtnoicl;
	private JTextField txtmucdo;
	private JTextField txtmacl;
	private JTextField txtbatdau;
	private JTextField txtketthuc;
	public static ttcachly ex=new ttcachly();
	public static nhan_khau ex2=new nhan_khau();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Themmoicachly frame = new Themmoicachly();
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
	public Themmoicachly() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 912, 678);
		setTitle("Thêm mới người cách ly");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel hoten = new JLabel("Họ tên");
		hoten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hoten.setBounds(106, 198, 76, 27);
		contentPane.add(hoten);
		
		JLabel lblSCmnd = new JLabel("Số CMND");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSCmnd.setBounds(96, 156, 76, 27);
		contentPane.add(lblSCmnd);
		
		JLabel id_nk = new JLabel("ID nhân khẩu");
		id_nk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		id_nk.setBounds(96, 107, 96, 27);
		contentPane.add(id_nk);
		
		JLabel macl = new JLabel("Mã cách ly");
		macl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		macl.setBounds(96, 249, 76, 27);
		contentPane.add(macl);
		
		JLabel noicl = new JLabel("Nơi cách ly");
		noicl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		noicl.setBounds(96, 293, 112, 27);
		contentPane.add(noicl);
		
		JLabel mucdo = new JLabel("Mức độ cách ly");
		mucdo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mucdo.setBounds(96, 338, 142, 27);
		contentPane.add(mucdo);
		
		JLabel batdau = new JLabel("Ngày bắt đầu");
		batdau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		batdau.setBounds(96, 430, 112, 27);
		contentPane.add(batdau);
		
		JLabel ketthuc = new JLabel("Ngày kết thúc");
		ketthuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ketthuc.setBounds(96, 483, 112, 27);
		contentPane.add(ketthuc);
		
		JLabel test = new JLabel("Test");
		test.setFont(new Font("Tahoma", Font.PLAIN, 16));
		test.setBounds(96, 389, 76, 27);
		contentPane.add(test);
		
		txthoten = new JTextField();
		txthoten.setEditable(false);
		txthoten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txthoten.setBounds(235, 193, 288, 36);
		contentPane.add(txthoten);
		txthoten.setColumns(10);
		
		txtcmnd = new JTextField();
		txtcmnd.setEditable(false);
		txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(235, 147, 288, 36);
		contentPane.add(txtcmnd);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtid.setColumns(10);
		txtid.setBounds(235, 102, 288, 36);
		contentPane.add(txtid);
		
		txtnoicl = new JTextField();
		txtnoicl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtnoicl.setColumns(10);
		txtnoicl.setBounds(235, 287, 288, 36);
		contentPane.add(txtnoicl);
		
		txtmucdo = new JTextField();
		txtmucdo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmucdo.setColumns(10);
		txtmucdo.setBounds(235, 333, 288, 36);
		contentPane.add(txtmucdo);
		
		txtmacl = new JTextField();
		txtmacl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmacl.setColumns(10);
		txtmacl.setBounds(235, 239, 288, 36);
		contentPane.add(txtmacl);
		
//		txtbatdau = new JTextField();
//		txtbatdau.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		txtbatdau.setColumns(10);
//		txtbatdau.setBounds(680, 193, 69, 36);
//		contentPane.add(txtbatdau);
//		
//		txtketthuc = new JTextField();
//		txtketthuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		txtketthuc.setColumns(10);
//		txtketthuc.setBounds(707, 244, 52, 36);
//		contentPane.add(txtketthuc);
		
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
		
		JRadioButton yes = new JRadioButton("Đã Test");
		yes.setFont(new Font("Tahoma", Font.BOLD, 16));
		yes.setBounds(235, 379, 96, 37);
		contentPane.add(yes);
		
		JRadioButton no = new JRadioButton("Chưa Test");
		no.setFont(new Font("Tahoma", Font.BOLD, 16));
		no.setBounds(347, 379, 112, 37);
		contentPane.add(no);
		ButtonGroup group= new ButtonGroup();
		group.add(no);
		group.add(yes);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(235, 422, 288, 36);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_kt = new JDateChooser();
		dateChooser_kt.setBounds(235, 473, 288, 36);
		contentPane.add(dateChooser_kt);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ex.setId_nk(Integer.parseInt(txtid.getText().toString().trim()));
				String dateinput= new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
				ex.setBatdau(java.sql.Date.valueOf(dateinput));
//				ex.setBatdau(java.sql.Date.valueOf(txtbatdau.getText().toString().trim()));
//				if(txtketthuc.getText().trim().equals("")) ex.setKetthuc(null);
//				else ex.setKetthuc(java.sql.Date.valueOf(txtketthuc.getText().toString().trim()));
				try {
					String dateouput=new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_kt.getDate());
					ex.setKetthuc(java.sql.Date.valueOf(dateouput));
				} catch (Exception e2) {
					// TODO: handle exception
					ex.setKetthuc(null);
				}
				
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

				//ex.setDatest(textField_8);
			}
		});
		 txtid.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(txtid.getText().trim().length()!=0) {
				int s=Integer.parseInt(txtid.getText().toString().trim());
				txthoten.setText(ttkhaibao_mt.findhoten(s));
				txtcmnd.setText(ttkhaibao_mt.findCMND(s));
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(txtid.getText().trim().length()!=0) {
				int s=Integer.parseInt(txtid.getText().toString().trim());
				txthoten.setText(ttkhaibao_mt.findhoten(s));
				txtcmnd.setText(ttkhaibao_mt.findCMND(s));
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(txtid.getText().trim().length()!=0) {
				int s=Integer.parseInt(txtid.getText().toString().trim());
				txthoten.setText(ttkhaibao_mt.findhoten(s));
				txtcmnd.setText(ttkhaibao_mt.findCMND(s));
				}
			}
		});
	}
}
