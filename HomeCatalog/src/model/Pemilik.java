package model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Pemilik {
	private String id;
	String namaP;
	String nomorHP;
	String email;
	List<String> idRumahList = new ArrayList<>();
	List<Rumah> rumahList = new ArrayList<>();
	
	public Pemilik() {
		super();
	}
	
	public Pemilik(String id, String NamaP, String NomorHP, String Email, 
			       List<String> idRumahList) {
		super();
		this.namaP= NamaP;
		this.nomorHP = NomorHP;
		this.email= Email;
		this.setId(id);
		this.idRumahList = idRumahList;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public final String getNamaP() {
		return namaP;
	}
	
	public final void setNamaP(String NamaP) {
		this.namaP = NamaP;
	}
	
	public final String getNomorHP() {
		return nomorHP;
	}
	
	public final void setNomorHP(String NomorHP) {
		this.nomorHP = NomorHP;
	}
	
	public final String getEmail() {
		return email;
	}
	
	public final void setEmail(String Email) {
		this.email = Email;
	}
	
	public List<String> getIdRumahList() {
		return idRumahList;
	}

	public void setIdRumahList(List<String> idRumahList) {
		this.idRumahList = idRumahList;
	}

	public List<Rumah> gettingRumahList() {
		return rumahList;
	}

	public void settingRumahList(List<Rumah> rumahList) {
		this.rumahList = rumahList;
	}
	
	public void addRumah(Rumah rumah) {
		this.rumahList.add(rumah);
	}
	
	public final List<String> tampilNama(){
		List<String> nama = new ArrayList<String>();
		for(int i =0; i<gettingRumahList().size(); i++){
			nama.add(gettingRumahList().get(i).getNama());
		}
		return nama;
	}
}
