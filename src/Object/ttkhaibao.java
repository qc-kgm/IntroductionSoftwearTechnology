package Object;

import java.sql.Date;

public class ttkhaibao {
	private int id_nk;
	private String hoten;
	private String tinhtrang_sk;
	private Date ngaykhaibao;
	private Date ngaysinh;
	private String lichsu_dilai;
	private String lido;
	public ttkhaibao(int id_nk, String hoten, String tinhtrang_sk, Date ngaykhaibao, String lichsu_dilai) {
		super();
		this.id_nk = id_nk;
		this.hoten = hoten;
		this.tinhtrang_sk = tinhtrang_sk;
		this.ngaykhaibao = ngaykhaibao;
		this.lichsu_dilai = lichsu_dilai;
	}
	
	public String getLido() {
		return lido;
	}

	public void setLido(String lido) {
		this.lido = lido;
	}

	public ttkhaibao() {
		super();
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
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	
	
}
