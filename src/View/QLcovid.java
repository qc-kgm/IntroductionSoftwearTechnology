package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;

import Object.ttcachly;

import java.awt.Rectangle;

public class QLcovid extends JPanel {

	/**
	 * Create the panel.
	 */
	public QLcovid() {
		setBackground(new Color(240,240,240));
		setLayout(null);
		JTabbedPane tabbedPanel=new JTabbedPane();
		tabbedPanel.setBounds(new Rectangle(0, 0, 1105, 610));
		Thongtinkhaibao khaibao_panel=new Thongtinkhaibao();
		//panel.setBackground(Color.ORANGE);
		tabbedPanel.addTab("Quản lí khai báo", null,khaibao_panel);
		Thongtincachly cachly=new Thongtincachly();
		tabbedPanel.addTab("Quản lí cách ly", null,cachly);
		add(tabbedPanel);
	}
}
