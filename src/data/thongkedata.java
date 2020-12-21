package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Object.ttcachly;

public class thongkedata {
	public static int sncl;
	public static int snkb;
	public static int tempcl;
	public static int tempkb;
	public static int[] thongketheotongquat() {
		int tq[]=new int[2];
		String sql="select COUNT(ma_so_cach_ly) from thong_tin_cach_li ";
		String sql2="select COUNT(ma_so_cach_ly) from thong_tin_cach_li where thoi_gian_ket_thuc  is not null";
		try {
			Statement stm=ConnectDB.toconnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			res.next();
			tq[0]=res.getInt(1);
			res=stm.executeQuery(sql2);
			res.next();
			tq[1]=res.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tq;
	}
	public static List<ttcachly> thongkecuthe(String a,String b,String c) {
		String sql="select  ma_so_cach_ly,nhan_khau.ID_nhan_khau,ho_ten,thoi_gian_bat_dau,muc_do_cach_ly,noi_cach_ly,da_test_covid,thoi_gian_ket_thuc  "
				+ " from thong_tin_cach_li inner join nhan_khau on thong_tin_cach_li.ID_nhan_khau=nhan_khau.ID_nhan_khau  "
				+ " where (thoi_gian_bat_dau between '"+a+"' and '"+b+"' ) and muc_do_cach_ly like '%"+c+"%' order by thoi_gian_bat_dau asc";
		String sql2="select COUNT(ma_so_cach_ly) from thong_tin_cach_li where (thoi_gian_ket_thuc between '"+a+"' and '"+b+"' ) ";
		String sql3="select COUNT(ma_so_cach_ly) from thong_tin_cach_li where (thoi_gian_bat_dau between '"+a+"' and '"+b+"' ) ";
		 
		 
		List<ttcachly> list_ttcachly=new ArrayList<>();
		try {
			Statement stt=ConnectDB.toconnection().createStatement();
			ResultSet res= stt.executeQuery(sql);
			while(res.next()) {
				ttcachly vd=new ttcachly();
				vd.setMa_cachly(res.getInt(1));
				vd.setId_nk(res.getInt(2));
				vd.setHoten(res.getString(3));
				vd.setBatdau(res.getDate(4));
				vd.setMucdocachly(res.getString(5));
				vd.setNoicachly(res.getString(6));
				vd.setDatest(res.getBoolean(7));
				vd.setKetthuc(res.getDate(8));
				list_ttcachly.add(vd);
			}
			
			stt.close();
			res.close();
		}
		
		catch (Exception e) {
			System.out.println("Loi khi get list thong tin cach ly");
			e.printStackTrace();
		}
		try {
			Statement stt=ConnectDB.toconnection().createStatement();
			 ResultSet res= stt.executeQuery(sql2);
			 res.next();
			tempkb=res.getInt(1);
			ResultSet res1= stt.executeQuery(sql3);
			res1.next();
			tempcl=res1.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_ttcachly;
		
	}
}
