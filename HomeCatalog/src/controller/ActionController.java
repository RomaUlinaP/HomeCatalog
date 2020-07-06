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
import model.Ukuran;

public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String currNomorHP;
	String Kecamatan;
	int LuasTanahMin;
	int LuasTanahMax;
	int LuasBangunanMin;
	int LuasBangunanMax;
	int HargaMin;
	int HargaMax;
	public ActionController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("ACTION = "+action);
		MongoDBUtils mongodbUtils = new MongoDBUtils();
		if("Retrieve".equals(action)){
			showAllData(request, response, mongodbUtils);
		}else if("insert".equals(action)){
			// TODO
			String nama = request.getParameter("NamaRumah");
			String status = "Belum Terjual";
			String provinsi = request.getParameter("Provinsi");
			String alamat = request.getParameter("Alamat");
			int harga = Integer.parseInt(request.getParameter("Harga"));
			String namaP = request.getParameter("NamaP");
			String nomorHP = request.getParameter("NomorHP");
			String email = request.getParameter("Email");
			int panjang = Integer.parseInt(request.getParameter("Panjang"));
			int lebar = Integer.parseInt(request.getParameter("Lebar"));
			int kamarTidur = Integer.parseInt(request.getParameter("KamarTidur"));
			int kamarMandi = Integer.parseInt(request.getParameter("KamarMandi"));
			int garasi = Integer.parseInt(request.getParameter("Garasi"));
			int dapur = Integer.parseInt(request.getParameter("Dapur"));
			int halamanBelakang = Integer.parseInt(request.getParameter("HalamanBelakang"));
			Fasilitas fasilitas = new Fasilitas(kamarTidur, kamarMandi, garasi, dapur, halamanBelakang);
			Ukuran ukuran = new Ukuran(panjang, lebar);
			boolean result= mongodbUtils.inserting(nama, status, provinsi, alamat, harga, 
												   namaP, nomorHP, email, ukuran, fasilitas);
			if(result) {
				showAllData(request, response, mongodbUtils);
				System.out.println("done");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}else if("delete".equals(action)){
		
		}else if("Input".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/Input.jsp");
			rd.forward(request, response);
		}else if("before_update".equals(action)) {

		}else if("update".equals(action)) {
			/*String namaP = request.getParameter("NamaP");
			String nomorHP = request.getParameter("NomorHP");
			String email = request.getParameter("Email");
			boolean result= mongodbUtils.updateData(namaP, nomorHP, email);
			if(result) {
				//showAllData(request, response, mongodbUtils);
				System.out.println("done");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}*/
		}else if("search".equals(action)) {
			/*String namaP = request.getParameter("NamaP");
			String nomorHP = request.getParameter("NomorHP");
			String email = request.getParameter("Email");
			System.out.println("a :"+namaP + nomorHP + email);
			boolean result= mongodbUtils.search(namaP, nomorHP, email);*/
			/*if(result) {
				//showAllData(request, response, mongodbUtils);
				System.out.println("done");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}*/
		}else if("TampilPemilik".equals(action)){
			String idPemilik = request.getParameter("idPemilik");
			showDataPemilik(request, response, mongodbUtils, idPemilik);
		}else if("retrieve".equals(action)){
			showDataRumah(request, response, mongodbUtils, currNomorHP);
		}else if("SearchKecamatan".equals(action)){
			Kecamatan = request.getParameter("Kec");
			HargaMin = Integer.parseInt(request.getParameter("HargaMin"));
			HargaMax = Integer.parseInt(request.getParameter("HargaMaks"));
			if(Kecamatan.compareTo("kosong") == 0) {
				Filters2(request, response, mongodbUtils, HargaMin, HargaMax);
				System.out.println("cek");
			}else {
				Filters1(request, response, mongodbUtils, Kecamatan, HargaMin, HargaMax);
			}
		}else if("Cari".equals(action)){
			LuasTanahMin = Integer.parseInt(request.getParameter("LuasTanahMin"));
			LuasTanahMax = Integer.parseInt(request.getParameter("LuasTanahMax"));
			LuasBangunanMin = Integer.parseInt(request.getParameter("LuasBangunanMin"));
			LuasBangunanMax = Integer.parseInt(request.getParameter("LuasBangunanMax"));
			int KamarTidur = Integer.parseInt(request.getParameter("KamarTidur"));
			int KamarMandi = Integer.parseInt(request.getParameter("KamarMandi"));
			if(Kecamatan.compareTo("kosong") == 0) {
				Filters2Fix1(request, response, mongodbUtils,LuasTanahMin,LuasTanahMax,LuasBangunanMin,LuasBangunanMax,HargaMin,HargaMax,KamarTidur,KamarMandi);
			}else {
				Filters2Fix2(request, response, mongodbUtils, LuasTanahMin, LuasTanahMax, LuasBangunanMin, 
						LuasBangunanMax, Kecamatan,HargaMin,HargaMax,KamarTidur,KamarMandi);
			}
		}else if("Urutkan".equals(action)) {
			int SortValue = Integer.parseInt(request.getParameter("SortHarga"));
			if(Kecamatan.compareTo("kosong") == 0) {
				Filters7(request, response, mongodbUtils, SortValue,HargaMin,HargaMax,LuasTanahMin,LuasTanahMax, LuasBangunanMin, LuasBangunanMax);
			}else {
				Filters6(request, response, mongodbUtils, SortValue,Kecamatan,HargaMin,HargaMax,LuasTanahMin,LuasTanahMax, LuasBangunanMin, LuasBangunanMax);
			}
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
	//
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
	//
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
	//
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
	//
	public void Filters6(HttpServletRequest request, HttpServletResponse response, 
			MongoDBUtils mongodbUtils,int SortValue, String Kecamatan, int HargaMin, int HargaMax,int LuasTanahMin, int LuasTanahMax, int LuasBangunanMin, 
			int LuasBangunanMax)  {
		try {
			System.out.println("Menampilkan Data ...");
				List<Rumah> listRumah= mongodbUtils.getRumahbyFilter6(SortValue,Kecamatan,HargaMin,HargaMax,LuasTanahMin,LuasTanahMax, LuasBangunanMin, LuasBangunanMax);
				request.setAttribute("dataR", listRumah);
				request.getRequestDispatcher("TampilRumahFIlter2.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	public void Filters7(HttpServletRequest request, HttpServletResponse response, 
			MongoDBUtils mongodbUtils,int SortValue,int HargaMin, int HargaMax,int LuasTanahMin, int LuasTanahMax, int LuasBangunanMin, 
			int LuasBangunanMax)  {
		try {
			System.out.println("Menampilkan Data ...");
				List<Rumah> listRumah= mongodbUtils.getRumahbyFilter7(SortValue,HargaMin,HargaMax,LuasTanahMin,LuasTanahMax, LuasBangunanMin, LuasBangunanMax);
				request.setAttribute("dataR", listRumah);
				request.getRequestDispatcher("TampilRumahFIlter2.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Filters2Fix1(HttpServletRequest request, HttpServletResponse response, 
			MongoDBUtils mongodbUtils,
			int LuasTanahMin, int LuasTanahMax, int LuasBangunanMin, int LuasBangunanMax, int HargaMin, 
			int HargaMax, int KamarTidur, int KamarMandi)  {
		try {
			System.out.println("Menampilkan Data ...");
				List<Rumah> listRumah= mongodbUtils.getRumahbyFilter2Fix1(LuasTanahMin,LuasTanahMax,
						LuasBangunanMin,LuasBangunanMax,HargaMin,HargaMax,KamarTidur,KamarMandi);
				request.setAttribute("dataR", listRumah);
				request.getRequestDispatcher("TampilRumahFIlter2.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Filters2Fix2(HttpServletRequest request, HttpServletResponse response, 
			MongoDBUtils mongodbUtils,int LuasTanahMin, int LuasTanahMax, int LuasBangunanMin, 
			int LuasBangunanMax, String Kecamatan, int HargaMin, int HargaMax, int KamarTidur, int KamarMandi)  {
		try {
			System.out.println("Menampilkan Data ...");
				List<Rumah> listRumah= mongodbUtils.getRumahbyFilter2Fix2(LuasTanahMin, LuasTanahMax, LuasBangunanMin, 
						LuasBangunanMax, Kecamatan,HargaMin,HargaMax,KamarTidur,KamarMandi);
				request.setAttribute("dataR", listRumah);
				request.getRequestDispatcher("TampilRumahFIlter2.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	public void showDataRumah(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils, String nomorHP) {
		try {
			/*ArrayList<Pemilik> listPemilik = mongodbUtils.getPemilik();
			ArrayList<Rumah> listRumah = mongodbUtils.getRumah();
			for(int i=0; i<listPemilik.size();i++) {
				List<String> idRumah = listPemilik.get(i).getIdRumahList();
				for(int j=0; j<listRumah.size();j++) {
					if(idRumah.contains(listRumah.get(j).getId())) {
						listPemilik.get(i).addRumah(listRumah.get(j));
					}
				}
			}*/
			ArrayList<Pemilik> listPemilik = mongodbUtils.getPemilik();
			ArrayList<Rumah> listRumah = mongodbUtils.getRumah();
			for(int i=0; i<listPemilik.size();i++) {
				List<String> idRumah = listPemilik.get(i).getIdRumahList();
				for(int j=0; j<listRumah.size(); j++) {
					if(idRumah.contains(listRumah.get(j).getId())){
						listPemilik.get(i).addRumah(listRumah.get(j));
					}
				}
			}
			request.setAttribute("dataList", listPemilik);
			request.getRequestDispatcher("/DetailPemilik.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}