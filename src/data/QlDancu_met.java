package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Object.ho_gd;
import Object.nhan_khau;
public class QlDancu_met {

	public static List<ho_gd> getHoGD(){
		Statement stt;
		ResultSet res;
		String sql="select * from ho_gia_dinh order by chu_ho asc";
		List<ho_gd> list_hogd=new ArrayList<>();
		try {
			stt=ConnectDB.toconnection().createStatement();
			res= stt.executeQuery(sql);
			while(res.next()) {
				
				ho_gd vd=new ho_gd();
				vd.setDia_chi(res.getString(2));
				vd.setTen_chu_ho(res.getString(3));
				vd.setMa_hogd(res.getString(1));
				vd.setSo_tv(res.getInt(4));
				list_hogd.add(vd);
			}
			stt.close();
			res.close();
		}
		catch (Exception e) {
			System.out.println("Loi khi get list ho gia dinh");
		}
		return list_hogd;
	}
	
	public static List<nhan_khau> getNhankhau(){
		Statement stt;
		String sql="select * from nhan_khau order by ID_nhan_khau asc";
		ResultSet res;
		List<nhan_khau> list_nhkhau=new ArrayList<>();
		try {
			stt=ConnectDB.toconnection().createStatement();
			res= stt.executeQuery(sql);
			while(res.next()) {
				nhan_khau nk=new nhan_khau();
				nk.setId_nkhau(res.getInt(1));
				nk.setMa_hogd(res.getString(3));
				nk.setNoi_lam_viec(res.getString(4));
				nk.setSo_cmnd(res.getBigDecimal(2));
				nk.setSo_dt(res.getString(5));
				nk.setHo_ten(res.getString(6));
				nk.setNgay_sinh(res.getDate(7));
				nk.setGioitinh(res.getString(8));
				list_nhkhau.add(nk);
			}
			res.close();
			stt.close();
		}
		catch (Exception e) {
			System.out.println("Loi khi get list nhan khau");
		}
		return list_nhkhau;
	}
	
	
	public static DefaultTableModel getTableModel(List<ho_gd> hogd,String []listColumns) {
		DefaultTableModel modeldf=new DefaultTableModel();
		modeldf.setColumnIdentifiers(listColumns);
		ho_gd vd=null;
		Object []obj;
		for(int i=0;i<hogd.size();i++) {
			vd=hogd.get(i);
			obj=new Object[listColumns.length];
			obj[0]=vd.getMa_hogd();
			obj[1]=vd.getTen_chu_ho();
			obj[2]=vd.getDia_chi();
			obj[3]=vd.getSo_tv();
			modeldf.addRow(obj);
			
			
		}
		System.out.println("add thanh cong");
		return modeldf;
	}
	public static DefaultTableModel getTableModel_nk(List<nhan_khau> nh_kh,String []listColumns) {
		DefaultTableModel modeldf=new DefaultTableModel();
		modeldf.setColumnIdentifiers(listColumns);
		nhan_khau vd=null;
		Object []obj;
		for(int i=0;i<nh_kh.size();i++) {
			vd=nh_kh.get(i);
			obj=new Object[listColumns.length];
			obj[0]=vd.getId_nkhau();
			obj[1]=vd.getMa_hogd();
			obj[2]=vd.getHo_ten();
			obj[3]=vd.getGioitinh();
			obj[6]=vd.getSo_dt();
			obj[5]=vd.getNoi_lam_viec();
			obj[7]=vd.getSo_cmnd();
			obj[4]=vd.getNgay_sinh();
			modeldf.addRow(obj);
			
			
		}
		System.out.println("add thanh cong");
		return modeldf;
	}
}
