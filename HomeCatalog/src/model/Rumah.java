package model;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

import com.mongodb.DBRef;

public class Rumah {
	//private ObjectId id;
	private String id;
	String nama;
	String status;
	String provinsi;
	String alamat;
    private String idPemilik;
	int harga;
	private Ukuran ukuran;
	private Fasilitas fasilitas;
	//String Foto;
	
	
	public Rumah() {
		super();
	}
	
	public Rumah(String id, String nama, String status, String provinsi, String alamat, int harga, 
				 Ukuran ukuran, Fasilitas fasilitas, String idPemilik) {
		this.setId(id);
		this.nama = nama;
		this.status = status;
		this.provinsi = provinsi;
		this.alamat = alamat;
		this.harga = harga;
		this.idPemilik = idPemilik;
		this.setUkuran(ukuran);
		this.setFasilitas(fasilitas);
	}
	
	private void setPemilik(Object myDbRef) {
		// TODO Auto-generated method stub
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return alamat;
	}

	public void setAlamat(String alamat) {
		alamat = alamat;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		harga = harga;
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

	public String getIdPemilik() {
		return idPemilik;
	}

	public void setIdPemilik(String idPemilik) {
		this.idPemilik = idPemilik;
	}

}
