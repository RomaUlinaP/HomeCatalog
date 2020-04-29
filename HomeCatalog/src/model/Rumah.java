package model;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class Rumah {
	private String id;
	String nama;
	String status;
	String provinsi;
	String alamat;
	int harga;
	private Ukuran ukuran;
	private Fasilitas fasilitas;
	//String Foto;
	
	List<String> idPemilikList = new ArrayList<>();
	List<Pemilik> pemilikList = new ArrayList<>();
	
	
	public Rumah() {
		super();
	}
	
	public Rumah(String nama, String status, String provinsi, String alamat, int harga, 
			     List<String> idPemilikList) {
		this.nama = nama;
		this.status = status;
		this.provinsi = provinsi;
		this.alamat = alamat;
		this.harga = harga;
		this.idPemilikList = idPemilikList;
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
	
	public List<String> getIdPemilikList() {
		return idPemilikList;
	}

	public void setIdPemilikList(List<String> idPemilikList) {
		this.idPemilikList = idPemilikList;
	}

	public List<Pemilik> gettingPemilikList() {
		return pemilikList;
	}

	public void settingPemilikList(List<Pemilik> pemilikList) {
		this.pemilikList = pemilikList;
	}
	
	public void addPemilik(Pemilik pemilik) {
		this.pemilikList.add(pemilik);
		System.out.println("Finish insert data");
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
