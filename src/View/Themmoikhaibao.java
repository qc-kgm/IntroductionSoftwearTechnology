package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;

public class Themmoikhaibao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Themmoikhaibao frame = new Themmoikhaibao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Themmoikhaibao() {
		setTitle("Khai b\u00E1o y t\u1EBF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Họ và tên");
		lblNewLabel.setBounds(10, 96, 121, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID nhân khẩu");
		lblId.setBounds(10, 131, 121, 24);
		contentPane.add(lblId);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setBounds(10, 166, 121, 24);
		contentPane.add(lblNgySinh);
		
		JLabel lblTnhTrngSc = new JLabel("Tình trạng sức khỏe");
		lblTnhTrngSc.setBounds(10, 201, 121, 24);
		contentPane.add(lblTnhTrngSc);
		
		JLabel lblThiGianKhai = new JLabel("Thời gian khai báo");
		lblThiGianKhai.setBounds(10, 236, 121, 24);
		contentPane.add(lblThiGianKhai);
		
		JLabel lblLchSi = new JLabel("Lịch sử đi lại");
		lblLchSi.setBounds(10, 271, 121, 24);
		contentPane.add(lblLchSi);
		
		textField = new JTextField();
		textField.setBounds(141, 98, 163, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 133, 163, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(141, 168, 163, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(141, 203, 163, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(141, 238, 163, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(141, 273, 163, 20);
		contentPane.add(textField_5);
		
		JLabel lblLinQuanTi = new JLabel("Liên quan đến vùng dịch");
		lblLinQuanTi.setBounds(10, 306, 117, 24);
		contentPane.add(lblLinQuanTi);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("C\u00F3");
		rdbtnNewRadioButton.setBounds(141, 307, 62, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnKhng = new JRadioButton("Kh\u00F4ng");
		rdbtnKhng.setBounds(242, 307, 62, 23);
		contentPane.add(rdbtnKhng);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(215, 410, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.GRAY);
		btnSave.setForeground(Color.BLACK);
		btnSave.setBounds(314, 410, 89, 23);
		contentPane.add(btnSave);
	}
}
