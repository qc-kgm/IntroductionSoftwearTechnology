package Object;

import java.sql.Date;

public class ttkhaibao {
	private int id_nk;
	private String hoten;
	private String tinhtrang_sk;
	private Date ngaykhaibao;
	private int tuoi;
	private String lichsu_dilai;
	private String ma_kb;



	public ttkhaibao() {
		super();
	}
	
	public String getMa_kb() {
		return ma_kb;
	}

	public void setMa_kb(String ma_kb) {
		this.ma_kb = ma_kb;
	}

	public int getId_nk() {
		return id_nk;
	}
	public void setId_nk(int id_nk) {
		this.id_nk = id_nk;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTinhtrang_sk() {
		return tinhtrang_sk;
	}
	public void setTinhtrang_sk(String tinhtrang_sk) {
		this.tinhtrang_sk = tinhtrang_sk;
	}
	public Date getNgaykhaibao() {
		return ngaykhaibao;
	}
	public void setNgaykhaibao(Date ngaykhaibao) {
		this.ngaykhaibao = ngaykhaibao;
	}
	public String getLichsu_dilai() {
		return lichsu_dilai;
	}
	public void setLichsu_dilai(String lichsu_dilai) {
		this.lichsu_dilai = lichsu_dilai;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}






	
	
}
