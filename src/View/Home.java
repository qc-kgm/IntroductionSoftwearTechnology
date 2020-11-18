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

public class Home extends JFrame {

	private JPanel contentPane;

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
		
		JLabel lblNewLabel = new JLabel("                            UBND Xã ...............");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 36));
		lblNewLabel.setBounds(0, 0, 1364, 113);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 112, 252, 618);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel trang_chu = new JLabel("HOME");
		trang_chu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		trang_chu.setBackground(Color.GREEN);
		trang_chu.setOpaque(true);
		trang_chu.setFont(new Font("Arial", Font.BOLD, 16));
		trang_chu.setBounds(0, 39, 252, 97);
		panel.add(trang_chu);
		
		JLabel dan_cu = new JLabel("QL DÂN CƯ");
		dan_cu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		dan_cu.setOpaque(true);
		dan_cu.setBackground(Color.GREEN);
		dan_cu.setToolTipText("");
		dan_cu.setFont(new Font("Arial", Font.BOLD, 16));
		dan_cu.setBounds(0, 161, 252, 97);
		panel.add(dan_cu);
		
		JLabel dan_cu_1 = new JLabel("QL COVID");
		dan_cu_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		dan_cu_1.setBackground(Color.GREEN);
		dan_cu_1.setOpaque(true);
		dan_cu_1.setFont(new Font("Arial", Font.BOLD, 16));
		dan_cu_1.setBounds(0, 280, 252, 97);
		panel.add(dan_cu_1);
		
		JLabel trang_chu_1 = new JLabel("THỐNG KÊ COVID");
		trang_chu_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		trang_chu_1.setBackground(Color.GREEN);
		trang_chu_1.setOpaque(true);
		trang_chu_1.setFont(new Font("Arial", Font.BOLD, 16));
		trang_chu_1.setBounds(0, 407, 252, 97);
		panel.add(trang_chu_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(256, 112, 1108, 618);
		contentPane.add(panel_1);
	}
}
