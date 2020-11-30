package View;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Object.ttkhaibao;
import data.ttkhaibao_mt;

public class Thongtinkhaibao extends JPanel {

	/**
	 * Create the panel.
	 */
	private String[] columns_kb= {
			"ID Nhân khẩu","Họ tên","Ngày sinh","Thời gian khai báo","Tình trạng sức khỏe","Lịch sử đi lại","Liên quan đến vùng dịch"
	};
	
	public Thongtinkhaibao() {
		setLayout(null);
		
		JButton btnNew = new JButton("New");
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNew.setBounds(781, 10, 85, 21);
		add(btnNew);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(911, 10, 85, 21);
		add(btnNewButton_1);
		
		JTable table=new JTable(){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		List<ttkhaibao> list_kb=ttkhaibao_mt.getttkhaibao();
		table.setModel(ttkhaibao_mt.getTableModel_kb(list_kb, columns_kb));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 1080, 514);
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		
	}
}
