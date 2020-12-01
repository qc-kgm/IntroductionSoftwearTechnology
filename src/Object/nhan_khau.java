package Object;

import java.math.BigDecimal;
import java.sql.Date;

public class nhan_khau {
	private BigDecimal so_cmnd;
	private String ho_ten;
	private String ma_hogd;
	private String noi_lam_viec;
	private String so_dt;
	private int id_nkhau;
	private Date ngay_sinh;
	private String gioitinh;
	public nhan_khau(BigDecimal so_cmnd, String ho_ten, String ma_hogd, String noi_lam_viec, String so_dt,int idnhk,Date ns,String gt) {
		this.so_cmnd = so_cmnd;
		this.ho_ten = ho_ten;
		this.ma_hogd = ma_hogd;
		this.noi_lam_viec = noi_lam_viec;
		this.so_dt = so_dt;
		this.id_nkhau=idnhk;
		this.ngay_sinh=ns;
		this.gioitinh=gt;
	}
	public  nhan_khau() {
		
	}
	public BigDecimal getSo_cmnd() {
		return so_cmnd;
	}
	public void setSo_cmnd(BigDecimal so_cmnd) {
		this.so_cmnd = so_cmnd;
	}
	public String getHo_ten() {
		return ho_ten;
	}
	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}
	public String getMa_hogd() {
		return ma_hogd;
	}
	public void setMa_hogd(String ma_hogd) {
		this.ma_hogd = ma_hogd;
	}
	public String getNoi_lam_viec() {
		return noi_lam_viec;
	}
	public void setNoi_lam_viec(String noi_lam_viec) {
		this.noi_lam_viec = noi_lam_viec;
	}
	public String getSo_dt() {
		return so_dt;
	}
	public void setSo_dt(String so_dt) {
		this.so_dt = so_dt;
	}
	public int getId_nkhau() {
		return id_nkhau;
	}
	public void setId_nkhau(int id_nkhau) {
		this.id_nkhau = id_nkhau;
	}
	public Date getNgay_sinh() {
		return ngay_sinh;
	}
	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	
	
	
}
