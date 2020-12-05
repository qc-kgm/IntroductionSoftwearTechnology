package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Object.ho_gd;
import Object.nhan_khau;
import Object.ttcachly;
import Object.ttkhaibao;

public class ttkhaibao_mt {
	public static List<ttkhaibao> getttkhaibao(){
		Statement stt;
		ResultSet res;
		String sql=" select ma_khai_bao,nhan_khau.ID_nhan_khau,ho_ten,tinh_trang_sk,lich_su_di_lai,thoi_gian_khai_bao "
				+ " from thong_tin_khai_bao join nhan_khau on thong_tin_khai_bao.ID_nhan_khau=nhan_khau.ID_nhan_khau ";
		List<ttkhaibao> list_ttkhaibao=new ArrayList<>();
		try {
			stt=ConnectDB.toconnection().createStatement();
			res= stt.executeQuery(sql);
			while(res.next()) {
				ttkhaibao vd=new ttkhaibao();
				vd.setId_nk(res.getInt(2));
				vd.setHoten(res.getString(3));
				vd.setTuoi(calYearold(vd.getId_nk()));
				vd.setTinhtrang_sk(res.getString(4));
				vd.setMa_kb(res.getString(1));
				vd.setLichsu_dilai(res.getString(5));
				vd.setNgaykhaibao(res.getDate(6));
				list_ttkhaibao.add(vd);
			}
			stt.close();
			res.close();
		}
		catch (Exception e) {
			System.out.println("Loi khi get list thong tin khai bao");
			e.printStackTrace();
		}
		return list_ttkhaibao;
	}
	public static List<ttcachly> getttcachly(){
		Statement stt;
		ResultSet res;
		String sql=" select ma_so_cach_ly,nhan_khau.ID_nhan_khau,ho_ten,thoi_gian_bat_dau,muc_do_cach_ly,noi_cach_ly,da_test_covid,thoi_gian_ket_thuc "
				+ " from thong_tin_cach_li inner join nhan_khau on thong_tin_cach_li.ID_nhan_khau=nhan_khau.ID_nhan_khau order by thoi_gian_bat_dau asc ";
		List<ttcachly> list_ttcachly=new ArrayList<>();
		try {
			stt=ConnectDB.toconnection().createStatement();
			res= stt.executeQuery(sql);
			while(res.next()) {
				ttcachly vd=new ttcachly();
				vd.setMa_cachly(res.getString(1));
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

		return list_ttcachly;
	}
	
	public static DefaultTableModel getTableModel_kb(List<ttkhaibao> khaibao,String []listColumns) {
		DefaultTableModel modeldf=new DefaultTableModel();
		modeldf.setColumnIdentifiers(listColumns);
		ttkhaibao vd=null;
		Object []obj;
		for(int i=0;i<khaibao.size();i++) {
			vd=khaibao.get(i);
			obj=new Object[listColumns.length];
			obj[1]=vd.getId_nk();
			obj[2]=vd.getHoten();
			obj[3]=vd.getTuoi();
			obj[4]=vd.getTinhtrang_sk();
			obj[0]=vd.getMa_kb();
			obj[5]=vd.getLichsu_dilai();
			obj[6]=vd.getNgaykhaibao();
			modeldf.addRow(obj);
		}
		System.out.println("add thanh cong list thong tin khai bao");
		return modeldf;
	}
	public static DefaultTableModel getTableModel_cl(List<ttcachly> cachly,String []listColumns) {
		DefaultTableModel modeldf=new DefaultTableModel();
		modeldf.setColumnIdentifiers(listColumns);
		ttcachly vd=null;
		Object []obj;
		for(int i=0;i<cachly.size();i++) {
			vd=cachly.get(i);
			obj=new Object[listColumns.length];
			obj[0]=vd.getMa_cachly();
			obj[1]=vd.getId_nk();
			obj[2]=vd.getHoten();
			obj[3]=vd.getBatdau();
			obj[4]=vd.getMucdocachly();
			obj[5]=vd.getNoicachly();
			obj[6]=vd.getDatest();
			if(vd.getDatest()==true) obj[6]="Đã test";else obj[6]="Chưa test";
			obj[7]=vd.getKetthuc();
			modeldf.addRow(obj);
		}
		System.out.println("add thanh cong list tt cach ly");
		return modeldf;
	}
	
	public static int InsertorUpdatecachly(ttcachly tt) {
//		String sql="insert into Thuthu(Ma_TT_20183489,Ten_TT_20183489,Gioitinh_20183489,Ngaysinh_20183489,CMND_20183489,Email_20183489,Dienthoai_20183489) "
//				+ "values(?,?,?,?,?,?,?) on duplicate key update Ma_TT_20183489 =values(Ma_TT_20183489), Ten_TT_20183489= values(Ten_TT_20183489),Gioitinh_20183489=values(Gioitinh_20183489),"
//				+ "Ngaysinh_20183489=values(Ngaysinh_20183489),CMND_20183489=values(CMND_20183489),Email_20183489=values(Email_20183489),Dienthoai_20183489=values(Dienthoai_20183489) ";
//		
		String sql="	MERGE INTO thong_tin_cach_li USING "
				+ "    (SELECT macl=?,batdau=?,mucdo=?,datest=?,id_nk=?, ketthuc=?,noicl=?) AS ne "
				+ "  ON thong_tin_cach_li.ma_so_cach_ly =ne.macl  WHEN MATCHED THEN "
				+ "    UPDATE SET ma_so_cach_ly=macl,thoi_gian_bat_dau=batdau,muc_do_cach_ly=mucdo,da_test_covid=datest, "
				+ "	ID_nhan_khau=id_nk,thoi_gian_ket_thuc=ketthuc,noi_cach_ly=noicl  WHEN NOT MATCHED THEN "
				+ "    INSERT (ma_so_cach_ly,thoi_gian_bat_dau,muc_do_cach_ly,da_test_covid, "
				+ "	ID_nhan_khau,thoi_gian_ket_thuc,noi_cach_ly) VALUES (macl,batdau,mucdo,datest,id_nk,ketthuc,noicl);";
//		String sql2=" 	MERGE INTO nhan_khau  USING "
//				+ "  (select hoten=?,cmnd=?,id=?) as ne "
//				+ "  on nhan_khau.ID_nhan_khau=ne.id when matched then update set so_CMND=cmnd,ho_ten=hoten;";
		try {
			PreparedStatement ps=ConnectDB.toconnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			//PreparedStatement ps2=ConnectDB.toconnection().prepareStatement(sql2);
			ps.setString(1, tt.getMa_cachly());
			ps.setString(3, tt.getMucdocachly());
			ps.setNString(7, tt.getNoicachly());
			ps.setDate(2, tt.getBatdau());
			ps.setBoolean(4,tt.getDatest());
			ps.setDate(6, tt.getKetthuc());
			ps.setInt(5, tt.getId_nk());
			ps.execute();
//			ps2.setNString(1,tt2.getHo_ten() );
//			ps2.setBigDecimal(2, tt2.getSo_cmnd());
//			ps2.setInt(3, tt2.getId_nkhau());
//			ps2.execute();
			ResultSet res=ps.getGeneratedKeys();
			int genkey=0;
			if(res.next()) {
				genkey=1;
			}
			ps.close();
			res.close();
			return genkey;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static int Insertkhaibao(ttkhaibao tt) {
		String sql="  insert into thong_tin_khai_bao values (?,?,?,?,?)";
		try {
			PreparedStatement ps =ConnectDB.toconnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, tt.getMa_kb());
			ps.setInt(2, tt.getId_nk());
			ps.setNString(3, tt.getTinhtrang_sk());
			ps.setDate(4, tt.getNgaykhaibao());
			ps.setNString(5,tt.getLichsu_dilai());
			ps.execute();
			ResultSet res=ps.getGeneratedKeys();
			int genkey=0;
			if(res.next()) {
				genkey=1;
			}
			ps.close();
			res.close();
			JOptionPane.showMessageDialog(null, "Thêm khai báo thành công");
			return genkey;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Thêm khai báo thất bại","Error",JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		return 0;
		
	}
	public static int updatekhaibao(ttkhaibao tt) {
		String sql="  update thong_tin_khai_bao  set tinh_trang_sk=?,thoi_gian_khai_bao=?,lich_su_di_lai=? where ma_khai_bao=?";
		try {
			PreparedStatement ps =ConnectDB.toconnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setNString(1, tt.getTinhtrang_sk());
			ps.setDate(2,tt.getNgaykhaibao());
			ps.setNString(3, tt.getLichsu_dilai());
			ps.setString(4, tt.getMa_kb());
			ps.execute();
			ResultSet res=ps.getGeneratedKeys();
			int genkey=0;
			if(res.next()) {
				genkey=1;
			}
			ps.close();
			res.close();
			JOptionPane.showMessageDialog(null, "Sửa khai báo thành công");
			return genkey;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Sửa khai báo thất bại","Error",JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		return 0;
		
		
	}
	public static String findCMND(int a) {
		String sql="select so_CMND from nhan_khau where ID_nhan_khau ='"+a+"'";
		Statement stm;
		
		try {
			stm=ConnectDB.toconnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			while(res.next()) {
				return res.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String findhoten(int a) {
		String sql="select ho_ten from nhan_khau where ID_nhan_khau ='"+a+"'";
		Statement stm;
		
		try {
			stm=ConnectDB.toconnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			while(res.next()) {
				return res.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static int calYearold(int a) {
		String sql="select year(GETDATE())- YEAR(ngay_sinh) from nhan_khau where ID_nhan_khau="+a;
		Statement stm;
		
		try {
			stm=ConnectDB.toconnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			while(res.next()) {
				return Integer.parseInt(res.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static List<ttcachly> findbyallcl(String a) {
		String sql="  select ma_so_cach_ly,nhan_khau.ID_nhan_khau,ho_ten,thoi_gian_bat_dau,muc_do_cach_ly,noi_cach_ly,da_test_covid, "
				+ "  thoi_gian_ket_thuc from thong_tin_cach_li inner join nhan_khau on thong_tin_cach_li.ID_nhan_khau=nhan_khau.ID_nhan_khau  "
				+ "   where nhan_khau.ID_nhan_khau = "+a+" or ho_ten like N'%"+a+"%' or ma_so_cach_ly like '%"+a+"%' "
				+ " or muc_do_cach_ly like '%"+a+"%' or noi_cach_ly like N'%"+a+"%' "
				+ "  order by thoi_gian_bat_dau asc";
		String sql2=" select ma_so_cach_ly,nhan_khau.ID_nhan_khau,ho_ten,thoi_gian_bat_dau,muc_do_cach_ly,noi_cach_ly,da_test_covid, "
				+ "  thoi_gian_ket_thuc from thong_tin_cach_li inner join nhan_khau on thong_tin_cach_li.ID_nhan_khau=nhan_khau.ID_nhan_khau  "
				+ "   where ho_ten like N'%"+a+"%' or muc_do_cach_ly like '%"+a+"%' or noi_cach_ly like N'%"+a+"%' or ma_so_cach_ly like '%"+a+"%'  order by thoi_gian_bat_dau asc";
		List<ttcachly> list_ttcachly=new ArrayList<>();
		ResultSet res;
		Statement stt;
		try {
			stt=ConnectDB.toconnection().createStatement();
			res= stt.executeQuery(sql);
			while(res.next()) {
				ttcachly vd=new ttcachly();
				vd.setMa_cachly(res.getString(1));
				vd.setId_nk(res.getInt(2));
				vd.setHoten(res.getString(3));
				vd.setBatdau(res.getDate(4));
				vd.setMucdocachly(res.getString(5));
				vd.setNoicachly(res.getString(6));
				vd.setDatest(res.getBoolean(7));
				vd.setKetthuc(res.getDate(8));
				list_ttcachly.add(vd);
			}
		}
		catch (Exception e) {
			try {
				Statement stm;
				stm=ConnectDB.toconnection().createStatement();
				res= stm.executeQuery(sql2);
				while(res.next()) {
					ttcachly vd=new ttcachly();
					vd.setMa_cachly(res.getString(1));
					vd.setId_nk(res.getInt(2));
					vd.setHoten(res.getString(3));
					vd.setBatdau(res.getDate(4));
					vd.setMucdocachly(res.getString(5));
					vd.setNoicachly(res.getString(6));
					vd.setDatest(res.getBoolean(7));
					vd.setKetthuc(res.getDate(8));
					list_ttcachly.add(vd);
				}
				stm.close();
				res.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			System.out.println("Loi khi get list thong tin cach ly");
			//e.printStackTrace();
		}

		return list_ttcachly;
	}
	public static List<ttkhaibao> findbyallkb(String a){
		String sql="select ma_khai_bao,nhan_khau.ID_nhan_khau,ho_ten,tinh_trang_sk,lich_su_di_lai,thoi_gian_khai_bao "
				+ " from thong_tin_khai_bao join nhan_khau on thong_tin_khai_bao.ID_nhan_khau=nhan_khau.ID_nhan_khau  "
				+ " where nhan_khau.ID_nhan_khau = "+a+" or ma_khai_bao like '%"+a+"%' or ho_ten like N'%"+a+"%' order by thoi_gian_khai_bao asc ";
		String sql2="select ma_khai_bao,nhan_khau.ID_nhan_khau,ho_ten,tinh_trang_sk,lich_su_di_lai,thoi_gian_khai_bao  "
				+ " from thong_tin_khai_bao join nhan_khau on thong_tin_khai_bao.ID_nhan_khau=nhan_khau.ID_nhan_khau  "
				+ " where ma_khai_bao like '%"+a+"%' or ho_ten like N'%"+a+"%' order by thoi_gian_khai_bao asc";
		Statement stt;
		ResultSet res;
		List<ttkhaibao> listkb=new ArrayList<>();
		try {
			stt=ConnectDB.toconnection().createStatement();
			res=stt.executeQuery(sql);
			while(res.next()) {
				ttkhaibao vd=new ttkhaibao();
				vd.setId_nk(res.getInt(2));
				vd.setHoten(res.getString(3));
				vd.setTuoi(calYearold(vd.getId_nk()));
				vd.setTinhtrang_sk(res.getString(4));
				vd.setMa_kb(res.getString(1));
				vd.setLichsu_dilai(res.getString(5));
				vd.setNgaykhaibao(res.getDate(6));
				listkb.add(vd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			try {
				Statement stm=ConnectDB.toconnection().createStatement();
				res=stm.executeQuery(sql2);
				while(res.next()) {
					ttkhaibao vd=new ttkhaibao();
					vd.setId_nk(res.getInt(2));
					vd.setHoten(res.getString(3));
					vd.setTuoi(calYearold(vd.getId_nk()));
					vd.setTinhtrang_sk(res.getString(4));
					vd.setMa_kb(res.getString(1));
					vd.setLichsu_dilai(res.getString(5));
					vd.setNgaykhaibao(res.getDate(6));
					listkb.add(vd);
				}
				stm.close();
				res.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//e.printStackTrace();
			
		}
		return listkb;
	}
	}
	
	
