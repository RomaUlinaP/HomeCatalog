package model;

import org.bson.types.ObjectId;

public class Pemilik {
	private ObjectId id;
	String NamaP;
	String NomorHP;
	String Email;
	String Password;
	
	public Pemilik() {}
	
	public Pemilik( String NamaP, String NomorHP, String Email, String Password) {
		super();
		this.NamaP= NamaP;
		this.NomorHP = NomorHP;
		this. Email= Email;
		this.Password = Password;
	}
	
	public ObjectId getId() {
		return id;
	}
	
	public final void setId(final ObjectId id) {
		this.id = id;
	}
	
	public final String getNamaP() {
		return NamaP;
	}
	
	public final void setNamaP(String NamaP) {
		this.NamaP = NamaP;
	}
	
	public final String getNomorHP() {
		return NomorHP;
	}
	
	public final void setNomorHP(String NomorHP) {
		this.NomorHP = NomorHP;
	}
	
	public final String getEmail() {
		return Email;
	}
	
	public final void setEmail(String Email) {
		this.Email = Email;
	}
	
	public final String getPassword() {
		return Password;
	}
	
	public final void setPassword(String Password) {
		this.Password = Password;
	}
	

}
