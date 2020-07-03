package model;

public class Luas {
	int luasBangunan;
	int luasTanah;
	
	public Luas() {}
	
	public  Luas(int luasBangunan, int luasTanah) {
		super();
		this.luasTanah = luasTanah;
		this.luasBangunan = luasBangunan;
	}
	public final int getLuasTanah() {
		return luasTanah;
	}

	public final void setLuasTanah(int luasTanah) {
		this.luasTanah = luasTanah;
	}
	
	public final int getLuasBangunan() {
		return luasBangunan;
	}

	public final void setLuasBangunan(int luasBangunan) {
		this.luasBangunan = luasBangunan;
	}
	
}
