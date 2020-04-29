package model;

public class Ukuran {
	int panjang;
	int lebar;
	
	public Ukuran() {}
	
	public  Ukuran(int panjang, int lebar) {
		super();
		this.panjang = panjang;
		this.lebar = lebar;
	}
	public final int getPanjang() {
		return panjang;
	}

	public final void setPanjang(int panjang) {
		this.panjang = panjang;
	}
	
	public final int getLebar() {
		return lebar;
	}

	public final void setLebar(int lebar) {
		this.lebar = lebar;
	}
	
}
