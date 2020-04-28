package model;

import java.util.ArrayList;
import java.util.List;

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
	
	List<Pemilik> pemilik = new ArrayList<>();
	String Foto; //
	
	public Rumah() {}
	
	public Rumah(String nama, String status, String provinsi, String Alamat, int Harga, String Foto, 
			     Ukuran ukuran, Fasilitas fasilitas) {
		this.nama = nama;
		this.status = status;
		this.provinsi = provinsi;
		this.Alamat = Alamat;
		this.Harga = Harga;
		this.Foto = Foto;
		this.setUkuran(ukuran);
		this.setFasilitas(fasilitas);
	}
	
	public ObjectId getId() {
		return id;
	}
	
	public void setId(final ObjectId id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	public String getAlamat() {
		return Alamat;
	}

	public void setAlamat(String alamat) {
		Alamat = alamat;
	}

	public int getHarga() {
		return Harga;
	}

	public void setHarga(int harga) {
		Harga = harga;
	}

	public String getFoto() {
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
	
	public List< Pemilik > getPemilik() {
        return pemilik;
    }
	
    public void setPemilik( final List< Pemilik > pemilik ) {
        this.pemilik = pemilik;
    }
}
