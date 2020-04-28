package model;

public class Fasilitas {
	private int kamarTidur;
	private int kamarMandi;
	private int garasi;
	private int dapur;
	private int halamanBelakang;
	
	public Fasilitas() {
		
	}
	
	public Fasilitas(final int kamarTidur, final int kamarMandi, final int garasi, final int dapur, final int halamanBelakang) {
		this.setKamarTidur(kamarTidur);
		this.setKamarMandi(kamarMandi);
		this.setGarasi(garasi);
		this.setDapur(dapur);
		this.setHalamanBelakang(halamanBelakang);
	}

	public int getKamarTidur() {
		return kamarTidur;
	}

	public void setKamarTidur(int kamarTidur) {
		this.kamarTidur = kamarTidur;
	}

	public int getKamarMandi() {
		return kamarMandi;
	}

	public void setKamarMandi(int kamarMandi) {
		this.kamarMandi = kamarMandi;
	}

	public int getGarasi() {
		return garasi;
	}

	public void setGarasi(int garasi) {
		this.garasi = garasi;
	}

	public int getDapur() {
		return dapur;
	}

	public void setDapur(int dapur) {
		this.dapur = dapur;
	}

	public int getHalamanBelakang() {
		return halamanBelakang;
	}

	public void setHalamanBelakang(int halamanBelakang) {
		this.halamanBelakang = halamanBelakang;
	}
	
}
