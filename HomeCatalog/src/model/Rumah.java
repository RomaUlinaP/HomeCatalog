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
	String kecamatan;
	String alamat;
	String idPemilik;
	int harga;
	private Luas luas;
	private Fasilitas fasilitas;
	
	public Rumah() {
		super();
	}
	
	public Rumah(String id, String nama, String kecamatan, String alamat, int harga, 
				 Luas luas, Fasilitas fasilitas, String idPemilik) {

		this.setId(id);
		this.nama = nama;
		this.kecamatan = kecamatan;
		this.alamat = alamat;
		this.harga = harga;
		this.idPemilik = idPemilik;
		this.setLuas(luas);
		this.setFasilitas(fasilitas);
		//setFoto(o);
	}
	
	public Rumah(String string, int sortValue) {
		// TODO Auto-generated constructor stub
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

	public final String getKecamatan() {
		return kecamatan;
	}

	public final void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
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

	public final Luas getLuas() {
		return luas;
	}

	public final void setLuas(Luas luas) {
		this.luas = luas;
	}


	public final String getIdPemilik() {
		return idPemilik;
	}

	public final void setIdPemilik(String idPemilik) {
		this.idPemilik = idPemilik;
	}

}
