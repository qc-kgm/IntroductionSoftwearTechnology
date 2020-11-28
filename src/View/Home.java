package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Control.ChuyenManHinh;
import Object.Menu;
import data.ConnectDB;

public class Home extends JFrame {

	private JPanel contentPane;
	private Menu[]menu;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 1378, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ConnectDB.toconnection();
		
		JLabel lblNewLabel = new JLabel("                            UBND Xã ...............");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 36));
		lblNewLabel.setBounds(0, 0, 1364, 113);
		contentPane.add(lblNewLabel);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.LIGHT_GRAY);
		panelMenu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelMenu.setBounds(0, 112, 252, 618);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel trang_chu = new JLabel("HOME");
		trang_chu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		trang_chu.setBackground(Color.GREEN);
		trang_chu.setOpaque(true);
		trang_chu.setFont(new Font("Arial", Font.BOLD, 16));
		trang_chu.setBounds(0, 39, 252, 97);
		panelMenu.add(trang_chu);
		
		JLabel dan_cu = new JLabel("QL DÂN CƯ");
		dan_cu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		dan_cu.setOpaque(true);
		dan_cu.setBackground(Color.GREEN);
		dan_cu.setToolTipText("");
		dan_cu.setFont(new Font("Arial", Font.BOLD, 16));
		dan_cu.setBounds(0, 161, 252, 97);
		panelMenu.add(dan_cu);
		
		JLabel qlcovid = new JLabel("QL COVID");
		qlcovid.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		qlcovid.setBackground(Color.GREEN);
		qlcovid.setOpaque(true);
		qlcovid.setFont(new Font("Arial", Font.BOLD, 16));
		qlcovid.setBounds(0, 280, 252, 97);
		panelMenu.add(qlcovid);
		
		JLabel thong_ke = new JLabel("THỐNG KÊ COVID");
		thong_ke.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		thong_ke.setBackground(Color.GREEN);
		thong_ke.setOpaque(true);
		thong_ke.setFont(new Font("Arial", Font.BOLD, 16));
		thong_ke.setBounds(0, 407, 252, 97);
		panelMenu.add(thong_ke);
		
		JPanel View = new JPanel();
		View.setBounds(256, 112, 1108, 618);
		contentPane.add(View);
//		System.out.println("add view");
//		View.removeAll();
//		View.add(new QLDancu());
//		View.validate();
//		View.repaint();
//		System.out.println("add ql");

		menu= new Menu[4];
		menu[0]=new Menu(0, trang_chu);
		menu[1]=new Menu(1,dan_cu);
		menu[2]= new Menu(2,qlcovid);
		menu[3]=new Menu(3,thong_ke);
		ChuyenManHinh switchscreen =new ChuyenManHinh(View);
		switchscreen.setEventMenu(menu);
	}
}
