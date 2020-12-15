	package View;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Object.ttkhaibao;
import data.ttkhaibao_mt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

	public class Themmoikhaibao extends JFrame {

		private JPanel contentPane;
		private JTextField txtid;
		private JTextField txthoten;
		private JTextField txttuoi;
		private JTextField txttinhtrang;
		private JTextField txtlichsu;
		private JTextField txtcmnd;
		private JTextField txtmakb;



		/**
		 * Create the frame.
		 */
		public Themmoikhaibao() {
			setTitle("Khai bao ");
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setBounds(100, 100, 847, 678);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Họ và tên");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(111, 111, 121, 24);
			contentPane.add(lblNewLabel);
			
			JLabel lblId = new JLabel("ID nhân khẩu");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblId.setBounds(111, 65, 121, 24);
			contentPane.add(lblId);
			
			JLabel lblNgySinh = new JLabel("Tuổi");
			lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNgySinh.setBounds(111, 209, 121, 24);
			contentPane.add(lblNgySinh);
			
			JLabel lblTnhTrngSc = new JLabel("Tình trạng sức khỏe");
			lblTnhTrngSc.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTnhTrngSc.setBounds(111, 300, 155, 24);
			contentPane.add(lblTnhTrngSc);
			
			JLabel lblThiGianKhai = new JLabel("Thời gian khai báo");
			lblThiGianKhai.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblThiGianKhai.setBounds(111, 346, 155, 24);
			contentPane.add(lblThiGianKhai);
			
			JLabel lblLchSi = new JLabel("Lịch sử đi lại");
			lblLchSi.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLchSi.setBounds(111, 394, 121, 24);
			contentPane.add(lblLchSi);
			
			txtid = new JTextField();
			txtid.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtid.setBounds(283, 59, 319, 36);
			contentPane.add(txtid);
			txtid.setColumns(10);
			
			JButton btncancel = new JButton("Cancel");
			btncancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btncancel.setBounds(508, 532, 94, 36);
			contentPane.add(btncancel);
			
			JButton btnsave = new JButton("Save");
			btnsave.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnsave.setBackground(Color.CYAN);
			btnsave.setBounds(659, 532, 94, 36);
			contentPane.add(btnsave);
			
			txthoten = new JTextField();
			txthoten.setEditable(false);
			txthoten.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txthoten.setColumns(10);
			txthoten.setBounds(283, 105, 319, 36);
			contentPane.add(txthoten);
			
			txttuoi = new JTextField();
			txttuoi.setEditable(false);
			txttuoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txttuoi.setColumns(10);
			txttuoi.setBounds(283, 197, 319, 36);
			contentPane.add(txttuoi);
			
			txttinhtrang = new JTextField();
			txttinhtrang.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txttinhtrang.setColumns(10);
			txttinhtrang.setBounds(283, 294, 319, 36);
			contentPane.add(txttinhtrang);    
			
			txtlichsu = new JTextField();
			txtlichsu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtlichsu.setColumns(10);
			txtlichsu.setBounds(283, 386, 319, 68);
			contentPane.add(txtlichsu);
			
			JLabel lblSCmnd = new JLabel("Số CMND");
			lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSCmnd.setBounds(111, 157, 121, 24);
			contentPane.add(lblSCmnd);
			
			txtcmnd = new JTextField();
			txtcmnd.setEditable(false);
			txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtcmnd.setColumns(10);
			txtcmnd.setBounds(283, 151, 319, 36);
			contentPane.add(txtcmnd);
			
			JLabel lblMKhaiBo = new JLabel("Mã khai báo");
			lblMKhaiBo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMKhaiBo.setBounds(111, 249, 121, 24);
			contentPane.add(lblMKhaiBo);
			
			txtmakb = new JTextField();
			txtmakb.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtmakb.setColumns(10);
			txtmakb.setBounds(283, 243, 319, 36);
			contentPane.add(txtmakb);
			
			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(283, 340, 319, 36);
			contentPane.add(dateChooser);
			txtid.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					if(txtid.getText().trim().length()!=0) {
					int s=Integer.parseInt(txtid.getText().toString().trim());
					txthoten.setText(ttkhaibao_mt.findhoten(s));
					txtcmnd.setText(ttkhaibao_mt.findCMND(s));
					txttuoi.setText(String.valueOf(ttkhaibao_mt.calYearold(s)));
					}
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					if(txtid.getText().trim().length()!=0) {
					int s=Integer.parseInt(txtid.getText().toString().trim());
					txthoten.setText(ttkhaibao_mt.findhoten(s));
					txtcmnd.setText(ttkhaibao_mt.findCMND(s));
					txttuoi.setText(String.valueOf(ttkhaibao_mt.calYearold(s)));

					}
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					if(txtid.getText().trim().length()!=0) {
					int s=Integer.parseInt(txtid.getText().toString().trim());
					txthoten.setText(ttkhaibao_mt.findhoten(s));
					txtcmnd.setText(ttkhaibao_mt.findCMND(s));
					txttuoi.setText(String.valueOf(ttkhaibao_mt.calYearold(s)));
					}
				}
			});
			btncancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});

			btnsave.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						ttkhaibao ex=new ttkhaibao();
						ex.setHoten(txthoten.getText().trim());
						ex.setId_nk(Integer.parseInt(txtid.getText().trim()));
						ex.setLichsu_dilai(txtlichsu.getText().trim());
						String dateinput= new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
						ex.setNgaykhaibao(java.sql.Date.valueOf(dateinput));
						ex.setTinhtrang_sk(txttinhtrang.getText().trim());
						ex.setMa_kb(txtmakb.getText().trim());
						ttkhaibao_mt.Insertkhaibao(ex);
						Thongtinkhaibao.updatetable();
						dispose();
						
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Thêm khai báo thất bại","Error",JOptionPane.WARNING_MESSAGE);
						String dateinput= new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
						System.out.println("\n"+dateinput+"\n");
					}
					
				}
			});
			
		}
	}
