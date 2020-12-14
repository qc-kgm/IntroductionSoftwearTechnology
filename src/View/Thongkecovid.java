package View;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Object.ho_gd;
import Object.nhan_khau;
import Object.ttcachly;
import data.ttkhaibao_mt;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class Thongkecovid extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	private String[] loai= {
			"Muc do cach ly"
	};
	private static String[] columns_cly= {
			"Mã cách ly","ID Nhân khẩu","Họ tên","Mức độ cách ly"
	};
	
	public Thongkecovid() {
		setLayout(null);
		List<ttcachly> list_tkcovid=ttkhaibao_mt.gettkcovid();
		table = new JTable(){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.setModel(QlDancu_met.getTableModel(list_ho_gd, QlDancu_met.columns_hogd));
//		table.setBounds(10, 45, 1092, 563);
//		System.out.println("add tabel ho gia dinh");
//		add(table);
		
		JComboBox comboBox = new JComboBox(loai);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(923, 10, 130, 32);
		add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch ((String)comboBox.getSelectedItem()) {
				case "Muc do cach ly": {
					table.setModel(ttkhaibao_mt.getTableModel_tk(list_tkcovid, columns_cly));
//					table.setBounds(10, 45, 1092, 563);
					System.out.println("add column F0");
					//add(table);
					break;
				}
				
			}
			}
		});
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setBounds(10,60,1085,545);
		scrollpane.setViewportView(table);
		add(scrollpane);
		
		JLabel lblNewLabel = new JLabel("Danh sách các nhân khẩu liên quan vùng dịch thuộc phường Bách Khoa");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(200, 6, 1000, 39);
		add(lblNewLabel);
//		add(table);

		
//		table_1 = new JTable();
//		table_1.setBounds(10, 63, 1088, 545);
//		add(table_1);

	}
}
