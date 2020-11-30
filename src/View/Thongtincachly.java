package View;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import Object.ttcachly;
import Object.ttkhaibao;
import data.ttkhaibao_mt;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Thongtincachly extends JPanel {

	/**
	 * Create the panel.
	 */
	private static String[] columns_cly= {
			"Mã cách ly","ID Nhân khẩu","Họ tên","Ngày bắt đầu","Mức độ cách ly","Nơi cách ly","Đã test","Ngày kết thúc"
	};
	private static JTable table;
	public Thongtincachly() {
		setLayout(null);
		
		JButton btnNew = new JButton("New");
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				themmoi.setResizable(false);
				new Themmoicachly().setVisible(true);
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNew.setBounds(781, 10, 85, 30);
		add(btnNew);
		
		table=new JTable(){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		List<ttcachly> list_cly=ttkhaibao_mt.getttcachly();
//		table.setModel(ttkhaibao_mt.getTableModel_cl(list_cly, columns_cly));
		updatetable();
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(911, 10, 85, 30);
		add(btnNewButton_1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 1080, 520);
		scrollPane.setViewportView(table);
		add(scrollPane);
	}
	public  static void updatetable() {
		List<ttcachly> list_cly=ttkhaibao_mt.getttcachly();
		table.setModel(ttkhaibao_mt.getTableModel_cl(list_cly, columns_cly));
	}

}
