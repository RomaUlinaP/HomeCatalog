package model;

import org.bson.types.ObjectId;

public class Rumah {
	private ObjectId id;
	String nama;
	String status;
	String provinsi;
	String Alamat;
	int Harga;
	private Ukuran ukuran;
	private Fasilitas fasilitas;
	String Foto; //
	
	public Rumah() {
		super();
	}
	
	public Rumah(String nama, String status, String provinsi, String Alamat, int Harga, String Foto) {
		super();
		this.setNama(nama);
		this.setStatus(status);
		this.setProvinsi(provinsi);
		this.setAlamat(Alamat);
		this.setHarga(Harga);
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

	public final String getFoto() {
		return Foto;
	}

	public void setFoto(String foto) {
		Foto = foto;
	}

	public Fasilitas getFasilitas() {
		return fasilitas;
	}

	public void setFasilitas(Fasilitas fasilitas) {
		this.fasilitas = fasilitas;
	}

	public Ukuran getUkuran() {
		return ukuran;
	}

	public void setUkuran(Ukuran ukuran) {
		this.ukuran = ukuran;
	}
}
