package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class trangchu extends JPanel {

	/**
	 * Create the panel.
	 */
	public trangchu() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("           Nhóm 6-Nhập môn CNPM");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 60));
		lblNewLabel.setBounds(0, 117, 1100, 271);
		add(lblNewLabel);
		
	}
}
