package Object;

public class ho_gd {
	private String ma_hogd;
	private String ten_chu_ho ;
	private int so_tv;
	private String dia_chi;
	public ho_gd(String a,String b,String c,int d ) {
		this.ma_hogd=a;
		this.ten_chu_ho=b;
		this.dia_chi=c;
		this.so_tv=d;
	}
	
	public ho_gd() {
		super();
	}

	public String getMa_hogd() {
		return ma_hogd;
	}
	public void setMa_hogd(String ma_hogd) {
		this.ma_hogd = ma_hogd;
	}
	public String getTen_chu_ho() {
		return ten_chu_ho;
	}
	public void setTen_chu_ho(String ten_chu_ho) {
		this.ten_chu_ho = ten_chu_ho;
	}
	public int getSo_tv() {
		return so_tv;
	}
	public void setSo_tv(int so_tv) {
		this.so_tv = so_tv;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	
}
