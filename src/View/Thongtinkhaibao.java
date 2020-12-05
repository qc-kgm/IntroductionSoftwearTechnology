package View;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import Object.ttcachly;
import Object.ttkhaibao;
import data.ttkhaibao_mt;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Thongtinkhaibao extends JPanel {

	/**
	 * Create the panel.
	 */
	private static String[] columns_kb= {
			"Mã khai báo","ID Nhân khẩu","Họ tên","Tuổi","Tình trạng sức khỏe","Lịch sử đi lại","Ngày khai báo"
	};
	private static JTable table;
	private static String[] now=new String[8];
	private JTextField txtfind;
	public Thongtinkhaibao() {
		setLayout(null);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNew.setBounds(1005, 51, 85, 47);
		add(btnNew);
		
		JButton btnedit = new JButton("Edit");
		btnedit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnedit.setBounds(1005, 123, 85, 47);
		btnedit.setEnabled(false);
		add(btnedit);
		
		table=new JTable(){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow()!=-1) {
					DefaultTableModel model= (DefaultTableModel)table.getModel();
					int selectedRow=table.getSelectedRow();
					now[0]=model.getValueAt(selectedRow, 1).toString();
					now[1]=model.getValueAt(selectedRow, 2).toString();
					//now[2]=model.getValueAt(selectedRow, 2).toString();//cmnd
					now[2]=ttkhaibao_mt.findCMND(Integer.parseInt(model.getValueAt(selectedRow, 1).toString()));
					now[3]=model.getValueAt(selectedRow, 3).toString();
					now[4]=model.getValueAt(selectedRow, 0).toString();
					now[5]=model.getValueAt(selectedRow, 4).toString();
					now[6]=model.getValueAt(selectedRow, 6).toString();
					now[7]=model.getValueAt(selectedRow, 5).toString();
					btnedit.setEnabled(true);
				}
			}
		});
		List<ttkhaibao> list_kb=ttkhaibao_mt.getttkhaibao();
		table.setModel(ttkhaibao_mt.getTableModel_kb(list_kb, columns_kb));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 985, 514);
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(69, 10, 76, 30);
		add(lblNewLabel);
		
		txtfind = new JTextField();
		txtfind.setColumns(10);
		txtfind.setBounds(155, 10, 231, 31);
		add(txtfind);
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Themmoikhaibao().setVisible(true);
			}
		});
		btnedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Editkhaibao editkb= new Editkhaibao();
				editkb.hienthinoidung(now[0], now[1], now[2], now[3], now[4], now[5], now[6], now[7]);
				editkb.setVisible(true);
			}
		});
		
txtfind.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(txtfind.getText().trim().length()!=0) {
					List<ttkhaibao> list_kb=ttkhaibao_mt.findbyallkb(txtfind.getText().trim());
					table.setModel(ttkhaibao_mt.getTableModel_kb(list_kb, columns_kb));
				}
				else updatetable();
				
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(txtfind.getText().trim().length()!=0) {
					List<ttkhaibao> list_kb=ttkhaibao_mt.findbyallkb(txtfind.getText().trim());
					table.setModel(ttkhaibao_mt.getTableModel_kb(list_kb, columns_kb));
				}
				else updatetable();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
//				if(txtfind.getText().trim().length()!=0) {
//					List<ttcachly> list_cly=ttkhaibao_mt.findbyallcl(txtfind.getText().trim());
//					table.setModel(ttkhaibao_mt.getTableModel_cl(list_cly, columns_cly));
//				}
//				else updatetable();
				
			}
		});
		
	}
	
	public static void updatetable() {
		List<ttkhaibao> list_kb=ttkhaibao_mt.getttkhaibao();
		table.setModel(ttkhaibao_mt.getTableModel_kb(list_kb, columns_kb));
	}
}
