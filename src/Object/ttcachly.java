package Object;

import java.sql.Date;

public class ttcachly {
	private int ma_cachly;
	private int id_nk;
	private String hoten;
	private Date batdau;
	private Date ketthuc;
	private String mucdocachly;
	private Boolean datest;
	private String noicachly;
	public ttcachly() {
		super();
	}
	
	public String getNoicachly() {
		return noicachly;
	}

	public void setNoicachly(String noicachly) {
		this.noicachly = noicachly;
	}

	public int getMa_cachly() {
		return ma_cachly;
	}
	public void setMa_cachly(int ma_cachly) {
		this.ma_cachly = ma_cachly;
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
	public Date getBatdau() {
		return batdau;
	}
	public void setBatdau(Date batdau) {
		this.batdau = batdau;
	}
	public Date getKetthuc() {
		return ketthuc;
	}
	public void setKetthuc(Date ketthuc) {
		this.ketthuc = ketthuc;
	}
	public String getMucdocachly() {
		return mucdocachly;
	}
	public void setMucdocachly(String mucdocachly) {
		this.mucdocachly = mucdocachly;
	}
	public Boolean getDatest() {
		return datest;
	}
	public void setDatest(Boolean datest) {
		this.datest = datest;
	}
	
	
}
