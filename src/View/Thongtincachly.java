package View;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import Object.ttcachly;
import Object.ttkhaibao;
import data.ttkhaibao_mt;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Thongtincachly extends JPanel {

	/**
	 * Create the panel.
	 */
	private static String[] columns_cly= {
			"Mã cách ly","ID Nhân khẩu","Họ tên","Ngày bắt đầu","Mức độ cách ly","Nơi cách ly","Đã test","Ngày kết thúc"
	};
	private static String[] now=new String[9];
	private static JTable table;
	private JTextField txtfind;
	public Thongtincachly() {
		setLayout(null);
		
		JButton btnnew = new JButton("New");
		btnnew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				themmoi.setResizable(false);
				new Themmoicachly().setVisible(true);
			}
		});
		btnnew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnnew.setBounds(1005, 50, 85, 48);
		add(btnnew);
		JButton btnedit = new JButton("Edit");
		btnedit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnedit.setBounds(1005, 111, 85, 48);
		btnedit.setEnabled(false);
		add(btnedit);
		JButton btnketqua = new JButton("KQ test");
		btnketqua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnketqua.setBounds(1005, 169, 85, 48);
		btnketqua.setEnabled(false);
		add(btnketqua);
		
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
					now[3]=model.getValueAt(selectedRow, 0).toString();
					now[4]=model.getValueAt(selectedRow, 5).toString();
					now[5]=model.getValueAt(selectedRow, 4).toString();
					if(model.getValueAt(selectedRow, 6).toString()=="Đã test") now[6]="yes";
					else now[6]="no";
					now[7]=model.getValueAt(selectedRow, 3).toString();
					if(model.getValueAt(selectedRow, 7) != null) now[8]=model.getValueAt(selectedRow, 7).toString();
					else now[8]=null;
					btnedit.setEnabled(true);
					btnketqua.setEnabled(true);
					
				}
			}
		});
//		List<ttcachly> list_cly=ttkhaibao_mt.getttcachly();
//		table.setModel(ttkhaibao_mt.getTableModel_cl(list_cly, columns_cly));
		updatetable();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 979, 520);
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		
		btnketqua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		
		txtfind = new JTextField();
		txtfind.setBounds(126, 9, 231, 31);
		add(txtfind);
		txtfind.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(40, 9, 76, 30);
		add(lblNewLabel);
		btnedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Editttcachly editcl= new Editttcachly();
				editcl.hienthinoidung(now[0], now[1], now[2], now[3], now[4], now[5], now[6], now[7], now[8]);
				editcl.setVisible(true);
			}
		});
		txtfind.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(txtfind.getText().trim().length()!=0) {
					List<ttcachly> list_cly=ttkhaibao_mt.findbyallcl(txtfind.getText().trim());
					table.setModel(ttkhaibao_mt.getTableModel_cl(list_cly, columns_cly));
				}
				else updatetable();
				
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(txtfind.getText().trim().length()!=0) {
					List<ttcachly> list_cly=ttkhaibao_mt.findbyallcl(txtfind.getText().trim());
					table.setModel(ttkhaibao_mt.getTableModel_cl(list_cly, columns_cly));
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
		btnketqua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(now[3]!=null) {
				
				Ketquatest.maso=now[3];
				Ketquatest.labelten=now[1];
				Ketquatest kq=new Ketquatest();
				kq.setVisible(true);
				}
			}
		});
	}
	
	public  static void updatetable() {
		List<ttcachly> list_cly=ttkhaibao_mt.getttcachly();
		table.setModel(ttkhaibao_mt.getTableModel_cl(list_cly, columns_cly));
	}
}
