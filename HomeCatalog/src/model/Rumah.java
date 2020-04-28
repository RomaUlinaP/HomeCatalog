package model;

import org.bson.types.ObjectId;

public class Rumah {
	private ObjectId id;
	String nama;
	String status;
	String provinsi;
	String Alamat;
	int Harga;
	int ukuran; //panjang, lebar
	String fasilitas; //schema
	String Foto; //
	
	public Rumah() {
		super();
	}
	
	public Rumah(String nama, String status, String provinsi, String Alamat, int Harga, int ukuran, String fasilitas, String Foto) {
		super();
		this.setNama(nama);
		this.setStatus(status);
		this.setProvinsi(provinsi);
		this.setAlamat(Alamat);
		this.setHarga(Harga);
		this.setUkuran(ukuran);
		this.setFasilitas(fasilitas);
		this.setFoto(Foto);
	}
	
	public ObjectId getId() {
		return id;
	}
	
	public final void setId(final ObjectId id) {
		this.id = id;
	}

	public final String getNama() {
		return nama;
	}

	public final void setNama(String nama) {
		this.nama = nama;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final String getProvinsi() {
		return provinsi;
	}

	public final void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	public final String getAlamat() {
		return Alamat;
	}

	public final void setAlamat(String alamat) {
		Alamat = alamat;
	}

	public final int getHarga() {
		return Harga;
	}

	public final void setHarga(int harga) {
		Harga = harga;
	}

	public final int getUkuran() {
		return ukuran;
	}

	public final void setUkuran(int ukuran) {
		this.ukuran = ukuran;
	}

	public final String getFasilitas() {
		return fasilitas;
	}

	public final void setFasilitas(String fasilitas) {
		this.fasilitas = fasilitas;
	}

	public final String getFoto() {
		return Foto;
	}

	public void setFoto(String foto) {
		Foto = foto;
	}
	
	
	
	
}
