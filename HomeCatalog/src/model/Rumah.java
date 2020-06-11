package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBRef;

import controller.MongoDBUtils;

public class Rumah {
	private String id;
	String nama;
	String status;
	String provinsi;
	String alamat;
	String idPemilik;
	int harga;
	private Ukuran ukuran;
	private Fasilitas fasilitas;
	
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
		//setFoto(o);
	}
	
	private final void setPemilik(Object myDbRef) {
		// TODO Auto-generated method stub
		
	}
	
	public final String getId() {
		return id;
	}

	public final void setId(String id) {
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
		return alamat;
	}

	public final void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public final int getHarga() {
		return harga;
	}

	public final void setHarga(int harga) {
		this.harga = harga;
	}
    
    public final Fasilitas getFasilitas() {
		return fasilitas;
	}

	public final void setFasilitas(Fasilitas fasilitas) {
		this.fasilitas = fasilitas;
	}

	public final Ukuran getUkuran() {
		return ukuran;
	}

	public final void setUkuran(Ukuran ukuran) {
		this.ukuran = ukuran;
	}


	public final String getIdPemilik() {
		return idPemilik;
	}

	public final void setIdPemilik(String idPemilik) {
		this.idPemilik = idPemilik;
	}

}
