package model;

public class Motor {
	
	String vmerk;
	String vwarna;
	public Motor(String vmerk, String vwarna) {
		super();
		this.vmerk = vmerk;
		this.vwarna = vwarna;
	}
	public final String getVmerk() {
		return vmerk;
	}
	public final void setVmerk(String vmerk) {
		this.vmerk = vmerk;
	}
	public final String getVwarna() {
		return vwarna;
	}
	public final void setVwarna(String vwarna) {
		this.vwarna = vwarna;
	}
	
	
}
