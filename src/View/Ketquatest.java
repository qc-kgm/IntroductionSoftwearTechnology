package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import Object.ketquatest;

import java.util.List;
import data.ketquatest_mt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

public class Ketquatest extends JFrame {

	private JPanel contentPane;
	private JTextField txtmaso;
	private JFormattedTextField txtlantest;
	private JTextField txtthoigian;
	public static String maso;
	public static String labelten;
	private static String m;
	public static String[] listColumns = {
			"Mã số cách ly","Lần test","Kết quả test","Thời điểm test"
	};
	private static JTable table;
	public Ketquatest() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 810, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(139, 10, 540, 46);
		contentPane.add(lblNewLabel);
		
		table=new JTable(){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
	       List<ketquatest> listkq=ketquatest_mt.getlistketquatest(maso);
	       DefaultTableModel dtm=ketquatest_mt.getdefaulttablemodel_ketquatest(listkq, listColumns);
	       table.setModel(dtm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 704, 282);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		JButton btnNew = new JButton("+");
		btnNew.setForeground(Color.RED);
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNew.setBounds(729, 379, 57, 46);
		contentPane.add(btnNew);
		
		txtmaso = new JTextField();
		txtmaso.setEditable(false);
		txtmaso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmaso.setBounds(10, 379, 188, 46);
		contentPane.add(txtmaso);
		txtmaso.setColumns(10);
		txtmaso.setText(maso);
		

		
		txtthoigian = new JTextField();
		txtthoigian.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtthoigian.setColumns(10);
		txtthoigian.setBounds(632, 11, 164, 46);
		//contentPane.add(txtthoigian);
		String e="Kết quả test của bệnh nhân : "+labelten;
		lblNewLabel.setText(e);
		
		JRadioButton yes = new JRadioButton("Dương tính");
		yes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		yes.setBounds(409, 379, 103, 21);
		contentPane.add(yes);
		
		JRadioButton no = new JRadioButton("Âm tính");
		no.setFont(new Font("Tahoma", Font.PLAIN, 14));
		no.setBounds(409, 414, 103, 21);
		contentPane.add(no);
		ButtonGroup group=new ButtonGroup();
		group.add(yes);
		group.add(no);
		
		
		
		NumberFormat format=NumberFormat.getInstance();
		NumberFormatter formatter =new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
		txtlantest = new JFormattedTextField(formatter);
		txtlantest.setEditable(false);
		txtlantest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtlantest.setColumns(10);
		txtlantest.setBounds(208, 379, 157, 46);
		contentPane.add(txtlantest);
		DefaultTableModel d=(DefaultTableModel) table.getModel();
		
		try {
			int temp= Integer.parseInt(d.getValueAt(d.getRowCount()-1,1 ).toString())+1;
			m=String.valueOf(temp);
			
			
		} catch (Exception e2) {
			// TODO: handle exception
			m="1";
		}
		txtlantest.setText(m);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(550, 379, 164, 46);
		contentPane.add(dateChooser);
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				ketquatest kq=new ketquatest();
				kq.setMasocl(txtmaso.getText().trim());
				//if(txtlantest.getText()) kq.setKetqua();
				kq.setLantest(Integer.parseInt(txtlantest.getText()));
				if(yes.isSelected()) kq.setKetqua(true); if(no.isSelected()) kq.setKetqua(false);
				String dateinput=new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
				//kq.setThoigian(java.sql.Date.valueOf(txtthoigian.getText().trim()));
				//kq.setThoigian(dateChooser.getDate());
				kq.setThoigian(java.sql.Date.valueOf(dateinput));
				int a= ketquatest_mt.insertkq(kq);
				if(a==1) {
					txtlantest.setText(null);
					//txtthoigian.setText(null);
					yes.setSelected(false);no.setSelected(false);
					updatetale();
				}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showInternalMessageDialog(null,"Thêm kết quả test thất bại","Error",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}
	private void updatetale() {
		List<ketquatest> listkq=ketquatest_mt.getlistketquatest(maso);
	    DefaultTableModel dtm=ketquatest_mt.getdefaulttablemodel_ketquatest(listkq, listColumns);
	    table.setModel(dtm);
	}
}
