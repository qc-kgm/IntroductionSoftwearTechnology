package View;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Object.ho_gd;
import Object.nhan_khau;
import data.QlDancu_met;

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

public class QLDancu extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	private String[] loai= {
			"Hộ gia đình","Nhân khẩu"
	};
	private static String[] columns_hogd= {
			"Mã hộ gia đình","Tên chủ hộ ","Địa chỉ","Số thành viên"
	};
	private static String[] columns_nh_khau= {
			"ID Nhân khẩu","Mã hộ gia đình","Họ và tên","Giới tính","Ngày sinh","Nơi làm việc","Số điện thoại","Số CMND"
	};
	
	public QLDancu() {
		setLayout(null);
		List<ho_gd> list_ho_gd=QlDancu_met.getHoGD();
		List <nhan_khau> list_nhan_khau=QlDancu_met.getNhankhau();
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
				case "Hộ gia đình": {
					table.setModel(QlDancu_met.getTableModel(list_ho_gd, columns_hogd));
//					table.setBounds(10, 45, 1092, 563);
					System.out.println("add table ho gia dinh");
					//add(table);
					break;
				}
				case "Nhân khẩu":{
					table.setModel(QlDancu_met.getTableModel_nk(list_nhan_khau, columns_nh_khau));
//					table.setBounds(10, 45, 1092, 563);
					System.out.println("add table nhan khau");
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
		
		JLabel lblNewLabel = new JLabel("Danh sách các nhân khẩu ,hộ gia đinh thuộc phường Bách Khoa");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(212, 6, 606, 39);
		add(lblNewLabel);
//		add(table);

		
//		table_1 = new JTable();
//		table_1.setBounds(10, 63, 1088, 545);
//		add(table_1);

	}
}
