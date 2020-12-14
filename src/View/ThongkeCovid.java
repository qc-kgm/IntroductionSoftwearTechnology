package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Object.ttcachly;
import data.thongkedata;
import data.ttkhaibao_mt;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

public class ThongkeCovid extends JPanel {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTable table;
	private static 	JLabel lbl2;
	private String[] mucdo= {
			"F0","F1","F2","F3","Tất cả"
	};
	private static String[] columns_cly= {
			"Mã cách ly","ID Nhân khẩu","Họ tên","Ngày bắt đầu","Mức độ cách ly","Nơi cách ly","Đã test","Ngày kết thúc"
	};
	private static String mucdocuthe;
	private static String date;
	private static String date1;
	/**
	 * Create the panel.
	 */
	
	public ThongkeCovid() {
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Tổng số ca bệnh được cách ly : ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(26, 0, 226, 47);
		add(lblNewLabel);
		
		JLabel lblSTrngHp = new JLabel("Tổng số trường hợp không còn bị cách ly : ");
		lblSTrngHp.setForeground(Color.RED);
		lblSTrngHp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTrngHp.setBounds(371, 0, 304, 47);
		add(lblSTrngHp);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setBounds(262, 6, 45, 35);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(682, 6, 52, 35);
		add(textField_1);
		
		JComboBox comboBox = new JComboBox(mucdo);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(167, 62, 108, 35);
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Mức độ cách ly");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(26, 56, 120, 42);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Từ ngày : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(339, 55, 80, 42);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Đến ngày : ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(586, 55, 89, 42);
		add(lblNewLabel_1_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(415, 62, 147, 29);
		add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(690, 62, 147, 29);
		add(dateChooser_1);
		table=new JTable(){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 160, 1107, 452);
		scrollPane.setViewportView(table);
		add(scrollPane);

		JButton btnthongke = new JButton("Thống kê");
		btnthongke.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnthongke.setBounds(895, 52, 108, 51);
		add(btnthongke);
		
		 lbl2 = new JLabel("");
		lbl2.setForeground(Color.RED);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl2.setBounds(26, 107, 809, 47);
		add(lbl2);
		btnthongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if((String) comboBox.getSelectedItem()=="Tất cả") mucdocuthe="F";
					else mucdocuthe=(String)comboBox.getSelectedItem();
					 date=new SimpleDateFormat("yyyy/MM/dd").format(dateChooser.getDate());
					 date1=new SimpleDateFormat("yyyy/MM/dd").format(dateChooser_1.getDate());
					 System.out.println(date);
					 System.out.println(date1);
					System.out.println(mucdocuthe);
				} catch (Exception e2) {
					// TODO: handle exception
					date=null;date1=null;
					e2.printStackTrace();
				}
				updatetable(date, date1, mucdocuthe);
			}
		});
	}
	public  static void updatetable(String a,String b,String c) {
		thongkedata thongke=new thongkedata();
		List<ttcachly> list_cly=thongke.thongkecuthe(a, b, c);
		table.setModel(ttkhaibao_mt.getTableModel_cl(list_cly, columns_cly));
		int arr[]= thongke.thongketheotongquat();
		textField.setText(String.valueOf(thongke.sncl));
		textField_1.setText(String.valueOf(thongke.snkb));
		textField.setText(String.valueOf(arr[0]));
		textField_1.setText(String.valueOf(arr[1]));
		lbl2.setText("Từ ngày "+date+" đến ngày "+date1+" có thêm "+thongke.tempcl+ " người bị cách ly , có "+thongke.tempkb+" người không còn bị cách ly ");
		
		
	}
}
