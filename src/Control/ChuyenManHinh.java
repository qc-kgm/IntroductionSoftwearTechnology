package Control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Object.Menu;
import View.QLDancu;
import View.QLcovid;
import View.Thongkecovid;

import javax.swing.JPanel;


public class ChuyenManHinh {
	private JPanel view;
	
	public ChuyenManHinh(JPanel view) {
		this.view = view;

	}
	public void setView(JPanel views) {
//		jpn.setBackground(new Color(100,100,100));
//		jlb.setBackground(new Color(100,100,100));
		view.removeAll();
		view.setLayout(new BorderLayout());
		view.add(views);
		//Menu[i] truyen vao mang menu va thu tu (switch case) 
		view.validate();
		view.repaint();
	}
	public void setEventMenu(Menu []a) {
//		for(Menu s :a) {
//			s.getJpn().addMouseListener(new ClickEvent(s.getMenu(), s.getJpn(), s.getJlb()));
//		}
		a[0].getLabel().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse click done");
				markColorLabel(0, a);
//				a[0].getJpn().setBackground(new Color(100,100,100));
//				a[0].getJlb().setBackground(new Color(100,100,100));
//				setView(new QLDancu());
			}
		});
		a[1].getLabel().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse 2 click done");
				markColorLabel(1, a);
//				a[1].getJpn().setBackground(new Color(100,100,100));
//				a[1].getJlb().setBackground(new Color(100,100,100));
				setView(new QLDancu());
			}
		});
		a[2].getLabel().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse 2 click done");
				markColorLabel(2, a);
//				a[1].getJpn().setBackground(new Color(100,100,100));
//				a[1].getJlb().setBackground(new Color(100,100,100));
				//setView(new QLThuthuView());
				setView(new QLcovid());
			}
		});
		a[3].getLabel().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse 2 click done");
				markColorLabel(3, a);
//				a[1].getJpn().setBackground(new Color(100,100,100));
//				a[1].getJlb().setBackground(new Color(100,100,100));
				//setView(new QLThuthuView());
				setView(new Thongkecovid());
			}
		});
		a[3].getLabel().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse 2 click done");
				markColorLabel(3, a);
//				a[1].getJpn().setBackground(new Color(100,100,100));
//				a[1].getJlb().setBackground(new Color(100,100,100));
				//setView(new QLThuthuView());
			}
		});

	}
	public void markColorLabel(int i,Menu []m) {
		for(int j=0;j<4;j++) {
			if(j==i) {
				//m[j].getJpn().setBackground(new Color(45, 168, 51));
				m[j].getLabel().setBackground(new Color(45, 168, 51));
			}
			else {
//				m[j].getLabel().setBackground(new Color(100, 149, 237));
				m[j].getLabel().setBackground(new Color(100, 149, 237));
			}
		
	}
	
}
}