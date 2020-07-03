package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fasilitas;
import model.Pemilik;
import model.Rumah;
import model.Luas;

public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String currNomorHP;
	String Kecamatan;
	int LuasTanahMin;
	int LuasTanahMax;
	int LuasBangunanMin;
	int LuasBangunanMax;
	public ActionController() {
		super();
	}
	MongoDBUtils mongodbUtils = new MongoDBUtils();
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("ACTION = "+action);
		MongoDBUtils mongodbUtils = new MongoDBUtils();
		
		if("Retrieve".equals(action)){
			showAllData(request, response, mongodbUtils);
		}else if("insert".equals(action)){
			// TODO
			String nama = request.getParameter("NamaRumah");
			String kecamatan = request.getParameter("Kecamatan");
			String alamat = request.getParameter("Alamat");
			int harga = Integer.parseInt(request.getParameter("Harga"));
			String namaP = request.getParameter("NamaP");
			String nomorHP = request.getParameter("NomorHP");
			String email = request.getParameter("Email");
			int luasTanah = Integer.parseInt(request.getParameter("LuasTanah"));
			int luasBangunan = Integer.parseInt(request.getParameter("LuasBangunan"));
			int kamarTidur = Integer.parseInt(request.getParameter("KamarTidur"));
			int kamarMandi = Integer.parseInt(request.getParameter("KamarMandi"));
			int garasi = Integer.parseInt(request.getParameter("Garasi"));
			int dapur = Integer.parseInt(request.getParameter("Dapur"));
			int halamanBelakang = Integer.parseInt(request.getParameter("HalamanBelakang"));
			Fasilitas fasilitas = new Fasilitas(kamarTidur, kamarMandi, garasi, dapur, halamanBelakang);
			Luas luas = new Luas(luasTanah, luasBangunan);
			boolean result= mongodbUtils.inserting(nama, kecamatan, alamat, harga, 
												   namaP, nomorHP, email, luas, fasilitas);
			if(result) {
				showAllData(request, response, mongodbUtils);
				System.out.println("done");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}else if("hapus".equals(action)){
			String id = request.getParameter("idRumah");
			boolean result = mongodbUtils.delete(id, currNomorHP);
			if(result) {
				boolean result2 = mongodbUtils.search(currNomorHP);
				if(result2) {
					showDataRumah(request, response, mongodbUtils, currNomorHP);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("/Update.jsp");
					rd.forward(request, response);
				}
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}else if("Input".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/Input.jsp");
			rd.forward(request, response);
		}else if("before_update".equals(action)) {
			String id = request.getParameter("idRumah");
			String nama = request.getParameter("NamaRumah");
			String idPemilik = request.getParameter("idPemilik");
			String kecamatan = request.getParameter("Kecamatan");
			String alamat = request.getParameter("Alamat");
			int harga = Integer.parseInt(request.getParameter("Harga"));
			int luasTanah = Integer.parseInt(request.getParameter("LuasTanah"));
			int luasBangunan = Integer.parseInt(request.getParameter("LuasBangunan"));
			int kamarTidur = Integer.parseInt(request.getParameter("KamarTidur"));
			int kamarMandi = Integer.parseInt(request.getParameter("KamarMandi"));
			int garasi = Integer.parseInt(request.getParameter("Garasi"));
			int dapur = Integer.parseInt(request.getParameter("Dapur"));
			int halamanBelakang = Integer.parseInt(request.getParameter("HalamanBelakang"));
			Fasilitas fasilitas = new Fasilitas(kamarTidur, kamarMandi, garasi, dapur, halamanBelakang);
			Luas luas = new Luas(luasTanah, luasBangunan);
			
			Rumah rumah = new Rumah (id,nama,kecamatan,alamat,harga,luas,fasilitas,idPemilik);
			request.setAttribute("rumah", rumah);
			RequestDispatcher rd = request.getRequestDispatcher("/editrumah.jsp");
			rd.forward(request, response);
		}else if("update".equals(action)) {
			String id = request.getParameter("idRumah");
			String nama = request.getParameter("NamaRumah");
			String kecamatan = request.getParameter("Kecamatan");
			String alamat = request.getParameter("Alamat");
			int harga = Integer.parseInt(request.getParameter("Harga"));
			int luasTanah = Integer.parseInt(request.getParameter("LuasTanah"));
			int luasBangunan = Integer.parseInt(request.getParameter("LuasBangunan"));
			int kamarTidur = Integer.parseInt(request.getParameter("KamarTidur"));
			int kamarMandi = Integer.parseInt(request.getParameter("KamarMandi"));
			int garasi = Integer.parseInt(request.getParameter("Garasi"));
			int dapur = Integer.parseInt(request.getParameter("Dapur"));
			int halamanBelakang = Integer.parseInt(request.getParameter("HalamanBelakang"));
			Fasilitas fasilitas = new Fasilitas(kamarTidur, kamarMandi, garasi, dapur, halamanBelakang);
			Luas luas = new Luas(luasTanah, luasBangunan);
			boolean resultUpdate;
			try {
				
				System.out.println("Data Rumah Berhasil Diperbaharui");
				resultUpdate = mongodbUtils.updateData(id, nama, kecamatan, alamat, harga, luas, fasilitas);
				RequestDispatcher rd = request.getRequestDispatcher("/ListRumah.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("search".equals(action)) {
			currNomorHP = request.getParameter("NomorHP");
			boolean result = mongodbUtils.search(currNomorHP);
			if(result) {
				RequestDispatcher rd = request.getRequestDispatcher("/ListRumah.jsp");
				rd.forward(request, response);
			}else {
				System.out.println("Data tidak ditemukan");
				RequestDispatcher rd = request.getRequestDispatcher("/Update.jsp");
				rd.forward(request, response);
			}
		}else if("TampilPemilik".equals(action)){
			String idPemilik = request.getParameter("idPemilik");
			showDataPemilik(request, response, mongodbUtils, idPemilik);
		}else if("retrieve".equals(action)){
			showDataRumah(request, response, mongodbUtils, currNomorHP);
		}else if("SearchKecamatan".equals(action)){
			Kecamatan = request.getParameter("Kec");
			int HargaMin = Integer.parseInt(request.getParameter("HargaMin"));
			int HargaMax = Integer.parseInt(request.getParameter("HargaMaks"));
			//System.out.println(Kecamatan);
			if(Kecamatan.compareTo("kosong") == 0) {
				Filters2(request, response, mongodbUtils, HargaMin, HargaMax);
				System.out.println("cek");
			}else {
				Filters1(request, response, mongodbUtils, Kecamatan, HargaMin, HargaMax);
			}
		}/*else if("SearchLuas".equals(action)){
			/LuasTanahMin = Integer.parseInt(request.getParameter("LuasTanahMin"));
			LuasTanahMax = Integer.parseInt(request.getParameter("LuasTanahMax"));
			LuasBangunanMin = Integer.parseInt(request.getParameter("LuasBangunanMin"));
			LuasBangunanMax = Integer.parseInt(request.getParameter("LuasBangunanMax"));
			int kamarTidur = Integer.parseInt(request.getParameter("KamarTidur"));
			int kamarMandi = Integer.parseInt(request.getParameter("KamarMandi"));
			Filters3(request, response, mongodbUtils, LuasTanahMin, LuasTanahMax, LuasBangunanMin, 
					LuasBangunanMax, Kecamatan, kamarTidur, kamarMandi);
		}*/else if("SearchFasilitas".equals(action)){
			int SortValue = Integer.parseInt(request.getParameter("SortHarga"));
			System.out.println(SortValue);
			Filters4(request, response, mongodbUtils, SortValue);
		}
	}
	
	public void showAllData(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils) {
		try {
			ArrayList<Pemilik> listPemilik = mongodbUtils.getPemilik();
			ArrayList<Rumah> listRumah = mongodbUtils.getRumah();
			for(int i=0; i<listPemilik.size();i++) {
				List<String> idRumah = listPemilik.get(i).getIdRumahList();
				for(int j=0; j<listRumah.size();j++) {
					if(idRumah.contains(listRumah.get(j).getId())) {
						listPemilik.get(i).addRumah(listRumah.get(j));
					}
				}
			}
			request.setAttribute("dataR", listRumah);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showDataPemilik(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils, String id) {
		try {
			System.out.println("Menampilkan Data ...");
			ArrayList<Pemilik> listPemilik = mongodbUtils.getPemilikbyid(id);
			request.setAttribute("dataPemilik", listPemilik);
			request.getRequestDispatcher("DetailPemilik.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Filters1(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils, String kecamatan, int HargaMin, int HargaMax) {
		try {
			System.out.println("Menampilkan Data ...");
				List<Rumah> listRumah= mongodbUtils.getRumahbyFilter1(kecamatan, HargaMin, HargaMax);
				request.setAttribute("dataR", listRumah);
			request.getRequestDispatcher("TampilRumahFIlter2.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Filters2(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils, int HargaMin, int HargaMax) {
		try {
			System.out.println("Menampilkan Data ...");
				List<Rumah> listRumah= mongodbUtils.getRumahbyFilter2(HargaMin, HargaMax);
				request.setAttribute("dataR", listRumah);
			request.getRequestDispatcher("TampilRumahFIlter2.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Filters3(HttpServletRequest request, HttpServletResponse response, 
			MongoDBUtils mongodbUtils, int LuasTanahMin, int LuasTanahMax, int LuasBangunanMin, 
			int LuasBangunanMax, String kecamatan, int kamarTidur, int kamarMandi) {
		try {
			System.out.println("Menampilkan Data ...");
				List<Rumah> listRumah= mongodbUtils.getRumahbyFilter3(LuasTanahMin, LuasTanahMax, 
						LuasBangunanMin, LuasBangunanMax, kecamatan, kamarTidur, kamarMandi);
				request.setAttribute("dataR", listRumah);
			request.getRequestDispatcher("TampilRumahFIlter2.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Filters4(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils, int SortValue) {
		try {
			System.out.println("Menampilkan Data ...");
				List<Rumah> listRumah= mongodbUtils.getRumahbyFilter4(SortValue);
				request.setAttribute("dataR", listRumah);
			request.getRequestDispatcher("TampilRumahFIlter2.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showDataRumah(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils, String nomorHP) {
		try {
			System.out.println("Menampilkan Data ...");
			ArrayList<Rumah> listRumah = mongodbUtils.getRumahByPemilik(nomorHP);
			request.setAttribute("dataRumah", listRumah);
			request.getRequestDispatcher("ListRumah.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}