package model;

import org.bson.types.ObjectId;

public class Pemilik {
	private String id;
	String namaP;
	String nomorHP;
	String email;
	
	public Pemilik() {
		super();
	}
	
	public Pemilik(String id, String NamaP, String NomorHP, String Email) {
		super();
		this.namaP= NamaP;
		this.nomorHP = NomorHP;
		this.email= Email;
		this.setId(id);
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

}
