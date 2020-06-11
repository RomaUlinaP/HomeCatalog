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
<<<<<<< Updated upstream
    private DBRef pemilik;
=======
    String idPemilik;
>>>>>>> Stashed changes
	int harga;
	private Ukuran ukuran;
	private Fasilitas fasilitas;
	
	public Rumah() {
		super();
	}
	
	public Rumah(String id, String nama, String status, String provinsi, String alamat, int harga, 
<<<<<<< Updated upstream
				 Ukuran ukuran, Fasilitas fasilitas, DBRef pemilik) {
=======
				 Ukuran ukuran, Fasilitas fasilitas, String idPemilik /*,BasicDBObject o*/) {
>>>>>>> Stashed changes
		this.setId(id);
		this.nama = nama;
		this.status = status;
		this.provinsi = provinsi;
		this.alamat = alamat;
		this.harga = harga;
		this.setPemilik(pemilik);
		this.setUkuran(ukuran);
		this.setFasilitas(fasilitas);
		//setFoto(o);
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
	
	public final String getNama() {
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

	public final String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
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

	public DBRef getPemilik() {
		return pemilik;
	}

	public void setPemilik(DBRef pemilik) {
		this.pemilik = pemilik;
	}
<<<<<<< Updated upstream



=======
	
>>>>>>> Stashed changes
}
