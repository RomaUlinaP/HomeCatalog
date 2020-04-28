package model;

public class Ukuran {
	int Panjang;
	int Lebar;
	
	public Ukuran() {}
	
	public  Ukuran(int Panjang, int Lebar) {
		super();
		this.Panjang = Panjang;
		this.Lebar = Lebar;
	}
	public final int getPanjang() {
		return Panjang;
	}

	public final void setPanjang(int Panjang) {
		this.Panjang = Panjang;
	}
	
	public final int getLebar() {
		return Lebar;
	}

	public final void setLebar(int Lebar) {
		this.Lebar = Lebar;
	}
	
}
