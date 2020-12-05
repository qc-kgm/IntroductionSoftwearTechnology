package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Object.ketquatest;
import Object.ttkhaibao;
public class ketquatest_mt {
	public static List<ketquatest> getlistketquatest(String a) {
		List<ketquatest> listkq=new ArrayList<>();
		String sql="select ma_so_cach_ly,lan_test,ket_qua_test,thoi_gian_test from ket_qua_test where ma_so_cach_ly = '"+ a+"'";
		try {
			Statement stm=ConnectDB.toconnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			while(res.next()) {
				ketquatest kq=new ketquatest();
				kq.setMasocl(res.getString(1));
				kq.setKetqua(res.getBoolean(3));
				kq.setThoigian(res.getDate(4));
				kq.setLantest(res.getInt(2));
				listkq.add(kq);
			}
			stm.close();
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listkq;
	}
	public static DefaultTableModel getdefaulttablemodel_ketquatest(List<ketquatest> listkq,String []listColumns) {
		DefaultTableModel modeldf=new DefaultTableModel();
		modeldf.setColumnIdentifiers(listColumns);
		ketquatest vd=null;
		Object []obj;
		for(int i=0;i<listkq.size();i++) {
			vd=listkq.get(i);
			obj=new Object[listColumns.length];
			obj[0]=vd.getMasocl();
			obj[1]=vd.getLantest();
			if(vd.getKetqua()==true) obj[2]="Dương tính";else obj[2]="Âm tính";
			obj[3]=vd.getThoigian();
			modeldf.addRow(obj);
		}
		System.out.println("add thanh cong list ket qua test");
		return modeldf;
	}
	public static int insertkq(ketquatest kq) {
		String sql="insert into ket_qua_test values(?,?,?,?)";
		int genkey=0;
		try {
			PreparedStatement ps=ConnectDB.toconnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1,kq.getMasocl());
			ps.setDate(2,kq.getThoigian());
			ps.setBoolean(3, kq.getKetqua());
			ps.setInt(4, kq.getLantest());
			ps.execute();
			ResultSet res=ps.getGeneratedKeys();
			if(res.next()) {
				genkey=1;
				JOptionPane.showMessageDialog(null, "Thêm khai báo thành công");
			}
			res.close();
			ps.close();
			return genkey;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Thêm kết quả test thất bại","Error",JOptionPane.WARNING_MESSAGE);
		}
		return 0;
	}
}
