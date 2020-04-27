package model;

public class Pemilik {
	String IdP;
	String NamaP;
	String NomorHP;
	String Email;
	String Password;
	
	public Pemilik(String IdP, String NamaP, String NomorHP, String Email, String Password) {
		super();
		this.IdP= IdP;
		this.NamaP= NamaP;
		this.NomorHP = NomorHP;
		this. Email= Email;
		this.Password = Password;
	}
	
	public final String getIdP() {
		return IdP;
	}
	
	public final void setIdP(String IdP) {
		this.IdP = IdP;
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
