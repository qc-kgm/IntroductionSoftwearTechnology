package Object;

import javax.swing.JLabel;

public class Menu {
	private int menu;
	private JLabel label;
	public Menu() {
	}
	public Menu(int menu, JLabel label) {
		super();
		this.menu = menu;
		this.label = label;
	}
	public int getMenu() {
		return menu;
	}


	public void setMenu(int menu) {
		this.menu = menu;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
}
